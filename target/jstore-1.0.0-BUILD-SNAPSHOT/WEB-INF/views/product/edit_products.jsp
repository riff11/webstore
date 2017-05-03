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
<script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery.tablesorter.js" />"></script>
<script>
	var jsonSiblingsCategory = '${jsonSiblingsCategory}';
	var childSelected = "${childSelected}";
	var jsonCategoryRoot = '${jsonCategoryRoot}';
	var pageContext = "${pageContext.request.contextPath}";
	var rootSelected = "${rootSelected}";
	var jsonProducersList = '${jsonProducersList}';
	/* alert('jsonCategoryRoot:' + '${jsonCategoryRoot}'); */
</script>

<%-- <script type="text/javascript"
	src="<c:url value="/resources/js/store.js"/>"></script> --%>
<script type="text/javascript"
	src="<c:url value="/resources/js/home.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/productTable.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/product.js" />"></script>

<title>jStore</title>
</head>
<body>
	<div id="container">
		<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/admin/headerAdmin.jsp" />
		<!-- End of Page Header -->

		<!-- left_sidebar -->
		<c:import url="/WEB-INF/views/product/leftSideBar.jsp" />

		<!-- End of Left Sidebar -->
		<!-- Start of Main Content Area -->
		<div id="main_content">

			<!-- <form action="DeleteFew" method="post"> -->
			<fieldset>
				<legend>Редактирование продуктов</legend>
				<br> <input type="hidden" id="lastId" value="${lastId}" />

				<c:if test="${not empty list}">

					<table id="myTable" class="tablesorter">
						<thead>
							<tr>
								<th>Id</th>
								<th>Название</th>
								<th>Цена</th>
								<th>Производитель</th>
								<th>Категория</th>
								<!-- <th>Картинка</th> -->
								<th>Описание</th>
								<th>На складе</th>
								<th>Редактировать</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<c:forEach var="prod" items="${list}">
								<tr id="tr${prod.id }">
									<td name="idColumn" id="${prod.id }">${prod.id }</td>
									<td id="name${prod.id }">${prod.name}</td>
									<td id="price${prod.id }">${prod.price}</td>
									<td id="producer${prod.id }">${prod.producer}</td>
									<td id="category${prod.id }">${prod.category}</td>
									<%-- <td id="picture${prod.id }">${prod.image}</td> --%>
									<td id="descr${prod.id }">${prod.description}</td>
									<td id="available${prod.id }">${prod.available}</td>
									<td>
										<center>
											<input type="radio" name="Radiobutton" id=${prod.id }>
										</center>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<!-- <br> <input type="submit" value="DeleteFew"> <br> -->
			</fieldset>

			<!-- </form> -->
			<br> <br> <input type="text" id="Editname" name="name"
				placeholder="Name" />
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
			<input type="text" id="Editprice" name="price" placeholder="Price" />
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
				id="Editavailable" name="available" placeholder="available" /></br> <br>
			<textarea id="Editdescription" rows="10" cols="45" name="descr"
				placeholder="Description"> </textarea>
			<br> <input type="submit" name="Edit" id="EEdit1" value="Edit">
			</fieldset>

		</div>
		<!-- End of Main Content Area -->
		<div class="clearthis">&nbsp;</div>

	</div>

</body>
</html>