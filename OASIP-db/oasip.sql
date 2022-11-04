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



DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `eventId` int NOT NULL auto_increment,
  `bookingName` varchar(100) NOT NULL,
  `bookingEmail` varchar(45) NOT NULL,
  `startTime` datetime NOT NULL,
  `Durations` int NOT NULL,
  `Note` varchar(500) DEFAULT NULL,
  `Category_Id` int NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `ClientFirstsName_index` (`bookingName`),
  KEY `fk_Event_Category_idx` (`Category_Id`),
  CONSTRAINT `fk_Event_Catagory` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`eventCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

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
  
DROP TABLE IF EXISTS `mydb`.`eventcategoryowner` ;
CREATE TABLE IF NOT EXISTS `mydb`.`eventcategoryowner` (
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
