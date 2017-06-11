package cn.wjdghd

import cn.wjdghd.entity.Teacher
import cn.wjdghd.jdbc.updateTeacherInfo

//1110001	软工教师1	系主任	13011110001

fun main(args: Array<String>) {
//    deleteStudent("20151001295")
    val teacher=Teacher("1110001","软工教师233","系主任","13011111001")
    updateTeacherInfo(teacher,"1110001")
}