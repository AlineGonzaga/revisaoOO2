package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MODEL.Aluno;

public class ConnectionFactory {

	private String url = "jdbc:postgresql://localhost:5432/crud";
	private String user = "postgres";
	private String password = "123";
	
	public Connection getconnection(){
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, user,password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		Aluno aline = new Aluno();
		aline.setAtivo(true);
		aline.setEmail("ewuyriu@fff");
		aline.setEndereco(" rua presidente janio ");
		aline.setIdade(29);
		aline.setMatricula(7587494L);
		aline.setNome("Aline silva gonzaga da");
		aline.setTelefone(91917035L);
		
	}
}
