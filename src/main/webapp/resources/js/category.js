$(document).ready(

function() {
	$("#addCategory").click(function() {
		var arr = jsonSiblingsCategory;
		id = arr[$("#child_edit").val() - 1].id;
		$.ajax({
			url : 'addCategory.json',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : JSON.stringify({
				name : $("input[name='AddCategory']").val(),
				parentId : id
			}),
			/*
			 * "&name=" + $("input[name='AddCategory']").val() + "&parent_id" +
			 * id,
			 */
			success : function(data) {
				alert("OK");
			}
		});
	});
	$("#delCategory").click(function() {
		// alert("delProducer");
		$.ajax({
			url : 'deleteCategory.json',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : JSON.stringify({
				name : $("input[name='DeleteCategory']").val()
			}),
			error : function(xhr, ajaxOptions, thrownError) {
				// alert(xhr.status);
				// alert(thrownError);
			},
//			data : "&categoryName=" + $("input[name='DeleteCategory']").val(),
			success : function() {
				alert("OK");
			}
		});
	});
	// $("#child_edit").change(function() {
	//
	// });

});