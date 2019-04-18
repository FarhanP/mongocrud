<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table id="list" border="2" width="70%" cellpadding="2"> 
<tr>
<th>Id</th><th>Name</th><th>Age</th><th>location</th><th>DOB</th>
</tr>

<c:forEach items="${list}" var="student">   
<tr>
   <td>${student.studentId}</td>  
   <td>${student.studentName}</td>  
   <td>${student.age}</td>  
   <td>${student.location}</td>
   <td>${student.dateOfBirth}</td>  
</tr>
 </c:forEach>

</body>
</html>