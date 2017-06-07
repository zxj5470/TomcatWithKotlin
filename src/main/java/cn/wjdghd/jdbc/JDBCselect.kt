package cn.wjdghd.jdbc

import cn.wjdghd.entity.CONST
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.sql.Connection

fun selectFromAll(tableName: String): JsonObject {
    JDBCUtil.getConn()
    val statement = (JDBCUtil.dbConn as Connection).createStatement()
    val rs = statement.executeQuery("select * from $tableName")
    val obj = JsonObject()
    val array = JsonArray()
    var statusCode = 0

    val length = rs.metaData.columnCount
    //key=>value {name=>type}
    val columnTypesNamesMap = HashMap<String, String>()
    for (i in 1..length) columnTypesNamesMap[rs.metaData.getColumnName(i)] = rs.metaData.getColumnTypeName(i)
    while (rs.next()) {
        val ob = JsonObject()
        //adapt to each type
        columnTypesNamesMap.map { (k, v) ->
            val getChinese= CONST.get().englishToChinese[k]
            when (v) {
                "text" -> ob.addProperty(getChinese, rs.getString(k))
                "varchar" -> ob.addProperty(getChinese, rs.getString(k))
                "decimal" -> ob.addProperty(getChinese, rs.getBigDecimal(k))
                "smallint" -> ob.addProperty(getChinese, rs.getInt(k))
                "integer" -> ob.addProperty(getChinese, rs.getInt(k))
                "bigint" -> ob.addProperty(getChinese, rs.getLong(k))
                "float" -> ob.addProperty(getChinese, rs.getFloat(k))
                "double" -> ob.addProperty(getChinese, rs.getDouble(k))
            }
        }
        array.add(ob)
    }

    if (array.size() == 0) statusCode = -1
    obj.addProperty("status", statusCode)
    obj.add("results", array)
    println(obj)

    JDBCUtil.closeConn()
    return obj
}
