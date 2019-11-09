<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--<meta http-equiv="refresh" content="1">--%>
    <link type="text/css" href="${pageContext.request.contextPath}/css/myHIgh.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swalCss.css">
    <title>差分迹</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/myJs/sweetalert.min.js"></script>
    <script type="text/css">
        table{border-collapse:collapse;}
        td{width:100px;height:40px;border:1px solid #ccc;}
        tr:first-child td{border:none;}

    </script>
</head>
<body>
<div id="beijing">
    <h3><font size="7px" color="#ffffff">&nbsp;差分迹</font></h3>

    <div id="sub6">
        <input id="subbianyi" class="bianyi" type="submit" name="sub" value="打印" onclick='printDiv()'/>

    </div>
    <div id="subfanhui1">
        <input id="sub" type="submit" name="sub" value="返回" onclick='location.href=("${pageContext.request.contextPath}/dif/Truncated")'/>
    </div>
</div>
<div class="rightTrace">
<div class="solver"></div>
<div class="externalHtml3" style="" id="externalHtml"></div>
</div>
<script type="application/javascript">

    function printDiv()
    {

        var divToPrint=document.getElementById('externalHtml');

        var newWin=window.open('','Print-Window');

        newWin.document.open();

        newWin.document.write('<html><body onload="window.print()">'+divToPrint.innerHTML+'</body></html>');

        newWin.document.close();

        setTimeout(function(){newWin.close();},10);

    }

    function reloadView() {

        $.ajax({
            url: '${pageContext.request.contextPath}/different/getTrace',
            type: 'GET',
            async: true,    //或false,是否异步
            success: function (result) {
                if (result.code == "200") {
                    $('.solver').html("目标解："+result.date.solver);
                    $('.externalHtml3').html(result.date.tableHtml);
                } else if(result.code == "405"){
                    swal("未找到相关解","","error");
                }


            },
            error: function (XMLHttpRequest, txtStatus, errorThrown) {
                //alert(XMLHttpRequest + "<br>" + txtStatus + "<br>" + errorThrown);
            }
        });
    }

    setInterval(reloadView, 1000);

</script>
</body>
</html>