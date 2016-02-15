<%@page import="DAO.AlunoDAO"%>
<%@page import="MODEL.Aluno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizando aluno</title>
</head>
<body>
	<% Aluno aluno = new AlunoDAO().find(Integer.parseInt(request.getParameter("id")));%>
	
	<form action="alunoCONTROLLER" method="get">
		<input type="hidden" name="operacao" value="atualizar">
		<input type="hidden" name="id" value="<%=aluno.getId()%>">
		
		<label for="name">Nome:</label>
		<input type="text" id="nome" name="nome" value="<%=aluno.getNome()%>"/><br/>
		
		<label for="telefone">Telefone:</label>
		<input type="text" id="telefone" name="telefone" value="<%=aluno.getTelefone() %>"/><br/>
		
		<label for="email">E-mail:</label>
		<input type="text" id="email" name="email" value="<%=aluno.getTelefone() %>" /><br>
		
		<label for="endereco">Endereço:</label>
		<input type="text" id="endereco" name="endereco" value="<%=aluno.getTelefone() %>"/><br>
		
		<label for="matricula">Matricula</label>
		<input type="text" id="matricula" name="matricula" value="<%=aluno.getMatricula() %>"/><br>
		
		<label for="idade">Idade</label>
		<input type="text" id="idade" name="idade" value="<%=aluno.getIdade() %>"/><br>
		
		<label for="ativo">Ativo:</label>
		
		<%if(aluno.getAtivo()==true){ %>
			<input type="checkbox" id="ativo" name="ativo" value="true"/><br>
		<%}else { %>
			<input type="checkbox" id="ativo" name="ativo" value="true" checked="checked"/><br>
		<%} %>		
		<input type="submit" value="Atualizar">		
	</form>
</body>
</html>