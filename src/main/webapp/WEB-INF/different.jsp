<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.baseTool.util.CookieUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link type="text/css" href=${pageContext.request.contextPath}/css/myHIgh.css rel="stylesheet">
    <link href=${pageContext.request.contextPath}/css/style.css rel="stylesheet" type="text/css" media="all"/>
    <script src=${pageContext.request.contextPath}/myJs/sweetalert.min.js></script>
    <title>差分分析</title>
    <style type="text/css" media="screen">
        .btn { display: block; position: relative; background: #aaa; padding: 5px; float: left; color: #fff; text-decoration: none; cursor: pointer; }
        .btn i { background-position: top left; position: absolute; margin-bottom: -5px;  top: 0; left: 0; width: 5px; height: 5px; }
        * html .btn span,
        * html .btn i { float: left; width: auto; background-image: none; cursor: pointer; }
        .btn:hover { background-color: #a00; }
        .btn:active { background-color: #444; }
        * html .btn { border: 3px double #aaa; }
        * html .btn:hover { border-color: #a00; }
        p { clear: both; padding-bottom: 2em; }
        #reset_btn{

            width: 85px;
            height: 25px;

        }
        #exitBut{
            position: relative;
            height: 20px;
            width: 20px;
            bottom:-24%;
            left: 60%;

        }
    </style>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-3.2.1.min.js"></script>
<body>
<%
    //    Cookie[] cookies = request.getCookies();
//    Cookie cookie = null;
//    for(int i = 0;i<cookies.length;i++){
//        if(cookies[i].getName().equals("token")){
//            cookie = cookies[i];
//            break;
//        }
//    }
//    String token = null;
//    if(cookie != null) {
//        token = URLDecoder.decode(cookie.getValue(), "UTF-8");
//    }
//    System.out.println(token);
//    String html = null;
//    if(token!=null){
//        html=request.getSession().getAttribute(token)+"";
//    }
//    System.out.println(html);
//    System.out.println(request.getSession().getId());
    HttpSession session1 = request.getSession();
    String userName = CookieUtil.getUserName(session1);
    System.out.println(userName);
    String html = request.getSession().getAttribute(userName+"trunkDiff") + "";

    if (html == null || html.equals("null") || html.equals("")) {
%>
<pre id="editor">function foo(items) {
    var i;
    for (i = 0; i &lt; items.length; i++) {
        alert("Ace Rocks " + items[i]);
    }
}</pre>

<%
} else {

%>
<pre id="editor"><%=html%></pre>
<%}%>

<input id="subhid" type="hidden" name="subTxt">
<div id="butInp" class="box">
</div>
<%--<script>--%>
    <%--var box = document.getElementsByClassName("box1")[0]; //获取元素--%>
    <%--var x, y; //存储div的坐标--%>
    <%--var isDrop = false; //移动状态的判断鼠标按下才能移动--%>
    <%--box.onmousedown = function(e) {--%>
        <%--var e = e || window.event; //要用event这个对象来获取鼠标的位置--%>
        <%--x = e.clientX - box.offsetLeft;--%>
        <%--y = e.clientY - box.offsetTop;--%>
        <%--isDrop = true; //设为true表示可以移动--%>
    <%--}--%>

    <%--document.onmousemove = function(e) {--%>
        <%--//是否为可移动状态                　　　　　　　　　　　 　　　　　　　--%>
        <%--if(isDrop) {--%>
            <%--var e = e || window.event;--%>
            <%--var moveX = e.clientX - x; //得到距离左边距离                    　　--%>
            <%--var moveY = e.clientY - y; //得到距离上边距离--%>

            <%--var maxX = document.documentElement.clientWidth - box.offsetWidth;--%>
            <%--var maxY = document.documentElement.clientHeight - box.offsetHeight;--%>

            <%--//范围限定  当移动的距离最小时取最大  移动的距离最大时取最小--%>
            <%--//范围限定一--%>
            <%--/*if(moveX < 0) {--%>
                <%--moveX = 0--%>
            <%--} else if(moveX > maxX) {--%>
                <%--moveX = maxX;--%>
            <%--}--%>

            <%--if(moveY < 0) {--%>
                <%--moveY = 0;--%>
            <%--} else if(moveY > maxY) {--%>
                <%--moveY = maxY;--%>
            <%--}　*/--%>
            <%--//范围限定二　--%>
            <%--moveX=Math.min(maxX, Math.max(0,moveX));--%>

            <%--moveY=Math.min(maxY, Math.max(0,moveY));--%>
            <%--box.style.left = moveX + "px";--%>
            <%--box.style.top = moveY + "px";--%>
        <%--} else {--%>
            <%--return;--%>
        <%--}--%>

    <%--}--%>

    <%--document.onmouseup = function() {--%>
        <%--isDrop = false; //设置为false不可移动--%>
    <%--}--%>
<%--</script>--%>
<div id="tex">
    <%--<textarea style="width:100%;height:100%;resize:none" id="buildout" rows="8" data-role="none" readonly="readonly"--%>
              <%--class="area">(compiler output will display here)</textarea>--%>
<div id="show" style="overflow:auto; width:100%;height:100%; border: 1px solid #797979;" class="box1"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/amq_jquery_adapter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/amq.js"></script>
<%
    String ip = request.getHeader("x-forwarded-for");
    if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
        ip = request.getHeader("Proxy-Client-IP");
    }
    if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
        ip = request.getRemoteAddr();
    }

%>
<script>
    function showInfo(str) {
        var t = document.getElementById("show");

        if(str=="exit"){
            t.innerHTML +=  "<br>" +"程序分析工作完成"+ "<br>";
            t.scrollTop = t.scrollHeight;
        }else{
            t.innerHTML +=  "<br>" + str + "<br>";
            t.scrollTop = t.scrollHeight;
        }
    }
    function clearShow() {
        var t = document.getElementById("show");

        t.innerHTML="";
    }
    var amq = org.activemq.Amq;
    amq.init({
        uri: '${pageContext.request.contextPath}/amq',
        logging: true,
        timeout: 20
    });
    var myHandler =
        {
            rcvMessage: function(message)
            {
                console.log(message);
                //chrome
                showInfo( message.textContent);
            }
        };
    var destination = "channel://<%=userName%>wordDiff";
    amq.addListener(1,destination,myHandler.rcvMessage);
</script>

<div id="beijing">

    <table id="tabId">
        <tr id="ziti">
            <div id="wenzi"><font color="#fff" size="6px">截断型差分分析</font></div>
        </tr>
        <tr id="trd">

            <td class="tableFont" id="table1" width="28px">
                <div id="fontThe">&nbsp;Theme:</div>
            </td>
            <td>
                <div id="selectStyle">
                    <select name="themeName" onchange="changeTheme()" id="select">
                        <optgroup label="Bright">
                            <option value="chrome">Chrome</option>
                            <option value="clouds">Clouds</option>
                            <option value="crimson_editor">Crimson Editor</option>
                            <option value="dawn">Dawn</option>
                            <option value="dreamweaver">Dreamweaver</option>
                            <option value="eclipse">Eclipse</option>
                            <option value="github">GitHub</option>
                            <option value="iplastic">IPlastic</option>
                            <option value="solarized_light">Solarized Light</option>
                            <option value="textmate">TextMate</option>
                            <option value="tomorrow">Tomorrow</option>
                            <option value="xcode">XCode</option>
                            <option value="kuroir">Kuroir</option>
                            <option value="katzenmilch">KatzenMilch</option>
                            <option value="sqlserver">SQL Server</option>
                        </optgroup>
                        <optgroup label="Dark">
                            <option value="ambiance">Ambiance</option>
                            <option value="chaos">Chaos</option>
                            <option value="clouds_midnight">Clouds Midnight</option>
                            <option value="dracula">Dracula</option>
                            <option value="cobalt">Cobalt</option>
                            <option value="gruvbox">Gruvbox</option>
                            <option value="gob">Green on Black</option>
                            <option value="idle_fingers">idle Fingers</option>
                            <option value="kr_theme">krTheme</option>
                            <option value="merbivore">Merbivore</option>
                            <option value="merbivore_soft">Merbivore Soft</option>
                            <option value="mono_industrial">Mono Industrial</option>
                            <option value="monokai">Monokai</option>
                            <option value="pastel_on_dark">Pastel on dark</option>
                            <option value="solarized_dark">Solarized Dark</option>
                            <option value="terminal">Terminal</option>
                            <option value="tomorrow_night">Tomorrow Night</option>
                            <option value="tomorrow_night_blue">Tomorrow Night Blue</option>
                            <option value="tomorrow_night_bright">Tomorrow Night Bright</option>
                            <option value="tomorrow_night_eighties">Tomorrow Night 80s</option>
                            <option value="twilight">Twilight</option>
                            <option value="vibrant_ink">Vibrant Ink</option>
                        </optgroup>
                    </select>
                </div>
            </td>
        </tr>

    </table>
    <table id="tabId1">
        <tr>
            <td class="tableFont" id="table2" width="50px">&nbsp;Size:</td>
            <td height="60"><input type="number" id="but2" value=12 min=0 onclick="changeSize1(id)"><input type="button"
                                                                                                           id="but"
                                                                                                           value="12px"
                                                                                                           onclick="changeSize(id)"><input
                    type="button" id="but1" value="24px" onclick="changeSize(id)"></td>
        </tr>
    </table>
    <div id="sub6">
        <input type="submit" value="编译" class="bianyi" onclick="copyText()" id="subbianyi">
    </div>
    <div id="sub7">
        <input type="submit" value="分析" class="bianyi1" id="fenxi">
    </div>
    <div id="sub8">

        <input type="submit" value="工作空间" class="bianyi2" id="kongjian" onclick="getDir()">

    </div>
    <div id="sub9">

        <input type="submit" value="差分迹" class="bianyi3" id="traceBut" onclick="getTrace()">

    </div>
    <div id="subfanhui">
        <input id="sub" type="submit" name="sub" value="返回"
               onclick="chooseFun()"/>
    </div>
    <div id="exitBut">
    <p><input type="Button" id="reset_btn" value="退出" class="btn" onclick="chooseFun()"/></p>
    </div>
</div>
<%
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("token")) {
            cookie = cookies[i];
            break;
        }
    }
    String token = null;
    if (cookie != null) {
        token = URLDecoder.decode(cookie.getValue(), "UTF-8");
    }
    String complieRes = request.getSession().getAttribute(userName+"Res")+"";
    System.out.println(complieRes);

