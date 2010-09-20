<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>User Details</title></head>
<body>
  <h3>User's Details:</h3>
  First Name: <c:out value="${link.url}"/>
  Last Name: <c:out value="${link.metaDescription}"/>
</body>
</html>