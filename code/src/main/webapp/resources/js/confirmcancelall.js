/* Confirm popup for cancel all*/
$(function() {
	$(".cancel").click(
					function(e) {
						e.preventDefault();
						var cid = this.id;
						swal(
								{
									title : "Bạn muốn hủy đăng ký?",
									type : "warning",
									showCloseButton : true,
									showCancelButton : true,
									cancelButtonText : "Không",
									confirmButtonColor : "#DD6B55",
									confirmButtonText : "Hủy đăng ký",
									closeOnConfirm : false,
								},
								function(isConfirmed) {
									if (isConfirmed) {
										swal(
												{
													title : "Nhấn 'Tất cả' để hủy những vé bạn đã đăng ký. Nhấn 'Chỉ mình tôi' để hủy vé của bạn",
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
														document.getElementById("reg" + cid).click();
														$(".file").addClass("isDeleted");
														swal("Đã hủy!", "Đăng ký đã được hủy.", "success");
													} else {
														document.getElementById("all" + cid).click();
														$(".file").addClass(
														"isDeleted");
														swal("Đã hủy!", "Đăng ký đã được hủy.", "success");
													}
												})
									}
								});
					});
});
/* End Confirm popup for cancel all */