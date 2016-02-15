package CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AlunoDAO;
import MODEL.Aluno;

@WebServlet("/alunoCONTROLLER")
public class AlunoCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoCONTROLLER() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno();
		
		String operacao = request.getParameter("operacao");
		
		switch(operacao){
		case "incluir":
			aluno.setNome(request.getParameter("nome"));
			aluno.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
			aluno.setEmail(request.getParameter("email"));
			aluno.setEndereco(request.getParameter("endereco"));
			aluno.setIdade(Integer.parseInt(request.getParameter("idade")));
			aluno.setMatricula(Long.parseLong(request.getParameter("matricula")));
			aluno.setTelefone(Long.parseLong(request.getParameter("telefone")));
			dao.save(aluno);
			
			response.sendRedirect("listar.jsp");
			break;
			
		case "deleter":
			aluno.setId(Integer.parseInt(request.getParameter("id")));
			dao.delete(aluno);
			response.sendRedirect("listar.jsp");
			
			break;
			
		case "atualizar":

			aluno.setId(Integer.parseInt(request.getParameter("id")));
			aluno.setNome(request.getParameter("nome"));
			aluno.setEmail(request.getParameter("email"));
			aluno.setEndereco(request.getParameter("endereco"));
			aluno.setIdade(Integer.parseInt(request.getParameter("idade")));
			aluno.setMatricula(Long.parseLong(request.getParameter("matricula")));
			aluno.setTelefone(Long.parseLong(request.getParameter("telefone")));
			aluno.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
			
			dao.update(aluno);
			response.sendRedirect("listar.jsp");
			break;
			
			
		}
	}
}
