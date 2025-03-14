<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" width="70%" cellpadding="2">  
<tr><th>Product Id </th><th>Product Name</th><th>Product Price in Rs. </th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="prod" items="${aslist}">   
   <tr>  
   <td>${prod.pid}</td>  
   <td>${prod.pname}</td>  
   <td>${prod.price}</td>  

   <td><a href="editprod/${prod.pid}">Edit</a></td>  
   <td><a href="deleteprod/${prod.pid}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="form">Add New Product</a>  
</body>
</html>