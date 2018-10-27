/**
 * Classe responsável por retornar a conexão com o banco de dados
 */
package com.example.samuel.escolaideal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**@author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class ConnectionFactory
{

	//Carrega o driver
	static
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new RuntimeException( e );
		}
	}

	/**
	 *Método responsável por retornar a conexão com o banco de dados
	 */
	public static Connection obtemConexao( ) throws SQLException
	{
		return DriverManager.getConnection(

				"jdbc:mysql://3.16.35.222:3306/escola_ideal","ei","escolaideal");

	}

}//Fim da classe