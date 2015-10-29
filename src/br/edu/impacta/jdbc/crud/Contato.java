package br.edu.impacta.jdbc.crud;

import java.util.Calendar;


public class Contato {
	private Long codigo;
	private String nome;
	private String email;
	private String endereco;
	// usando o data Calendar para conveter a data, para o banco
	private Calendar dataNascimentoCalendar;
	//data String
	private String dataNascimentoString;
	
	public Contato() {
		
	}
	 
	/*get e set*/
	public String getDataNascimentoString() {
		return dataNascimentoString;
	}

	public void setDataNascimentoString(String dataNascimentoString) {
		this.dataNascimentoString = dataNascimentoString;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimentoCalendar() {
		return dataNascimentoCalendar;
	}
	public void setDataNascimentoCalendar(Calendar dataNascimento) {
		this.dataNascimentoCalendar = dataNascimento;
	}
}
