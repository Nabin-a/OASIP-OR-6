CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb`;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `eventCategoryId` int NOT NULL auto_increment,
  `CategoryName` varchar(100) NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Duration(min.)` int NOT NULL,
  PRIMARY KEY (`eventCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;



DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `bookingId` int NOT NULL auto_increment,
  `bookingName` varchar(100) NOT NULL,
  `bookingEmail` varchar(45) NOT NULL,
  `StartTime` datetime NOT NULL,
  `Durations` int NOT NULL,
  `Note` varchar(500) DEFAULT NULL,
  `Category_Id` int NOT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `ClientFirstsName_index` (`bookingName`),
  KEY `fk_Event_Category_idx` (`Category_Id`),
  CONSTRAINT `fk_Event_Catagory` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`eventCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

