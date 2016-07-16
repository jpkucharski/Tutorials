
$(document).ready(function() {
	
	getInventory();
	
	$(document.body).on('click', ':button, .DELETE_BTN', function(e) {
		var $this = $(this)
			, ID = $this.val()
			, obj = {ID_name : ID}
			, $tr = $this.closest('tr')
			
		
		deleteInventory(obj);
	});
});

function deleteInventory(obj) {
	
	ajaxObj = {  
			type: "DELETE",
			url: "http://localhost:8080/com.jpk.rest/api/v4/delete/",
			data: JSON.stringify(obj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) {
				$('#delete_response').text( data[0].MSG );
			},
			complete: function(XMLHttpRequest) {
				getInventory();
			}, 
			dataType: "json" 
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
	return '<tr>'
			+ '<td class="CL_ID">' + param.id + '</td>'
			+ '<td class="CL_PROFESSION">' + param.profession + '</td>'
			+ '<td class="CL_NAME">' + param.name + '</td>'
			+ '<td class="CL_EMAIL">' + param.email + '</td>' +

			'<td class="CL_EMPLOYEE_BTN"> <button class="DELETE_BTN" value="'
			+ param.id + '" type="button">Delete</button> </td>' + '</tr>';
}
