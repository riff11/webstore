$(document)
		.ready(
				function() {

					var selectArrays = [];
					// var f = eval('(' + '${productTypesRoot}' + ')');
					selectArrays[0] = JSON.parse(jsonCategoryRoot);

					// alert(productTypesRoot);
					for (var i = 0; i < selectArrays[0].categories.length; i++) {
						$('#type,#typeAdd')
								.append(
										'<option value="' + (i + 1) + '">'
												+ selectArrays[0].categories[i].name
												+ '</option>');
					}

					if (jsonSiblingsCategory != "") {
						selectArrays[1] = JSON.parse(jsonSiblingsCategory);
						$("#child,#child_admin").prop('disabled', false);
						for (var i = 0; i < selectArrays[1].categories.length; i++) {
							$('#child,#child_admin').append(
									'<option value="' + (i + 1) + '">'
											+ selectArrays[1].categories[i].name
											+ '</option>');
						}

					}

					$("#type").val(rootSelected);
					$("#child,#child_admin").val(childSelected);
					$("#type")
							.change(
									function() {

										$("#child,#child_admin,#child_edit")
												.find("option").not(":first")
												.remove().end().prop(
														'disabled', false);
										var type_id = $('#type').val();
										window.typeSelected = type_id;
										if (type_id == 0) {
											$("#child,#child_admin,#child_edit")
													.prop("disabled", true);
											return;
										}
										$
												.ajax({
													url : pageContext
															+ '/catalog/getlist',
													type : 'POST',
													contentType : 'application/json; charset=utf-8',
													/* dataType : 'json', */
													data : JSON
															.stringify(selectArrays[0].categories[type_id - 1].id),
													error : function() {
														alert("bad");
													},

													success : function(listCat) {
														jsonSiblingsCategory = listCat;
														selectArrays[1] = listCat;
														for (var i = 0; i < listCat.categories.length; i++) {
															$(
																	'#child,#child_admin,#child_edit')
																	.append(
																			'<option value="'
																					+ (i + 1)
																					+ '">'
																					+ listCat.categories[i].name
																					+ '</option>');
														}
														$(
																'#child,#child_admin,#child_edit')
																.prop(
																		'disabled',
																		false);
													}

												});
									});
					$("#child").change(
							function() {

								var type_id = $('#child').val();
								childSelected = type_id;
								if (type_id == 0) {
									return;
								}
								var url = pageContext + "/catalog/"
										+ selectArrays[1].categories[type_id - 1].id;
								window.location.assign(url);
							});
					$("#child_admin").change(
							function() {

								var type_id = $('#child_admin').val();
								childSelected = type_id;
								if (type_id == 0) {
									return;
								}
								var url = pageContext + "/admin/catalog/"
										+ selectArrays[1].categories[type_id - 1].id;
								window.location.assign(url);
							});
					$("#linkprice_sort").click(function() {
						var regex = new RegExp(/^(?:\d+?)$/);
						var min = $("#min").val();
						var max = $("#max").val();
						var available = $("#available").is(':checked');
						var url = window.location.pathname;
						if (regex.test(min) && regex.test(max) || available) {
							url = url + "?";
							if (regex.test(min) && regex.test(max)) {
								url = url + "min=" + min + "&max=" + max;
								if (available) {
									url = url + "&available=" + available;
								}
							} else if (available) {
								url = url + "available=" + available;
							}
							window.location.assign(url);
							// alert(url);
						} else {
							window.location.assign(url);
						}

					});
				});
