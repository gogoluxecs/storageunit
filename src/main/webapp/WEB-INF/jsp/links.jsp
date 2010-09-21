<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<response>
	<url><c:out value="${link.url}"/></url>
	<meta_description><c:out value="${link.metaDescription}"/></meta_description>
</response>