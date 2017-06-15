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
    <link rel="stylesheet" href="./WebContent/css/bootstrap.min.css">
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
                <li><a href="login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<br/>
<p></p>
<div class="container-fluid">
    <div class="row"><br/>
        <div class="col-sm-2 col-md-2 sidebar">
            <ul class="nav nav-sidebar"><p></p>
                <li><a href="#student" class="btn btn-default" data-toggle="tab" onclick="todo()">学生管理</a></li>
                <p></p>
                <p></p>
                <li><a href="#teacher" class="btn btn-default" data-toggle="tab">教师管理</a>
                </li>
            </ul>
            <HR align="left"><!--------------分隔符--------------->

            <ul class="nav nav-sidebar">
                <li><a href="#stuSelect" class="btn btn-default"
                       data-toggle="tab">选课情况查询</a></li>
                <p></p>
                <li><a href="" class="btn btn-default">教师授课查询</a></li>
            </ul>

            <HR align="left"><!--------------分隔符--------------->
            <ul class="nav nav-sidebar">
                <li><a href="#cj" class="btn btn-default">成绩查询</a></li>
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
                </table>
            </div>
            <div class="panel panel-default fade" id="teacher">
                <div class="panel-heading"><strong>教师信息管理</strong></div>
                <table id="teacherTable" class="table">
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
    var oldID;
    var thisTable;
    thisTable = "tStudent";
    var $stutable = $('#studentTable');
    var $teatable = $('#teacherTable');
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

    function setStuTableOption(ob) {
        return {
            data: ob,
            editable: true,
            clickToSelect: true,
            cache: false,
            striped: true,
            search: true,
            smartDisplay: true,
            columns: [
                [
                    {
                        field: "index",
                        title: "序号",
                        align: "center",
                        formatter: function (value, row, index) {
                            return row.index = index + 1;
                        }
                    },
                    {
                        field: "stuName",
                        title: "姓名",
                        align: "center",
                        order: "asc",
                        sortable: "true",
                        formatter: simpleNameFormatter
                    },
                    {
                        field: "stuId", title: "学号", align: "center", sortable: "true", formatter: simpleNumberFormatter
                    },
                    {
                        field: "stuSex", title: "性别", align: "center", sortable: "true", formatter: sexFormatter
                    },
                    {
                        field: "stuBirth",
                        title: "出生日期",
                        align: "center",
                        sortable: "true",
                        formatter: simpleNumberFormatter
                    },
                    {
                        field: "stuClass",
                        title: "所属班级",
                        align: "center",
                        sortable: "true",
                        formatter: simpleNumberFormatter
                    },
                    {
                        field: 'operate',
                        title: '工具栏',
                        align: 'center',
                        events: operateEvents,
                        formatter: operateFormatter
                    }
                ]
            ],
            onClickRow: function (field, value, row, $element) {
                curRow = row;
            }
        };
    }

    function setTeaTableOption(ob) {
        return {
            data: ob,
            editable: true,
            clickToSelect: true,
            cache: false,
            striped: true,
            search: true,
            smartDisplay: true,
            columns: [
                [
                    {
                        field: "index",
                        title: "序号",
                        align: "center",
                        formatter: function (value, row, index) {
                            return row.index = index + 1;
                        }
                    },
                    {
                        field: "stuName",
                        title: "姓名",
                        align: "center",
                        order: "asc",
                        sortable: "true",
                        formatter: simpleNameFormatter
                    },
                    {
                        field: "stuId", title: "学号", align: "center", sortable: "true", formatter: simpleNumberFormatter
                    },
                    {
                        field: "stuSex", title: "性别", align: "center", sortable: "true", formatter: sexFormatter
                    },
                    {
                        field: "stuBirth",
                        title: "出生日期",
                        align: "center",
                        sortable: "true",
                        formatter: simpleNumberFormatter
                    },
                    {
                        field: "stuClass",
                        title: "所属班级",
                        align: "center",
                        sortable: "true",
                        formatter: simpleNumberFormatter
                    },
                    {
                        field: 'operate',
                        title: '工具栏',
                        align: 'center',
                        events: operateEvents,
                        formatter: operateFormatter
                    }
                ]
            ],
            onClickRow: function (field, value, row, $element) {
                curRow = row;
            }
        };
    }

    window.operateEvents = {
        'click .edit': function (e, value, row, index) {
            console.log(row);
            console.log(index);
            if (isEditing) {
                isEditing = !isEditing;
                var msg = confirm("请确认是否保存数据\n" + StuInfoToString(row));
                if (msg === true) {
                    updateStudent(obj[index], oldID);
                }
            } else {
                isEditing = !isEditing;
                curRow = row;
                oldID = row.stuId;
            }
            $stutable.bootstrapTable('refresh');
            $stutable.bootstrapTable(setStuTableOption(obj));
            $stutable.bootstrapTable('load', obj);
        },
        'click .remove': function (e, value, row, index) {
            var msg = confirm("确认要删除这条记录吗？\n请注意数据库中也会将该条内容删除……" + StuInfoToString(row));
            if (msg === true) {
                $stutable.bootstrapTable('remove', {
                    field: 'index',
                    values: [row.index]
                });
                deleteStudent(row);
            }
        }
    };

    function addRow(insertIndex, rowObj) {
        console.log(rowObj.stuName);
        if (isEditing) {
            isEditing = false;
            insertStudent(rowObj);
        } else {
            isEditing = true;
            var insertR = rowObj;
            $.each(insertR, function (name) {
                insertR[name] = '';
            });
            var params = {index: insertIndex + 1, row: insertR};
            $stutable.bootstrapTable('insertRow', params);
        }
        $stutable.bootstrapTable('refresh');
        $stutable.bootstrapTable(setStuTableOption(obj));
        $stutable.bootstrapTable('load', obj);
    }

    function operateFormatter(value, row, index) {
        return [
            "<a class=\"add\" href='javascript:addRow(" + index + ", " + JSON.stringify(row) + ")' title=\"添加\">",
            '<em class="glyphicon glyphicon-plus"></em>',
            '</a>&nbsp;&nbsp;',
            '<a class="edit" href="javascript:void(0)" title="编辑">',
            '<em class="glyphicon glyphicon-edit"></em>',
            '</a>&nbsp;&nbsp;',
            '<a class="remove" href="javascript:void(0)" title="删除">',
            '<em class="glyphicon glyphicon-remove"></em>',
            '</a>'
        ].join('');
    }

    $('input').on('keyDown', function (e) {
        console.log(e);
    });

    function todo() {
        $.ajax({
            url: '/query',
            data: {table: 'tStudent'},
            success: function (data) {
                obj = (JSON.parse(data)).results;
                $stutable.bootstrapTable(setStuTableOption(obj));
                $stutable.bootstrapTable('load', obj);
            }
        });
    }

    $(window).resize(function () {
        $('#studentTable').bootstrapTable('resetView');
    });

</script>

</body>
</html>