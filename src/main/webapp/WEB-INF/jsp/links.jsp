<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>List of the links</title>
</head>

<body>
	<div>
		<ul>
			<c:forEach var="link" items="${links}">
				<li>Link url: ${link.url}</li>
				<li>Meta description: ${link.metaDescription}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>