package com.example.samuel.escolaideal;

import java.lang.reflect.Method;
import java.util.List;

import br.com.matheus.coordenadas.principal.Calculo;
import br.com.matheus.coordenadas.principal.Local;

public class Knn 
{
	
	//Atributo
	private Escola classificacao [ ];
	private double euclidiana[ ];
	private Local origem;
	/**
	 *	Construtor Padrao
	 */
	public Knn(  List< Escola > lista , Escola escola ,  int [ ] prioridade ,  int selecionados [ ] , Local local )
	{
		classificacao = new Escola[ lista.size( ) ];
		euclidiana = new double[ lista.size( ) ];
		this.origem = local;
		classificador(lista, escola, prioridade, selecionados);
		
	}

	/**
	 *Metodo que faz a distancia euclidiana das escolas 
	 */
	private void classificador( List< Escola > lista , Escola escola , int [ ] prioridade , int selecionados [ ] )
	{

		double somador , respostaListaDouble , respostaEscolaDouble , x , y;	
		boolean respostaLista , respostaEscola ;
		int j = 0;

		try
		{
			

			for( Escola e : lista )
			{
				int i = 0 ;
				somador = 0;
				while( selecionados[ i ] != 0 )
				{
					try
					{
						Class< ? > classe = Escola.class;

						Method m ;


						if( selecionados[ i ] == 1 )
						{
							Local local = new Local( Double.parseDouble(e.getLatitude()) ,Double.parseDouble(e.getLongitude( )) );
							double x1 = Calculo.calcular( origem , local );
							
							somador += prioridade[ i ] * Math.pow( x1 , 2 );
							
						}
						
						if( selecionados[ i ] == 35 || selecionados[ i ] == 11 )
						{
							if( selecionados[ i ] == 35  )
							{
								m = classe.getMethod( DicionarioMetodos.CHAVES.get( selecionados[ i ] + 35 )  );
								//Melhor media do enem
								respostaEscolaDouble =  1 / ( double ) m.invoke( e );	
								System.out.println( respostaEscolaDouble );
						//	respostaListaDouble = ( double ) m.invoke( e , null );
							
								somador += prioridade[ i ] * Math.pow( respostaEscolaDouble , 2 );
							}
						}
						else
						{
							if( !( selecionados[ i ] == 35 ) && !( selecionados[ i ] == 1 ) )
							{
								m = classe.getMethod( DicionarioMetodos.CHAVES.get( selecionados[ i ] + 35 ) );
								respostaEscola = ( boolean ) m.invoke( escola );						
								respostaLista = ( boolean ) m.invoke( e );		
							
							
								x = ( respostaEscola ? 0.0 : 1.0 );
								y = ( respostaLista ? 0.0 : 1.0 );
							
							
								somador += prioridade[ i ] * Math.pow( ( x - y ) , 2 );	
							}						
						}
						i++;
					}//Fim do try
					catch( Exception es )
					{
						es.printStackTrace();
					}					
					
				}//Fim do while
				
				double raiz = Math.sqrt( somador );
				
				
				classificacao[ j ] = e;
				euclidiana[ j ] = raiz;
				j++;
				
			}//Fim do for
		}//Fim do try
		catch( Exception e )
		{
			e.printStackTrace();
		}

	}//Fim do metodo

	//Classifica e retorna o vetor ordenado com as melhores escolas
	public Escola[ ] classificacao( )
	{
		QuickSortEuclidiana.quickSort( euclidiana , classificacao );
		
		return classificacao;
	}
	
	//Aqui retorna a distribui��o de dostancia euclididana 
	public double [ ] euclidiana( )
	{
		return euclidiana;
	}
	
	//Retorrna a melhor escola de acordo ao algoritmo de inteligencia artifical
	public void melhorEscola( )
	{
		System.out.println( classificacao[ 0 ] );
	}
}//Fim da classe