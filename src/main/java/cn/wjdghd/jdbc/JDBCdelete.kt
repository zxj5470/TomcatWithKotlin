package cn.wjdghd.jdbc

import java.sql.Connection

fun deleteCourse(couId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tCourse WHERE couId='$couId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun deleteFaculty(facId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tFaculty WHERE facId='$facId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun deleteStudent(stuId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tStudent WHERE stuId='$stuId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun deleteStuSelect(selStuId: String, selCouId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tStuSelect WHERE selStuId='$selStuId' and selCouId='$selCouId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun deleteTeacher(teaId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tTeacher WHERE teaId='$teaId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}

fun deleteTeaSelect(teaTeaId: String, teaCouId: String): Boolean {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val sql = "DELETE FROM tTeaSelect WHERE teaTeaId='$teaTeaId' and teaCouId='teaCouId'"
    val rs = statement.execute(sql)
    JDBCUtil.closeConn()
    return rs
}
