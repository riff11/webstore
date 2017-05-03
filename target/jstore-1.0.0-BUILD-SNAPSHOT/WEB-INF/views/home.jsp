<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<link href="<c:url value="/resources/css/store.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.9.1.js" />"></script>
<script>
	var jsonSiblingsCategory = '${jsonSiblingsCategory}';
	var childSelected = "${childSelected}";
	var jsonCategoryRoot = '${jsonCategoryRoot}';
	var pageContext = "${pageContext.request.contextPath}";
	var rootSelected = "${rootSelected}";
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/home.js" />"></script>
<link rel="icon" type="image/png" href="/resources/favicon.jpg">
<title>jStore</title>
</head>
<body>
	<div id="container">
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/header.jsp" />
		<!-- End of Page Header -->

		<!-- Start of Left Sidebar -->
		<div id="left_sidebar">
			<div id="categories">
				<div id="categories_header">
					<h2>
						<a href='${pageContext.request.contextPath}'>Список товаров</a>
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
						<select id="child" disabled>
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

		<!-- Shop Window -->
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/show_window.jsp" />

		<!-- End of Main Content Area -->
		<div class="clearthis">&nbsp;</div>
	</div>
</body>
</html>