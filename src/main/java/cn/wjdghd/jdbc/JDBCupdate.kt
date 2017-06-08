package cn.wjdghd.jdbc

import cn.wjdghd.entity.*
import java.sql.Connection

//UPDATE Websites SET alexa='5000', country='USA' WHERE name='菜鸟教程'
fun updateCourseInfo(c: Course, ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tCourse SET " +
            "couId='${c.couId}',couName='${c.couName}'," +
            "couScore='${c.couScore}',couTime='${c.couTime}'," +
            "couCurNum='${c.couCurNum}',couMaxNum='${c.couMaxNum}' " +
            "WHERE ID='$ID'"
    val rs = statement.execute(sql)
    return rs
}

fun updateFacultyInfo(faculty: Faculty, ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "UPDATE tFaculty SET " +
            "facId='${faculty.facId}',facName='${faculty.facName}'," +
            "facTel='${faculty.facTel}',facBoss='${faculty.facBoss}'" +
            "WHERE ID='$ID'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun updateStudentInfo(student: Student,ID: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "INSERT INTO tStudent SET" +
            "stuId='${student.stuId}',stuName='${student.stuName}'," +
            "stuSex='${student.stuSex}',stuBirth='${student.stuBirth}'," +
            "stuClass='${student.stuClass}'" +
            "WHERE ID='$ID'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}


fun updateStuSelectInfo(selectTable: StuSelect): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${selectTable.selStuId}','${selectTable.selCouId}',${selectTable.selStuScore}')")
    JDBCUtil.closeConn()
    return rs
}

fun updateTeacherInfo(teacher: Teacher): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${teacher.teaId}','${teacher.teaName}',${teacher.teaLevel}','${teacher.teaTel}')")
    JDBCUtil.closeConn()
    return rs
}

fun updateTeaSelectInfo(teachSelect: TeachSelect): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${teachSelect.teaCouId}','${teachSelect.teaCouId}')")
    JDBCUtil.closeConn()
    return rs
}