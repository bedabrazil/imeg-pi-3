window.addEventListener('load', function(){
//adicionar javascript a partir deste evento

	// document.querySelector("form button[type='button'].ajax").addEventListener('click', function(){
	// 	var form = document.querySelector('form.call');
	// 	var formData = new FormData();
	// 	var fields = document.querySelectorAll('form.call input, form.call textarea, form.call select');
	// 	var data = "";
	// 	var cont = -2;
	// 	// for(var i = 0;i < form.elements.length;i++){

	// 	// 	data += form.elements[i].name + "=" + form.elements[i].value+'&';
	// 	// }
	// 	Array.from(fields).forEach(function(e, i){
	// 		// data += e.name + "=" + e.value+'&';
	// 		formData.append(e.name, e.value);
	// 	});		
	// 	if(ajax(form, formData)){
	// 		// window.location = 'sucesso';
	// 	}
	// });
    $(function () {
      $('[data-toggle="tooltip"]').tooltip();
    });
});

function ajax(form, formData){
   var xhr = (window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP"));
	xhr.onreadystatechange = function(){
		if(xhr.readyState === XMLHttpRequest.DONE){
			if(xhr.status !== 200){
				return false;
			}
		}
	};
	xhr.open(form.method, form.action, true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
	xhr.send(formData);
	return true;
}

