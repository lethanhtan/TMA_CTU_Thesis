/* Show/ hide input when choose in select option */
var showDiv = function(number) {
  $('.number-option').hide();
  $('.number-option:lt(' + number + ')').show();
};

$('#main-select').change(function() {
  showDiv(parseInt(this.value, 10));
}).change();
/* End Show/ hide input when choose in select option */