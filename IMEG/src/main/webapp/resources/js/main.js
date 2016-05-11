window.addEventListener('load', function(){
//adicionar javascript a partir deste evento

	// document.querySelector("form.call button[type='button']").addEventListener('click', function(){
	// 	var form = document.querySelector("form.call");

 //        var warning = document.querySelector('#warning');
 //        warning.style.display = 'block';
 //        var content = document.createTextNode("");
 //    	for(var i = 0;i < form.elements.length;i++){
            
 //            if(!form.elements[i].value && form.elements[i].type === 'text'){
 //                form.elements[i].style.border = '1px solid red';
 //                warning.classList.add('alert', 'alert-danger');
 //                warning.appendChild(content);
 //                setInterval(fade(warning), 30);
 //            }
 //            if(form.elements[i].value){
 //                form.elements[i].style.border = '1px solid #002';
 //            }
 //    	}
 //        content.textContent = '';
	// });
    $(function () {
      $('[data-toggle="tooltip"]').tooltip();
    });
    // if(document.querySelector('#warning').classList.contains('alert-danger')){
    // 	fade(document.querySelector('#warning'));
    // 	    	
    // }
    if(document.querySelector('#warning') && (document.querySelector('#warning').classList.contains('alert-success') || document.querySelector('#warning').classList.contains('alert-danger'))){
    	fade(document.querySelector('#warning'));
    }

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

function fade(element) {
    var opacity = 1;  // opacidade inicial
    var timer = setInterval(function () {
        if (opacity <= 0.1){
            clearInterval(timer);
            element.style.display = 'none';
        }
        element.style.opacity = opacity;
        element.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
        opacity -= opacity * 0.1;
    }, 120);
}

function unfade(element) {
    var opacity = 0.1;  // opacidade inicial
    element.style.display = 'block';
    var timer = setInterval(function () {
        if (opacity >= 1){
            clearInterval(timer);
        }
        element.style.opacity = opacity;
        element.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
        opacity += opacity * 0.1;
    }, 10);
}
