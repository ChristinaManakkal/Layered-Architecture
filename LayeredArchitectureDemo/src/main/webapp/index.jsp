<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="insertlap">
	
	Enter lid:<input type="text" name="lid"/><br/>
	Enter make:<input type="text" name="make"/><br/>
	Enter cost:<input type="text" name="cost"/><br/>
	<input type="submit"/>
	</form><br/><br/>
	
	<form action="showlaps">
	<input type="submit" value="show"/>
	</form>
</body>
</html>