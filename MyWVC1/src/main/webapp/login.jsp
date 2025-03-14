<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login PAGE</h1>

<form:form action="checkLogin" method="post" modelAttribute="mylogin">
<pre>
Enter Name:     <form:input path="userName"/>
                <form:errors path="userName"/>
<br/>
Enter Password: <form:password path="password"/>
				<form:errors path="password"/>
<br/>
                <input type="submit" value="Login"/>
  </pre>
</form:form>


</body>
</html>