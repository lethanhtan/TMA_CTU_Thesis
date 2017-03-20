/* Adding commas when type number */
$(document).ready(
		function() {
			$("input[type='text']").keyup(
					function(event) {
						// Skip for arrow keys
						if (event.which >= 37 && event.which <= 40) {
							event.preventDefault();
						}
						var $this = $(this);
						var num = $this.val().replace(/,/gi, "").split("")
								.reverse().join("");
						var num2 = RemoveRougeChar(num
								.replace(/(.{3})/g, "$1,").split("").reverse()
								.join(""));
						console.log(num2);
						// The following line has been simplified. Revision
						// History contains original.
						$this.val(num2);
					});
		});

function RemoveRougeChar(convertString) {
	if (convertString.substring(0, 1) == ",") {
		return convertString.substring(1, convertString.length)
	}
	return convertString;
}
/* End Adding commas when type number */