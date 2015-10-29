package br.edu.impacta.jdbc.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import br.edu.impacta.jdbc.crud.Contato;
import br.edu.impacta.jdbc.crud.ContatoDAO;


public class Execucao {
	
	public static void main(String[] args) throws SQLException {
		/*
		 * Instância de objeto com data de nascimento do tipo Calendar
		 */
		Contato contato1 = new Contato();
		contato1.setNome("Cristina Luz");
		contato1.setEndereco("Av. Paulista, 321");
		contato1.setEmail("contato@cristec.com");
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(1999,0,22);
		contato1.setDataNascimentoCalendar(calendario);		
		
		
		/*
		 * Instância de objeto com data de nascimento do tipo String 
		 */
		Contato contato2 = new Contato();
		contato2.setNome("Maria luisa");
		contato2.setEndereco("Av. Paulista, 111");
		contato2.setEmail("Mluisa@uol.com.br");
		contato2.setDataNascimentoString("03/09/1986");
		
		
		ContatoDAO dao = new ContatoDAO();
		dao.salvarComDataString(contato2);
		dao.salvarComDataCalendar(contato1);
		
		/*mensagem */
		System.out.println("O contato " + contato2.getNome() + " foi salvo com sucesso!!!");
		System.out.println("O contato " + contato1.getNome() + " foi salvo com sucesso!!!");
	}
}
