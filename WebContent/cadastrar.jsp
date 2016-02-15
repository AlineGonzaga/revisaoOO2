<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro do Aluno</title>
</head>
<body>
	<form action="alunoCONTROLLER" method="get" >
		<input type="hidden" name="operacao" value="incluir" >
		
		<label for="nome">Nome:</label>
		<input type="text" id="nome" name="nome"/><br/>
		
		<label for="telefone">Telefone:</label>
		<input type="text" id="telefone" name="telefone"/><br/>
		
		<label for="email" >Email:</label>
		<input type="text" id="email" name="email"><br/>
		
		<label for="endereco">Endereço:</label>
		<input type="text" id="endereco" name="endereco"><br/>
		
		<label for="matricula">Matrícula:</label>
		<input type="text" id="matricula" name="matricula"><br/>
		
		<label for="idade">Idade:</label>
		<input type="text" id="idade" name="idade"><br/>
		
		<label for="ativo">Ativo:</label>
		<input type="checkbox" id="ativo" name="ativo"><br/>
		
		<input type="submit" value="Cadastre">
	</form>
</body>
</html>