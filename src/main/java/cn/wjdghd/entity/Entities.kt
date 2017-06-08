package cn.wjdghd.entity

data class Student(var stuId: String,
                   var stuName: String,
                   var stuSex: String,
                   var stuBirth: String,
                   var stuClass: String)

data class Teacher(var teaId: String,
                   var teaName: String,
                   var teaLevel: String,
                   var teaTel: String)

data class Course(var couId: String,
                  var couName: String,
                  var couScore: Double,
                  var couTime: String,
                  var couCurNum: Int,
                  var couMaxNum: Int)

data class Faculty(var facId: String,
                   var facName: String,
                   var facTel: String,
                   var facBoss: String)

data class StuSelect(var selStuId: String,
                       var selCouId: String,
                       var selStuScore: Int)

data class TeachSelect(var teaTeaId: String,
                       var teaCouId: String)