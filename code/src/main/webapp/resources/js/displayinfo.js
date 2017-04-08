/* Back To Top */
document.getElementById('test').addEventListener('change', function () {
    var style = this.value == 1 ? 'block' : 'none';
    document.getElementById('hidden_div').style.display = style;
});
/* End Back To Top */