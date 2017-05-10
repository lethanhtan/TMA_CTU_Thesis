/* Calendar */
$(document).ready(function() {
	$("#datepicker").datepicker();
});
$(document).ready(function() {
	$("#datepicker2").datepicker();
});
$(document).ready(function() {
	$("#datepicker3").datepicker();
});
$(document).ready(function() {
	$("#datepicker4").datepicker();
});
$(document).ready(function() {
	$("#datepicker5").datepicker();
});
$(document).ready(function() {
	$("#datepicker6").datepicker();
});
$('.datefield').datepicker({ dateFormat: 'dd/mm/yy'});

/* End Calendar */

/* Popup */
$(".modal-wide").on("show.bs.modal", function() {
	var height = $(window).height() - 900;
	$(this).find(".modal-body").css("max-height", height);
});
/* End Popup */

/* Text Editor */
bkLib.onDomLoaded(function() {
	nicEditors.allTextAreas()
}); // convert all text areas to rich text editor on that page

bkLib.onDomLoaded(function() {
	new nicEditor().panelInstance('area1');
}); // convert text area with id area1 to rich text editor.

bkLib.onDomLoaded(function() {
	new nicEditor({
		fullPanel : true
	}).panelInstance('area2');
}); // convert text area with id area2 to rich text editor with full panel.
/* End Text Editor */