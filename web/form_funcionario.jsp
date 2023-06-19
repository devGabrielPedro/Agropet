<%-- 
    Document   : index
    Created on : 11/05/2023, 16:55:50
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
        <title>Agropet</title>
    </head>
    <body>
        <div class="container-fluid">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Cadastrar Funcionário</h1>
            
            <form action="gerenciar_funcionario.do" method="POST">
                <input type="hidden" name="idFuncionario" value=""/>
                <div>
                    <h2>Dados do Funcionário</h2>
                    <label for="nome_fun">Nome:</label>
                    <input type="text" id="nome_fun" name="nome_fun" required="" value="" maxlength="50"/><br>
                    <label for="cpf_fun">CPF:</label>
                    <input type="text" id="cpf_fun" name="cpf_fun" required="" value="" maxlength="11"/><br>
                    <label for="endereco_fun">Endereço:</label>
                    <input type="text" id="endereco_fun" name="endereco_fun" required="" value="" maxlength="45"/><br>
                    <label for="telefone_fun">Telefone:</label>
                    <input type="text" id="telefone_fun" name="telefone_fun" required="" value="" maxlength="45"/><br>
                    <label for="funcao_fun">Função:</label>
                    <input type="text" id="funcao_fun" name="funcao_fun" required="" value="" maxlength="45"/><br>
                    <label for="email_fun">Email:</label>
                    <input type="text" id="email_fun" name="email_fun" value="" maxlength="60"/><br>
                    <label for="idPerfil">Perfil:</label>
                    <select name="idPerfil" required="">
                        <option value="">Selecione o Perfil</option>
                        <jsp:useBean class="model.dao.PerfilDAO" id="idPerfil"/>
                        <c:forEach var="p" items="${idPerfil.lista}">
                            <option value="${p.idPerfil}">${p.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <button>Gravar</button>
                    <a href="listar_funcionario.jsp">Voltar</a>
                </div>
                
            </form>
        </div>
    </body>
</html>
