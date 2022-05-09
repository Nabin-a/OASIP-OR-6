LOCK TABLES `event` WRITE;
INSERT INTO `event` VALUES
    (1,'Somchai Jaidee(OR-7)','somchai.jai@mail.kmutt.ac.th','DevOps/Infra Clinic','2022-05-23 13:30:00',30,NULL,2),
    (2,'Somsri Rakdee(SJ-3)','somsri.rak@mail.kmutt.ac.th','Project Management Clinic','2022-04-27 09:30:00',30,'ขอปรึกษาปัญหาเพื่อนไม่ช่วยงาน',1),
    (3,'สมเกียรติ ขยันเรียนกลุ่ม TT-4','somkiat.kay@kmutt.ac.th','Database Clinic','2022-05-23 16:30:00',15,NULL,3);
UNLOCK TABLES;
