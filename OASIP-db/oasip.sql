CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb`;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `eventCategoryId` int NOT NULL auto_increment,
  `CategoryName` varchar(100) NOT NULL unique,
  `Description` varchar(500) DEFAULT NULL,
  `Duration(min.)` int NOT NULL,
  PRIMARY KEY (`eventCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `category` WRITE;
INSERT INTO `category` VALUES 
    (1,'Project Management Clinic','ตารางนัดหมายนี้ใช้สำหรับนัดหมาย project management clinic ในวิชา INT221 integrated project I ให้นักศึกษาเตรียมเอกสารที่เกี่ยวข้องเพื่อแสดงระหว่างขอคำปรึกษา',30),
    (2,'DevOps/Infra Clinic','Use this event category for DevOps/Infra clinic.',20),
    (3,'Database Clinic','ตารางนัดหมายนี้ใช้สำหรับนัดหมาย database clinic ในวิชา INT221 integrated project I',15),
    (4,'Client-side Clinic','ตารางนัดหมายนี้ใช้สำหรับนัดหมาย client-side clinic ในวิชา INT221 integrated project I',30),
    (5,'Server-side Clinic',NULL,20);
UNLOCK TABLES;


DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `eventId` int NOT NULL auto_increment,
  `bookingName` varchar(100) NOT NULL,
  `bookingEmail` varchar(45) NOT NULL,
  `startTime` datetime NOT NULL,
  `Durations` int NOT NULL,
  `Note` varchar(500) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  `Category_Id` int NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `ClientFirstsName_index` (`bookingName`),
  KEY `fk_Event_Category_idx` (`Category_Id`),
  CONSTRAINT `fk_Event_Catagory` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`eventCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `event` WRITE;
INSERT INTO `event` VALUES
    (1,'Somchai Jaidee(OR-7)','somchai.jai@mail.kmutt.ac.th','2022-05-23 13:30:00',30,NULL,NULL,2),
    (2,'Somsri Rakdee(SJ-3)','somsri.rak@mail.kmutt.ac.th','2022-04-27 09:30:00',30,'ขอปรึกษาปัญหาเพื่อนไม่ช่วยงาน',NULL,1),
    (3,'สมเกียรติ ขยันเรียนกลุ่ม TT-4','somkiat.kay@kmutt.ac.th','2022-05-23 16:30:00',15,NULL,NULL,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `mydb`.`user` ;
create table `user` (
	userId int not null auto_increment,
    `name` varchar(100) not null unique, 
    email varchar(50) not null unique,
    password varchar(100) not null,
    `role` enum('admin', 'lecturer', 'student') default 'student' not null,
	createdOn timestamp default current_timestamp not null, 
    updatedOn timestamp default current_timestamp on UPDATE CURRENT_TIMESTAMP not null,
    PRIMARY KEY (`userId`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
  )ENGINE = InnoDB;
  
LOCK TABLES `user` WRITE;
insert into user (name, email, password, role, createdOn, updatedOn)
values('OASIP ADMIN', 'oasip.admin@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$sYXzbUOqBoHY1NfhJ8cjnw$H6+adWySiFPgcUogJK3hEhcF6Y4fusy7tcXYEL+f0cQ', 'admin', '2022-08-01 00:00:00+07:00', '2022-08-01 00:00:00+07:00'),
    ('Olarn Rojanapornpun', 'olarn.roj@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$Sx7y2jxKZSjpWUV4srd8eg$AMH09iFiPQgAZ00cAdN3Gucqfhx2kRo3tQbHeLSR0RE', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
    ('Pichet Limvachiranan', 'pichet.limv@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$46EB43gQ46Z1/EmdqxtKNA$7m6cWGO2iDlFl/ETDYuYf+ArnSjRnsNwXLIP18DTYQY', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
    ('Umaporn Supasitthimethee', 'umaporn.sup@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$1Z2UK1zC76FIQeLH54GVAQ$qfXcHF31LnuWpt37QAcWyNp8PdbOQ+jjaV1xWXixS0M', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
    ('Siam Yamsaengsung', 'siam.yam@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$C4pPaNWKTnZQX2mPs14jlg$rQ5W5NYKqGOu1B4GkUWq8cFbcg2peFWGjpUMr9Nkm8g', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
    ('Sunisa Sathapornvajana', 'sunisa.sat@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$29/ffaszvjvi3CZO45bSCg$kKpfq5WEswoqa/LfyIZzQaQ6AFdjhyiYjXRCfMiTnwg', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
	('Somchai Jaidee', 'somchai.jai@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$dmsOy7LPTjmooPu+P2oTZA$NZFTFd3f0K1Sp19aaUwyn3jgiy15yFcXhp8E4/1yXoI', 'lecturer', '2022-08-08 15:00:00+07:00', '2022-08-08 15:00:00+07:00'),
	('Komkrid Rakdee', 'komkrid.rak@mail.kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$8W61ZOC5RU7sJP5kKRbSqg$OLwZNPeMqxp+g0Vbn+odcA47XMClFN+IswTueVah7F0', 'student', '2022-08-08 15:00:01+07:00', '2022-08-08 15:00:01+07:00'),
    ('สมเกียรติ ขยันเรียน', 'somkiat.kay@kmutt.ac.th', '$argon2id$v=19$m=4096,t=3,p=1$gBqgjspF45FcIKQEw8GmaQ$alrOCZ0YrDqOu8/aZiLDMGZo4vFkSEAXA0YoHhY0BDQ', 'student', '2022-08-16 09:00:00+07:00', '2022-08-16 09:00:00+07:00');
UNLOCK TABLES;


DROP TABLE IF EXISTS `eventcategoryowner` ;
CREATE TABLE IF NOT EXISTS `eventcategoryowner` (
  `ownerId` INT NOT NULL auto_increment,
  `userId` INT NOT NULL,
  `eventCategoryId` INT NOT NULL,
  PRIMARY KEY (`ownerId`),
  INDEX `fk_category_has_user_user1_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_category_has_user_category1_idx` (`ownerId` ASC) VISIBLE,
  INDEX `fk_category_has_user_category_has_user1_idx` (`eventCategoryId` ASC) VISIBLE,
  CONSTRAINT `fk_category_has_user_category1`
    FOREIGN KEY (`eventCategoryId`)
    REFERENCES `mydb`.`category` (`eventCategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_user_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `mydb`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_user_category_has_user1`
    FOREIGN KEY (`ownerId`)
    REFERENCES `mydb`.`eventcategoryowner` (`ownerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

<<<<<<< HEAD
LOCK TABLES `eventcategoryowner` WRITE;
insert into eventcategoryowner (userId, eventCategoryId)
values(2,1),(2,2),(5,2),(6,3),(4,4),(3,5),(2,5); 
UNLOCK TABLES;


=======
Alter table event
add file varchar(100);
>>>>>>> dedbb7067e1c2f2f598aa97b98ecbe741918694b
