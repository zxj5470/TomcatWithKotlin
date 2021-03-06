package cn.wjdghd.jdbc

import cn.wjdghd.entity.*
import java.sql.Connection

//UPDATE tablename SET COL0001='5000', COL0002='USA' WHERE COL0001='sample'
fun updateCourseInfo(c: Course, ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tCourse SET " +
            "couId='${c.couId}',couName='${c.couName}'," +
            "couScore='${c.couScore}',couTime='${c.couTime}'," +
            "couCurNum='${c.couCurNum}',couMaxNum='${c.couMaxNum}' " +
            "WHERE couId='$ID'"
    val rs = statement.execute(sql)
    println(sql)
    return rs
}

fun updateFacultyInfo(faculty: Faculty, ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tFaculty SET " +
            "facId='${faculty.facId}',facName='${faculty.facName}'," +
            "facTel='${faculty.facTel}',facBoss='${faculty.facBoss}'" +
            "WHERE facId='$ID'"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}

fun updateStudentInfo(student: Student, ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tStudent SET " +
            "stuId='${student.stuId}',stuName='${student.stuName}'," +
            "stuSex='${student.stuSex}',stuBirth='${student.stuBirth}'," +
            "stuClass='${student.stuClass}'" +
            "WHERE stuId='$ID'"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}

fun updateStuSelectInfo(selectTable: StuSelect, oldSelStuId: String, oldSelCouId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tStuSelect SET " +
            "selStuId='${selectTable.selStuId}'," +
            "selCouId='${selectTable.selCouId}'," +
            "selStuScore='${selectTable.selStuScore}'" +
            "WHERE selStuId='$oldSelStuId' AND selCouId='$oldSelCouId'"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}

/**
 * @param teacher teacherInfo
 * @param ID old teacherId
 */
fun updateTeacherInfo(teacher: Teacher,ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="UPDATE tTeacher SET " +
            "teaId='${teacher.teaId}'," +
            "teaName='${teacher.teaName}'," +
            "teaLevel='${teacher.teaLevel}'," +
            "teaTel='${teacher.teaTel}'" +
            "WHERE teaId='$ID'"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}

fun updateTeaSelectInfo(teachSelect: TeachSelect,oldTeaTeaId: String,oldTeaCouId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="UPDATE tTeaSelect SET " +
            "teaTeaId='${teachSelect.teaTeaId}'," +
            "teaCouId='${teachSelect.teaCouId}'" +
            "WHERE teaTeaId='$oldTeaTeaId' AND teaCouId='$oldTeaCouId')"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}