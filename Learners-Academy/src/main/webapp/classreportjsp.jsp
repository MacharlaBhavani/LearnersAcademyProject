<%@page import="com.learnersacademy.trg.dto.Student"%>
<%@page import="com.learnersacademy.trg.dto.ClassDetails"%>
<%@page import="java.util.List"%>
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

     List<Student>  list=(List<Student>)request.getAttribute("list"); 
     List<ClassDetails> details=(List<ClassDetails>)request.getAttribute("list1");

%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <csajsp:heading> 
   Students 
</csajsp:heading>

<table  border="1">
        <tr>
         <td width="10">Student_id</td>
         <td width="168">StudentName</td>
         <td width="10">Class</td>
       </tr>
    <c:forEach items="${list}" var="students">
        <tr>
            <td width="10">${students.student_id}</td>
            <td width="168">${students.studentname}</td>
            <td width="10">${students.class_in}</td>
        </tr>
    </c:forEach>
</table>

<csajsp:heading> 
   ClassDetails
</csajsp:heading>

<table  border="1">
        <tr>
         <td width="10">Class</td>
         <td width="168">teacher_id</td>
         <td width="10">subject</td>
       </tr>
    <c:forEach items="${list1}" var="classdetails">
        <tr>
            <td width="10">${classdetails.class_in}</td>
            <td width="168">${classdetails.teacher_id}</td>
            <td width="10">${classdetails.subject}</td>
        </tr>
    </c:forEach>
</table>


    
</body>
</html>