$(document).ready(

function() {

	$("#addProducer").click(function() {
		$.ajax({
			url : 'addProducers',
			type : 'POST',

			data : "&producerName=" + $("input[name='AddProducer']").val(),
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
	$("#delProducer").click(function() {
		$.ajax({
			url : 'deleteProducers',
			type : 'POST',
			data : "&producerName=" + $("input[name='DeleteProducer']").val(),
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