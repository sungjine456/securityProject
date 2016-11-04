<!DOCTYPE html>
<html>
	<head>
		<title> Happy WOrld </title>
	</head>
	<body>
		<form method="post" action="/join">
			아이디 : <input type="text" name="userId" /><br>
			비밀번호 : <input type="password" name="password" /><br>
			<input type="hidden" name="role" value="ROLE_USER" /><br>
			<input type="submit" value="확인">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>