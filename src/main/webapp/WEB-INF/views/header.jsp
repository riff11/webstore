<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="page_header">
		<div id="page_heading">
			<a href='${pageContext.request.contextPath}'>
				<h1>
					<span>WebStore</span>
				</h1>
			</a>
		</div>
		<div id="page_headerlinks">
			<ul>
				<li><a href="${pageContext.request.contextPath}/admin">Админка</a></li>
			</ul>
		</div>
	</div>
</body>
</html>