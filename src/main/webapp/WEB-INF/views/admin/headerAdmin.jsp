<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
			<li><a
				href='${pageContext.request.contextPath}/admin/addCategory'>Категории</a></li>

			<li><a
				href='${pageContext.request.contextPath}/admin/addProducers'>Производители</a></li>

		</ul>
	</div>

	<!-- End of Page Menu -->
</div>
