package cn.wjdghd.dao

import cn.wjdghd.jdbc.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun deleteTableRow(request: HttpServletRequest, response: HttpServletResponse) {
    val tableName = request.getParameter("table")
    when (tableName) {
        "tCourse" -> {
            val couId = request.getParameter("couId") as String? ?: ""
            val result = deleteCourse(couId)
            response.writer.println(result)
        }
        "tFaculty" -> {
            val facId = request.getParameter("facId") as String? ?: ""
            val result = deleteFaculty(facId)
            response.writer.println(result)
        }
        "tStudent" -> {
            val stuId = request.getParameter("stuId") as String? ?: ""
            val result = deleteStudent(stuId)
            response.writer.println(result)
        }
        "tStuSelect" -> {
            val selStuId = request.getParameter("selStuId") as String? ?: ""
            val selCouId = request.getParameter("selCouId") as String? ?: ""
            val result = deleteStuSelect(selStuId, selCouId)
            response.writer.println(result)
        }
        "tTeacher" -> {
            val teaId = request.getParameter("teaId") as String? ?: ""
            val result = deleteTeacher(teaId)
            response.writer.println(result)
        }
        "tTeaSelect" -> {
            val teaTeaId = request.getParameter("teaTeaId") as String? ?: ""
            val teaCouId = request.getParameter("teaCouId") as String? ?: ""
            val result = deleteTeaSelect(teaTeaId, teaCouId)
            response.writer.println(result)
        }
    }
    response.writer.println("OK")
}
