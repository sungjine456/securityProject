<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
logged in as <@security.authentication property="principal.username" /> 
<form action="/logout" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button type="submit" class="btn">Log out</button>
</form>