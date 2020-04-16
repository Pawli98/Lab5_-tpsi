<%-- 
    Document   : tablica
    Created on : 2020-04-15, 17:25:38
    Author     : gp41370
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tablica zad nr.5</title>
    </head>
    <body>
        <h1>Lista studentów</h1>
        <table border="1">
            <thead>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.student_Tab}" var="student">
                    <tr>
                        <th><c:out value="${student.getFirstName()}"/> </th>
                        <th><c:out value="${student.getLastName()}"/> </th>
                        <th><c:out value="${student.getEmail()}"/> </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br><br>
        <h1>Dodaj nowego studenta:</h1>
        <form action='/lab5/tablica' method='post'>
            Imie:
            <input type='text' name='imie'><br>
            Nazwisko:
            <input type='text' name='nazwisko'><br>
            Email:
            <input type='text' name='email'><br>
            <input type='submit'>
	</form>
        
        
        <br><a href="/lab5/index.html"> Strona główna </a>
    </body>
</html>
