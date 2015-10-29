package br.edu.impacta.jdbc.crud;

import java.sql.SQLException;
import java.util.List;

public interface IContato {
	
	public void salvarComDataCalendar(Contato vo) throws SQLException;
	
	public void salvarComDataString(Contato vo) throws SQLException;
	
	public void alterar(Contato vo) throws SQLException;
	
	public void excluir(Contato vo) throws SQLException;
	
	public List<Contato> getLista() throws SQLException;
}
