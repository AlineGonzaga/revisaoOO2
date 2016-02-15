<%@page import="MODEL.Aluno"%>
<%@page import="DAO.AlunoDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de alunos</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Telefone</td>
			<td>Matricula</td>
			<td>Estado</td>
			<td>Endereco</td>
			<td>Idade</td>
			<td>Ação</td>
		</tr>
		<% 
			for(Aluno aluno : new AlunoDAO().list()){
		%>	
		<tr>
			<td><%=aluno.getId() %></td>
			<td><%=aluno.getNome()%></td>
			<td><%=aluno.getEmail() %></td>
			<td><%=aluno.getTelefone() %></td>
			<td><%=aluno.getMatricula() %></td>
			    <%if(aluno.getAtivo() == true) {%>
				<td>Ativo</td>
				  <%} else { %>
				<td>Desativado</td>
				<%} %>
			<td><%=aluno.getEndereco() %></td>
			<td><%=aluno.getIdade() %></td>
			<td><a href="alunoCONTROLLER?operacao=deletar&id=<%=aluno.getId()%>">Deleter</a></td>
			<td><a href="atualizar.jsp?id=<%=aluno.getId()%>">Editar</a></td>
			<td><a href="cadastrar.jsp">Cadastrar</a><td/>
	  </tr>
	  <%} %>
	</table>
</body>
</html>