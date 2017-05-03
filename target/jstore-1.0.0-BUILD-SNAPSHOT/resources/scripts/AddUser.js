var controller = new Controller();

window.onload = function() {
	controller.init();	
}


function Controller() {
	self = this;
	this.init = function() {

		document.getElementById("add").onclick = function(e) {
			console.log(e.target.id);
			self.add($(this).attr('id'));
		}
	
}

	this.add = function(i) {
		/*$
				.ajax({
					url : './addoneuser',
					type : 'POST',

					data : "&name=" + $('#name').val() + "&phone="
					+ $('#phone').val() + "&email=" + $('#email').val()
					+ "&username=" + $('#username').val() + "&role="
					+ $('#role').val(),
					success : function() {				
						
						alert("Data Added")

					}
				})

	}*/
		$.ajax({
			url : './addoneuser',
			type : 'POST',

			data : "&firstName=" + $('#name').val() + "&phone="
			+ $('#phone').val() + "&email=" + $('#email').val()
			+ "&userName=" + $('#username').val() 
			+ "&Password=" + $('#password').val()
			+ "&role="	+ $('#role').val(),
			success : function(response) {				
				if(response=="true"){
				/*alert("Data Add");*/
				$("#success").html("Data Added");
				}else $("#success").html("");
			},
			error : function(e){
				/*alert("Error: "+ e);*/
			},
		})
		$.ajax({
			url : './firstName',
			type : 'POST',

			data : "&firstName=" + $('#name').val(),
			success : function(response) {
					/*alert(response);*/
                  $('#errorName').html(response);	                 
			},
			error : function(e){
			//	alert("Error: "+ e);
			},
		})
			$.ajax({
			url : './phone',
			type : 'POST',

			data : "&phone=" + $('#phone').val() ,
			success : function(response) {												 
                  $('#errorPhone').html(response);              
			},
			error : function(e){
				//alert("Error: "+ e);
			},
		})
			$.ajax({
			url : './email',
			type : 'POST',

			data : "&email="+ $('#email').val(),
			success : function(response) {												 
                  $('#errorEmail').html(response);	                 
                  /*$('#errorEmail').show('slow');*/
			},
			error : function(e){
				//alert("Error: "+ e);
			},
		})
	}

	return this;
}