package br.edu.impacta.jdbc.crud;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;




import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.edu.impacta.jdbc.conexao.ConnectionFactory;

public class ContatoDAO implements IContato {
	
	
	//DICA: Utilização de "try-with-resources" do JAVA 7
	public void salvarComDataCalendar(Contato vo) {
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		
		try(Connection conexao = new ConnectionFactory().obterConexao()) {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getEndereco());
			
			// Metedeo de conversão
			//1° Conversão = Calendar -> java.util.Date
			//2° Conversão = java.util.Date -> java.sql.Date
			java.util.Date dt = vo.getDataNascimentoCalendar().getTime();
			Date data = new Date(dt.getTime());
			ps.setDate(4, data);
			
			ps.execute();
		} 
		catch (SQLException e) {	
			
			e.printStackTrace();
		}
		
	}
	
	public void salvarComDataString(Contato vo){
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		
		try(Connection conexao = new ConnectionFactory().obterConexao()) {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getEndereco());
			
			//1° Conversão = String -> java.util.Date
			//2° Conversão = java.util.Date -> java.sql.Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dataEmDateUtil = sdf.parse(vo.getDataNascimentoString());
			Date dataSQL = new Date(dataEmDateUtil.getTime());
			ps.setDate(4, dataSQL);
			
			ps.execute();
		} 
		catch (SQLException | ParseException e) {		
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Contato vo){
		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE codigo=?";
		
		try(Connection conexao = new ConnectionFactory().obterConexao()) 
		{
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getEndereco());
			
			java.util.Date dt = vo.getDataNascimentoCalendar().getTime();
			Date data = new Date(dt.getTime());
			ps.setDate(4, data);
			
			ps.execute();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//DICA: Sem utilização de "try-with-resources" do JAVA 7
	public void excluir(Contato vo) throws SQLException
	{
		String sql = "DELETE FROM contatos WHERE codigo=?";
		
		Connection conexao = new ConnectionFactory().obterConexao();
		PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
		
		ps.setLong(1, vo.getCodigo());
				
		ps.execute();
		ps.close();
	}
	
	public List<Contato> getLista() throws SQLException {
		List<Contato> contatos = new ArrayList<>();
		Connection conexao = new ConnectionFactory().obterConexao();
		PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM contatos");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Contato c = new Contato();
			
			c.setCodigo(rs.getLong("codigo"));
			
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setEndereco(rs.getString("endereco"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			c.setDataNascimentoCalendar(data);
			
			contatos.add(c);
		}
		
		rs.close();
		ps.close();
		
		return contatos;
		
	}
}
