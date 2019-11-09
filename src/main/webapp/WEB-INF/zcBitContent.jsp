<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>文件内容</title>
    <style type="text/css">
        body {
            overflow: hidden;
        }

        #editor {
            margin: 1px;
            position: absolute;
            top: 0;
            bottom:23%;
            left: 20.4%;
            right: 0%;

        }
        #sub{
            margin: 1px;
            position: relative;
            top: 20%;
            bottom:60%;
            left: 65%;
            right: 30%;
            width: 86px;/*按钮控件的宽度*/
            text-align: center;/*按钮控件中文本居中显示*/
            line-height: 100%;/*用百分比设置行高*/
            padding-top: 0.55em;/*文本顶部的内边距*/
            padding-right: 1em;/*文本右侧的内边距*/
            padding-bottom: 1.55em;/*文本底部的内边距*/
            padding-left: 1em;/*文本左侧的内边距*/
            font-family: "Arial Black", Gadget, sans-serif;/*字体*/
            font-size: 8px;/*字体大小*/
            font-style: normal;/*字体样式*/
            font-variant: normal;/*小写字母*/
            font-weight: normal;/*文本不需要加粗*/
            text-decoration: none;/*文本不需要下划线等*/
            margin-top: 0px;/*外边框的距离*/
            margin-right: 2px;/*外边框的距离*/
            margin-bottom: 0px;/*外边框的距离*/
            margin-left: 2px;/*外边框的距离*/
            vertical-align: text-bottom;/*图像放在文本下面*/
            display: inline-block;/*段落内生出内框*/
            cursor: pointer;/*鼠标的形状*/
            zoom:1;
            outline-width:medium;/*整个轮廓的宽度*/
            outline-color:inherit;/*轮廓的颜色*/
            font-size-adjust:none;
            font-stretch:normal;
            border-top-left-radius:0.5em;/*圆角边框弧度*/
            border-top-right-radius:0.5em;/*圆角边框弧度*/
            border-bottom-left-radius:0.5em;/*圆角边框弧度*/
            border-bottom-right-radius:0.5em;/*圆角边框弧度*/
            box-shadow:0px 1px 2px rgba(0,0,0,0.2);/*给按钮增加阴影*/
            color:#fefee9;/*设置文本的颜色*/
            border-top-color:#da7c0c;/*边框的颜色*/
            border-right-color:#da7c0c;/*边框的颜色*/
            border-bottom-color:#da7c0c;/*边框的颜色*/
            border-left-color:#da7c0c;/*边框的颜色*/
            border-top-width:1px;/*边框的粗细*/
            border-right-width:1px;/*边框的粗细*/
            border-bottom-width:1px;/*边框的粗细*/
            border-left-width:1px;/*边框的粗细*/
            border-top-style:solid;/*边框的样式*/
            border-right-style:solid;/*边框的样式*/
            border-bottom-style:solid;/*边框的样式*/
            border-left-style:solid;/*边框的样式*/
            background-image:none;/*背景图片*/
            background-attachment:scroll;/*背景图片是否移动*/
            background-repeat:repeat;/*允许重复*/
            background-position-x:0%;/*背景的x轴坐标*/
            background-position-y:0%;/*背景的y轴坐标*/
            background-size:auto;/*背景图片的尺寸*/
            background-origin:padding-box;/*背景图像相对于内边距框来定位*/
            background-clip:padding-box;/*背景被裁剪到内边距框*/
            background-color:#f78d1d;/*背景颜色*/
        }
        #sub:hover {

            background-color: #f47c20;

        }
        #subfanhui{
            position: relative;
            left: 1%;
            top: 10%;
            height: 800px;
            right: 20%;
            bottom: 10%;
        }
        #subfanhui1{
            position: relative;
            left: 1%;
            top: 48%;
            height: 800px;
            right: 20%;
            bottom: 10%;

        }
        #beijing{
            position: absolute;
            background: url(../myPicture/bg.jpg);
            top:0px;
            right:79.8%;
            left: 0px;
            bottom: 0px;
        }
        input{
            border:0px;
            height:20px;
            width:40px;
        }

        #trd{
            width: 150px;
        }
        #but{
            position: relative;
            top:5%;
            left:5%;

        }
        #but1{
            position: relative;
            top:5%;
            left:10%;
        }
        #but2{
            background-color:#535353;
            width: 50px;
        }
        .tableFont{
            color: #e6f5fc;
            font-size: 13px;

        }
        #tabId{
            position: relative;
            top:35px;
            left: 14%;
            width: 300px;
        }
        #tabId1{
            position: relative;
            top:45px;
            left: 14%;
            width: 300px;
        }
        #imgId{
            position: relative;
            width: 290px;
            height: 250px;
        }
        #tex{
            position: absolute;
            top:78%;
            right:0.5%;
            left: 20.5%;
            bottom: 0.5%;


        }
        #butInp{
            border: 2px solid black;
            background-color: black;
            position: absolute;
            top:77%;
            right:0%;
            left: 20.4%;
            bottom: 19%;
            height: 6px;
        }
        #ziti{
            text-align:center;
        }
        #wenzi{
            position: relative;
            top: 2%;
            left: 10%;

        }
        #sub6{
            position: relative;
            top: 5%;
            left: 12%;
            height: 80px;
            right: 85%;
            width: 650px;

        }
        #sub7{
            position: relative;
            top: 5%;
            left: 12%;
            right: 10%;
            height: 80px;
            width: 650px;
        }
        #sub8{
            position: relative;
            top: 5%;
            left: 12%;
            right: 10%;
            height: 80px;
            width: 650px;
        }
        @media (max-width:320px){
            .message.warning  {
                margin:8% auto 0;
                width:90%;
            }
            .login-head {
                padding: 1.45em 0;
            }
            .login-head h1 {
                font-size: 1.15em;
            }
            .icon {
                margin: -33px 9px 9px 0px;
            }
            input[type="text"], input[type="password"] {
                font-size: 16px;
            }
            .alert-close {
                right: 12px;
                top: 22px;
            }
            form {
                padding: 1.5em 1.5em;
            }
            .submit {
                padding-top: 0.4em;
            }
            input[type="submit"] {
                float:none;
                padding: 11px 0px;
                width: 52%;
                font-size: 15px;
            }
            .submit h4 {
                margin-top: 15px;
                margin-bottom: 20px;
            }
            .submit h4 a {
                float: none;
                font-size: 15px;
            }
            .footer {
                left: 22%;
                bottom: 59px;
            }

        }
        .submit h4 a{
            float:left;
            font-size: 16px;
            color: #999;
            font-weight: 400;
            font-family: 'Droid Sans', sans-serif;
            margin-top: 15px;
            margin-left: 21px;
        }
        .submit h4 a:hover{
            color:#8D4294;
        }
        .tlinks{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
        /*************************/
        .submit{
            padding-top:3em;
        }
        input[type="submit"] {
            float: left;
            color: #fff;
            cursor: pointer;
            font-weight: 900;
            outline: none;
            font-family: 'Raleway', sans-serif;
            padding: 12px 0px;
            width: 35%;
            font-size: 18px;
            background:#6C496F;
            border:2px solid #6C496F;
            border-radius: 0.5em;
            -webkit-border-radius:0.5em;
            -moz-border-radius:0.5em;
            -o-border-radius:0.5em;
        }
        input[type="submit"]:hover {
            background: #fff;
            color:#6C496F;
            border:2px solid #6C496F;
        }
        .bianyi{
            left: 3%;
            width: 130px;
            height: 50px;
        }
        .bianyi1{
            left: 3%;
            width: 130px;
            height: 50px;
        }
        .bianyi2{
            left: 3%;
            width: 130px;
            height: 50px;
        }
        .fontSize{
            position: relative;
            top: 2%;
        }
        .fontThe{
            position: relative;

            left: 10%;
        }
        .table1{
            text-align: center;
        }
        .table2{
            text-align: center;
        }

        #divThe{
            position: relative;
            top: 5%;
            left: 1%;
            width: 800px;
            height: 100px;
            border:2px solid #6C496F;
        }
        #select{
            display:block;
            width:100%;
            height:100%;
            box-sizing:border-box;
            background:none;
            border:1px solid #222;
            outline:none;
            -webkit-appearance:none;
            padding:0 5px;
            line-height:inherit;
            color:inherit;
            cursor:default;
            font-size:14px;
            position:relative;
            z-index:3;
        }
        #select option{
            color:#222;
        }
        #select option:hover{
            color:#fff;
        }
        #select option:checked{
            background:#535353;
            color:#fff;
        }
        #selectStyle{
            display:block;
            margin:0 auto;
            overflow:hidden;
            left: -9%;
            height:30px;
            width:170px;
            border-radius:0;
            background:#535353 url("${pageContext.request.contextPath}/myPicture/timg 2.jpg") right center no-repeat;
            background-size:auto 80%;
            color:#fff;
            line-height:2;
            /* 如果不想加图片，
               则可以设置一个自己的三角形样式，
               如下的自定义方式，
               见代码1 */
            position:relative;
            z-index:1;
            z-index:1;
        }
        .externalHtml{
            background-color: #f6f6f6;
            position: relative;
            left: 30%;
            top:0%;
            width: 622px;
            height: 757px;
            border: 1px solid #000000;
        }

        #dirPath{
            position: relative;
            left: -30%;
        }
        #nameFile{
            position: relative;
            color: white;
            left: 10%;
            top: 5%;
            width: 100px;
        }
        #chooseFile {
            overflow: auto;
            background-color: white;
            position: absolute;
            height: 900px;
            width: 300px;
            left: 79%;
            top: 0%;
        }
        th > span, th > img {

            vertical-align: middle;

        }

        th {
            cursor: pointer;
            border: 1px solid transparent;
        }

        th:hover {
            border: 1px solid greenyellow
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-3.2.1.min.js"></script>
</head>
<body bgcolor="#f6f6f6">

<div id="beijing">
    <h3><font size="7px" color="#ffffff">&nbsp;文本内容</font></h3>
    <div id="nameFile">${fileName}</div>
    <div id="subfanhui1">
        <input id="sub" type="submit" name="sub" value="返回" onclick='location.href=("${pageContext.request.contextPath}/zcBitPath")'/>
    </div>
</div>
<div class="externalHtml">
<textarea rows="50" cols="100"  id="plain" class="plainText" readonly="readonly">

</textarea>
</div>
<div id="chooseFile">
    <table id="table">
        <c:forEach items="${fileNameList}" var="list">
            <tr style="height: 30px">
                <th style="height: 30px;width: 300px" align="center" valign="middle">
                        ${list}
                </th>
            </tr>
        </c:forEach>
    </table>
</div>

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

<script type="text/javascript">
    $("#table").on("click", "th", function () {
        var html = this.innerText;
        window.location.href="${pageContext.request.contextPath}/getzcTrunkFile/"+html;
    })
</script>
</body>
</html>