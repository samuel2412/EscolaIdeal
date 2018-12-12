package com.example.samuel.escolaideal;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class DicionarioMetodos 
{
	
	public static Map< Integer , String  > CHAVES;
	
	static
	{
		populaChaves( );
	}
	
	
	//Construtor Privado
	private DicionarioMetodos( )
	{
		
	}
	
	
	public static void populaChaves( )
	{
		try {
			CHAVES = new HashMap<>();
			CHAVES.put(1, "setDistancia");
			CHAVES.put(2, "setLaboratorioCiencias");
			CHAVES.put(3, "setLaboratorioInformatica");
			CHAVES.put(4, "setQuadraCoberta");
			CHAVES.put(5, "setQuadraDescoberta");
			CHAVES.put(6, "setBiblioteca");
			CHAVES.put(7, "setSalaLeitura");
			CHAVES.put(8, "setSanitarioPNE");
			CHAVES.put(9, "setDependenciasPNE");

			CHAVES.put(10, "setAuditorio");
			CHAVES.put(11, "setComputadores");
			CHAVES.put(12, "setParqueInfantil");
			CHAVES.put(13, "setPatioCoberto");
			CHAVES.put(14, "setPatioDescoberto");
			CHAVES.put(15, "setRefeitorio");
			CHAVES.put(16, "setSanitarioForaPredio");
			CHAVES.put(17, "setSanitarioDentroPredio");
			CHAVES.put(18, "setInternet");
			CHAVES.put(19, "setRegPreescola");
			CHAVES.put(20, "setRegFundamental9");
			CHAVES.put(21, "setRegMedioNormal");
			CHAVES.put(22, "setRegMedioIntegrado");
			CHAVES.put(23, "setRegMedioMedio");

			CHAVES.put(24, "setEjaFundamental");
			CHAVES.put(25, "setEjaMedio");

			CHAVES.put(26, "setEjaProjovem");
			CHAVES.put(27, "setEspCreche");

			CHAVES.put(28, "setEspEjaFundamental");
			CHAVES.put(29, "setEspEjaMedio");

			CHAVES.put(30, "setEspMedioIntegrado");
			CHAVES.put(31, "setEspMedioMedio");
			CHAVES.put(32, "setEspMedioNormal");
			CHAVES.put(33, "setEspMedioProfissional");
			CHAVES.put(34, "setEspPreescola");
			CHAVES.put(35, "setEnemMediaGeral");

			CHAVES.put(36, "getDistancia");
			CHAVES.put(37, "isLaboratorioCiencias");
			CHAVES.put(38, "isLaboratorioInformatica");
			CHAVES.put(39, "isQuadraCoberta");
			CHAVES.put(40, "isQuadraDescoberta");
			CHAVES.put(41, "isBiblioteca");
			CHAVES.put(42, "isSalaLeitura");
			CHAVES.put(43, "isSanitarioPNE");
			CHAVES.put(44, "isDependenciasPNE");

			CHAVES.put(45, "isAuditorio");
			CHAVES.put(46, "getComputadores");
			CHAVES.put(47, "isParqueInfantil");
			CHAVES.put(48, "isPatioCoberto");
			CHAVES.put(49, "isPatioDescoberto");
			CHAVES.put(50, "isRefeitorio");
			CHAVES.put(51, "isSanitarioForaPredio");
			CHAVES.put(52, "isSanitarioDentroPredio");
			CHAVES.put(53, "isInternet");
			CHAVES.put(54, "isRegPreescola");
			CHAVES.put(55, "isRegFundamental9");
			CHAVES.put(56, "isRegMedioNormal");
			CHAVES.put(57, "isRegMedioIntegrado");
			CHAVES.put(58, "isRegMedioMedio");

			CHAVES.put(59, "isEjaFundamental");
			CHAVES.put(60, "isEjaMedio");

			CHAVES.put(61, "isEjaProjovem");
			CHAVES.put(62, "isEspCreche");

			CHAVES.put(63, "isEspEjaFundamental");
			CHAVES.put(64, "isEspEjaMedio");

			CHAVES.put(65, "isEspMedioIntegrado");
			CHAVES.put(66, "isEspMedioMedio");
			CHAVES.put(67, "isEspMedioNormal");
			CHAVES.put(68, "isEspMedioProfissional");
			CHAVES.put(69, "isEspPreescola");
			CHAVES.put(70, "getEnemMediaGeral");

			CHAVES.put(71, "getLatitude");
			CHAVES.put(72, "getLongitude");
		}catch (Exception e){
			Log.e("CHAVES","exception",e);
		}
	}
	
	
	
	
	
}