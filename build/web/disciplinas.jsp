<%-- 
    Document   : disciplinas
    Created on : 05/10/2020, 13:02:29
    Author     : Vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/menu.jspf" %>

<%@page import="fatecpg.poo.p1.Disciplina" %>
<%@page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Minhas Disciplinas</h1>
        
        <%
            if(request.getParameter("nome")!=null){
                String nome = (String)request.getParameter("nome");
                String ementa = (String)request.getParameter("ementa");
                int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                Double nota = Double.parseDouble(request.getParameter("nota"));
                
                Disciplina.insert(nome, ementa, ciclo, nota);
            }
            
            if(request.getParameter("id")!=null){
                Disciplina.delete(Long.parseLong(request.getParameter("id")));
            }
        %>
        
        <table>
            <tr>
                <th>Disciplinas</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Alterar</th>
            </tr>
            <%for(Disciplina d: Disciplina.getList()) {%>
            <tr>
                <td><%= d.getNome() %></td>
                <td><%= d.getEmenta() %></td>
                <td><%= d.getCiclo() %></td>
                <td><%= d.getNota() %></td>
                <td>
                    <form>
                        <input type="hidden" name="id" value="<%= d.getRowId()%>">
                        <input type="submit" value="Apagar">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
        
        <h2>Adicionar Disciplinas</h2>
        <form>
            <input type="text" name="nome" placeholder="Disciplina">
            <input type="text" name="ementa" placeholder="Ementa">
            <input type="text" name="ciclo" placeholder="Ciclo">
            <input type="text" name="nota" placeholder="Nota">
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>
