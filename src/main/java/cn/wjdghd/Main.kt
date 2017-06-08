package cn.wjdghd

import cn.wjdghd.entity.StuSelect
import cn.wjdghd.entity.Student
import cn.wjdghd.jdbc.insertStuSelectInfo
import cn.wjdghd.jdbc.insertStudentInfo
import cn.wjdghd.jdbc.selectFromAll
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Main : HttpServlet() {
    @WebServlet("/query")
    class Query : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
            try {
                response.setHeadersForPage()
                val out = response.writer
                val tableName = request.getParameter("table")
                out.println(selectFromAll(tableName).toString())

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            doGet(request, response)
        }
    }

    @WebServlet("/insert")
    class Insert : HttpServlet() {

        @Throws(ServletException::class, IOException::class)
        override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
            try {
                response.setHeadersForPage()
                val tableName = request.getParameter("table")
                i(request, response, tableName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            doGet(request, response)
        }

        fun i(request: HttpServletRequest, response: HttpServletResponse, tableName: String) {
            when(tableName){
                "tStudent"->{
                    val student: Student
                    val stuId = request.getParameter("stuId") ?: "20000000000"
                    val stuName = request.getParameter("stuName") ?: "null"
                    val stuSex = request.getParameter("stuSex") ?: "中"
                    val stuBirth = request.getParameter("stuBirth") ?: "19700101"
                    val stuClass = request.getParameter("stuClass") ?: "010101"
                    student = Student(stuId, stuName, stuSex, stuBirth, stuClass)
                    insertStudentInfo(student)
                    response.writer.println(student)
                }
                "tStuSelect"->{
                    val stuSelect: StuSelect
                    val stuId = request.getParameter("selStuId") ?: ""
                    val stuName = request.getParameter("selCouId") ?: ""
                    val selStuScoreString = request.getParameter("selStuScore")
                    //  val selStuScore=if(selStuScoreString==null)-1 else selStuScoreString.toInt())
                    val selStuScore= selStuScoreString?.toInt() ?: -1
                    stuSelect = StuSelect(stuId, stuName, selStuScore)
                    insertStuSelectInfo(stuSelect)
                    response.writer.println(stuSelect)
                }
            }
        }

    }
}

fun HttpServletResponse.setHeadersForPage() {
    this.contentType = "text/html;charset=UTF-8"
    this.setHeader("Access-Control-Allow-Origin", "*")
}