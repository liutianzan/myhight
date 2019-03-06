<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="5">
    <link type="text/css" href="${pageContext.request.contextPath}/css/myHIgh.css" rel="stylesheet">
    <title>工作空间</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="beijing">
    <h3><font size="7px" color="#ffffff">&nbsp;文本内容</font></h3>
    <div id="subfanhui1">
        <input id="sub" type="submit" name="sub" value="返回" onclick='location.href=("${pageContext.request.contextPath}/differentPath")'/>
    </div>
</div>
<div class="externalHtml">
<textarea rows="50" cols="100"  id="plain" class="plainText" readonly="readonly">

</textarea>

</div>
<div id="nameFile">${fileName}</div>
<div id="dirPath">
    <pre id="textHuo" style="size: 1px">${text}</pre>
</div>
<c:if test="${text != null}">


    <script type="text/javascript">
        window.onload=function()//用window的onload事件，窗体加载完毕的时候
        {
            var pp = document.getElementById("plain");
            var pr = document.getElementById("textHuo")
            pp.innerHTML = pr.innerHTML;
        }




    </script>
</c:if>

</body>
</html>