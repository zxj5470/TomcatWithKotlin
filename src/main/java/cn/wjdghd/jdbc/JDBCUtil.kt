package cn.wjdghd.jdbc

import java.sql.Connection
import java.sql.DriverManager

class JDBCUtil {
    companion object Factory {
        val driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        val dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=ZH"
        val userName = "sa"
        val userPwd = "zxj5470"
        var dbConn: Connection? = null //define a nullable object for connection

        //获取数据库连接
        fun getConn() {
            Class.forName(driverName)
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd)
            System.out.println("连接数据库成功")
        }
        fun closeConn() {
            dbConn!!.close()
        }
    }

}