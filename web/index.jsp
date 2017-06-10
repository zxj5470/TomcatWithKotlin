<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="http://www.cnblogs.com/favicon.ico" rel="shortcut icon">
    <meta charset="UTF-8">
    <title>学校选课数据库管理系统</title>
    <link rel="stylesheet" href="./WebContent/css/bootstrap.min.css">
    <link rel="stylesheet" href="./WebContent/css/bootstrap-table.css">
    <link rel="stylesheet" href="./WebContent/css/bootstrap-editable.css">
    <link rel="stylesheet" href="./WebContent/extensions/click-edit-row/bootstrap-table-click-edit-row.css">

    <script src="./WebContent/js/jquery.min.js"></script>
    <script src="./WebContent/js/bootstrap.js"></script>
    <script src="./WebContent/js/bootstrap-table.js"></script>
    <script src="./WebContent/locale/bootstrap-table-zh-CN.js"></script>
    <script src="./WebContent/js/bootstrap-editable.min.js"></script>
    <script src="./WebContent/extensions/click-edit-row/bootstrap-table-click-edit-row.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#Main" data-toggle="tab">学生课程管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">选项</a></li>
                <li><a href="#">关于</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<br/>
<div class="container-fluid">
    <div class="row"><br/>
        <div class="col-sm-2 col-md-2 sidebar">
            <ul class="nav nav-sidebar"></br>
                <li><a href="#student" class="btn btn-default" data-toggle="tab" onclick="todo()">学生管理</a></li>
                <p></p>
                <p></p>
                <li><a href="#teacher" class="btn btn-default" data-toggle="tab">教师管理</a>
                </li>
            </ul>
            <HR align="left"><!--------------分隔符--------------->

            <ul class="nav nav-sidebar">
                <li><a href="#ejb" class="btn btn-default" data-toggle="tab">Another nav item</a></li>
                <p></p>
                <li><a href="" class="btn btn-default">More navigation</a></li>
            </ul>

            <HR align="left"><!--------------分隔符--------------->
            <ul class="nav nav-sidebar">
                <li><a href="" class="btn btn-default">One more nav</a></li>
                <p></p>
                <li><a href="" class="btn btn-default">Another nav item</a></li>
            </ul>
        </div>

        <div id="myTabContent" class="col-sm-10 col-md-10 tab-content">
            <a href=""></a><br/><a href=""></a><br/>
            <div class="tab-pane in active center-block text-primary" id="Main">
                <h1 align="center">欢迎来到学生管理系统~</h1><br><br><br><br>
                <blockquote class="pull-right bottom" id="quote">
                    <small><cite title="Source Title" id="sourceTitle"></cite></small>
                </blockquote>
            </div>
            <div class="tab-pane fade panel-default" id="student">
                <div class="panel-heading"><strong>学生信息管理</strong></div>
                <table id="studentTable" class="table" data-click-edit="true">
                    <thead id="studentTableHead">
                    <tr>
                        <td data-field="stuName" data-editable="input"></td>
                    </tr>
                    </thead>
                    <tbody id="studentTableBody">
                    </tbody>
                </table>
            </div>
            <div class="panel panel-default fade" id="teacher">
                <div class="panel-heading"><strong>教师信息管理</strong></div>
                <table id="teacherTable" class="table" data-click-edit="true">
                    <thead id="teacherTableHead"></thead>
                    <tbody id="teacherTableBody"></tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="Export">
            </div>
            <div class="tab-pane fade" id="ejb">
            </div>
        </div>
    </div>
</div>
<script>
    var curRow = {};
    $(function () {
        $.ajax({
            url: 'gou.json',
            success: function (v) {
                var l = v.length;
                var index = (Math.random() * l).toFixed(0);
                console.log(v[index]);
                for (k in v[index]) {
                    $('#quote').text(k);
                    $('#sourceTitle').text(v[index][k]);
                }
            }
        });
    });
    function setOption(ob) {
        return {
            url: ob,
            editable: true,
            clickToSelect: true,
            cache: false,
            pageList: [10, 25, 50, 100],
            pageSize: 10,
            pageNumber: 1,
            uniqueId: 'index',
            striped: true,
            search: true,
            showRefresh: true,
            minimumCountColumns: 2,
            smartDisplay: true,
            columns: [
                [
                    {
                        field: "index",
                        title: "序号",
                        align: "left",
                        formatter: function (value, row, index) {
                            return row.index = index + 1;
                        }
                    },
                    {
                        field: "stuName",
                        title: "姓名",
                        align: "left",
                        order: "asc",
                        sortable: "true",
                        editable: {
                            type: 'text',
                            title: '姓名',
                            validate: function (v) {
                            }
                        }
                    },
                    {
                        field: "stuId", title: "学号", align: "left", sortable: "true"
                    },
                    {field: "stuSex", title: "性别", align: "left", sortable: "true",
                        editable: {
                        type: 'select',
                        title: 'Sex',
                        validate: function (v) {
                            console.log(v);
                        }
                    }},
                    {field: "stuBirth", title: "出生日期", align: "left", sortable: "true"},
                    {field: "stuClass", title: "所属班级", align: "left", sortable: "true"}
                ]
            ],
            onClickRow: function (row) {
                curRow = row;
                console.log(row);
            }
        };
    }
    function todo() {
        var url = 'http://localhost:8080/query?table=tStudent';
        $('#studentTable').bootstrapTable(setOption(url));
        $('#studentTable').bootstrapTable('refresh', {
            url: url
        });
    }
    $(window).resize(function () {
        $('#studentTable').bootstrapTable('resetView');
    });
</script>
</body>
</html>