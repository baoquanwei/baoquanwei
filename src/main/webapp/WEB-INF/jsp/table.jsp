<%--
  Created by IntelliJ IDEA.
  User: Wei.Wei
  Date: 2020/3/2
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>表格</title>
</head>
<style type="text/css">
    body,div,a,p,span{
        margin: 0;
        padding:0;
        }
    .shade{
        width: 100%;
        height: 100%;
        background: rgba(0,0,0,.5);
        position: absolute;
        z-index: 1;
        display: none;
        }
    .login{
        padding:10px;
        border-radius: 10px;
        width:300px;
        height: 200px;
        background: #fff;
        position: absolute;
        z-index: 2;
        display: none;
        }
    span{
        float: right;
        cursor: pointer;
        }
    .title{
        border-bottom: 1px #ccc solid;
        text-align: center;
        font-weight: bold;
        padding:5px 0 10px 0;
        }
</style>

<body>
你好：${Msg}
<table border="1" content="">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>账号</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${ulist}" var="ulist">
    <tr>

            <td>${ulist.userId}</td>
            <td>${ulist.userName}</td>
            <td>${ulist.loginName}</td>
            <td>${ulist.password}</td>
            <td><button id="updabtn " onclick="upda(${ulist.userId})">编辑</button><button id="delebtn" onclick="del(${ulist.userId})" >删除</button></td>

     </tr>
    </c:forEach>


</table>
<div class="shade"></div>
  <div class="login">
          <p class="title">编辑页面<span>&times;</span></p>
        <form action="" method="post" id="form">
        用户名：<input name="userName" type="text" ><br>
        账号：<input name="loginName" type="text" ><br>
        密码：<input name="password" type="text" ><br>
        编号：<input name="userName" type="text" ><br>
        </form>
                <%--<p class="cont">弹出内容</p>--%>
    </div>
        <a href="#">登录</a>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.42.min.js"></script>
<script>
    function del(data){

        if (confirm("确定删除？")==true){
            //ajax
            alert("删除成功！"+data)
        }

    }

    function upda(data){
        $.ajax({

        })
        if (confirm("确定删除？")==true){
            alert("删除成功！"+data)
        }
    }
</script>
<script type="text/javascript">
    $(function(){
        //浏览器大小发生改变
        $(window).resize(function(){
            showShade();
        });

        //模态框出现
        $("a").bind("click",function(){
            $(".shade").fadeIn(1000);
            $(".login").fadeIn(1000);
            $(this).css("display","none");
            showShade();
        });
        //点击span关闭
        $("span").bind("click",function(){
            $(".shade").fadeOut(1000);
            $(".login").fadeOut(1000);
        });

        //居中显示
        function showShade(){
            var $vW = $(window).width();
            var $w = $(".login").outerWidth();
            var $vH = $(window).height();
            var $h = $(".login").outerHeight();
            $(".login").css({"left":($vW - $w)/2 + "px","top":($vH - $h)/2 + "px"});
        };

        //绑定键盘事件  按下esc键退出
        $(document).keyup(function(ev){
//                alert(ev.keyCode);  获取esc的键码27
            if(ev.keyCode == 27){
//                    $("span").click();
                //模拟事件
                $("span").trigger("click");
            }
        })

    })
</script>


</html>
