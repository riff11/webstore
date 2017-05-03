$(document).ready(function name() {

	$("input[name='deleteFewProducts']").click(function() {
		var idProductList = [];
		$("input:checked").each(function() {
			idProductList.push($(this).val())
		});
		if (idProductList.length != 0) {
			$.ajax({
				url : 'deleteFew.json',
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				data : JSON.stringify(idProductList),
				error: function() {
//					alert("bad");
					location.reload();
				},
				success : function() {
//					alert("ok");
					location.reload();
				}
			});
		}
	})
});