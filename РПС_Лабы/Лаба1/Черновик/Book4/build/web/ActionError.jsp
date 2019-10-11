<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page1</title>
        </head>
        <body>
       
        <h:form>
            <table border="1" >
               <thead>
                   <tr>
                       <th>ID_book</th>
                       <th>Name_book</th>
                       <th>Author</th>
                       <th>Birthday</th>
                   </tr>
               </thead>               
                <tr>
                       <th>  <h:inputText value="#{book.ID_book}" required="true" id = "IDInput" validatorMessage="Ошибка" requiredMessage="Ошибка"> <f:validateLongRange minimum = "0" maximum = "500"/> </h:inputText> </th> 
                       <th>  <h:inputText value="#{book.kk}" required="true" id = "name_book" validatorMessage="Ошибка" requiredMessage="Ошибка"> <f:validateLength minimum="1" maximum="20"/> <f:validateRegex pattern="[a-zA-Z0-9_]+" /> </h:inputText></th> 
                       <th>  <h:inputText value="#{book.rip}" required="true" id = "author" validatorMessage="Ошибка" requiredMessage="Ошибка"> <f:validateLength minimum="1" maximum="20"/><f:validateRegex pattern="[a-zA-Z0-9_]+" /> </h:inputText></th>
                       <th>  <h:inputText value="#{book.birthday}"  required="true" id = "birthday" validatorMessage="Ошибка" requiredMessage="Ошибка"><f:convertDateTime type="date" pattern="yyyy-MM-dd"/></h:inputText></th> 
                </tr>
            </table>
                <br />
                <h:commandButton  action="#{book.create}" value="Добавить" />
                <br />      
                <h:message for = "IDInput" style = "color:red" />
                <br>
                <h:message for = "name_book" style = "color:red" />
                 <br>
                <h:message for = "author" style = "color:red" />
                <br>
                <h:message for = "birthday" style = "color:red" />
                

            </h:form>

        </body>
    </html>
</f:view>
