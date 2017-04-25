$(document).ready(

function() {

	$("#addProducer").click(function() {
//		alert("addProduce");
		$.ajax({
			url : 'addProducers',
			type : 'POST',

			data : "&producerName=" + $("input[name='AddProducer']").val(),
			error : function(xhr, ajaxOptions, thrownError) {
//				alert(xhr.status);
//				alert(thrownError);
			},
			success : function() {
				alert("OK");
			}
		});
	});
	$("#delProducer").click(function() {
//		alert("delProducer");
		$.ajax({
			url : 'deleteProducers',
			type : 'POST',
			error : function(xhr, ajaxOptions, thrownError) {
//				alert(xhr.status);
//				alert(thrownError);
			},
			data : "&producerName=" + $("input[name='DeleteProducer']").val(),
			success : function() {
				alert("OK");
			}
		});
	});
	// $("#child_edit").change(function() {
	//
	// });

});