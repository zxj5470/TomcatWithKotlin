package cn.wjdghd

import cn.wjdghd.dao.*
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.*

class Main : HttpServlet() {

    @WebServlet("/query")
    class Query : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
            response.setGetHeadersForPage()
            selectTableNameAndResponse(request, response)
        }
    }

    @WebServlet("/insert")
    class Insert : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            response.setPostHeadersForPage()
            insertTableRow(request, response)
        }
    }

    @WebServlet("/update")
    class Update : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            response.setPostHeadersForPage()
            updateTableRow(request,response)
        }
    }

    @WebServlet("/delete")
    class Delete : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            response.setPostHeadersForPage()
            deleteTableRow(request, response)
        }
    }

    @WebServlet("/login")
    class Login : HttpServlet() {
        @Throws(ServletException::class, IOException::class)
        override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
            response.setPostHeadersForPage()
            loginAndResponse(request,response)
        }
    }
}

fun HttpServletResponse.setGetHeadersForPage() {
    this.contentType = "text/html;charset=UTF-8"
    this.setHeader("Access-Control-Allow-Origin", "*")
    this.setHeader("Access-Control-Allow-Methods", "GET")
    this.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type")

}

fun HttpServletResponse.setPostHeadersForPage() {
    this.contentType = "text/html;charset=UTF-8"
    this.setHeader("Access-Control-Allow-Origin", "*")
    this.setHeader("Access-Control-Allow-Methods", "POST")
    this.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type")
}