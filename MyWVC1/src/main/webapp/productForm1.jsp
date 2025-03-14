<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login PAGE</h1>

<form:form action="checkProduct" method="post" modelAttribute="myproduct">
<pre>
Enter Product Id:     <form:input path="pid"/>
                		<form:errors path="pid"/>
<br/>
Enter Product Name:     <form:input path="pname"/>
                <form:errors path="pname"/>
<br/>
Enter Product Price: <form:input path="price"/>
				<form:errors path="price"/>
<br/>
                <input type="submit" value="prod"/>
  </pre>
</form:form>


</body>
</html>