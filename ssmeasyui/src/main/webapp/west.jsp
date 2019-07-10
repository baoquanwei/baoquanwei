<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="inc.jsp"/>
<script type="text/javascript">
var layout_west_tree;
	$(function() {
		layout_west_tree = $('#layout_west_tree').tree({
			onClick : function(node) {
					addTab({
						url : node.attributes.url,
						title : node.text,
					});
			},
		});
	});

	function addTab(params) {
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
			parent.$.messager.progress('close');
		} else {
			t.tabs('add', opts);
		}
	}
</script>
</head>
<body>

			<ul class="easyui-tree" id="layout_west_tree">
				<li>
					<span>后台管理</span>
					<ul>
						<li data-options="attributes:{'url':'${pageContext.request.contextPath}/user/usermanage'}"> <span>用户管理</span>  </li>
						<li> <span>账号管理</span> </li>
					</ul>
				</li>
			</ul> 
		
</body>
</html>