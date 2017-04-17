//$(function() {                                       // <== Doc Ready
//    $("#email").change(function() {                  // When the email is changed
//        $('#mail').val(this.value);                  // copy it over to the mail
//    });
//});

$('#singleStakesBox').keyup(function () {
    var input = document.getElementsByClassName("stakebox");
for (var i = 0; i < input.length; i++)
    input[i].value = document.getElementById('singleStakesBox').value;
});

$('#singleInputEmail').keyup(function () {
    var input = document.getElementsByClassName("inputemail");
for (var i = 0; i < input.length; i++)
    input[i].value = document.getElementById('inputemail').value;
});

$('#singleInputAddress').keyup(function () {
    var input = document.getElementsByClassName("inputaddress");
for (var i = 0; i < input.length; i++)
    input[i].value = document.getElementById('inputaddress').value;
});