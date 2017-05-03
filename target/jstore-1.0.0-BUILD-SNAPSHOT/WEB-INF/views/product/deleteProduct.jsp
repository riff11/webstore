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
	/* alert('jsonCategoryRoot:' + '${jsonCategoryRoot}'); */
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/productTable.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/deleteproduct.js" />"></script>

<title>Shop</title>
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
			<form action="deleteProduct" method="post">
				<fieldset>
					<legend>Удалить продукт по имени</legend>
					<input type="text" name="name" placeholder="name" /> <input
						type="submit" value="Удалить">
				</fieldset>
			</form>

			<!-- <form action="deleteFew" method="post"> -->
			<fieldset>
				<legend>Удалить несколько продуктов</legend>
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
								<th>Удалить</th>
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
											<input type="checkbox" value=${prod.id } id=${prod.id }>
										</center>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<br> <input name="deleteFewProducts" type="submit"
					value="Удалить несколько"> <br>

			</fieldset>

		</div>
		<div class="clearthis">&nbsp;</div>

	</div>

</body>
</html>