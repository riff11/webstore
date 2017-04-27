$(document).ready(

		function() {

			var idCategory;
			var idProducer;
			/* $("#add").disabled = true; */
			/* $("#idp").disabled = true; */
			var arrProducers = JSON.parse(jsonProducersList);
			if (jsonProducersList != "") {
				for (var i = 0; i < arrProducers.length; i++) {
					$('#producers').append(
							'<option value="' + (i + 1) + '">'
									+ arrProducers[i].name + '</option>');
				}

			}

			$("#add").click(function() {
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

			$("input[name='Radiobutton']").click(function() {
				var i = $(this).attr('id');
				// id = id.text().substring(2, id.length);
				var name = $('#name' + i).html();
				$('#Editname').val(name);
				var price = $('#price' + i).html();
				$('#Editprice').val(price);
				var descr = $('#descr' + i).html();
				$('#Editdescription').val(descr);
				var available = $('#available' + i).html();
				if (available == 'true')
					$('#Editavailable').attr('checked', true)
				else
					$('#Editavailable').attr('checked', false)
				$("#EEdit1").attr('name', i);
			});

			$("#EEdit1").click(function(i) {
				var arrChildCategory = jsonSiblingsCategory;
				idCategory = arrChildCategory[$("#child_edit").val() - 1].id;
				idProducer = arrProducers[$("#producers").val() - 1].id;
				var id = $(this).attr('name');
				;
				$.ajax({
					url : 'editProducts',
					type : 'POST',
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					data : JSON.stringify({
						"id" : $(this).attr('name'),
						"name" : $('#Editname').val(),
						"categories_fk" : idCategory,
						"price" : $('#Editprice').val(),
						"producer_fk" : idProducer,
						"description" : $('#Editdescription').val(),
						"available" : $('#Editavailable').is(':checked')
					}),
					error : function() {
						alert("bad");
						change(id);
					},
					success : function() {
						alert("OK");
						change(id);
					}
				})
			});

			function change(i) {
				var name = $('#Editname').val();
				$('#name' + i).text(name);
				var price = $('#Editprice').val()
				$('#price' + i).text(price);
				var category = $("#child_edit option:selected").text();
				$("#category" + i).text(category);
				var droducer = $("#producers option:selected").text();
				$("#producer" + i).text(droducer);
				var price = $('#Editprice').val()
				$('#price' + i).text(price);
				var descr = $('#Editdescription').val();
				$('#descr' + i).text(descr);
				var available = $('#Editavailable').is(":checked");
				if (available)
					$('#available' + i).text(true)
				else
					$('#available' + i).text(false)
			}
		});