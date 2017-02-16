<%@ page isErrorPage="true"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Sorry, something went wrong...</h1>

<c:choose>
	<c:when test="${not empty exception && not empty exception.message}">
		<p>
			${exception.message}
		</p>
	</c:when>
	<c:otherwise>
		Insert error section here.
	</c:otherwise>
</c:choose>
