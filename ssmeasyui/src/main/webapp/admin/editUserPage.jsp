<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/editUser',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				
				var password = $('#password').val();
				var result = true;
				if(password == '') {
					parent.$.messager.progress('close');
					$.messager.alert('错误','密码不能为空!','error');
					result = false;
				}
				
				return result;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
					$.messager.show({
					title:'操作正确',
					msg:result.msg,
					timeout:2000,
					showType:'slide'
			});
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
		<input type="hidden" id="id" name="id" value="${user.id}"/> 
			<table class="table table-hover table-condensed">
				
				<tr>
					<th>用户名:</th>
					<td><span>${user.username} </span><input type="hidden" id="username" name="username" value="${user.username}"/> </td>
				</tr>
				
				<tr>
					<th>密码:</th>
					<td><input id="password"  name="password" type="text" value="${user.password} "/>   </td>
				</tr>
			</table>
		</form>
	</div>
</div>