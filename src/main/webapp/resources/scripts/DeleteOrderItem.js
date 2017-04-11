var controller = new Controller();

window.onload = function() {
	controller.init();
	 $('#name').val(getCookie("name"));
	 $('#phone').val(getCookie("phone"));
	 $('#email').val(getCookie("email"));
	  
	 self.check();
}



function Controller() {
	self = this;
	this.init = function() {
		document.getElementById("action").onclick = function(e) {
			self.addcookie();
		}
		

		var arr = document.getElementsByName("Delete");
		var tr = document.getElementsByName("ProductTR");
		for ( var i = 0; i < arr.length; i++) {
			arr[i].onclick = function() {
				self.deleteRows();
				 self.deleteOrderItem(this.id);
			}
		
		}
			this.deleteOrderItem = function(i) {
			
				var x=confirm("Are you sure you want to delete the product?");
				 if (x==true){	
					 $('#'+"tr"+i).remove();
					   self.sumOrderItem();	 
				$.ajax({
					
					url : './deleteorderitem',
					type : 'POST',
					data : "prod_id=" + i,
					success : function() {
						 							     			 	
					}
				})}
				 else {
					 
				   }		
			}
			
			this.deleteRows=function(){
				
			}
			
			document.onkeyup = function() {
				self.check();		
	}
			
	this.sumOrderItem=function(){
	var quant=document.getElementsByName('prod_q');
  	   var price=document.getElementsByName('prod_price');
  	   var sum=0;
  	 for ( var i = 0; i < quant.length; i++) {
			sum=parseInt(sum)+parseInt(quant[i].value)*parseInt(price[i].value);
			}
  	$('#sum').val(accounting.formatMoney(parseFloat(sum)));
	}	
	
	this.addcookie = function() {
		var name = $('#name').val();
		var phone = $('#phone').val();
		var email = $('#email').val();
		
		setCookie("name",name,"Wed, 02-Jan-2030 00:00:00 GMT");
		setCookie("phone",phone,"Wed, 02-Jan-2030 00:00:00 GMT");
		setCookie("email",email,"Wed, 02-Jan-2030 00:00:00 GMT");
	


	}
	 this.check = function (){
			$('#action').click(function(){});			
			var key1 = 0;
			var key2 = 0;
			var key3 = 0;
			

			
		 {
				
				$('#name').removeClass();				
				var nameLngth = $('#name').val().length;

				if (nameLngth <= 1) {
					$('#name').addClass('notValid');
					$(this).next().text('Введите пожалуйста ваше имя');
					key1 = 0;

				} else {					
					
					$('#name').removeClass();
					$(this).next().text('');
					key1 = 1;
				}
				butoon();
			};

			
			 {
								
				$('#phone').removeClass();								
				var phoneV = $('#phone').val();								
				var phoneLngth = phoneV.length;
				if (/[^0-9]/.test(phoneV)) {
					$('#phone').addClass('notValid');
					$(this)
							.next()
							.text('Номер телефона должен содержать только цифры');
				} else if (phoneLngth <= 5) {
					$('#phone').addClass('notValid');
					$(this)
							.next()
							.text('Введите пожалуйста ваш номер телефона');
					key2 = 0;
				} else {
					$('#phone').removeClass();
					$(this).next().text('');
					key2 = 1;
				}
				butoon();
			};

				
			$('#email').mousemove( function(){email()});
			$('#email').keyup( function(){email()});
			$('#email').change( function(){email()});
			
			
			{				
				$('#email').removeClass();
				var emailV = $('#email').val();
				var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;				
				if (filter.test(emailV)) {
					$('#email').removeClass();
					$(this).next().text('');
					key3 = 1;
				} else {
					$('#email').addClass('notValid');
					$(this)
							.next()
							.text('Введите пожалуйста правильно ваш e-mail');
					key3 = 0;
				}
				butoon();
			}
			
			function butoon() {
				

				if (key1 == 1 && key2 == 1 && key3 == 1) {
					
					/* document.getElementById("action").disabled = false; */
					$('#action').click(function(){sendRequest()});
				} else
					/* document.getElementById("action").disabled = true; */
					$('#action').unbind('click', function(){});
				 /* alert(key1+" "+key2+" "+key3+" ");  */
			}			
		}		 		 
	 }
	
	

	
	return this;
}