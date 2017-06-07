package cn.wjdghd

import cn.wjdghd.jdbc.selectFromAll
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Main : HttpServlet(){
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
}

fun HttpServletResponse.setHeadersForPage() {
    this.contentType = "text/html;charset=UTF-8"
    this.setHeader("Access-Control-Allow-Origin", "*")
}