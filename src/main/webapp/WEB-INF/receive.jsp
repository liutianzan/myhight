<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>receive</title>
</head>
<body>
<div id="show" style="overflow:auto; height: 200px; width: 700px; border: 1px solid #797979;"></div>

<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/amq_jquery_adapter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/amq.js"></script>
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
    showInfo("start");
    var amq = org.activemq.Amq;
    amq.init({
        uri: 'amq',
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
    var destination = "channel://qwewq";
    amq.addListener(1,destination,myHandler.rcvMessage);
    showInfo("listening");
</script>
</body>
</html>