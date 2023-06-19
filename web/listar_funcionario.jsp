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
        <script type="text/javascript">
            function confirmarExclusao(id,nome) {
                if(confirm('Deseja realmente excluir o funcionário '+nome+'?')) {
                    location.href='gerenciar_funcionario.do?acao=deletar&idFuncionario='+id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Funcionários</h1>
            
            <a href="form_funcionario.jsp">Novo cadastro</a>
            
            <table id="listarFuncionario">
            <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Telefone</th>
                <th>Função</th>
                <th>Email</th>
                <th>Perfil</th>
                <th>Opções</th>
            </thead>    
                <jsp:useBean class="model.dao.FuncionarioDAO" id="fDAO"/>
                
                <c:forEach var="f" items="${fDAO.lista}">
                
                <tr>
                    <td>${f.idFuncionario}</td>
                    <td>${f.nome_fun}</td>
                    <td>${f.cpf_fun}</td>
                    <td>${f.endereco_fun}</td>
                    <td>${f.telefone_fun}</td>
                    <td>${f.funcao_fun}</td>
                    <td>${f.email_fun}</td>
                    <td>${f.idPerfil.nome}</td>
                    <td>
                        <a href="gerenciar_funcionario.do?acao=alterar&idPerfil=${f.idFuncionario}">
                            Alterar
                        </a>
                        <button onclick="confirmarExclusao(${f.idFuncionario},'${f.nome_fun}')">
                            Excluir
                        </button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