%>
<input type="hidden" value="<%=complieRes%>" id="hidRes">

<script type="text/javascript">
    $(function () {


        $("#subbianyi").click(function () {
            clearShow();
            ace.require("ace/ext/language_tools");
            var editor = ace.edit("editor");
            var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
            txt = editor.getValue();
            $.post("${pageContext.request.contextPath}/submit/text", {subTxt: txt}, function (result) {
                if (result == "编译失败") {
                    swal("编译失败，请检查您提交的代码", " ", "error");
                } else {
                    swal("编译成功", " ", "success");
                }

            });
        });
        $("#fenxi").click(function () {
            ace.require("ace/ext/language_tools");
            var editor = ace.edit("editor");
            var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
            txt = editor.getValue();
            clearShow();
            $.post("${pageContext.request.contextPath}/complie", {subTxt: txt}, function (result) {

                if (result == "编译未成功") {

                    swal("编译未成功", " ", "error");
                    showInfo("程序发生改变，请先进行编译")
                } else {
                    showInfo("开始分析");

                }

            });
        });




        function reloadView() {
            <%--$.get("${pageContext.request.contextPath}/getComplieStatus", function (result) {--%>
                <%--if (result.code == "0") {--%>
                    <%--$('#show').html("(compiler output will display here)");--%>
                <%--} else if(result.code =="1"){--%>
                    <%--alert(result);--%>

                    <%--$('#show').html("求解中");--%>

                <%--}else{--%>
                    <%--$('.area').html(result.date);--%>
                <%--}--%>

            <%--});--%>

            var a = document.getElementById("show");
            var b = document.getElementById("hidRes");
            if(b.value=="null"){
                a.innerHTML = "(compiler output will display here)";
            }else{

                a.innerHTML = b.value;
            }



        }

        setInterval(reloadView(), 1000);
    });
    <%--var intervald;--%>
    <%--function clickFenxi() {--%>
    <%--intervald = setInterval(reloadView, 1000);--%>
    <%--}--%>
    <%--function reloadView() {--%>
    <%--ace.require("ace/ext/language_tools");--%>
    <%--var editor = ace.edit("editor");--%>
    <%--var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素--%>
    <%--txt = editor.getValue();--%>
    <%--$.ajax({--%>
    <%--url: '${pageContext.request.contextPath}/getComplieStatus',--%>
    <%--type: 'GET',--%>
    <%--data: {subTxt: txt},--%>
    <%--async: true,    //或false,是否异步--%>
    <%--success: function (result) {--%>
    <%--if (result.code == "0") {--%>
    <%--$('.area').html("(compiler output will display here)");--%>
    <%--} else if (result.code == "1") {--%>
    <%--alert(result);--%>
    <%--$('.area').html(result);--%>
    <%--} else{--%>

    <%--clearInterval(intervald);--%>
    <%--}--%>


    <%--},--%>
    <%--error: function (XMLHttpRequest, txtStatus, errorThrown) {--%>
    <%--//alert(XMLHttpRequest + "<br>" + txtStatus + "<br>" + errorThrown);--%>
    <%--}--%>
    <%--});--%>
    <%--}--%>


