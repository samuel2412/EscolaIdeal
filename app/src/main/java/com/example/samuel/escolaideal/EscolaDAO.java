package com.example.samuel.escolaideal;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EscolaDAO
{
	//Atributos
	private Connection conexao;


	//Construtor
	public EscolaDAO( )
	{

	}


	//Insere escola
	public void adiciona( List<Escola> lista ) throws SQLException
	{

		conexao = ConnectionFactory.obtemConexao( );

		PreparedStatement st = null;
		int v = 0;
		for( Escola escola : lista )
		{
			String sql = "INSERT INTO Escola"
					+ "( cod ,anoCenso,nome,situacaoFuncionamento,situacaoCenso,inicioAno,fimAno,"
					+ "codDistrito,nomeDistrito,codMunicipio,dependenciaAdiministrativa,tipoLocalizacao,"
					+ "regulamentada,aguaFiltrada,aguaPublica,aguaPocoArtesiano,aguaCacimba,"
					+ "aguaRio,aguaInexistente,energiaPublica,energiaGerador,energiaOutros,"
					+ "energiaInexistente,esgotoPublico,esgotoFossa,esgotoInexistente,"
					+ "lixoColetaPeriodica,lixoQueima,lixoJogaOutraArea,lixoRecicla,lixoEnterra,lixoOutros,"
					+ "salaDiretoria,salaProfessores,laboratorioInformatica,laboratorioCiencias,atendimentoEspecial,"
					+ "quadraCoberta,quadraDescoberta,cozinha,biblioteca,salaLeitura,parqueInfantil,bercario,"
					+ "sanitarioForaPredio,sanitarioDentroPredio,sanitarioEducInfant,sanitarioPNE , dependenciasPNE ,secretaria,"
					+ "banheiroChuveiro,refeitorio,despensa,almoxarifado,auditorio,patioCoberto, patioDescoberto ,alojamentoAluno,"
					+ "alojamentoProfessor,areaVerde,lavanderia,salasExistentes,salasUtilizadas,"
					+ "televisores,videoCassetes,dvds,parabolicas,copiadoras,retroprojetores,impressoras,"
					+ "aparelhosSom,datashows,fax,foto,computadores,computadoresAdm , computadoresAlunos,internet,bandaLarga,funcionarios,alimentacao,"
					+ "aee,atividadeComplementar,ensinoRegular,regCreche,regPreescola,regFundamental8,"
					+ "regFundamental9,regMedioMedio,regMedioIntegrado,regMedioNormal,regMedioProfissional,"
					+ "ensinoEspecial,espCreche,espPreescola,espFundamental8,espFundamental9,espMedioMedio,"
					+ "espMedioIntegrado,espMedioNormal,espMedioProfissional,espEjaFundamental,espEjaMedio,ensinoEja,"
					+ "ejaFundamental,ejaMedio,ejaProjovem,ciclos,fimDeSemana,pedagogiaAlternancia,idebAI,"
					+ "idebAF,enemPortugues,enemMatematica,enemHumanas,enemNaturais,enemRedacao,"
					+ "enemMediaObjetiva,enemMediaGeral,socioEconomico,formacaoDocente,endereco,"
					+ "latitude,longitude,inicioAnoTxt,fimAnoTxt,dependenciaAdministrativaTxt,tipoLocalizacaoTxt,"
					+ "regulamentadaTxt,nomeTitulo,situacaoFuncionamentoTxt)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";




			try
			{
				st = conexao.prepareStatement( sql );

				st.setInt( 1 , escola.getCod( ) );
				st.setInt( 2 , escola.getAnoCenso( ) );
				st.setString( 3 ,  escola.getNome( ) );
				st.setInt( 4 ,  escola.getSituacaoFuncionamento( ) );
				st.setInt( 5 , escola.getSituacaoCenso( ) );
				st.setString( 6 ,  escola.getInicioAno( ) );
				st.setString( 7 ,  escola.getFimAno( ) );
				st.setInt( 8 ,  escola.getCodDistrito( ) );
				st.setString( 9 ,  escola.getNomeDistrito( ) );
				st.setInt( 10 ,  escola.getCodMunicipio( ) );
				st.setInt( 11 ,  escola.getDependenciaAdministrativa( ) );
				st.setInt( 12 ,  escola.getTipoLocalizacao( ) );

				st.setInt( 13 ,  escola.getRegulamentada( ) );

				st.setBoolean( 14 ,  escola.isAguaFiltrada( ) );
				st.setBoolean( 15 ,  escola.isAguaPublica( ) );
				st.setBoolean( 16 ,  escola.isAguaPocoArtesiano( ) );
				st.setBoolean( 17 ,  escola.isAguaCacimba( ) );
				st.setBoolean( 18 ,  escola.isAguaRio( ) );
				st.setBoolean( 19 ,  escola.isAguaInexistente( ) );

				st.setBoolean( 20 ,  escola.isEnergiaPublica( ) );
				st.setBoolean( 21 ,  escola.isEnergiaGerador( ) );
				st.setBoolean( 22 ,  escola.isEnergiaOutros( ) );
				st.setBoolean( 23 ,  escola.isEnergiaInexistente( ) );

				st.setBoolean( 24 ,  escola.isEsgotoPublico( ) );
				st.setBoolean( 25 ,  escola.isEsgotoFossa( ) );
				st.setBoolean( 26 ,  escola.isEsgotoInexistente( ) );

				st.setBoolean( 27 ,  escola.isLixoColetaPeriodica( ) );
				st.setBoolean( 28 ,  escola.isLixoQueima( ) );
				st.setBoolean( 29 ,  escola.isLixoJogaOutraArea( ) );
				st.setBoolean( 30 ,  escola.isLixoRecicla( ) );
				st.setBoolean( 31 ,  escola.isLixoEnterra( ) );
				st.setBoolean( 32 ,  escola.isLixoOutros( ) );




				st.setBoolean( 33 ,  escola.isSalaDiretoria( ) );
				st.setBoolean( 34 ,  escola.isSalaProfessores( ) );
				st.setBoolean( 35 ,  escola.isLaboratorioInformatica( ) );
				st.setBoolean( 36 ,  escola.isLaboratorioCiencias( ) );
				st.setBoolean( 37 ,  escola.isAtendimentoEspecial( ) );
				st.setBoolean( 38 ,  escola.isQuadraCoberta( ) );
				st.setBoolean( 39 ,  escola.isQuadraDescoberta( ) );
				st.setBoolean( 40 ,  escola.isCozinha( ) );
				st.setBoolean( 41 ,  escola.isBiblioteca( ) );
				st.setBoolean( 42 ,  escola.isSalaDiretoria( ) );
				st.setBoolean( 43 ,  escola.isParqueInfantil( ) );
				st.setBoolean( 44 ,  escola.isBercario( ) );
				st.setBoolean( 45 ,  escola.isSanitarioForaPredio( ) );
				st.setBoolean( 46 ,  escola.isSanitarioDentroPredio( ) );
				st.setBoolean( 47 ,  escola.isSanitarioEducInfant( ) );
				st.setBoolean( 48 ,  escola.isSanitarioPNE( ) );
				st.setBoolean( 49 , escola.isDependenciasPNE( ) );


				st.setBoolean( 50 ,  escola.isSecretaria( ) );
				st.setBoolean( 51 ,  escola.isBanheiroChuveiro( ) );
				st.setBoolean( 52 ,  escola.isRefeitorio( ) );
				st.setBoolean( 53 ,  escola.isDespensa( ) );
				st.setBoolean( 54 ,  escola.isAlmoxarifado( ) );
				st.setBoolean( 55 ,  escola.isAuditorio( ) );
				st.setBoolean( 56 ,  escola.isPatioCoberto( ) );
				st.setBoolean( 57 , escola.isPatioDescoberto( ) );


				st.setBoolean( 58 ,  escola.isAlojamentoAluno( ) );
				st.setBoolean( 59 ,  escola.isAlojamentoProfessor( ) );
				st.setBoolean( 60 ,  escola.isAreaVerde( ) );
				st.setBoolean( 61 ,  escola.isLavanderia() );



				st.setInt( 62 ,  escola.getSalasExistentes( ) );
				st.setInt( 63 ,  escola.getSalasUtilizadas( ) );
				st.setInt( 64 ,  escola.getTelevisores( ) );
				st.setInt( 65 ,  escola.getVideoCassetes( ) );
				st.setInt( 66 ,  escola.getDvds( ) );
				st.setInt( 67 ,  escola.getParabolicas( ) );
				st.setInt( 68 ,  escola.getCopiadoras( ) );
				st.setInt( 69 ,  escola.getRetroprojetores( ) );
				st.setInt( 70 ,  escola.getImpressoras( ) );
				st.setInt( 71 ,  escola.getAparelhosSom( ) );
				st.setInt( 72 ,  escola.getDatashows( ) );
				st.setInt( 73 ,  escola.getFax( ) );
				st.setInt( 74 ,  escola.getFoto( ) );
				st.setInt( 75 ,  escola.getComputadores( ) );
				st.setInt( 76 ,  escola.getComputadoresAdm( ));
				st.setInt( 77 , escola.getComputadoresAlunos( ));

				st.setBoolean( 78 ,  escola.isInternet( ) );

				st.setBoolean( 79 ,  escola.isBandaLarga( ) );
				st.setInt( 80 ,  escola.getFuncionarios( ) );
				st.setBoolean( 81 ,  escola.isAlimentacao( ) );
				st.setBoolean( 82 ,  escola.isAee( ) );
				st.setInt( 83 ,  escola.getAtividadeComplementar( ) );
				st.setBoolean( 84 ,  escola.isEnsinoRegular( ) );
				st.setBoolean( 85 ,  escola.isRegCreche( ) );
				st.setBoolean( 86 ,  escola.isRegPreescola( ) );
				st.setBoolean( 87 ,  escola.isRegFundamental8( ) );




				st.setBoolean( 88 ,  escola.isRegFundamental9( ) );
				st.setBoolean( 89 ,  escola.isRegMedioMedio( ) );
				st.setBoolean( 90 ,  escola.isRegMedioNormal( ) );

				st.setBoolean( 91 ,  escola.isRegMedioProfissional( ) );
				st.setBoolean( 92 ,  escola.isEnsinoEspecial( ));
				st.setBoolean( 93 ,  escola.isEspCreche( ) );
				st.setBoolean( 94 ,  escola.isEspPreescola( ) );
				st.setBoolean( 95 ,  escola.isEspFundamental8( ) );
				st.setBoolean( 96 ,  escola.isEspFundamental9( ) );
				st.setBoolean( 97 ,  escola.isEspMedioMedio( ) );
				st.setBoolean( 98 ,  escola.isEspMedioIntegrado( ) );
				st.setBoolean( 99 ,  escola.isEspMedioNormal() );
				st.setBoolean( 100 ,  escola.isEspMedioProfissional( ) );
				st.setBoolean( 101 ,  escola.isEspEjaFundamental( ) );
				st.setBoolean( 102 ,  escola.isEspEjaMedio( ) );
				st.setBoolean( 103 ,  escola.isEnsinoEja( ) );

				st.setBoolean( 104 ,  escola.isEjaFundamental( ) );
				st.setBoolean( 105 ,  escola.isEjaMedio( ) );
				st.setBoolean( 106 ,  escola.isEjaMedio( ) );
				st.setBoolean( 107 ,  escola.isEjaProjovem( ) );
				st.setBoolean( 108 ,  escola.isCiclos( ) );
				st.setBoolean( 109 ,  escola.isFimDeSemana( ) );
				st.setBoolean( 110 ,  escola.isPedagogiaAlternancia( ) );




				st.setDouble( 111 ,  escola.getIdebAI( ) );
				st.setDouble( 112 ,  escola.getIdebAF( ) );
				st.setDouble( 113 ,  escola.getEnemPortugues( ) );
				st.setDouble( 114 ,  escola.getEnemMatematica( ) );
				st.setDouble( 115 ,  escola.getEnemHumanas( ) );
				st.setDouble( 116 ,  escola.getEnemNaturais( ) );
				st.setDouble( 117 ,  escola.getEnemRedacao( ) );
				st.setDouble( 118 ,  escola.getEnemMediaObjetiva( ) );
				st.setDouble( 119 ,  escola.getEnemMediaGeral( ) );
				st.setString( 120 ,  escola.getSocioEconomico( ) );
				st.setDouble( 121 ,  escola.getFormacaoDocente( ) );
				st.setString( 122 ,  escola.getEndereco( ) );
				st.setDouble( 123 ,  escola.getLatitude( ) );
				st.setDouble( 124 ,  escola.getLongitude( ) );
				st.setString( 125 ,  escola.getInicioAnoTxt( ) );
				st.setString( 126 ,  escola.getFimAnoTxt( ) );
				st.setString( 127 ,  escola.getDependenciaAdministrativaTxt( ) );
				st.setString( 128 ,  escola.getTipoLocalizacaoTxt( ) );
				st.setString( 129 ,  escola.getRegulamentadaTxt( ) );
				st.setString( 130 ,  escola.getNomeTitulo( ) );
				st.setString( 131 ,  escola.getSituacaoFuncionamentoTxt( ) );

				//System.out.println( escola.getRegulamentadaTxt( ) );

				st.execute();
				System.out.println( v );
				v++;
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}

		}
		st.close();

	}


	public List<Escola> consulta( int sigla )
	{
		List< Escola > lista = new ArrayList< >( );

		String sql = "select * from Escola e " +
				"inner join Municipio m " +
				"on m.codMunicipio = e.codMunicipio "+
				"inner join Estado es "+
				"on es.codEstado = m.codEstado " +
				"where es.codEstado = " + sigla;

		Connection conexao = null;
		PreparedStatement st = null;
		try
		{
			conexao = ConnectionFactory.obtemConexao( );

			st = conexao.prepareStatement( sql );

			ResultSet rs = st.executeQuery( );

			while( rs.next( ) )
			{


				Escola e = new Escola();
				e.setCod ( rs.getInt("cod") );
				e.setAnoCenso( rs.getInt( "anoCenso" ) );
				e.setNome( rs.getString( "nome" ) );
				e.setSituacaoFuncionamento( rs.getInt( "situacaoFuncionamento" ) );
				e.setSituacaoCenso( rs.getInt( "situacaoCenso" ) );
				e.setInicioAno("" + rs.getString( "inicioAno" ) );
				e.setFimAno( "" + rs.getString( "fimAno"  ) );
				// e.setCodUf( rs.getInt( "codUf" ));
				e.setCodMunicipio( rs.getInt( "codMunicipio" ) );
				// e.setSiglaUf(rs.getString("siglaUf"));
				e.setCodDistrito( rs.getInt( "codDistrito" ) );
				e.setNomeDistrito( rs.getString( "nomeDistrito" ) );
				//e.setRegiao( rs.getString( "regiao" ) );
				e.setDependenciaAdministrativa( rs.getInt( "dependenciaAdiministrativa" ));
				e.setTipoLocalizacao( rs.getInt( "tipoLocalizacao" ));
				e.setRegulamentada( rs.getInt( "regulamentada" ) );
				e.setAguaFiltrada( rs.getBoolean( "aguaFiltrada" ) );
				e.setAguaPublica( rs.getBoolean( "aguaPublica" ) );
				e.setAguaPocoArtesiano( rs.getBoolean( "aguaPocoArtesiano") );
				e.setAguaCacimba( rs.getBoolean( "aguaCacimba" ));
				e.setAguaRio( rs.getBoolean( "aguaRio") );
				e.setAguaInexistente( rs.getBoolean( "aguaInexistente" ) );
				e.setEnergiaPublica( rs.getBoolean( "energiaPublica" ) );
				e.setEnergiaGerador( rs.getBoolean( "energiaGerador" ) );
				e.setEnergiaOutros( rs.getBoolean( "energiaOutros") );
				e.setEnergiaInexistente( rs.getBoolean( "energiaInexistente" ) );
				e.setEsgotoPublico( rs.getBoolean( "esgotoPublico" ) );
				e.setEsgotoFossa( rs.getBoolean( "esgotoFossa" ) );
				e.setEsgotoInexistente( rs.getBoolean( "esgotoInexistente" ) );
				e.setLixoColetaPeriodica( rs.getBoolean( "lixoColetaPeriodica" ) );
				e.setLixoQueima( rs.getBoolean( "lixoQueima" ) );
				e.setLixoJogaOutraArea( rs.getBoolean( "lixoJogaOutraArea") );
				e.setLixoRecicla( rs.getBoolean( "lixoRecicla" ) );
				e.setLixoEnterra( rs.getBoolean( "lixoEnterra" ) );
				e.setLixoOutros( rs.getBoolean( "lixoOutros" ) );
				e.setSalaDiretoria( rs.getBoolean( "salaDiretoria" ) );
				e.setSalaProfessores( rs.getBoolean( "salaProfessores" ) );
				e.setLaboratorioInformatica( rs.getBoolean( "laboratorioInformatica" ) );
				e.setLaboratorioCiencias( rs.getBoolean( "laboratorioCiencias" ) );
				e.setAtendimentoEspecial( rs.getBoolean( "atendimentoEspecial" ) );
				e.setQuadraCoberta( rs.getBoolean( "quadraCoberta" ) );
				e.setQuadraDescoberta( rs.getBoolean( "quadraDescoberta" ) );
				e.setCozinha( rs.getBoolean( "cozinha" ) );
				e.setBiblioteca( rs.getBoolean( "biblioteca" ) );
				e.setSalaLeitura( rs.getBoolean( "salaLeitura" ) );
				e.setParqueInfantil( rs.getBoolean( "parqueInfantil" ) );
				e.setBercario( rs.getBoolean( "bercario" ) );
				e.setSanitarioForaPredio( rs.getBoolean( "sanitarioForaPredio" ) );
				e.setSanitarioDentroPredio( rs.getBoolean( "sanitarioDentroPredio" ) );
				e.setSanitarioEducInfant( rs.getBoolean( "sanitarioEducInfant" ) );
				e.setSanitarioPNE( rs.getBoolean( "sanitarioPNE" ) );
				e.setDependenciasPNE( rs.getBoolean( "dependenciasPNE" ) );
				e.setSecretaria( rs.getBoolean( "secretaria" ) );
				e.setBanheiroChuveiro( rs.getBoolean( "banheiroChuveiro" ) );
				e.setRefeitorio( rs.getBoolean( "refeitorio" ) );
				e.setDespensa( rs.getBoolean( "despensa" ) );
				e.setAlmoxarifado( rs.getBoolean( "almoxarifado" ) );
				e.setAuditorio( rs.getBoolean( "auditorio" ) );
				e.setPatioCoberto( rs.getBoolean( "patioCoberto" ) );
				e.setPatioDescoberto( rs.getBoolean( "patioDescoberto" ) );
				e.setAlojamentoAluno( rs.getBoolean( "alojamentoAluno" ) );
				e.setAlojamentoProfessor( rs.getBoolean(  "alojamentoProfessor"  ) );
				e.setAreaVerde( rs.getBoolean( "areaVerde" ) );
				e.setLavanderia( rs.getBoolean( "lavanderia" ) );
				e.setSalasExistentes( rs.getInt( "salasExistentes" ) );
				e.setSalasUtilizadas( rs.getInt( "salasUtilizadas" ) );
				e.setTelevisores( rs.getInt( "televisores" ) );
				e.setVideoCassetes( rs.getInt( "videoCassetes" ) );
				e.setDvds( rs.getInt( "dvds" ) );
				e.setParabolicas( rs.getInt( "parabolicas" ) );
				e.setCopiadoras( rs.getInt( "copiadoras" ) );
				e.setRetroprojetores( rs.getInt( "retroprojetores" ) );
				e.setImpressoras( rs.getInt( "impressoras" ) );
				e.setAparelhosSom( rs.getInt( "aparelhosSom" ) );
				e.setDatashows( rs.getInt( "datashows" ) );
				e.setFax( rs.getInt( "fax" ) );
				e.setFoto( rs.getInt( "foto" ) );
				e.setComputadores( rs.getInt( "computadores" ) );
				e.setComputadoresAdm( rs.getInt( "computadoresAdm" ) );
				e.setComputadoresAlunos( rs.getInt( "computadoresAlunos" ) );
				e.setInternet( rs.getBoolean( "internet" ) );
				e.setBandaLarga( rs.getBoolean( "bandaLarga" ) );
				e.setFuncionarios( rs.getInt( "funcionarios" ) );
				e.setAlimentacao( rs.getBoolean( "alimentacao" ) );
				e.setAee( rs.getBoolean( "aee" ) );
				e.setAtividadeComplementar( rs.getInt( "atividadeComplementar" ) );
				e.setEnsinoRegular( rs.getBoolean( "ensinoRegular" ) );
				e.setRegCreche( rs.getBoolean( "regCreche" ) );
				e.setRegPreescola( rs.getBoolean( "regPreescola" ) );
				e.setRegFundamental8( rs.getBoolean( "regFundamental8" ) );
				e.setRegFundamental9( rs.getBoolean( "regFundamental9" ) );
				e.setRegMedioMedio( rs.getBoolean( "regMedioMedio" ) );
				e.setRegMedioIntegrado( rs.getBoolean( "regMedioIntegrado" ) );
				e.setRegMedioNormal( rs.getBoolean( "regMedioNormal" ) );
				e.setRegMedioProfissional( rs.getBoolean( "regMedioProfissional" ) );
				e.setEnsinoEspecial( rs.getBoolean( "ensinoEspecial" ) );
				e.setEspCreche( rs.getBoolean( "espCreche" ) );
				e.setEspPreescola( rs.getBoolean( "espPreescola" ) );
				e.setEspFundamental8( rs.getBoolean( "espFundamental8" ) );
				e.setEspFundamental9( rs.getBoolean( "espFundamental9" ) );
				e.setEspMedioMedio( rs.getBoolean( "espMedioMedio" ) );
				e.setEspMedioNormal( rs.getBoolean( "espMedioNormal" ) );
				e.setEspMedioProfissional( rs.getBoolean( "espMedioProfissional" ) );
				e.setEspEjaFundamental( rs.getBoolean( "espEjaFundamental" ) );
				e.setEspEjaMedio( rs.getBoolean( "espEjaMedio" ) );
				e.setEnsinoEja( rs.getBoolean( "ensinoEja" ) );
				e.setEjaFundamental( rs.getBoolean( "ejaFundamental" ) );
				e.setEjaMedio( rs.getBoolean( "ejaMedio" ) );
				e.setEjaProjovem( rs.getBoolean( "ejaProjovem" ) );
				e.setCiclos( rs.getBoolean( "ciclos" ) );
				e.setFimDeSemana( rs.getBoolean( "fimDeSemana" ) );
				e.setPedagogiaAlternancia( rs.getBoolean( "pedagogiaAlternancia" ) );
				e.setIdebAI( rs.getDouble( "idebAI" ) );
				e.setIdebAF( rs.getDouble( "idebAF" ) );
				e.setEnemPortugues( rs.getDouble( "enemPortugues" ) );
				e.setEnemMatematica( rs.getDouble( "enemMatematica" ) );
				e.setEnemHumanas( rs.getDouble( "enemHumanas" ) );
				e.setEnemNaturais( rs.getDouble( "enemNaturais" ) );
				e.setEnemRedacao( rs.getDouble( "enemRedacao" ) );
				e.setEnemMediaObjetiva(  rs.getDouble( "enemMediaObjetiva" ) );
				e.setEnemMediaGeral( rs.getDouble( "enemMediaGeral" ) );
				e.setSocioEconomico( rs.getString( "socioEconomico" ) );
				e.setFormacaoDocente( rs.getDouble( "formacaoDocente" ) );
				e.setEndereco( rs.getString( "endereco" ) );
				e.setLatitude( rs.getDouble( "latitude" ) );
				e.setLongitude( rs.getDouble( "longitude" ) );
				e.setInicioAnoTxt( rs.getString( "inicioAnoTxt" ) );
				e.setFimAnoTxt( rs.getString( "fimAnoTxt" ) );
				e.setDependenciaAdministrativaTxt( rs.getString( "dependenciaAdministrativaTxt" ) );
				e.setTipoLocalizacaoTxt( rs.getString( "tipoLocalizacaoTxt" ) );
				e.setRegulamentadaTxt( rs.getString( "regulamentadaTxt" ) );
				e.setNomeTitulo( rs.getString( "nomeTitulo" ) );
				e.setSituacaoFuncionamentoTxt( rs.getString( "situacaoFuncionamentoTxt" ) );

				lista.add( e );


			}


		}
		catch( Exception e )
		{
			Log.e("BANCO",e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}

}