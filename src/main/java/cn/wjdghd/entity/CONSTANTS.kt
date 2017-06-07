package cn.wjdghd.entity
//单例模式
class CONST private constructor(){
    val englishToChinese=HashMap<String,String>()
    init {
        englishToChinese["couId"]="课程号"
        englishToChinese["couName"]="课程名称"
        englishToChinese["couScore"]="课程学分"
        englishToChinese["couTime"]="上课时间"
        englishToChinese["couMaxNum"]="最大选课人数"
        englishToChinese["couCurNum"]="当前选课人数"

        englishToChinese["stuId"]="学号"
        englishToChinese["stuName"]="姓名"
        englishToChinese["stuSex"]="性别"
        englishToChinese["stuBirth"]="出生日期"
        englishToChinese["stuClass"]="所属班级"

        englishToChinese["teaId"]="教师编号"
        englishToChinese["teaName"]="教师姓名"
        englishToChinese["teaLevel"]="教师等级"
        englishToChinese["teaTel"]="联系方式"

        englishToChinese["facId"]="院系号"
        englishToChinese["facName"]="院系名"
        englishToChinese["facTel"]="院系电话"
        englishToChinese["facBoss"]="系主任"
    }
    companion object{
        fun get():CONST{
            return Inner.single
        }
    }
    private object Inner{
        val single=CONST()
    }

}
