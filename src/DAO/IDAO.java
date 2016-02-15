package DAO;

import java.util.List;

import MODEL.Aluno;

public interface IDAO {

	public void save(Aluno aluno);
	void update(Aluno aluno);
	void delete(Aluno aluno);
	Aluno find(Integer id);
	List<Aluno> list();
}
