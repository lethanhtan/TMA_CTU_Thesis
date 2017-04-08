/* Adding commas when type number */
$('input.number').keyup(function(event) {

	// Skip for arrow keys
	if (event.which >= 37 && event.which <= 40)
		return;

	// Format number
	$(this).val(function(index, value) {
		return value.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	});
});
/* End Adding commas when type number */