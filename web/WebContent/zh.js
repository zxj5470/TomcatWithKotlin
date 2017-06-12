var isEditing = false;

function StuInfoToString(row) {
    var r = "\n";
    r += ("\n姓名：" + row.stuName);
    r += ("\n学号：" + row.stuId);
    r += ("\n性别：" + row.stuSex);
    r += ("\n生日：" + row.stuBirth);
    r += ("\n班级：" + row.stuClass);
    return r;
}

function deleteStudent(row) {
    $.ajax({
        type: 'POST',
        url: '/delete',
        data: {table: 'tStudent', stuId: row.stuId},
        success: function (r) {
            console.log(r);
        }
    });
}

function on() {
    console.log(this.value);
}

function simpleTextFormatter(value, row, index) {
    if (isEditing)
        return '<input type="text" name="" class="form-control input-sm" value="'+value+'"'+' onchange="on()">';
    else return value;
}

