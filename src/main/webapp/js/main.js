// $(document).ready(function(){
//     $('#logar').click(function () {
//         $('#login-form').attr('action', '/poonotes/login');
//         $('#login-form').submit();
//     });
// });

function submitForm() {
    document.getElementById('login-form').submit();
}

function getCardId(id) {
    document.getElementById('cardId').value = id;
    document.getElementById('card-form').submit();
}

function openCardType(evt, tabName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}