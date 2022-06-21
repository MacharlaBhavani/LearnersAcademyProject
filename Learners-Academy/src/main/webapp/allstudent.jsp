<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.learnersacademy.trg.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 List<Student>  allStudents=(List<Student>)request.getAttribute("allStudents");

%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table  border="1">
        <tr>
         <td width="10">student_id</td>
         <td width="168">StudentName</td>
         <td width="10">Class</td>
       </tr>
    <c:forEach items="${allStudents}" var="students">
        <tr>
            <td width="10">${students.student_id}</td>
            <td width="168">${students.studentname}</td>
            <td width="10">${students.class_in}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>