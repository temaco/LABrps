<%-- 
    Document   : index
    Created on : Jun 5, 2018, 6:57:31 PM
    Author     : mikhail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="com.kurochkin.bean.re.IDAOLog"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.ejb.EJB"%>



<%
    InitialContext ctx=new InitialContext();

    IDAOLog daolog = (IDAOLog) ctx.lookup("com.kurochkin.bean.re.IDAOLog");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="MessageServlet" method="post">
        Enter your message:
        <input type="text" name="msg" value=""/>
          <div>
            <input type="checkbox"  name="replyto" value="1">
            <label for="subscribeNews">Reply To?</label>
          </div>
          <div>
            <input type="checkbox"  name="objmsg" value="1">
            <label for="subscribeNews">Object message?</label>
          </div>
        <input type="submit" name="action" value="Send"/>
    </form>
    <table style="border: 1px solid black">
        <tr>
            <td>Id</td>
            <td>Name</td>
        </tr>
        <h3>Your messages:</h3>
        <c:forEach var="log" items="<%= daolog.getAll()%>">
            <tr>
                <td style="border: 1px solid black"><c:out value="${log.getId()}"/></td>
                <td style="border: 1px solid black"><c:out value="${log.getName()}"/></td>         
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
