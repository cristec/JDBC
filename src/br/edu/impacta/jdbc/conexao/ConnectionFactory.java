package br.edu.impacta.jdbc.conexao;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	public Connection obterConexao() throws SQLException {
		
		/*String de conex�o, estou usado MySql */
		
		Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "cristec");
		
		System.out.println("Teste: O Banco dados est� conectado");
		
		return conexao;
	}
}
