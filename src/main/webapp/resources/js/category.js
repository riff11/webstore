$(document).ready(

function() {
	$("#addCategory").click(function() {
		var arr = JSON.parse(jsonCategoryRoot).categories;
		id = null;
		if ($("#typeAdd").val() != 0)
			id = arr[$("#typeAdd").val() - 1].id;
		$.ajax({
			url : 'addCategory.json',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : JSON.stringify({
				name : $("input[name='AddCategory']").val(),
				parentId : id
			}),
			error : function() {
				alert("bad");
				location.reload();
			},
			success : function() {
				alert("OK");
				location.reload();
			}
		});
	});
	$("#delCategory").click(function() {
		$.ajax({
			url : 'deleteCategory.json',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : JSON.stringify({
				name : $("input[name='DeleteCategory']").val()
			}),
			error : function() {
				alert("bad");
				location.reload();
			},
			success : function() {
				alert("OK");
				location.reload();
			}
		});
	});

});