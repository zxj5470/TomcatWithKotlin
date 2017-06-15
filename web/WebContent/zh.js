var obj;
var isEditing = false;
var curRow;
/** @namespace row.stuName */
/** @namespace row.stuSex */
/** @namespace row.stuBirth */
/** @namespace row.stuClass*/
/** @return {string}
 */
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

function updateStudent(row, oldID) {
    $.ajax({
        type: 'POST',
        url: '/update',
        data: {
            table: 'tStudent',
            stuId: row.stuId,
            stuName: row.stuName,
            stuSex:row.stuSex,
            stuBirth:row.stuBirth,
            stuClass:row.stuClass,
            ID:oldID
        },
        success: function (r) {
            console.log(r);
        }
    });
}

function insertStudent(row) {
    console.log(row);
    $.ajax({
        type: 'POST',
        url: '/insert',
        data: {
            table: 'tStudent',
            stuId: row.stuId,
            stuName: row.stuName,
            stuSex:row.stuSex,
            stuBirth:row.stuBirth,
            stuClass:row.stuClass
        },
        success: function (r) {
            console.log(r);
        }
    });
}
function on(value, self) {
    console.log(value);
    console.log(curRow);
    var i = (self.getAttribute("i"));
    obj[i][curRow] = value;
    if (curRow === "stuBirth") {
        if (value.length > 8) {
            self.value = value.substr(0, 8);
            alert("请保证输入格式为 yyyyMMdd \n例如：19960101");
        }
    }
}

function simpleNameFormatter(value, index) {
    var i = index.index - 1;
    if (isEditing)
        return '<input type="text" class="form-control input-sm" i="' + i + '" value="' + value + '"' + ' oninput="on(value,this)">';
    else return value;
}
function simpleNumberFormatter(value, index) {
    var i = index.index - 1;
    if (isEditing)
        return '<input type="number" class="form-control input-sm" i="' + i + '" value="' + value + '"' + ' oninput="on(value,this)">';
    else return value;
}

function isSelectedMan(value) {
    if (value === "男")return 'selected="selected"';
    else return "";
}
function isSelectedWoman(value) {
    if (value === "女")return 'selected="selected"';
    else return "";
}

function sexFormatter(value, index) {
    var i = index.index - 1;
    if (isEditing)
        return '<select class="form-control selection-handle" i="' + i + '" onchange="on(value,this)">' +
            '<option value="男"' + isSelectedMan(value) + '>男</option>' +
            '<option value="女"' + isSelectedWoman(value) + '>女</option>' +
            '</select>';
    else return value;
}

// function sendObject(obj, table, oldID) {
//     for (var i in obj) {
//         obj[i].table = table;
//         obj[i].ID = oldID;
//         $.ajax({
//             url: '/update',
//             method: 'POST',
//             data: obj[i],
//             success: function (data) {
//                 console.log(data);
//             }
//         });
//     }
//
// }