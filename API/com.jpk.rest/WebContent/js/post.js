$(document).ready(function() {
	var $post_example = $('#post_example');
	getInventory();
/*	
 * Using Jackson Mapper
 */
	$('#submit_it').click(function(e) {
		
		e.preventDefault();
		
		var jsObj = $post_example.serializeObject()
			, ajaxObj = {};
		
		
		
		ajaxObj = {  
			type: "POST",
			url: "http://localhost:8080/com.jpk.rest/api/v2/", 
			data: JSON.stringify(jsObj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error " + jqXHR.getAllResponseHeaders() + " " + errorThrown);
			},
			success: function(data) { 
				if(data[0].HTTP_CODE == 200) {
					$('#div_ajaxResponse').text( data[0].MSG );
				}
			},
			complete: function(XMLHttpRequest) {
			
			}, 
			dataType: "json" 
		};
		
		$.ajax(ajaxObj);
	});
	
	
	
	
/*
 * Using JSON Array and Object
 */
	$('#submit_2').click(function(e) {
		e.preventDefault();
		
		var jsObj = $post_example.serializeObject(), ajaxObj = {};
		ajaxObj = {  
			type: "POST",
			url: "http://localhost:8080/com.jpk.rest/api/v3", 
			data: JSON.stringify(jsObj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error " + jqXHR.getAllResponseHeaders() + " " + errorThrown);
			},
			success: function(data) { 
			
				if(data[0].HTTP_CODE == 200) {
					$('#div_ajaxResponse').text( data[0].MSG );
				}
			},
			complete: function(XMLHttpRequest) {
		
			}, 
			dataType: "json" 
		};
		
		$.ajax(ajaxObj);
	});
});

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
			+'<td class="CL_EMAIL">' + param.id + '</td>'
			+ '<td class="CL_PROFESSION">' + param.profession + '</td>'
			+ '<td class="CL_NAME">' + param.name + '</td>'
			+ '<td class="CL_EMAIL">' + param.email + '</td>' 
			+ '</tr>';
}