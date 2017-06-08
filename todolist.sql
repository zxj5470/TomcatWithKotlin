CREATE TABLE tTeacher (
  teaId VARCHAR(20) NOT NULL PRIMARY KEY,
  teaName varchar(20),
  teaLevel varchar(10),
  teaTel varchar(13)
);

CREATE TABLE tStudent (
  stuId varchar(20) NOT NULL PRIMARY KEY,
  stuName varchar(20),
  stuSex varchar(5),
  stuBirth varchar(8),
  stuClass varchar(10)
);

CREATE TABLE tCourse (
  couId VARCHAR(20) NOT NULL PRIMARY KEY,
  couName varchar(30),
  couScore decimal(5),
  couTime TEXT,
  couMaxNum SMALLINT,
  couCurNum SMALLINT
);


CREATE TABLE tFaculty (
  facId VARCHAR(20) NOT NULL PRIMARY KEY,
  facName varchar(20),
  facTel varchar(13),
  facBoss VARCHAR(20),
  FOREIGN KEY (facBoss)REFERENCES tTeacher(teaId)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
);


CREATE TABLE tStuSelect (
  selStuId VARCHAR(20),
  selCouId varchar(20),
  selStuScore SMALLINT,
  PRIMARY KEY (selStuId,selCouId),
  FOREIGN KEY (selStuId)REFERENCES tStudent(stuId)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY (selCouId)REFERENCES tCourse(couId)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE tTeaSelect (
  teaTeaId VARCHAR(20),
  teaCouId varchar(20),
  PRIMARY KEY (teaTeaId,teaCouId),
  FOREIGN KEY (teaTeaId)REFERENCES tTeacher(teaId)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY (teaCouId)REFERENCES tCourse(couId)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

--insert Students
INSERT INTO tStudent VALUES ('1215001295','刘信哲','男','1990','1142');
INSERT INTO tStudent VALUES ('1215002387','张佳文','女','19961004','1142');
INSERT INTO tStudent VALUES ('1215001296','李茹','女','19970308','1142');

--insert Teachers
INSERT INTO tTeacher VALUES ('1110001','软工教师1','系主任','13011110001')
INSERT INTO tTeacher VALUES ('1120001','遥感教师1','系主任','13011120001')
INSERT INTO tTeacher VALUES ('1140001','地信教师1','系主任','13011140001')
INSERT INTO tTeacher VALUES ('1150001','测绘教师1','系主任','13011150001')
INSERT INTO tTeacher VALUES ('1160001','信工教师1','系主任','13011160001')

--insert Faculties
INSERT INTO tFaculty VALUES ('111','软件工程系','072-87660001','1110001')
INSERT INTO tFaculty VALUES ('113','遥感科学系','072-87660002','1120001')
INSERT INTO tFaculty VALUES ('114','空间信息系','072-87660003','1140001')
INSERT INTO tFaculty VALUES ('115','遥感科学系','072-87660004','1150001')
INSERT INTO tFaculty VALUES ('116','信息工程系','072-87660005','1160001')

--insert Courses
INSERT INTO tCourse VALUES ('10911630', '大学英语3（ABC）', 3, '1-12周，星期三3-4节', 90, 88);
INSERT INTO tCourse VALUES ('21212711', '高等数学', 5, '1-8周，星期一7-8节', 120, 117);
INSERT INTO tCourse VALUES ('21212801', '线性代数', 4, '1-8周，星期一5-6节', 120, 118);

--insert StuSelect
INSERT INTO tStuSelect VALUES('1215001295','21212801',80)

--insert TeaSelect


--test
DELETE FROM tStuSelect WHERE tStuSelect.selStuId='1215001295'
INSERT INTO tStuSelect VALUES ('1215001295','21212711',88)
