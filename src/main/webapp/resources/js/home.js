$(document)
		.ready(
				function() {
					var selectArrays = [];
					// var f = eval('(' + '${productTypesRoot}' + ')');
					selectArrays[0] = JSON.parse(productTypesRoot);
//					alert(productTypesRoot);
					for ( var i = 0; i < selectArrays[0].length; i++) {
						$('#type')
								.append(
										'<option value="' + (i + 1) + '">'
												+ selectArrays[0][i].name
												+ '</option>');
					}
					$("#type")
							.change(
									function() {

										$("#child").find("option")
												.not(":first").remove().end()
												.prop('disable', true);
										var type_id = $('#type').val();
										if (type_id == 0) {
											return;
										}
										$
												.ajax({
													url : 'categories/getlist.json',
													type : 'POST',
													contentType : 'application/json; charset=utf-8',
													/* dataType : 'json', */
													data : JSON
															.stringify(selectArrays[0][type_id - 1].id),
													/* .stringify(selectArrays[0][type_id].id), */
													error : function() {
														alert("При выполнении запроса произошла ошибка :(");
													},

													success : function(listCat) {
														selectArrays[1] = listCat;
														for ( var i = 0; i < listCat.length; i++) {
															$('#child')
																	.append(
																			'<option value="'
																					+ (i + 1)
																					+ '">'
																					+ listCat[i].name
																					+ '</option>');
														}
														$('#child').prop(
																'disabled',
																false); // Включаем
														// поле

													}

												});
									});
					$("#child")
							.change(
									function() {

										var type_id = $('#child').val();
										if (type_id == 0) {
											return;
										}
										$
												.ajax({
													url : 'categories/getProducts.json',
													type : 'POST',
													contentType : 'application/json; charset=utf-8',
													/* dataType : 'json', */
													data : JSON
															.stringify(selectArrays[1][type_id - 1].id),
													error : function() {
														alert("При выполнении запроса произошла ошибка :(");
													},

													success : function(
															listProducts) {
														$("#products div").remove();
														for ( var i = 0; i < listProducts.length; i++) {
															$('#products')
																	.append(
																			
																			'<div id="new_item"> '
																					+ '<div id="new_item_header">  <h1>'
																					+ listProducts[i].name
																					+ '</h1></div>	<div id="new_item_image">'
																					+ '<img src="'
																					+ listProducts[i].image
																					+ '" height="150" alt="New Item Name" />	</div>	<div class="price">	<h2>'
																					+ listProducts[i].price
																					+ '</h2> </div>'
																					+ '</div>'
																					 );
//															alert(listProducts[i].name);
														}

													}

												});
									});

					// : function() {
					// progress.startInfinite('Получение категорий
					// продуктов...');
					// $.ajax({
					// url : '../categories/getProducts.json',
					// type : 'POST',
					// dataType : 'json',
					// contentType: 'application/json',
					// data: JSON.stringify({}),
					// success : function(data) {
					// internal.authMethods = data;
					// if (internal.permissions) {
					// internal.loadAccounts();
					// } else {
					// internal.loadPermissions();
					// }
					// },
					// error : function() {
					// progress.stop();
					// }
					// });
					// },

				});
