package cn.wjdghd.jdbc

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
//            val getChinese= CONST.get().englishToChinese[k]
            when (v) {
                "text" -> ob.addProperty(k, rs.getString(k))
                "varchar" -> ob.addProperty(k, rs.getString(k))
                "decimal" -> ob.addProperty(k, rs.getBigDecimal(k))
                "smallint" -> ob.addProperty(k, rs.getInt(k))
                "integer" -> ob.addProperty(k, rs.getInt(k))
                "bigint" -> ob.addProperty(k, rs.getLong(k))
                "float" -> ob.addProperty(k, rs.getFloat(k))
                "double" -> ob.addProperty(k, rs.getDouble(k))
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
