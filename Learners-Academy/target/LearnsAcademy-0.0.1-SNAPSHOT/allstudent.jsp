<%@page import="java.util.Set"%>
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
      
    
    Set<Student>  allstudents=(Set<Student>)request.getAttribute("allStudents");
    for(Student students : allstudents)
    {
        out.print("Id: " + students.getAdmission_no());
        out.print("<br/>");
        out.print("Name: " + students.getStudentname());
        out.print("<br/>");
        out.print("class: " + students.getClassinfo());
        
        out.print("<br/>");
        out.print("<br/>");
    }
     
     
   %>

</body>
</html>