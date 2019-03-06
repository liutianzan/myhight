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
    </script>
</head>
<body>
<div id="cho">


    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/differentChoose")' value="差分分析" id="sub1">



    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/liner")' value="线性分析" id="sub2">



    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/impossible")' value="不可能差分分析" id="sub3">


    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/zero")' value="零相关线性分析" id="sub4">

    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/base")' value="基于可分析的积分分析" id="sub5">
    <input type="submit" onclick='location.href=("${pageContext.request.contextPath}/middle")' value="中间相遇分析" id="middle">
</div>
<!-- contact-form -->

<div class="clear"> </div>
<!--- footer --->
<div class="footer">
    <p>自动化分析平台.</p>
</div>


</body>
</html>