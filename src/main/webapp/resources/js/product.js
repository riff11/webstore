$(document).ready(

		function() {

			var idCategory;
			var idProducer;
			$("#add").disabled = true;
			$("#idp").disabled = true;
			var arrProducers = JSON.parse(jsonProducersList);
			if (jsonProducersList != "") {
				for (var i = 0; i < arrProducers.length; i++) {
					$('#producers').append(
							'<option value="' + (i + 1) + '">'
									+ arrProducers[i].name + '</option>');
				}

			}

			$("#add").click(function() {
				document.getElementById("idp").disabled = false;
				document.getElementById("add").disabled = true;
				// alert(jsonSiblingsCategory);
				var arrChildCategory = jsonSiblingsCategory;
				idCategory = arrChildCategory[$("#child_edit").val() - 1].id;
				idProducer = arrProducers[$("#producers").val() - 1].id;
				$.ajax({
					url : 'addProduct.json',
					type : 'POST',
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					data : JSON.stringify({
						"name" : $('#name').val(),
						"categories_fk" : idCategory,
						"price" : $('#price').val(),
						"producer_fk" : idProducer,
						"description" : $('#description').val(),
						"available" : $('#available').is(':checked')
					}),
					success : function() {
alert("ok");
					}
				});
			});

		});