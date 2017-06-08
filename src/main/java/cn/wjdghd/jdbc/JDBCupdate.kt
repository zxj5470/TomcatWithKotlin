package cn.wjdghd.jdbc

import cn.wjdghd.entity.*
import java.sql.Connection
//UPDATE Websites SET alexa='5000', country='USA' WHERE name='菜鸟教程'
fun updateCourseInfo(course: Course): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute("INSERT INTO tCourse VALUES('${course.couId}','${course.couName}','${course.couScore}','${course.couTime}','${course.couCurNum}','${course.couMaxNum}')")
    JDBCUtil.closeConn()
    return rs
}

fun updateFacultyInfo(faculty: Faculty): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${faculty.facId}','${faculty.facName}',${faculty.facTel}','${faculty.facBoss}')")
    JDBCUtil.closeConn()
    return rs
}

fun updateStudentInfo(student: Student): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${student.stuId}','${student.stuName}',${student.stuSex}','${student.stuBirth}','${student.stuClass}')")
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

fun updateTeaSelectInfo(teachTable: TeachTable):Boolean{
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.execute(
            "INSERT INTO tFaculty VALUES('${teachTable.teaCouId}','${teachTable.teaCouId}')")
    JDBCUtil.closeConn()
    return rs
}