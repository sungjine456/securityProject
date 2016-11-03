<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<@security.authorize access="isAnonymous()">
    log out 
</@security.authorize>
<@security.authorize access="isAuthenticated()">
    log in 
</@security.authorize>
