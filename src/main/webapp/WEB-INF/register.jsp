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
            <h1>注册</h1>
            <div class="alert-close"> </div>
        </div>
        <form action="${pageContext.request.contextPath}/registering" method="get" onsubmit="return confirm()">
            <li>
                <input id="username" name="username" type="text" class="text" value="" placeholder="请输入您的用户名"><a href="#" class=" icon user"></a>
            </li>
            <div class="clear"> </div>
            <li>
                <input id="password" name="password" placeholder="请输入您的密码" type="password" value="" > <a href="#" class="icon lock"></a>
            </li>
            <li>
                <input id="password1" placeholder="请重复您的密码" name="password1" type="password" value=""> <a href="#" class="icon lock"></a>
            </li>
            <div class="clear">
                <c:if test="${mgs != null}">
                    <span id="loginError" style="color: red">${mgs}</span>
                </c:if>
            </div>
            <div class="submit">
                <input type="submit"  value="注册" id="onLogin">
                <h4><a href="${pageContext.request.contextPath}/login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返回</a></h4>
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

</script>
<script type="text/javascript">
    var Webname_Regular = /^[0-9a-zA-Z-_ \u4e00-\u9fa5]*$/;           //昵称的正则表达式。
    var Webpassword_Regular = /^^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;       //注册登录密码的正则表达式。
    function myUsername() {
        if(document.getElementById("username").value.length < 1){
            swal("用户昵称不能为空!"," ","error");
            return false;
        }else if(document.getElementById("username").value.length > 3 && document.getElementById("username").value.length < 21&&Webname_Regular.test(document.getElementById("username").value)){
            return true;
        }else{
            swal("昵称格式错误，格式为4-20位字母和数字"," ","error");
            return false;
        }


    }
    function myPassword() {
        if(document.getElementById("password").value=="Password" || document.getElementById("password").value==null||document.getElementById("password").value.length < 1){
            swal("请输入密码", " ", "error");
            return false;
        }else if(Webpassword_Regular.test(document.getElementById("password").value)){
            return true;

        }else{
            swal("密码格式错误，格式为6-16位英文+数字组成!", " ", "error");
            return false;
        }

    }
    function confirmPassword() {
        if(document.getElementById("password1").value=="Password" || document.getElementById("password1").value==null||document.getElementById("password1").value.length < 1){
            swal("二次确认密码不能为空!", " ", "error");
            return false;
        }
        else if(document.getElementById("password").value!=document.getElementById("password1").value){
            swal("两次密码输入不一样!", " ", "error");
            return false;
        }
        else{

            return true;
        }
    }
    function confirm() {
        return myUsername()&&myPassword()&&confirmPassword();
    }

</script>
</body>
</html>