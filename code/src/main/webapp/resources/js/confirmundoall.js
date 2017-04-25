/* Confirm popup for undo cancel */
$(function() {
	$(".undo").click(
					function(e) {
						e.preventDefault();
						var cid = this.id;
						swal(
								{
									title : "Bạn muốn phục hồi đăng ký đã hủy?",
									type : "warning",
									showCloseButton : true,
									showCancelButton : true,
									cancelButtonText : "Không",
									confirmButtonColor : "#DD6B55",
									confirmButtonText : "Phục hồi",
									closeOnConfirm : false,
								},
								function(isConfirmed) {
									if (isConfirmed) {
										swal(
												{
													title : "Nhấn 'Tất cả' để phục hồi những vé bạn đã đăng ký. Nhấn 'Chỉ mình tôi' để phục hồi vé của bạn",
													type : "warning",
													showCancelButton : true,
													confirmButtonClass : 'btn-danger',
													confirmButtonText : 'Chỉ mình tôi!',
													cancelButtonText : "Tất cả!",
													closeOnConfirm : false,
													closeOnCancel : false,
												},
												function(isConfirm) {
													if (isConfirm) {
														document.getElementById("only" + cid).click();
														$(".file").addClass("isDeleted");
														swal("Đã phục hồi!", "Đăng ký bị hủy đã được phục hồi khỏi hệ thống.", "success");
													} else {
														document.getElementById("all" + cid).click();
														$(".file").addClass(
														"isDeleted");
														swal("Đã phục hồi!", "Đăng ký bị hủy đã được phục hồi khỏi hệ thống.", "success");
													}
												})
									}
								});
					});
});
/* End Confirm popup for undo cancel */