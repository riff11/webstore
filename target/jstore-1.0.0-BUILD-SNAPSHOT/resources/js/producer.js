$(document).ready(

function() {
	$("#myTable").tablesorter({
		sortList : [ [ 0, 0 ], [ 1, 0 ] ]
	});

	$("input[name='deleteFewProducers']").click(function() {
		var idProductList = [];
		$("input:checked").each(function() {
			idProductList.push($(this).val())
		});
		if (idProductList.length != 0) {
			$.ajax({
				url : 'deleteFewProducers.json',
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				data : JSON.stringify(idProductList),
				error : function() {
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

	$("#addProducer").click(function() {
		$.ajax({
			url : 'addProducers',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : $("input[name='AddProducer']").val(),
			error : function() {
//				alert("bad");
				location.reload();
			},
			success : function() {
//				alert("OK");
				location.reload();
			}
		});
	});
	$("#delProducer").click(function() {
		$.ajax({
			url : 'deleteProducers',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : $("input[name='DeleteProducer']").val(),
			error : function() {
//				alert("bad");
				location.reload();
			},
			success : function() {
//				alert("OK");
				location.reload();
			}
		});
	});

});