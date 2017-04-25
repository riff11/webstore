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
	/* alert('jsonCategoryRoot:' + '${jsonCategoryRoot}'); */
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/home.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/category.js" />"></script>

<title>jStore</title>
</head>
<body>
	<div id="container">
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/admin/headerAdmin.jsp" />
		<!-- End of Page Header -->

		<%-- <!-- left_sidebar -->
		<c:import url="/WEB-INF/views/product/leftSideBar.jsp" /> --%>

		<!-- End of Left Sidebar -->

		<!-- Start of Main Content Area -->
		<div id="main_content1">
			<div class="container">
				<fieldset>
					<br>
					<legend>Добавление категории товаров </legend>
					<input type="text" name="AddCategory" placeholder="category" />
					<!-- Форма для динамических списков -->
					<form action="" method="post" id="dynamic_selects" name="addCategory">
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
							<select id="child_edit" disabled>
								<option value="0">Выберите из списка</option>
								<%-- <c:forEach var="type" items="${productTypes}" varStatus="loop">
								<option value="${loop.getIndex()+1}">${type.getName()}</option>
							</c:forEach> --%>
							</select>
						</div>
					</form>
					 <input
						type="submit" value="AddCategory" id="addCategory"> <br>
					<br>
				</fieldset>
				<br>
				<fieldset>
					<br>
					<legend>Удалить категории товара по имени</legend>
					<input type="text" name="DeleteCategory" placeholder="category" />
					<input type="submit" value="DeleteCategory" id="delCategory">
					<br> <br>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>