package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Aluno;

public class AlunoDAO implements IDAO{

	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection connection;
	
	public AlunoDAO(){
		if(connection == null){
			connection = new ConnectionFactory().getconnection();
		}
	}
	
	@Override
	public void save(Aluno aluno) {
		sql = "insert into aluna(nome,"
				+ " email,"
				+ " matricula,"
				+ " endereco,"
				+ "telefone,"
				+ "idade,"
				+ "ativo) "
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			
		pst = connection.prepareStatement(sql);
		
		pst.setString(1, aluno.getNome());
		pst.setString(2, aluno.getEmail());
		pst.setLong(3, aluno.getMatricula());
        pst.setString(4, aluno.getEndereco());
		pst.setLong(5, aluno.getTelefone());
		pst.setInt(6, aluno.getIdade());
		pst.setBoolean(7, aluno.getAtivo());
		
		pst.execute();
		pst.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Aluno aluno) {
		sql = "update aluna set "
				+ "nome=?,"
				+ " telefone=?,"
				+ " endereco=?, "
				+ "idade=?, "
				+ "email=?,"
				+ "matricula=?,"
				+ " ativo=? where id=?";
				
		try {
			
			pst = connection.prepareStatement(sql);
			
			pst.setString(1, aluno.getNome());
			pst.setLong(2, aluno.getTelefone());
	        pst.setString(3, aluno.getEndereco());
			pst.setInt(4, aluno.getIdade());
			pst.setString(2, aluno.getEmail());
			pst.setLong(3, aluno.getMatricula());
			pst.setBoolean(7, aluno.getAtivo());
			pst.setInt(8, aluno.getId());
			
			pst.execute();
			pst.close();
			
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		
	}

	@Override
	public void delete(Aluno aluno) {
		
		sql = "delete from aluna where id=?";
		
		try{
			pst = connection.prepareStatement(sql);
			
			pst.setInt(1, aluno.getId());
			
			pst.execute();
			pst.close();
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Aluno find(Integer id) {
		Aluno aluno = null;
		sql = "select * from aluna where id=?";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				aluno = new Aluno();

				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setAtivo(rs.getBoolean("ativo"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setTelefone(rs.getLong("telefone"));
			}
			
			return aluno;
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> list() {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno aluno;
		
sql = "select * from aluna";
		
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				aluno = new Aluno();
				
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setAtivo(rs.getBoolean("ativo"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setTelefone(rs.getLong("telefone"));
				
				alunos.add(aluno);
			}
			
			return alunos;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
