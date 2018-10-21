package com.example.samuel.escolaideal;

public class QuickSortEuclidiana
{
	public static void quickSort( double euclidiana [ ] , Escola escolas[ ] )
	{
		quickSort( euclidiana , escolas , 0 , euclidiana.length - 1);
	}

	public static void quickSort( double euclidiana [ ] , Escola escolas[ ] , int esquerda , int direita)
	{
		int indice = particao( euclidiana , escolas , esquerda , direita );

		if(esquerda < indice - 1)
			quickSort(euclidiana , escolas ,esquerda , indice - 1);
		if(indice < direita)
			quickSort( euclidiana, escolas , indice , direita );
	}

	private static int particao(  double euclidiana [ ] , Escola escolas[ ] , int esquerda , int direita)
	{
		int i = esquerda , j = direita;
		double aux ;
		Escola escolaAux;
		double pivo = euclidiana[(esquerda + direita) / 2];

		while(i <= j)
		{
			while( euclidiana[ i ] < pivo )
				i++;
			while( euclidiana[ j ] > pivo )
				j--;

			if(i <= j )
			{

				aux = euclidiana[i];
				euclidiana[i] = euclidiana[j];
				euclidiana[j] = aux;

				escolaAux = escolas[ i ];
				escolas[ i ] = escolas[ j ];
				escolas[ j ] = escolaAux;				

				i++;j--;
			}
		}
		return i;
	}
}