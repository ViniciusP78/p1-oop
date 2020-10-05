<%-- 
    Document   : index
    Created on : 05/10/2020, 12:51:59
    Author     : Vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fatecpg.poo.p1.Disciplina" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% ArrayList<Disciplina> disciplinas = Disciplina.getList(); %>
        
        <h1>VINICIUS FRANCISCO DE SOUSA PEREIRA</h1>
        <h2>1290482023040<h2>
                
        <h2>Quantidade de Disciplinas Matriculas: <%= disciplinas.size() %></h2>
                
        <% for ( Disciplina disciplina : disciplinas) { %>
            <h3><%= disciplina.getNome()%></h3>
        <%}%>
    </body>
</html>
