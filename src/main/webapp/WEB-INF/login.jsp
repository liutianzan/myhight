<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Purple_loginform Website Template | Home :: w3layouts</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- -->
    <script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
    <script src="${pageContext.request.contextPath}/myJs/jquery.min.js"></script>

    <script>$(document).ready(function(c) {
        $('.alert-close').on('click', function(c){
            $('.message').fadeOut('slow', function(c){
                $('.message').remove();
            });
        });
    });
    </script><script src="${pageContext.request.contextPath}/myJs/sweetalert.min.js"></script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>登录</h1>
            <div class="alert-close"> </div>
        </div>
        <form action="${pageContext.request.contextPath}/isLogin" method="get" onsubmit="return myFunction()">
            <li>
                <input id="username" name="username" type="text" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}"><a href="#" class=" icon user"></a>
            </li>
            <div class="clear"> </div>
            <li>
                <input id="password" name="password" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
            </li>
            <div class="clear">
            <c:if test="${mgs != null}">
                <span id="loginError" style="color: red">${mgs}</span>
            </c:if>
            </div>
            <div class="submit">
                <input type="submit"  value="Sign in" id="onLogin">
                <h4><a href="#">Lost your Password ?</a></h4>
                <h4><a href="${pageContext.request.contextPath}/register">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</a></h4>
                <div class="clear">  </div>
            </div>

        </form>
    </div>
</div>
</div>
<div class="clear"> </div>
<!--- footer --->
<div class="footer">
    <p>自动化分析平台.</p>
</div>
<script type="text/javascript">
    function myFunction() {
        if(document.getElementById("username").value=="Username" || document.getElementById("username").value==null)
        {
            swal("请输入用户名"," ","error");
            return false;
        }
        else if(document.getElementById("password").value=="Password" || document.getElementById("password").value==null){
            swal("请输入密码", " ", "error");
            return false;
        }
        else{

            return true;
        }

    }


</script>
</body>
</html>