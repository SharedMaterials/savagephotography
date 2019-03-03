$().ready(function(){
	    $("#myForm").validate({
		        rules:{
                    name: {
                        required: true,
                        minlength: 2
                    },
                    email:{
                        required: true,
                        email: true
                    },
                    phone:{
                        required: true,
                        digits: true,
                        minlength: 7
                    }
		        },
		        messages:{
		            name: {
		                required: "Please specify your name",
		                minlength: "Mame must be at least 2 letters"
		            },
                    email: {
                        required: "We need your email address to contact you",
                        email: "Your email address must be in the format of name@domain.com"
                    },
                    phone: {
		                required: "We need your phone number to contact you",
		                digits: "Must contain numbers only",
		                minlength: "Mame must be at least 7 letters"
		            },
                },
		        errorElement: "div",
		        submitHandler: function (form) {
                    $('#modal').modal('hide');
                    $('.alert').show();
                    $form = $("#myForm");
                    $.ajax({
                        type: 'POST',
                        url: 'http://localhost:8080/contact'
                        + '/' + $form.find('input[name="name"]').val()
                        + '/' + $form.find('input[name="email"]').val()
                        + '/' + $form.find('input[name="phone"]').val()
                        + '?info=' + $form.find('textarea[name="info"]').val(),
                        //data: $(form).serialize(),
                        success: function(){
                            console.log('success!')
                        },
                        error: function( jqXhr, textStatus, errorThrown ){
                            console.log( errorThrown );
                        }
                    });
                    return false; // required to block normal submit since you used ajax
                }
	    });
    })