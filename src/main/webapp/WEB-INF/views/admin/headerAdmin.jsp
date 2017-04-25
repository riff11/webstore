<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="page_header">
		<div id="page_heading">
			<a href='${pageContext.request.contextPath}/admin'>
				<h1>
					<span>WebStore</span>
				</h1>
			</a>
		</div>

		<div id="page_headerlinks">
			<ul>
				<li><a href='${pageContext.request.contextPath}'>Выход</a></li>
			</ul>

		</div>


		<!-- Start of Page Menu -->
		<div id="page_menu">
			<ul>
				<li><a
					href='${pageContext.request.contextPath}/admin/addProduct'>Продукты</a></li>
				<!-- <li><a href="./Status">Статус заказа</a></li> -->
				<!-- <li><a href="./shopcartinfo">Корзина</a></li> -->

				<%-- <%
					if ( request.isUserInRole("ROLE_ADMIN")) {
				%> --%>
				<li><a
					href='${pageContext.request.contextPath}/admin/addCategory'>Категории</a></li>

				<li><a
					href='${pageContext.request.contextPath}/admin/addProducers'>Производители</a></li>

				<!-- <li class="last"><a href="./manager1">Менеджер</a></li> -->
				<%-- <%
					}
				%> --%>
				<%-- <%
					if ( request.isUserInRole("ROLE_MANAGER")) {
				%>
				<li><a href="./manager1">Менеджер</a></li>
				<%
					}
				%> --%>
			</ul>
		</div>

		<!-- End of Page Menu -->
	</div>
</body>
</html>