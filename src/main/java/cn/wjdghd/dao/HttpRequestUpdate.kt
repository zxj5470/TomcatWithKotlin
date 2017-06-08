package cn.wjdghd.dao

import cn.wjdghd.entity.*
import cn.wjdghd.jdbc.*

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun updateTableRow(request: HttpServletRequest, response: HttpServletResponse) {
    val tableName = request.getParameter("table")
    val ID=request.getParameter("ID") as String? ?: ""
    when (tableName) {
        "tCourse" -> {
            val couId = request.getParameter("couId") as String? ?: ""
            val couName = request.getParameter("couName") as String? ?: ""
            val couScore = request.getParameter("couScore") as Double? ?: 0.0
            val couTime = request.getParameter("couTime") as String? ?: ""
            val couMaxNum = request.getParameter("couMaxNum") as Int? ?: 0
            val couCurNum = request.getParameter("couCurNum") as Int? ?: 0

            val course = Course(couId, couName, couScore, couTime, couMaxNum, couCurNum)
            updateCourseInfo(course,ID)
            response.writer.println(course)
        }
        "tFaculty" -> {
            val facId = request.getParameter("facId") as String? ?: ""
            val facName = request.getParameter("facName") as String? ?: ""
            val facTel = request.getParameter("facTel") as String? ?: ""
            val facBoss = request.getParameter("facBoss") as String? ?: ""

            val faculty = Faculty(facId, facName, facTel, facBoss)
            updateFacultyInfo(faculty,ID)
            response.writer.println(faculty)
        }
        "tStudent" -> {
            val stuId = request.getParameter("stuId") as String? ?: "20000000000"
            val stuName = request.getParameter("stuName") as String? ?: "null"
            val stuSex = request.getParameter("stuSex") as String? ?: "男"
            val stuBirth = request.getParameter("stuBirth") as String? ?: "19700101"
            val stuClass = request.getParameter("stuClass") as String? ?: "010101"

            val student = Student(stuId, stuName, stuSex, stuBirth, stuClass)
            updateStudentInfo(student,ID)

            response.writer.println(student)
        }
        "tStuSelect" -> {
            val stuId = request.getParameter("selStuId") as String? ?: ""
            val stuName = request.getParameter("selCouId") as String? ?: ""
            val selStuScore = request.getParameter("selStuScore") as Int? ?: -1

            val stuSelect = StuSelect(stuId, stuName, selStuScore)
            updateStuSelectInfo(stuSelect)

            response.writer.println(stuSelect)
        }
        "tTeacher" -> {
            val teaId = request.getParameter("teaId") as String? ?: ""
            val teaName = request.getParameter("teaName") as String? ?: ""
            val teaLevel = request.getParameter("teaLevel") as String? ?: ""
            val teaTel = request.getParameter("teaTel") as String? ?: ""

            val teacher = Teacher(teaId, teaName, teaLevel, teaTel)
            updateTeacherInfo(teacher)
            response.writer.println(teacher)
        }
        "tTeaSelect" -> {
            val teaTeaId = request.getParameter("teaTeaId") as String? ?: ""
            val teaCouId = request.getParameter("teaCouId") as String? ?: ""

            val teaTeach = TeachSelect(teaTeaId, teaCouId)
            updateTeaSelectInfo(teaTeach)
            response.writer.println(teaTeach)
        }
    }
    response.writer.println("OK")
}