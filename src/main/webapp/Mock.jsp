<%@page import="dto.Mock_Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<table border=1px cellspacing=10px cellpadding=10px>
			<tr>
				<td>ID:<input type="text" name="id"></td>
				<td>NAME:<input type="text" name="name"></td>
				<td>MOBILE:<input type="text" name="mobile"></td>
				<td><button type="submit">INSERT</button>
			</tr>
			<br>
		</table>
	</form>
	<form action="search" method="post">
		<table border=1px cellspacing=10px cellpadding=10px>
			<tr>
				<td>ID:<input type="text" name="id"></td>
				<td><button>Search</button>
			</tr>
			<br>
		</table>
	</form>
	<form action="searchName" method="post">
		<br>
		<table border=1px cellspacing=10px cellpadding=10px>
			<tr>
				<td>NAME:<input type="text" name="name"></td>
				<td><button>Search</button>
			</tr>
			<br>
		</table>
	</form>
	<form action="fetchAll" method="post">
		<table border=1px cellspacing=10px cellpadding=10px>
			<tr>
				<br>
				<button>Fetch All</button>
			</tr>
			<br>
		</table>
	</form>
</body>
</html>