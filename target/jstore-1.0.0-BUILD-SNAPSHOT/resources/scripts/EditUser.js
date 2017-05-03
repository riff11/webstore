var controller = new Controller();

window.onload = function() {
	controller.init();
	
}

$(document).ready(function() {
	$("#myTable").tablesorter({
		sortList : [ [ 0, 0 ], [ 1, 0 ] ]
	});
});

function Controller() {
	self = this;
	this.init = function() {

		var arrRadio = document.getElementsByName("Radiobutton"), result;
		for ( var i = 0; i < arrRadio.length; i++) {
			arrRadio[i].onclick = function() {
				self.getRadio($(this).attr('id'));

			}
		}
		document.getElementsByName("Edit")[0].onclick = function(e) {
			console.log(e.target.id);
			self.edit($(this).attr('id'));
		}	
	}

	
	this.check = function() {

		var name = document.getElementById("name");

		if (name.value === '') {
			return false;
		} else {
			return true;
		}

	}
	this.check1 = function() {

		var phone = document.getElementById("phone");
		if (phone.value === '') {
			return false;
		} else {
			return true;
		}

	}
	

	this.checkEmail = function() {

		var email = document.getElementById("email");
		if (email.value === '') {
			return false;
		} else {
			return true;
		}
	}
	
	this.check2 = function() {

		var username = document.getElementById("username");

		if (username.value === '') {
			return false;
		} else {
			return true;
		}

	};

	this.getRadio = function(i) {
		var name = $('#name' + i).html();
		$('#Editname').val(name);
		
		var phone = $('#phone' + i).html();
		$('#Editphone').val(phone);
		
		var email = $('#email' + i).html();
		$('#Editemail').val(email);
		
		var username = $('#username' + i).html();
		$('#Editusername').val(username);
		
		var role = $('#role' + i).html();
		$('#Editrole').val(role);
		
		document.getElementsByName("Edit")[0].id = i;
	};

	this.edit = function(i) {
		var flag="flag";		
		/*if(flag==""){*/
			$.ajax({
				/*url : './editoneuser',
				type : 'POST',
	
				data : "id=" + i + "&name=" + $('#Editname').val() + "&phone="
						+ $('#Editphone').val() + "&email=" + $('#Editemail').val()
						+ "&username=" + $('#Editusername').val() + "&role="
						+ $('#Editrole').val(),
				success : function() {
					$('#name' + i).html($('#Editname').val());
					$('#phone' + i).html($('#Editphone').val());
					$('#email' + i).html($('#Editemail').val());
					$('#username' + i).html($('#Editusername').val());	
					$('#role' + i).html($('#Editrole').val());
	
				}*/
				url : './editoneuser',
				type : 'POST',
	
				data : "id=" + i + "&firstName=" + $('#Editname').val() + "&phone="
						+ $('#Editphone').val() + "&email=" + $('#Editemail').val()
						+ "&userName=" + $('#Editusername').val() + "&role="
						+ $('#Editrole').val(),
				success : function(response) {
					if(response=="true"){					
					$("#success").css("background-color","#A9FFAE");$("#success").css("color","#0A5216");
					$("#success").html("Data Edited");					
					$('#name' + i).html($('#Editname').val());
					$('#phone' + i).html($('#Editphone').val());
					$('#email' + i).html($('#Editemail').val());
					$('#username' + i).html($('#Editusername').val());	
					$('#role' + i).html($('#Editrole').val());
					}else if(i=="EEdit1"){$("#success").html("Select the user"); $("#success").css("background-color","#ffEEEE");$("#success").css("color","#ff0000");}
					else $("#success").html("");
				},
				error : function(e){
					alert("Error editoneuser: "+ e);
				},
			})
			if(i!="EEdit1"){
				$.ajax({
					url : './firstName',
					type : 'POST',
			
					data : "&firstName=" + $('#Editname').val(),
					success : function(response) {
							/*alert(response);*/
							flag=response;
			              $('#errorName').html(response);	                 
					},
					error : function(e){
						alert("Error firstName : "+ e);
					},
				})
				$.ajax({
					url : './phone',
					type : 'POST',
			
					data : "&phone=" + $('#Editphone').val() ,
					success : function(response) {	
							flag=response;
			              $('#errorPhone').html(response);              
					},
					error : function(e){
						alert("Error phone: "+ e);
					},
				})
				$.ajax({
					url : './email',
					type : 'POST',
			
					data : "&email="+ $('#Editemail').val(),
					success : function(response) {	
							flag=response;
			              $('#errorEmail').html(response);	                 
			              /*$('#errorEmail').show('slow');*/
					},
					error : function(e){
						alert("Error email: "+ e);
					},
				})
			}

	}

	return this;
}
