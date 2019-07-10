<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
var nameBool;
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/add',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var username = $('#username').val();
				var password = $('#password').val();
				var result = true;
				if(username == '' || password == '') {
					parent.$.messager.progress('close');
					$.messager.alert('错误','用户名或密码不能为空!','error');
					result = false;
				}
				
				if(!nameBool) {
					parent.$.messager.progress('close');
					$.messager.alert('错误','用户名已存在!','error');
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
	
	/**检查用户名是否存在*/
	function checkUsername() {
		var username = $('#username').val();
		if(username == '')
			return ;
		else
			{
				$.ajax({
   				type: "POST",
   				url: "${pageContext.request.contextPath}/user/checkUsername",
   				dataType:"json",
   				data:$('#form').serialize(),
   				success: function(j){
     				$('#usernameTip').html(j.msg);
     				if(j.success == true) {
     					nameBool = true;
     				} else {
     					nameBool = false;
     				}
   				}
				});
			}
	}
	
	/**清空用户名提醒*/
	function clearValue() {
		var usernameTip = $('#usernameTip').html();
		if(usernameTip != '') 
		{
			$('#usernameTip').html('');
			nameBool = false;
		}
			
	}
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>用户名:</th>
					<td><input id="username" type="text" name="username" type="text" onblur="checkUsername();" onfocus="clearValue();"/>  <span id="usernameTip" style="color: red"></span> </td>
				</tr>
				
				<tr>
					<th>密码:</th>
					<td><input id="password" type="password" name="password" type="text" />   </td>
				</tr>
			</table>
		</form>
	</div>
</div>