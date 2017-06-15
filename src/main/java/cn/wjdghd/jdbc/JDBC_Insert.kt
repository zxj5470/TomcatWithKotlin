package cn.wjdghd.jdbc

import cn.wjdghd.entity.*
import java.sql.Connection

fun insertCourseInfo(course: Course): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tCourse VALUES('${course.couId}','${course.couName}','${course.couScore}','${course.couTime}','${course.couCurNum}','${course.couMaxNum}')"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    println(sql)
    return rs
}

fun insertFacultyInfo(faculty: Faculty): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tFaculty VALUES('${faculty.facId}','${faculty.facName}',${faculty.facTel}','${faculty.facBoss}')"
    val rs = statement.execute(sql)
    println(sql)
    JDBCUtil.closeConn()
    return rs
}

fun insertStudentInfo(student: Student): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tStudent VALUES('${student.stuId}','${student.stuName}','${student.stuSex}','${student.stuBirth}','${student.stuClass}')"
    println(sql)
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}


fun insertStuSelectInfo(selectTable: StuSelect): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tStuSelect VALUES('${selectTable.selStuId}','${selectTable.selCouId}','${selectTable.selStuScore}')"
    println(sql)
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun insertTeacherInfo(teacher: Teacher): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tFaculty VALUES('${teacher.teaId}','${teacher.teaName}',${teacher.teaLevel}','${teacher.teaTel}')"
    println(sql)
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun insertTeaSelectInfo(teachSelect: TeachSelect):Boolean{
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql="INSERT INTO tFaculty VALUES('${teachSelect.teaCouId}','${teachSelect.teaCouId}')"
    println(sql)
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}