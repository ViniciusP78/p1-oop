<%-- 
    Document   : disciplinas
    Created on : 05/10/2020, 13:02:29
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
        <h1>Minhas Disciplinas</h1>
        
        <%
            ArrayList<Disciplina> disciplinas = (ArrayList)application.getAttribute("disciplinas");
            
            if (disciplinas == null) {
                disciplinas = Disciplina.getList();
            }
            
            String[] notas = request.getParameterValues("notas");
            
            if(notas != null) {
                for (int i = 0; i < disciplinas.size(); i++ ) {
                    disciplinas.get(i).setNota(Double.parseDouble(notas[i]));
                }
                
            application.setAttribute("disciplinas", disciplinas);
            }
            
            
        %>
        
        <form>
        <table>
            <tr>
                <th>Disciplinas</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Alterar</th>
            </tr>
            <% for ( Disciplina disciplina : disciplinas) { %>
            <tr>
                <td><%= disciplina.getNome() %></td>
                <td><%= disciplina.getEmenta()%></td>
                <td><%= disciplina.getCiclo()%></td>
                <td><%= disciplina.getNota()%></td>
                <td><input type="text" name="notas" value="<%= disciplina.getNota()%>"></td>
            </tr>
            
            <%}%>
        </table>
        <input type="submit" value="Enviar">
        </form>
        
        
        
    </body>
</html>
