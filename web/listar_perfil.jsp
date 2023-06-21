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
                if(confirm('Deseja realmente excluir o perfil '+nome+'?')) {
                    location.href='gerenciar_perfil.do?acao=deletar&idPerfil='+id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Perfis</h1>
            
            <a href="form_perfil.jsp">Novo cadastro</a>
            
            <table>
                <th>ID</th>
                <th>Nome</th>
                <th>Opções</th>
                
                <jsp:useBean class="model.dao.PerfilDAO" id="pDAO"/>
                
                <c:forEach var="p" items="${pDAO.lista}">
                
                <tr>
                    <td>${p.idPerfil}</td>
                    <td>${p.nome}</td>
                    <td>
                        <a href="gerenciar_perfil.do?acao=alterar&idPerfil=${p.idPerfil}">
                            Alterar
                        </a>
                        <button onclick="confirmarExclusao(${p.idPerfil},'${p.nome}')">
                            Excluir
                        </button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
