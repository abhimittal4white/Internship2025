<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Product</h1>  
       <form:form method="post" action="save1" modelAttribute="prod">    
        <table >    
         <tr>    
          <td>Product Id : </td>   
          <td><form:input path="pid"  /> <form:errors path="pid" cssStyle="color:red"/></td>  
         </tr>    
         <tr>    
          <td>Product Name :</td>    
          <td><form:input path="pname" /><form:errors path="pname" cssStyle="color:red"/></td>  
         </tr>   
         <tr>    
          <td>Product Price :</td>    
          <td><form:input path="price" /><form:errors path="price" cssStyle="color:red"/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>