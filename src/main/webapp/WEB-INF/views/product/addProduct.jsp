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
	var childSelected = '${childSelected}';
	var jsonCategoryRoot = '${jsonCategoryRoot}';
	var pageContext = '${pageContext.request.contextPath}';
	var rootSelected = '${rootSelected}';
	var jsonProducersList = '${jsonProducersList}';
	/* alert('jsonCategoryRoot:' + '${jsonCategoryRoot}'); */
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/home.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/product.js"/>"></script>

<title>jStore</title>
</head>
<body>
	<div id="container">
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/admin/headerAdmin.jsp" />
		<!-- End of Page Header -->

		<!-- left_sidebar -->
		<c:import url="/WEB-INF/views/product/leftSideBar.jsp" />

		<fieldset>
			<legend>Добавить продукт</legend>
			<br> <input type="text" id="name" name="name" placeholder="Name" />
			<form action="" method="post" id="dynamic_selectsEdit">
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
			<input type="text" id="price" name="price" placeholder="Price" />
			<div class="row" id="producersCatalog">
				<!-- Создаем поле со списком -->
				<label for="producers">Каталог производителей:</label> <select
					id="producers">
					<option value="0">Выберите из списка</option>
					<%-- <c:forEach var="producer" items="${producersList}" varStatus="loop">
						<option value="${loop.getIndex()+1}">${producer.getName()}</option>
					</c:forEach> --%>
				</select>
			</div>
			<label for="available">На складе:</label> <input type="checkbox"
				id="available" name="available" placeholder="available" /></br> <br>
			<textarea id="description" rows="10" cols="45" name="descr"
				placeholder="Description"> </textarea>
			<br> <input type="submit" id="add" value="Add"><br>
		</fieldset>

		<br>
		<%-- <fieldset>
			<h1>Загрузить картинку</h1>
			<br>
			<c:if test="${not empty originalFileName}">
				<h2>
					Uploaded file's name is:
					<c:out value="${originalFileName}" />
				</h2>
			</c:if>
			<div>
				<form action="form" method="post" enctype="multipart/form-data">
					<div>
						<input type="file" name="file" /> <input type="hidden"
							name="idpicture" value="0" />
					</div>
					<div>
						<input type="submit" id="idp" value="Upload" />
					</div>
				</form>
			</div>
		</fieldset> --%>
		<br>

	</div>
</body>
</html>