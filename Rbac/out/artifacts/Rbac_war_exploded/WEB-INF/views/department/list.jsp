<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="/style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script src="/js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="/js/commonAll.js"></script>
<title>WMS-部门管理</title>
<style>
.alt td {
	background: black !important;
}
</style>
<script type="text/javascript">
	$(function() {

		//新增/编辑(开发中一般利用样式别称)
		//window.location.href="/department/input.do";  写死,用html5的自定义data-url
		$(".btn_redirect").click(function() {
			//获取button中指定有url,然后到指定url上
			//$(this)  表示被点击元素
			window.location.href = $(this).data("url");
		});

		//删除(使用ajax请求)
		//给删除元素添加自定义样式: btn_delete, 同时添加data-url自定义的属性
		$(".btn_delete").click(function() {
			//询问用户是否确定删除
			var ret = confirm("你确定要删除吗?"); //查文档
			if (ret) {
				//发送ajax删除
				$.get($(this).data("url"), function(data) {
					window.location.reload();
				});

			}

		});
		
		//pageSize下拉框回显
		//参数1:数组或者对象,参数2:操作函数
		$.each($(":input[name='pageSize'] option"),function(index,item){
			//当用于回显的pageSize 等于option中value值时才选择
			if ( ${result.pageSize} == $(item).val()) {
				$(item).prop("selected",true);
			}
			
		});
		//下拉框发生改变时,执行重新加载一次数据
		$(":input[name='pageSize']").change(function(){
			$(":input[name='currentPage']").val(1);
			$("#searchForm").submit();
		});
		
		
		//分页操作
		$(".btn_page").click(function(){
			
			//这个跳转button对应currentPage输入框的应该是用户输入的
			var pageNo =$(this).data('page') || $(":input[name='currentPage']").val() || 1;
			//获取当前页,然后修改成指定的跳转的页码数
			$(":input[name='currentPage']").val(pageNo);
			//1.找到form表单,然后直接提交表单
			$("#searchForm").submit();
		});
		
		

	});
</script>
</head>
<body>
	<form id="searchForm" action="/department/list.do" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_bottom">
							<input type="button" value="新增"
								class="ui_input_btn01  btn_redirect"
								data-url="/department/input.do" />
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%"
						align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" /></th>
							<th>编号</th>
							<th>名称</th>
							<th>编码</th>
							<th></th>
						</tr>
						<tbody>
							<c:forEach items="${result.data}" var="item" varStatus="num">
								<tr>
									<td><input type="checkbox" class="acb" /></td>
									<td>${num.count}</td>
									<td>${item.name}</td>
									<td>${item.sn}</td>
									<td><a href="#javascript:;" class="btn_redirect"
										data-url="/department/input.do?id=${item.id}">编辑</a> <a
										href="#javascript:;" class="btn_delete"
										data-url="/department/delete.do?id=${item.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 分页操作 -->
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有 <span class="ui_txt_bold04">${result.totalCount}</span> 条记录，当前第
						<span class="ui_txt_bold04">${result.currentPage}/${result.endPage}</span>
						页
					</div>  
					<div class="ui_frt">
						<input type="button" value="首页" class="ui_input_btn01  btn_page" data-page="1"/> <input
							type="button" value="上一页" class="ui_input_btn01  btn_page" data-page="${result.prevPage}"/> <input
							type="button" value="下一页" class="ui_input_btn01  btn_page " data-page="${result.nextPage}"/> <input
							type="button" value="尾页" class="ui_input_btn01  btn_page" data-page="${result.endPage}"/> <select
							name="pageSize" class="ui_select02 ">
							<option value="3">3</option>
							<option value="5">5</option>
							<option value="10">10</option>
						</select> 转到第<input type="number" name="currentPage" value="${result.currentPage}"
							class="ui_input_txt01" min="1" style="width: 50px;" /> <input
							type="button" class="ui_input_btn01  btn_page " value="跳转" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>

