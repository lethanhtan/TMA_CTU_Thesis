/* Show/ hidden fields when choose select option 
$(document)
		.ready(
				function() {
					$('select').change(function() {
						var option = $(this).val();
						showFields(option);
						return false;
					});
					function showFields(option) {
						var content = '';
						for (var i = 2; i <= option; i++) {
							content += '<div id="cus_'
									+ i
									+ '"><label>Thông tin của người thứ '
									+ i
									+ ': </label><br /><label>Họ tên:</label> <input placeholder="Nhập họ tên" type="text" path="cusName_' 
									+ i
									+ '" name="cusName_'
									+ i
									+ '" class="ddlcss">'
							'"';
							content += '</select></br></div>';
						}
						$('#cus_relationship').html(content);
					}
				});

$(document).on('change', ".ddlcss", function() {
	if ($(this).val() == 3)
		$(this).next().show();
	else
		$(this).next().hide();
});
/* End Show/ hidden fields when choose select option */

$(document).ready(function () {
    $('.group').hide();
    $('#div1').show();
    $('#selectMe').change(function () {
        $('.group').hide();
        $('#'+$(this).val()).show();
    })
});

/* 
$.ajax({url: "http://localhost:8080/TravelSystem/getInfoGroup", 
type: "get", //send it through get method
 data: { 
	  numOfInfo: $( "#selectMe" ).val();
 },
success: function(result){
$("#group").html(result);
}});
*/