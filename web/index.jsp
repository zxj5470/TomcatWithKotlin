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

    <script src="./WebContent/js/jquery.min.js"></script>

    <script src="./WebContent/js/bootstrap.js"></script>
    <script src="./WebContent/js/bootstrap-editable.min.js"></script>
    <script src="./WebContent/js/bootstrap-table.js"></script>
    <script src="./WebContent/locale/bootstrap-table-zh-CN.js"></script>

    <script src="./WebContent/zh.js"></script>


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
                <li><a href="#ejb" class="btn btn-default"
                       data-toggle="tab">各种管理</a></li>
                <p></p>
                <li><a href="" class="btn btn-default">各种查询</a></li>
            </ul>

            <HR align="left"><!--------------分隔符--------------->
            <ul class="nav nav-sidebar">
                <li><a href="" class="btn btn-default">各种信息</a></li>
                <p></p>
                <li><a href="" class="btn btn-default">各种内容</a></li>
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
                <table id="studentTable"
                       class="table">
                    <thead>
                    <tr>
                        <th data-field="index"></th>
                        <th data-field="stuId" data-editable="true">学号</th>
                        <th data-field="stuName" data-editable="true">姓名</th>
                        <th data-field="stuSex" data-editable="true">性别</th>
                        <th data-field="stuBirth" data-editable="true">生日</th>
                        <th data-field="stuClass" data-editable="true">班级</th>
                    </tr>
                    </thead>
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

    var $table = $('#studentTable');

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
            striped: true,
            search: true,
            showRefresh: true,
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
                            type: "text"
                        }
                    },
                    {
                        field: "stuId", title: "学号", align: "left", sortable: "true"
                    },
                    {
                        field: "stuSex", title: "性别", align: "left", sortable: "true"
                    },
                    {field: "stuBirth", title: "出生日期", align: "left", sortable: "true"},
                    {field: "stuClass", title: "所属班级", align: "left", sortable: "true"},
                    {
                        field: 'operate',
                        title: 'Item Operate',
                        align: 'center',
                        events: operateEvents,
                        formatter: operateFormatter
                    }

                ]
            ],
            onClickRow: function (row) {
                curRow = row;
                console.log(row);
            }
        };
    }

    window.operateEvents = {
//        'click .edit': function (e, value, row, index) {
//        },
        'click .remove': function (e, value, row, index) {
            var msg=confirm("确认要删除这条记录吗？"+StuInfoToString(row));
            if(msg===true){
                $table.bootstrapTable('remove', {
                    field: 'index',
                    values: [row.index]
                });
                deleteStudent(row);
            }
        }
    };
    function operateFormatter(value, row, index) {
        return [
            '<a class="edit" href="javascript:void(0)" title="Edit">',
            '<i class="glyphicon glyphicon-edit"></i>',
            '</a>&nbsp;&nbsp;',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }

    function todo() {
        var url = 'http://localhost:8080/query?table=tStudent';
        $table.bootstrapTable(setOption(url));
        $table.bootstrapTable('refresh', {
            url: url
        });
    }

    $(window).resize(function () {
        $('#studentTable').bootstrapTable('resetView');
    });

    function StuInfoToString(row){
        var r="\n";
        r+=("\n学号："+row.stuId);
        r+=("\n姓名："+row.stuName);
        r+=("\n性别："+row.stuSex);
        r+=("\n生日："+row.stuBirth);
        r+=("\n班级："+row.stuClass);
        return r;
    }
</script>

</body>
</html>