<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Страница обработки ошибки</title>
    </head>
    <body>
       <h1>Страница обработки ошибки</h1>
       <h2>Ваша страница сгенерировала ошибку : <%= exception.toString() %> </h2>
    </body>
</html>