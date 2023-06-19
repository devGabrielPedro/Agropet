<%-- 
    Document   : index
    Created on : 11/05/2023, 16:55:50
    Author     : Gabriel
--%>

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
            <h1>Cadastrar Perfil</h1>
            
            <form action="gerenciar_perfil.do" method="POST">
                <input type="hidden" name="idPerfil" value="${perfil.idPerfil}"/>
                <div>
                    <h2>Dados do Perfil</h2>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required="" value="${perfil.nome}" maxlength="45"/><br>
                    <label for="login_per">Login:</label>
                    <input type="text" id="login_per" name="login_per" required="" value="${perfil.login_per}" maxlength="45"/><br>
                    <label for="senha_per">Senha:</label>
                    <input type="password" id="senha_per" name="senha_per" required="" value="${perfil.senha_per}" maxlength="45"/><br>
                </div>
                <div>
                    <button>Gravar</button>
                    <a href="listar_perfil.jsp">Voltar</a>
                </div>
                
            </form>
        </div>
    </body>
</html>
