<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="main_content">
		<div id="filter">

			По Цене: от <input type="text" id="min" value="${min}"> до <input
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
				<%-- <div id="new_item_image">
						<img src="${pageContext.request.contextPath}/${prod.image}"
							height="150" alt="New Item Name" />
					</div> --%>
				<div class="price">
					<h2>${prod.price}</h2>
				</div>
				<div>
					<h4 id="">${prod.description}</h4>
				</div>

				<div id="new_item_link"></div>

			</div>
		</c:forEach>


		<c:if test="${empty list}">
			<h1>Товаров не найдено</h1>
		</c:if>

	</div>
</body>
</html>