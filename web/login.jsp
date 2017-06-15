<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生系统登陆界面</title>
    <link rel="stylesheet" href="./WebContent/css/loginPage.css">
    <link rel="stylesheet" href="./WebContent/css/bootstrap.min.css">
    <script src="./WebContent/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <%--<img src="img/bg.jpg" style="opacity: 0.01">--%>
        <div class="col-md-offset-3 col-md-6 pull-right">
            <form class="form-horizontal pull-right" id="mainForm" method="post" onsubmit="return sub()">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputForm" placeholder="用户名">
                    <i class="glyphicon glyphicon-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="inputPassword" placeholder="密　码">
                    <i class="glyphicon glyphicon-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group pull-right">
                    <button class="btn btn-default" onclick="l()">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function sub() {
        return false;
    }
    function l() {
        var user = ($('#inputForm').val());
        var pswd = ($('#inputPassword').val());
        console.log(user);
        $.ajax({
            url: "/login",
            method: "POST",
            data: {user: user, pswd: pswd},
            success:function (data) {
                console.log(data);
                if(data!=="failed")
                    window.location.href="index.jsp";
                else {
                    alert("密码错误……")
                }
            }
        });
        return false;
    }
</script>
</body>
</html>
