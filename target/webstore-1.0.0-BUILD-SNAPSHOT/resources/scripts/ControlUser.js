$(document).ready(function() {
	/*alert("QQQQQQQ");*/
	$('#action').click(function(){});
	/* document.getElementById("action").disabled = true; */
	var key1 = 0;
	var key2 = 0;
	var key3 = 0;
	/*  alert("Vsego kart-k ");  */

	// ������� ����������� �� ������� .blur
	$('#name').keyup(function() {
		// ������� ��� ������ � ���� ����� ����
		$('#name').removeClass();
		// ���������� ����� �������� ����
		var nameLngth = $('#name').val().length;

		if (nameLngth <= 1) {
			$('#name').addClass('notValid');
			$(this).next().text('������� ���������� ���� ���');
			key1 = 0;

		} else {
			// ����� �� ����� ��� ������ ����, ���� ��� �������
			// �����
			$('#name').removeClass();
			$(this).next().text('');
			key1 = 1;
		}
		butoon();
	});

	// ������� ����������� �� ������� .blur
	$('#phone').keyup(function() {
						// ������� ��� ������ � ���� ���� �����
						// ��������
						$('#phone').removeClass();
						// ����� �������� ���� ���� �����
						// ��������
						var phoneV = $('#phone').val();
						// ���������� ����� �������� ����
						var phoneLngth = phoneV.length;
						if (/[^0-9]/.test(phoneV)) {
							$('#phone').addClass('notValid');
							$(this)
									.next()
									.text('����� �������� ������ ��������� ������ �����');
						} else if (phoneLngth <= 5) {
							$('#phone').addClass('notValid');
							$(this)
									.next()
									.text('������� ���������� ��� ����� ��������');
							key2 = 0;
						} else {
							$('#phone').removeClass();
							$(this).next().text('');
							key2 = 1;
						}
						butoon();
					});

		
	$('#email').mousemove( function(){email()});
	$('#email').keyup( function(){email()});
	$('#email').change( function(){email()});
	
	
	function email() {
		// ������� ��� ������ � ���� ����
		// e-mail�
		$('#email').removeClass();
		var emailV = $('#email').val();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;
		// ��������� ����� �� ������ e-mail
		if (filter.test(emailV)) {
			$('#email').removeClass();
			$(this).next().text('');
			key3 = 1;
		} else {
			$('#email').addClass('notValid');
			$(this)
					.next()
					.text('������� ���������� ��������� ��� e-mail');
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

});
