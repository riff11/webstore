$(document)
		.ready(
				function() {

					var selectArrays = [];
					// var f = eval('(' + '${productTypesRoot}' + ')');
					selectArrays[0] = JSON.parse(jsonCategoryRoot);

					// alert(productTypesRoot);
					for ( var i = 0; i < selectArrays[0].length; i++) {
						$('#type')
								.append(
										'<option value="' + (i + 1) + '">'
												+ selectArrays[0][i].name
												+ '</option>');
					}

					if (jsonSiblingsCategory != "") {
						selectArrays[1] = JSON.parse(jsonSiblingsCategory);
						$("#child,#child_admin").prop('disabled', false);
						for ( var i = 0; i < selectArrays[1].length; i++) {
							$('#child,#child_admin').append(
									'<option value="' + (i + 1) + '">'
											+ selectArrays[1][i].name
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
															+ '/catalog/getlist.json',
													type : 'POST',
													contentType : 'application/json; charset=utf-8',
													/* dataType : 'json', */
													data : JSON
															.stringify(selectArrays[0][type_id - 1].id),
													/* .stringify(selectArrays[0][type_id].id), */
													error : function() {
														alert("��� ���������� ������� ��������� ������ :(");
													},

													success : function(listCat) {
														jsonSiblingsCategory = listCat;
														selectArrays[1] = listCat;
														for ( var i = 0; i < listCat.length; i++) {
															$(
																	'#child,#child_admin,#child_edit')
																	.append(
																			'<option value="'
																					+ (i + 1)
																					+ '">'
																					+ listCat[i].name
																					+ '</option>');
														}
														$(
																'#child,#child_admin,#child_edit')
																.prop(
																		'disabled',
																		false); // ��������
														// ����

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
								// $.get("catalog/"+selectArrays[1][type_id -
								// 1].id);
								var url = pageContext + "/catalog/"
										+ selectArrays[1][type_id - 1].id;
								window.location.assign(url);
								// alert(url);
								// $

								// var typeSelected=0;
								// var childSelected=0;
								// var selectArrays = [];
								// // var f = eval('(' + '${productTypesRoot}' +
								// ')');
								// selectArrays[0] =
								// JSON.parse(productTypesRoot);
								// // alert(productTypesRoot);
								// for ( var i = 0; i < selectArrays[0].length;
								// i++) {
								// $('#type')
								// .append(
								// '<option value="' + (i + 1) + '">'
								// + selectArrays[0][i].name
								// + '</option>');
								// }
								//					
								// $("#type").val(typeSelected);
								// $("#child").val(typeSelected);
								// $("#type")
								// .change(
								// function() {
								//
								// $("#child").find("option")
								// .not(":first").remove().end()
								// .prop('disable', true);
								// var type_id = $('#type').val();
								// window.typeSelected = type_id;
								// if (type_id == 0) {
								// return;
								// }
								// $
								// .ajax({
								// url : pageContext + '/catalog/getlist.json',
								// type : 'POST',
								// contentType : 'application/json;
								// charset=utf-8',
								// /* dataType : 'json', */
								// data : JSON
								// .stringify(selectArrays[0][type_id - 1].id),
								// /* .stringify(selectArrays[0][type_id].id),
								// */
								// error : function() {
								// alert("���
								// ����������
								// �������
								// ���������
								// ������ :(");
								// },
								//
								// success : function(listCat) {
								// selectArrays[1] = listCat;
								// for ( var i = 0; i < listCat.length; i++) {
								// $('#child')
								// .append(
								// '<option value="'
								// + (i + 1)
								// + '">'
								// + listCat[i].name
								// + '</option>');
								// }
								// $('#child').prop(
								// 'disabled',
								// false); // ��������
								// // ����
								//
								// }
								//
								// });
								// });
								// $("#child")
								// .change(
								// function() {
								//
								// var type_id = $('#child').val();
								// childSelected = type_id;
								// if (type_id == 0) {
								// return;
								// }
								// // $.get("catalog/"+selectArrays[1][type_id -
								// 1].id);
								// window.location.href = pageContext
								// +"/catalog/"+selectArrays[1][type_id - 1].id;
								// // $
								// .ajax({
								// url : 'categories/getProducts.json',
								// type : 'POST',
								// contentType : 'application/json;
								// charset=utf-8',
								// /* dataType : 'json', */
								// data : JSON
								// .stringify(selectArrays[1][type_id - 1].id),
								// error : function() {
								// alert("���
								// ����������
								// �������
								// ���������
								// ������ :(");
								// },
								//
								// success : function(
								// listProducts) {
								// $("#products div").remove();
								// for ( var i = 0; i < listProducts.length;
								// i++) {
								// $('#products')
								// .append(
								//																			
								// '<div id="new_item"> '
								// + '<div id="new_item_header"> <h1>'
								// + listProducts[i].name
								// + '</h1></div> <div id="new_item_image">'
								// + '<img src="'
								// + listProducts[i].image
								// + '" height="150" alt="New Item Name" />
								// </div> <div class="price"> <h2>'
								// + listProducts[i].price
								// + '</h2> </div>'
								// + '</div>'
								// );
								// // alert(listProducts[i].name);
								// }
								//
								// }
								//
								// });
							});

					// : function() {
					// progress.startInfinite('���������
					// ���������
					// ���������...');
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
					// },$("#child").change(
					$("#child_admin").change(
							function() {

								var type_id = $('#child_admin').val();
								childSelected = type_id;
								if (type_id == 0) {
									return;
								}
								// $.get("catalog/"+selectArrays[1][type_id -
								// 1].id);
								var url = pageContext + "/admin/catalog/"
										+ selectArrays[1][type_id - 1].id;
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
