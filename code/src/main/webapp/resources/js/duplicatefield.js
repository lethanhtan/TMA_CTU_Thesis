/* Duplicate field when user typing */
$('#singleStakesBox').keyup(function () {
    var input = document.getElementsByClassName("stakebox");
for (var i = 0; i < input.length; i++)
    input[i].value = document.getElementById('singleStakesBox').value;
});
/* End Duplicate field when user typing */
