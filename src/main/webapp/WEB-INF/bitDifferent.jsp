<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder" %>
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
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
    String html = request.getAttribute("html") + "";

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
<div id="butInp">
</div>

<div id="tex">
    <textarea style="width:100%;height:100%;resize:none" id="buildout" rows="8" data-role="none" readonly="readonly"
              class="area">(compiler output will display here)</textarea>
</div>

<div id="beijing">

    <table id="tabId">
        <tr id="ziti">
            <div id="wenzi"><font color="#fff" size="6px">比特型差分分析</font></div>
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
        <input type="submit" value="分析" class="bianyi1" id="fenxi" onclick="clickFenxi()">
    </div>
    <div id="sub8">

        <input type="submit" value="工作空间" class="bianyi2" id="kongjian" onclick="getDir()">

    </div>
    <div id="sub9">

        <input type="submit" value="差分迹" class="bianyi3" id="traceBut" onclick="getTrace()">

    </div>
    <div id="subfanhui">
        <input id="sub" type="submit" name="sub" value="返回"
               onclick='location.href=("${pageContext.request.contextPath}/choose")'/>
    </div>
</div>

<script type="text/javascript">
    $(function () {


        $("#subbianyi").click(function () {
            ace.require("ace/ext/language_tools");
            var editor = ace.edit("editor");
            var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
            txt = editor.getValue();

            $.post("${pageContext.request.contextPath}/bit/submit/text", {subTxt: txt}, function (result) {
                if (result == "编译失败") {
                    swal("编译失败，请检查您提交的代码", " ", "error");
                } else {
                    swal("编译成功", " ", "success");
                }
                $('.area').html(result);

            });
        });
        $("#fenxi").click(function () {
            ace.require("ace/ext/language_tools");
            var editor = ace.edit("editor");
            var a = document.getElementById("editor");//通过ByTagName,ByClassName,ById获取a元素
            txt = editor.getValue();
            $('.area').html("正在分析请稍后");
            $.post("${pageContext.request.contextPath}/bit/complie", {subTxt: txt}, function (result) {
                if (result == "编译未成功") {

                    swal("编译未成功", " ", "error");
                    $('.area').html("程序发生改变，请先进行编译");
                } else {

                    $('.area').html(result);

                }

            });
        });

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
            String complieRes = request.getSession().getAttribute(token+"com")+"";

        %>

        function reloadView() {
            $.get("${pageContext.request.contextPath}/getComplieStatus", function (result) {
                if (result.code == "0") {
                    $('.area').html("(compiler output will display here)");
                } else if(result.code =="1"){
                    alert(result);

                    $('.area').html("求解中");

                }else{
                    $('.area').html(result.date);
                }

            });

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
        var a = document.getElementById("editor")//通过ByTagName,ByClassName,ById获取a元素
        txt = editor.getValue();
        document.write("<form action='${pageContext.request.contextPath}/bitDifferentPath' method=post name=manageDepForm style='display:none'>");
        document.write("<input type=hidden name='subTxt' value='" + txt + "'/>");//参数1
        document.write("</form>");
        document.manageDepForm.submit();
    }

    function getTrace() {
        ace.require("ace/ext/language_tools");
        var editor = ace.edit("editor");
        var a = document.getElementById("editor")//通过ByTagName,ByClassName,ById获取a元素
        txt = editor.getValue();
        document.write("<form action='${pageContext.request.contextPath}/bitDiff/differentTrace' method=post name=manageDepForm style='display:none'>");
        document.write("<input type=hidden name='subTxt' value='" + txt + "'/>");//参数1
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