<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"/>
<script type="text/javascript">
	var dataGrid;
	$(function() {
	dataGrid = $('#user').datagrid({
			url:'${pageContext.request.contextPath}/user/getAllUsers',
			nowrap : true,
			idField : 'id',
			pagination : true,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}]],
			 columns:[[
       			 {field:'username',title:'用户名',width:100},
        		 {field:'password',title:'密码',width:100,align:'right'},
        		 {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					str += '&nbsp;';
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
					return str;
				}
			} 
   			]],
   			toolbar : '#toolbar',
		})
	});
	/**添加用户*/
	function addUser() {
	parent.$.modalDialog({
			title : '添加用户',
			width : 500,
			href : '${pageContext.request.contextPath}/user/addUserPage',
			height : 300,
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	/**批量删除*/
	function batchDelete() {
		var rows = dataGrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			parent.$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if(r) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
   					type: "POST",
   					url: "${pageContext.request.contextPath}/user/batchDelete",
   					dataType:"json",
   					data:{
   						ids : ids.join(',')
   					},
   					success: function(j) {
     					if(j.success == true) {
     						dataGrid.datagrid('load');
							dataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.alert('提示', result.msg, 'info');
							
     					} else {
     						parent.$.messager.alert('错误', '删除失败', 'error');
     						
     					}
     				
   				}
				});
					parent.$.messager.progress('close');	
				}
			})
		} else {
			parent.$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
	
	/**修改用户*/
	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑用户',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/user/editPage?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	/**删除用户*/
	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前用户？', function(b) {
			if (b) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.ajax({
   				type: "POST",
   				url: "${pageContext.request.contextPath}/user/deleteUser?id="+id,
   				dataType:"json",
   				success: function(j){
     				if(j.success == true) {
     						$.messager.show({
							title:'操作正确',
							msg:j.msg,
							timeout:2000,
							showType:'slide'
			});
							dataGrid.datagrid('reload');
     				} else {
     					parent.$.messager.alert('提示', j.msg, 'error');
     				}
     				
   				}
   				
				});
				parent.$.messager.progress('close');	
				} else {
					parent.$.messager.show({
						title : '提示',
						msg : '错误失败'
					});
				}
		});
	}
</script>
</head>
<body>
<div>
<table id="user">
	
</table>
</div>

 <div id="toolbar" style="display: none;">
			<a onclick="addUser();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
			<a onclick="batchDelete();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'delete'">批量删除</a>
	</div>
	
</body>
</html>