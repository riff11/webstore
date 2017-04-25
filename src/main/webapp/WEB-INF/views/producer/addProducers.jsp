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
<%-- <script type="text/javascript"
	src="<c:url value="/resources/js/home.js" />"></script> --%>
<script type="text/javascript"
	src="<c:url value="/resources/js/producer.js" />"></script>

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
					<legend>Добавление производителя товаров </legend>
					<input type="text" name="AddProducer" placeholder="producer" /> <input
						type="submit" value="AddProducer" id="addProducer"> <br>
					<br>
				</fieldset>
				<br>
				<fieldset>
					<br>
					<legend>Удалить производителя товара по имени</legend>
					<input type="text" name="DeleteProducer" placeholder="producer" />
					<input type="submit" value="DeleteProducer" id="delProducer">
					<br> <br>
				</fieldset>



			</div>





		</div>
	</div>
</body>
</html>