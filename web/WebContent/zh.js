var isEditing = false;
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

function on(value,self) {
    console.log(value);
    console.log(curRow);
    var i=(self.getAttribute("i"));
    obj[i][curRow]=value;
}

function simpleTextFormatter(value, index) {
    if (isEditing)
        return '<input type="text" name="" class="form-control input-sm" i="'+index+'" value="' + value + '"' + ' oninput="on(value,this)">';
    else return value;
}

function sendObject(obj,table,oldID) {
    for(var i in obj){
        obj[i].table=table;
        obj[i].ID=oldID;
        $.ajax({
            url: '/update',
            method: 'POST',
            data: obj[i],
            success: function (data) {
                console.log(data);
            }
        });
    }

}