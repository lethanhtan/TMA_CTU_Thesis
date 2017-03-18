// Checkbox validation
document
		.addEventListener(
				"DOMContentLoaded",
				function() {
					var myForm = document.getElementById("checkboxV");
					var checkForm = function(e) {
						if (!this.terms.checked) {
							alert("Bạn chưa check đồng ý!");
							this.terms.focus();
							e.preventDefault();
							// Equivalent to return false
							return;
						}
					};

					// Attach the form submit handler
					myForm.addEventListener("submit", checkForm, true);
					var myCheckbox = document.getElementById("field_terms");
					var myCheckboxMsg = "Bạn chưa check đồng ý!";

					// Set the starting error message
					myCheckbox.setCustomValidity(myCheckboxMsg);

					// Attach checkbox handler to toggle error message
					myCheckbox
							.addEventListener(
									"change",
									function() {
										this
												.setCustomValidity(this.validity.valueMissing ? myCheckboxMsg
														: "");
									}, false);
				}, false);
// End Checkbox validation
