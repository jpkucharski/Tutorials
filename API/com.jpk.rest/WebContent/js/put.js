$(document)
		.ready(
				function() {
					var $put_example = $('#put_example');
					getInventory();
					$(document.body).on( 'click', ':button, .UPDATE_BTN', function(e) 
							{
										var $this = $(this), 
										id_local_variable = $this.val(), $tr = $this.closest('tr'), 
										profession_local_variable = $tr.find('.CL_PROFESSION').text(), 
										name_local_variable = $tr.find('.CL_NAME').text(),
										email_local_variable = $tr.find('.CL_EMAIL').text();
										$('#ID_id_from_webpage').val( id_local_variable);
										$('#ID1_id_from_webpage').val( id_local_variable);
										$('#PROFESSION1_id_from_webpage').text( profession_local_variable);
										$('#PROFESSION_id_from_webpage').text( profession_local_variable);
										$('#NAME_id_from_webpage').text( name_local_variable);
										$('#EMAIL_id_from_webpage').text( email_local_variable);
										$('#update_response').text("");
							});
					$put_example.submit(function(e) {
						e.preventDefault();
						var obj = $put_example.serializeObject();
						updateInventory(obj);
					});
				});

function updateInventory(obj) {
	ajaxObj = {
		type : "PUT",
		url : "http://localhost:8080/com.jpk.rest/api/v4/update",
		data : JSON.stringify(obj),
		contentType : "application/json",
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR.responseText);
		},
		success : function(data) {
			console.log(data);
			$('#update_response').text(data[0].MSG);
		},
		complete : function(XMLHttpRequest) {
			getInventory();
		},
		dataType : "json"
	};
	return $.ajax(ajaxObj);
}

function getInventory() {
	var d = new Date(), n = d.getTime();
	ajaxObj = {
		type : "GET",
		url : "http://localhost:8080/com.jpk.rest/api/v1/sqlall",
		data : "ts=" + n,
		contentType : "application/json",
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR.responseText);
		},
		success : function(data) {
			var html_string = "";

			$.each(data, function(index1, val1) {
				html_string = html_string + templateGetInventory(val1);
			});

			$('#get_inventory').html(
					"<table border='1'>" + html_string + "</table>");
		},
		complete : function(XMLHttpRequest) {
		},
		dataType : "json"
	};

	return $.ajax(ajaxObj);
}

function templateGetInventory(param) {
	return '<tr>' + '<td class="CL_PROFESSION">' + param.profession + '</td>'
			+ '<td class="CL_NAME">' + param.name + '</td>'
			+ '<td class="CL_EMAIL">' + param.email + '</td>' +

			'<td class="CL_EMPLOYEE_BTN"> <button class="UPDATE_BTN" value="'
			+ param.id + '" type="button">Update</button> </td>' + '</tr>';
}