</script>

<script type="text/javascript">
    function getDir() {
        ace.require("ace/ext/language_tools");
        var editor = ace.edit("editor");
        var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
        var b = document.getElementById("show");
        txt = editor.getValue();
        compileRes = b.innerHTML;
        document.write("<form action='${pageContext.request.contextPath}/differentPath' method=post name=manageDepForm style='display:none'>");
        document.write("<input type=hidden name='subTxt' value='" + txt + "'/>");//参数1
        document.write("<input type=hidden name='compileRes' value='" + compileRes + "'/>");//参数2
        document.write("</form>");
        document.manageDepForm.submit();
    }

    function chooseFun() {
        ace.require("ace/ext/language_tools");
        var editor = ace.edit("editor");
        var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
        var b = document.getElementById("show");
        txt = editor.getValue();
        compileRes = b.innerHTML;
        typeHtml = "trunkDiff"
        typeRes = "Res"
        document.write("<form action='${pageContext.request.contextPath}/choose' method=post name=manageDepForm style='display:none'>");
        document.write("<input type=hidden name='subTxt' value='" + txt + "'/>");//参数1
        document.write("<input type=hidden name='compileRes' value='" + compileRes + "'/>");//参数2
        document.write("<input type=hidden name='typeHtml' value='" + typeHtml + "'/>");//参数2
        document.write("<input type=hidden name='typeRes' value='" + typeRes + "'/>");//参数2
        document.write("</form>");
        document.manageDepForm.submit();
    }

    function getTrace() {
        ace.require("ace/ext/language_tools");
        var editor = ace.edit("editor");
        var a = document.getElementById("editor")//通过ByTagName,ByClassName,ById获取a元素
        var b = document.getElementById("show");
        txt = editor.getValue();
        compileRes = b.innerHTML;
        document.write("<form action='${pageContext.request.contextPath}/different/differentTrace' method=post name=manageDepForm style='display:none'>");
        document.write("<input type=hidden name='subTxt' value='" + txt + "'/>");//参数1
        document.write("<input type=hidden name='compileRes' value='" + compileRes + "'/>");
        document.write("</form>");
        document.manageDepForm.submit();
    }

    function copyText() {
        var r = confirm("是否提交");

        if (r == true) {
            var a = document.getElementById("editor")//通过ByTagName,ByClassName,ById获取a元素
            var input = document.getElementById("subhid");
            input.value = a.innerHTML;

            return true;
        } else {
            return false;
        }

    }
</script>
<script type="text/javascript">
    function show_confirm() {
        var r = confirm("是否提交");
        if (r == true) {
            alert("You pressed OK!");
        }
    }
</script>
<script src=${pageContext.request.contextPath}/src-min-noconflict/ace.js type="text/javascript"
        charset="utf-8"></script>
<script>
    ace.require("ace/ext/language_tools");
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/tomorrow");
    editor.session.setMode("ace/mode/javascript");
    editor.setOptions({
        enableBasicAutocompletion: true,
        enableSnippets: true,
        enableLiveAutocompletion: true
    });
</script>
<script type="text/javascript">
    function changeTheme() {
        var a = document.getElementById("select")//通过ByTagName,ByClassName,ById获取a元素
        var theme = "ace/theme/" + a.value;
        editor.setTheme(theme);
    }

    function changeSize(m) {
        var a = document.getElementById(m);
        var b = document.getElementById("but2");
        b.value = parseInt(a.value);
        document.getElementById('editor').style.fontSize = a.value;
    }

    function changeSize1(m) {
        var a = document.getElementById(m);
        var b = document.getElementById("but2");
        b.value = parseInt(a.value);

        document.getElementById('editor').style.fontSize = a.value + "px";
    }
</script>
</body>
</html>