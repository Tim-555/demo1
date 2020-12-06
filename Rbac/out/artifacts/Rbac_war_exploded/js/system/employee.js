$(function() {
	// 全部从左移动到右
	$("#selectAll").click(function() {
		$(".all_roles option").appendTo($(".selected_roles"));
	});
	// 把选中的从左移动到右
	$("#select").click(function() {
		$(".all_roles option:selected").appendTo($(".selected_roles"));
	});
	// 全部从右移动到左
	$("#deselectAll").click(function() {
		$(".selected_roles option").appendTo($(".all_roles"));
	});
	// 把选中的从右移动到左
	$("#deselect").click(function() {
		$(".selected_roles option:selected").appendTo($(".all_roles"));
	});
	//在表单提交之前,应该选中所有已经分配的权限选项
	$("#editForm").submit(function(){
		$(".selected_roles option").prop("selected",true)
	});
	//把已经分配的权限从所有的权限列表中移除
	//1:获取已经分配权限的的id,存储到ids数组中
	var ids = $.map($(".selected_roles option"),function(item){
		return $(item).val();
	});
	//2:迭代所有的权限列表的每一个<option>
	$.each($(".all_roles option"),function(index,item){
		var optionObject = $(item);
		var optionValue = $(item).val();
		//判断每一个值是否在ids数组中
		if($.inArray(optionValue,ids) >=0 ){
			optionObject.remove();//如果在ids数组中,删除自己
		}
	});
});

/**输入表单校验*/
$(function() {
	$("#editForm").validate({
		rules : {
			"name" : {
				rangelength : [ 2, 16 ]
			},
			"password" : {
				required : true,
				minlength : 1
			},
			"repassword" : {
				equalTo : "#password"
			},
			"email" : {
				required : true,
				email : true
			},
			"age" : {
				required : true,
				range : [ 10, 70 ]
			}
		},
		messages : {
			"name" : "账户名必须是2到16位",
			"password" : {
				required : "密码必填",
				minlength : "密码不能少于1位"
			},
			"repassword" : {
				equalTo : "两次密码不一致"
			},
			"email" : {
				required : "电子邮箱必填",
				email : "电子邮箱格式不正确"
			},
			"age" : {
				required : "年龄必填",
				range : "年龄必须在10到70岁之间"
			}
		}
	});
});

$(function() {
	var role = null;
	$(".ui_checkbox01").click(function() {
		if (this.checked) {
			role = $(".role").detach();
		} else {
			$(this).parents("tr").after(role);
		}
	});
	
	if ($(".ui_checkbox01").prop("checked")) {
		role = $(".role").detach();
	}
});