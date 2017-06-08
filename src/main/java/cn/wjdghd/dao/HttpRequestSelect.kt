package cn.wjdghd.dao

import cn.wjdghd.jdbc.selectFromAll
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun selectTableNameAndResponse(request: HttpServletRequest, response: HttpServletResponse) {
    val tableName = request.getParameter("table")
    response.writer.print(selectFromAll(tableName))
}