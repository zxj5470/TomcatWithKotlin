package cn.wjdghd.dao

import cn.wjdghd.jdbc.selectFromAll
import cn.wjdghd.jdbc.selectLogin
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun selectTableNameAndResponse(request: HttpServletRequest, response: HttpServletResponse) {
    val tableName = request.getParameter("table")
    response.writer.print(selectFromAll(tableName))
}

fun loginAndResponse(request: HttpServletRequest, response: HttpServletResponse) {
    val user = request.getParameter("user")
    val pswd = request.getParameter("pswd")
    val result = selectLogin(user, pswd)
    if(result!="failed"){
        response.sendRedirect("index.jsp?id=$user")
    }else{
        response.writer.print("failed")
    }
}