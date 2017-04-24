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
						document.getElementById("button" + cid).click();
						$(".file").addClass("isDeleted");
						swal("Đã xóa!", "Dữ liệu đã được xóa khỏi hệ thống.",
								"success");
					}
				});
			});
});
