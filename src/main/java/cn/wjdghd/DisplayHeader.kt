package cn.wjdghd

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/DisplayHeader")
class DisplayHeader : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        try {
            response.contentType = "text/html;charset=UTF-8"
            val out = response.writer
            val title = "HTTP Header 请求实例 - 菜鸟教程实例"
            val docType = "<!DOCTYPE html> \n"
            out.println(docType +
                    "<html>\n" +
                    "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                    "<tr bgcolor=\"#949494\">\n" +
                    "<th>Header 名称</th><th>Header 值</th>\n" +
                    "</tr>\n")
            val headerNames = request.headerNames
            while (headerNames.hasMoreElements()) {
                val paramName = headerNames.nextElement()
                out.print("<tr><td>$paramName</td>\n")
                val paramValue = request.getHeader(paramName)
                out.println("<td> $paramValue</td></tr>\n")
            }
            out.println("</table>\n</body></html>")
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }
}