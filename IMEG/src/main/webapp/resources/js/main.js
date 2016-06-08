window.addEventListener('load', function () {

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

    // if(document.querySelector('#warning').classList.contains('alert-danger')){
    // 	fade(document.querySelector('#warning'));
    // 	    	
    // }
    if (document.querySelector('#warning') && (document.querySelector('#warning').classList.contains('alert-success') || document.querySelector('#warning').classList.contains('alert-danger'))) {
        // fade(document.querySelector('#warning'));
    }

});


function ajax(form, formData) {
    var xhr = (window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP"));
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status !== 200) {
                return false;
            }
        }
    };
    xhr.open(form.method, form.action, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xhr.send(formData);
    return true;
}

function fade(element) {
    var opacity = 1;  // opacidade inicial
    var timer = setInterval(function () {
        if (opacity <= 0.1) {
            clearInterval(timer);
            element.style.display = 'none';
        }
        element.style.opacity = opacity;
        element.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
        opacity -= opacity * 0.1;
    }, 1200);
}

function unfade(element) {
    var opacity = 0.1;  // opacidade inicial
    element.style.display = 'block';
    var timer = setInterval(function () {
        if (opacity >= 1) {
            clearInterval(timer);
        }
        element.style.opacity = opacity;
        element.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
        opacity += opacity * 0.1;
    }, 10);
}

function dataInicialMaiorQueFinal($date_ini, $date_end) {
    if ($date_ini === "" || $date_end === "") {
        return false;
    }
    var initial_date = $date_ini.split("/");
    var final_date = $date_end.split("/");
    initial_date = new Date(initial_date[2], initial_date[1] - 1, initial_date[0]);
    final_date = new Date(final_date[2], final_date[1] - 1, final_date[0]);
    if (initial_date > final_date) {
        return false;
    }
    return true;
}

jQuery.noConflict();
(function ($) {
    $('[data-toggle="tooltip"]').tooltip();


    $('.sale').hover(function () {
        $('.over-sale').show();
        $(this).css("background-color", "#E2CC0C").css("color", "#dd1355");
        $(".badge", this).css("background-color", "#fff").css("color", "#dd1355");
        $('.btn-cart').click(function () {
            window.location = $(this).data("href");
        });
        return false;
    });
    $('.sale + .over-sale').mouseleave(function () {
        $(this).slideUp(200, function () {
            $(".sale").css("background-color", "transparent").css("color", "#fff");
            $(".sale .badge").css("background-color", "#dd1355").css("color", "#fff");
        });
        return false;
    });

    $(".maskmoney").maskMoney({prefix: 'R$ ', allowZero: true, defaultZero: false, allowNegative: false, thousands: '.', decimal: ',', affixesStay: false});
    $(".maskmeter").maskMoney({prefix: 'mÂ² ', allowZero: false, defaultZero: false, allowNegative: true, thousands: '.', decimal: ',', affixesStay: false});
    $(".maskpercent").maskMoney({prefix: '% ', allowZero: true, defaultZero: false, allowNegative: false, thousands: '.', decimal: ',', affixesStay: false});
    $(".number").maskMoney({prefix: '', allowZero: true, defaultZero: false, allowNegative: false, thousands: '.', decimal: '', affixesStay: false});
    $.datepicker.setDefaults($.datepicker.regional[ "pt-BR" ]);
    $(".datePicker").datepicker({dateFormat: 'dd/mm/yy', yearRange: '1900:' + new Date().getFullYear(), maxDate: new Date});
    $(".gerar_pdf, .gerar_excel").attr("disabled", true);

    var date_ini;
    var date_end;

    $("form").on("change", ".datePicker", function (e) {
        if (!date_ini) {
            date_ini = $(this);
        } else
        if (!date_end) {
            date_end = $(this);
        }
        if (date_ini && date_end) {
            var date_ok = dataInicialMaiorQueFinal(date_ini.val(), date_end.val());
            if (date_ok) {
                date_ini.addClass('border_true');
                date_end.addClass('border_true');
                date_ini.removeClass('border_false');
                date_end.removeClass('border_false');
                $("#error").hide().removeClass("errors");
                $(".gerar_excel").attr("disabled", false);
                date_ini = null;
                date_end = null;
            } else {
                date_ini.addClass('border_false');
                date_end.addClass('border_false');
                $("#error").show().addClass("alert alert-danger");
                $(".gerar_excel").attr("disabled", true);
                return false;
            }
        }
        return true;
    });
    $('#carouselChart.slide').carousel({
        interval: 5000,
        pause: "hover"
    });

//    $('carouselChart').focus(function(){
//       $(this).carousel('pause');
//    }).blur(function() {
//       $(this).carousel('cycle');
//    });   
})(jQuery);


