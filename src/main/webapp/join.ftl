<!DOCTYPE html>
<html>
	<head>
		<title> Happy WOrld </title>
	</head>
	<body>
		<form method="post" action="/join">
			���̵� : <input type="text" name="userId" /><br>
			��й�ȣ : <input type="password" name="password" /><br>
			<input type="hidden" name="role" value="ROLE_USER" /><br>
			<input type="submit" value="Ȯ��">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>