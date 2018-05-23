$(document).ready(function(){
    $('#logar').click(function () {
    	$('#login-form').attr('action', '/poonotes/login');
        $('#login-form').submit();
    });
});