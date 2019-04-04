<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="${pageContext.request.contextPath}/css/myHIgh.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swalCss.css">
    <title>工作空间</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/myJs/sweetalert.min.js"></script>
    <script type="text/css">
        table{width:1500px;margin:0px auto;}
        tr{width:1200px;height:150px;list-style-type:none;}
        td{border:1px solid #000;font-size:12px;font-family:"微软雅黑";line-hegiht:30px; align:center}
        /*修正1 设置垂直对齐为居中*/
        th>span,th>img {

            vertical-align: middle;

        }
    </script>
</head>
<body>
<div id="beijing">
    <h3><font size="7px" color="#ffffff">&nbsp;工作空间</font></h3>
    <div id="sub6">
        <input type="submit" value="删除文件" class="bianyi" id="removeFile">
    </div>
    <div id="subfanhui1">
        <input id="sub" type="submit" name="sub" value="返回" onclick='location.href=("${pageContext.request.contextPath}/liner")'/>
    </div>
</div>

<div class= "externalHtml"></div>
<% String txt = request.getAttribute("html")+"";
    System.out.println(txt);
%>
<script type="application/javascript">
    function reloadView(){

        $.ajax({
            url:'${pageContext.request.contextPath}/linerTrunkDir',
            type:'GET',
            async:true,    //或false,是否异步
            success:function(result){
                $('.externalHtml').html(result);


            },
            error: function (XMLHttpRequest, txtStatus, errorThrown)
            {
                //alert(XMLHttpRequest + "<br>" + txtStatus + "<br>" + errorThrown);
            }
        });
    }
    setInterval(reloadView(),10);

</script>
<script type="text/javascript">

    var LOGIN = {
        checkInput:function() {
            alert(2)
            var flag = false;
            swal("请输入用户名"," ","error");
            swal({
                    title: "确认删除?",
                    text: "Your will not be able to recover this imaginary file!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确认",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    closeOnCancel: false
                },
                function(isConfirm){
                    if (isConfirm) {
                        alert(3)
                        flag = true;
                    }
                });
            alert(4);
            return flag;
        },

        doLogin:function() {
            $.get("/removeLinerTrunkSol",function(data){

            });
        },
        login:function() {
            $.get("${pageContext.request.contextPath}/removeLinerTrunkSol",function(data){
                if(data=="无可删除文件"){

                    swal("无可删除文件"," ","error");
                }else{

                    location.reload(true);
                }

            });
        }

    };
    $(function(){
        $("#removeFile").click(function(){
            LOGIN.login();
        });
    });
</script>
</body>
</html>