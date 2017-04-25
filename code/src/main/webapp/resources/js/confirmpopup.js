/* Confirm popup for delete all */
$(function() {
	$(".deleteall")
			.click(
					function(e) {
						e.preventDefault();
						var cid = this.id;
						swal(
								{
									title : "Bạn chắc chắn muốn xóa?",
									type : "warning",
									showCloseButton : true,
									showCancelButton : true,
									cancelButtonText : "Không",
									confirmButtonColor : "#DD6B55",
									confirmButtonText : "Xóa",
									closeOnConfirm : false,
								},
								function(isConfirmed) {
									if (isConfirmed) {
										swal(
												{
													title : "Nhấn 'Tất cả' để xóa những vé người này đã đăng ký. Nhấn 'Chỉ một' để xóa vé của người này",
													type : "warning",
													showCancelButton : true,
													confirmButtonClass : 'btn-danger',
													confirmButtonText : 'Chỉ một',
													cancelButtonText : "Tất cả",
													closeOnConfirm : false,
													closeOnCancel : false,
												},
												function(isConfirm) {
													if (isConfirm) {
														document.getElementById( "only" + cid) .click();
														$(".file").addClass("isDeleted");
														swal("Đã xóa!", "Dữ liệu đã được xóa khỏi hệ thống.", "success");
													} else {
														document.getElementById("all" + cid).click();
														$(".file").addClass("isDeleted");
														swal("Đã xóa!", "Dữ liệu đã được xóa khỏi hệ thống.", "success");
													}
												})
									}
								});
					});
});
/* End Confirm popup for delete all */

/* Confirm popup for delete only one */
$(function() {
	$(".delete").click(
			function(e) {
				e.preventDefault();
				var cid = this.id;
				swal({
					title : "Bạn chắc chắn muốn xóa?",
					text : "Bạn sẽ không thể khôi phục lại!",
					type : "warning",
					showCancelButton : true,
					cancelButtonText : "Không",
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "Xóa",
					closeOnConfirm : false
				}, function(isConfirmed) {
					if (isConfirmed) {
						document.getElementById("only" + cid).click();
						$(".file").addClass("isDeleted");
						swal("Đã xóa!", "Dữ liệu đã được xóa khỏi hệ thống.",
								"success");
					}
				});
			});
});
/* Confirm popup for delete only one */

/* Confirm popup for cancel all*/
$(function() {
	$(".cancelall").click(
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
													confirmButtonText : 'Chỉ mình tôi',
													cancelButtonText : "Tất cả",
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

/* Confirm popup cancel only one */
$(function() {
	$(".cancel").click(
			function(e) {
				e.preventDefault();
				var cid = this.id;
				swal({
					title : "Bạn muốn hủy đăng ký?",
					type : "warning",
					showCancelButton : true,
					cancelButtonText : "Không",
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "Hủy đăng ký",
					closeOnConfirm : false
				}, function(isConfirmed) {
					if (isConfirmed) {
						document.getElementById("reg" + cid).click();
						$(".file").addClass("isDeleted");
						swal("Đã hủy!", "Đăng ký đã được hủy.",
								"success");
					}
				});
			});
});
/* End Confirm popup cancel only one */

/* Confirm popup for undo cancel all */
$(function() {
	$(".undoall")
			.click(
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
													confirmButtonText : 'Chỉ mình tôi',
													cancelButtonText : "Tất cả",
													closeOnConfirm : false,
													closeOnCancel : false,
												},
												function(isConfirm) {
													if (isConfirm) {
														document.getElementById("only" + cid).click();
														$(".file").addClass("isDeleted");
														swal("Đã phục hồi!","Đăng ký bị hủy đã được phục hồi.", "success");
													} else {
														document.getElementById("all" + cid).click();
														$(".file").addClass("isDeleted");
														swal("Đã phục hồi!", "Đăng ký bị hủy đã được phục hồi.", "success");
													}
												})
									}
								});
					});
});
/* End Confirm popup for undo cancel all */

/* Confirm popup for undo cancel only one */
$(function() {
	$(".undo").click(
			function(e) {
				e.preventDefault();
				var cid = this.id;
				swal({
					title : "Bạn muốn phục hồi đăng ký đã hủy?",
					type : "warning",
					showCancelButton : true,
					cancelButtonText : "Không",
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "Phục hồi",
					closeOnConfirm : false
				}, function(isConfirmed) {
					if (isConfirmed) {
						document.getElementById("only" + cid).click();
						$(".file").addClass("isDeleted");
						swal("Đã phục hồi!", "Đăng ký bị hủy đã được phục hồi.", "success");
					}
				});
			});
});
/* End Confirm popup for undo cancel only one */