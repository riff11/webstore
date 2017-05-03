var controller = new Controller();

	window.onload = function() {
		controller.init();

	}

	function Controller() {
		self = this;
		this.init = function() {
			var arr = document.getElementsByName("addcomment");
			var arr1 = document.getElementsByName("Add");
			var b = document.getElementsByName("b");
			var sum;
			for ( var i = 0; i < arr1.length; i++) {
				arr1[i].onclick = function() {
					 self.sendProduct(this.id);
				}
			
			}
		
			for ( var i = 0; i < arr.length; i++) {
				arr[i].onclick = function() {
					 self.addComments();
					 self.addBasket();
					 self.clickBasket();
				}
			
			}
			
			this.addComments = function() {
				$.ajax({
					url : './addcomments',
					type : 'POST',
					data : "&firstName=" + $('#username').val() + "&email=" + $('#useremail').val() + "&comment=" + $('#com').val() + "&prod_id=" + $('#hiddentext').val(),
					success : function() {				
						location.reload();
					},
					error : function(e){
					
					},
				})
										
		
	}
			this.sendProduct = function(i) {
				console.log(b[0].value);
				sum=parseInt(b[0].value)+1;
				b[0].value=sum;
				$.ajax({
					url : './shopcartadd',
					type : 'POST',
					data : "prod_id=" + i,
					success : function() {
		
						
					}
				})

			}
			
			this.addBasket = function() {
				
				$.ajax({
					url : './addbasket',
					type : 'POST',
					success : function() {					
					}
				})

			}
			
			this.clickBasket = function() {
				sum=parseInt(b[0].value)+1;
				b[0].value=sum;
			}
				
		return this;
	}
	}