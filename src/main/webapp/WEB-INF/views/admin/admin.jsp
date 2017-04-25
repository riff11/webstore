<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.9.1.js" />"></script>
<script>
	var jsonSiblingsCategory = '${jsonSiblingsCategory}';
	var childSelected = "${childSelected}";
	var jsonCategoryRoot = '${jsonCategoryRoot}';
	var pageContext = "${pageContext.request.contextPath}";
	var rootSelected = "${rootSelected}";
	/* alert('jsonCategoryRoot:' + '${jsonCategoryRoot}'); */
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/home.js" />"></script>
<title>Shop</title>
</head>
<body>
	<div id="container">
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/admin/headerAdmin.jsp" />
		<!-- End of Page Header -->

		<!-- Start of Left Sidebar -->
		<div id="left_sidebar">
			<div id="categories">
				<div id="categories_header">
					<h2>
						<a href='${pageContext.request.contextPath}/admin'>Список
							товаров</a>
					</h2>
				</div>
				<!-- <ul> -->
				<!-- Форма для динамических списков -->
				<form action="" method="post" id="dynamic_selects">
					<div class="row">
						<label for="type">Каталог товаров:</label>
						<!-- Создаем поле со списком -->
						<select id="type">
							<option value="0">Выберите из списка</option>
							<%-- <c:forEach var="type" items="${productTypesRoot}" varStatus="loop">
								<option value="${loop.getIndex()+1}">${type.getName()}</option>
							</c:forEach> --%>
						</select>
					</div>
					<div class="row">
						<!-- Создаем поле со списком -->
						<select id="child_admin" disabled>
							<option value="0">Выберите из списка</option>
							<%-- <c:forEach var="type" items="${productTypes}" varStatus="loop">
								<option value="${loop.getIndex()+1}">${type.getName()}</option>
							</c:forEach> --%>
						</select>
					</div>

				</form>

				<div class="clearthis">&nbsp;</div>
			</div>


		</div>
		<div id="main_content">
			<div id="filter">

				По Цене:
				от <input type="text" id="min" value="${min}"> до <input
					type="text" id="max" value="${max}"> На складе: <input
					type="checkbox" id="available"
					<c:if test="${available}">checked</c:if>>
				<button id="linkprice_sort">Найти</button>
			</div>
			<c:forEach var="prod" items="${list}">
				<div id="new_item">
					<div id="new_item_header">
						<h1>${prod.name}</h1>

					</div>
					<div id="new_item_image">
						<img src="${pageContext.request.contextPath}/${prod.image}"
							height="150" alt="New Item Name" />
					</div>
					<div class="price">
						<h2>${prod.price}</h2>
					</div>

					<div id="new_item_link"></div>

				</div>
			</c:forEach>


			<c:if test="${empty list}">
				<h1>Товаров не найдено</h1>
			</c:if>

		</div>

		<!-- End of Main Content Area -->
		<div class="clearthis">&nbsp;</div>
	</div>
</body>
</html>