# Реалізація інформаційного та програмного забезпечення

В рамках проекту розробляється: 
- SQL-скрипт для створення та початкового наповнення бази даних
  
```sql
-- MySQL Workbench Forward Engineering

SET \@OLD_UNIQUE_CHECKS=\@\@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET \@OLD_FOREIGN_KEY_CHECKS=\@\@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CKECKS=0;
SET \@OLD_SQL_MODE=\@\@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALIS_DATES';

-- -----------------------------------------------------
-- Schema `Project_DBB`
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Project_DBB`;


-- -----------------------------------------------------
-- Schema `Project_DBB`
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Project_DBB` DEFAULT CHARACTER SET utf8;
USE `Project_DBB`;


-- -----------------------------------------------------
-- Table `Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `bussinesRole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE INDEX `roleId_UNIQUE` (`roleId` ASC)) 
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roleId` INT NOT NULL,
  PRIMARY KEY (`userId`, `roleId`),
  INDEX `fk_User_Role_idx` (`roleId` ASC),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC),
  CONSTRAINT `fk_User_Role`
  FOREIGN KEY (`roleId`)
  REFERENCES `Role` (`roleId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Dataset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Dataset` (
  `datasetId` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(45) NOT NULL,
  `creation_data` DATE NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`datasetId`, `userId`),
  INDEX `fk_Dataset_User_idx` (`userId` ASC),
  UNIQUE INDEX `datasetId_UNIQUE` (`datasetId` ASC),
  CONSTRAINT `fk_Dataset_User`
    FOREIGN KEY (`userId`)
    REFERENCES `User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RequestStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RequestStatus` (
  `statusId` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`statusId`),
  UNIQUE INDEX `statusId_UNIQUE` (`statusId` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AddDataset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AddDataset` (
  `addId` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(45) NOT NULL,
  `creation_data` DATE NOT NULL,
  `userId` INT NOT NULL,
  `statusId` INT NOT NULL,
  `datasetId` INT NOT NULL,
  PRIMARY KEY (`addId`, `userId`, `statusId`, `datasetId`),
  INDEX `fk_AddDataset_User_idx` (`userId` ASC),
  INDEX `fk_AddDataset_RequestStatus_idx` (`statusId` ASC),
  INDEX `fk_AddDataset_Dataset_idx` (`datasetId` ASC),
  UNIQUE INDEX `addId_UNIQUE` (`addId` ASC),
  CONSTRAINT `fk_AddDataset_User`
      FOREIGN KEY (`userId`)
      REFERENCES `User` (`userId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_AddDataset_RequestStatus`
      FOREIGN KEY (`statusId`)
      REFERENCES `RequestStatus` (`statusId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_AddDataset_Dataset`
      FOREIGN KEY (`datasetId`)
      REFERENCES `Dataset` (`datasetId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SaveDataset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SaveDataset` (
  `saveId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `link` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL,
  `statusId` INT NOT NULL,
  `datasetId` INT NOT NULL,
  PRIMARY KEY (`saveId`, `userId`, `statusId`, `datasetId`),
  INDEX `fk_SaveDataset_User_idx` (`userId` ASC),
  INDEX `fk_SaveDataset_RequestStatus_idx` (`statusId` ASC),
  INDEX `fk_SaveDataset_Dataset_idx` (`datasetId` ASC),
  UNIQUE INDEX `addId_UNIQUE` (`saveId` ASC),
  CONSTRAINT `fk_SaveDataset_User`
      FOREIGN KEY (`userId`)
      REFERENCES `User` (`userId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_SaveDataset_RequestStatus`
      FOREIGN KEY (`statusId`)
      REFERENCES `RequestStatus` (`statusId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_SaveDataset_Dataset`
      FOREIGN KEY (`datasetId`)
      REFERENCES `Dataset` (`datasetId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelDataset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DelDataset` (
  `delId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `link` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL,
  `statusId` INT NOT NULL,
  `datasetId` INT NOT NULL,
  PRIMARY KEY (`delId`, `userId`, `statusId`, `datasetId`),
  INDEX `fk_DelDataset_User_idx` (`userId` ASC),
  INDEX `fk_DelDataset_RequestStatus_idx` (`statusId` ASC),
  INDEX `fk_DelDataset_Dataset_idx` (`datasetId` ASC),
  UNIQUE INDEX `delId_UNIQUE` (`delId` ASC),
  CONSTRAINT `fk_DelDataset_User`
      FOREIGN KEY (`userId`)
      REFERENCES `User` (`userId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_DelDataset_RequestStatus`
      FOREIGN KEY (`statusId`)
      REFERENCES `RequestStatus` (`statusId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_DelDataset_Dataset`
      FOREIGN KEY (`datasetId`)
      REFERENCES `Dataset` (`datasetId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GiveModeratorStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GiveModeratorStatus` (
  `giveId` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `userId` INT NOT NULL,
  `statusId` INT NOT NULL,
  `datasetId` INT NOT NULL,
  PRIMARY KEY (`giveId`, `userId`, `statusId`, `datasetId`),
  INDEX `fk_GiveModeratorStatust_User_idx` (`userId` ASC),
  INDEX `fk_GiveModeratorStatus_RequestStatus_idx` (`statusId` ASC),
  INDEX `fk_GiveModeratorStatus_Dataset_idx` (`datasetId` ASC),
  UNIQUE INDEX `giveId_UNIQUE` (`giveId` ASC),
  CONSTRAINT `fk_GiveModeratorStatus_User`
      FOREIGN KEY (`userId`)
      REFERENCES `User` (`userId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_GiveModeratorStatus_RequestStatus`
      FOREIGN KEY (`statusId`)
      REFERENCES `RequestStatus` (`statusId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_GiveModeratorStatus_Dataset`
      FOREIGN KEY (`datasetId`)
      REFERENCES `Dataset` (`datasetId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TakeModeratorStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TakeModeratorStatus` (
  `takeId` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `userId` INT NOT NULL,
  `statusId` INT NOT NULL,
  `datasetId` INT NOT NULL,
  PRIMARY KEY (`takeId`, `userId`, `statusId`, `datasetId`),
  INDEX `fk_TakeModeratorStatus_User_idx` (`userId` ASC),
  INDEX `fk_TakeModeratorStatus_RequestStatus_idx` (`statusId` ASC),
  INDEX `fk_TakeModeratorStatus_Dataset_idx` (`datasetId` ASC),
  UNIQUE INDEX `takeId_UNIQUE` (`takeId` ASC),
  CONSTRAINT `fk_TakeModeratorStatus_User`
      FOREIGN KEY (`userId`)
      REFERENCES `User` (`userId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_TakeModeratorStatus_RequestStatus`
      FOREIGN KEY (`statusId`)
      REFERENCES `RequestStatus` (`statusId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_TakeModeratorStatus_Dataset`
      FOREIGN KEY (`datasetId`)
      REFERENCES `Dataset` (`datasetId`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- ------------------------------------------------------------
-- Insertion values in `Project_DBB`
-- ------------------------------------------------------------

-- ------------------------------------------------------------
-- Data for table `Project_DBB`.`Role`
-- ------------------------------------------------------------

INSERT INTO `Project_DBB`.`Role` (`roleId`, `businessRole`) 
        VALUES (DEFAULT, 'Administrator');
INSERT INTO `Project_DBB`.`Role` (`roleId`, `businessRole`) 
        VALUES (DEFAULT, 'Moderator');
INSERT INTO `Project_DBB`.`Role` (`roleId`, `businessRole`)
        VALUES (DEFAULT, 'User');
INSERT INTO `Project_DBB`.`Role` (`roleId`, `businessRole`)
        VALUES (DEFAULT, 'Guest');


-- ------------------------------------------------------------
-- Data for table `Project_DBB`.`User`
-- ------------------------------------------------------------

INSERT INTO `Project_DBB`.`User` (`userId`, `nickname`, `email`, `password`, `roleId`)
    VALUES (DEFAULT, 'melo', 'adop23@gmail.com', '1234567', '1');
INSERT INTO `Project_DBB`.`User` (`userId`, `nickname`, `email`, `password`, `roleId`)
    VALUES (DEFAULT, 'socket', 'creator03@gmail.com', 'qwerty', '2');
INSERT INTO `Project_DBB`.`User` (`userId`, `nickname`, `email`, `password`, `roleId`)
    VALUES (DEFAULT, 'jav-east', 'developer31@gmail.com', 'coding8est', '3');
INSERT INTO `Project_DBB`.`User` (`userId`, `nickname`, `email`, `password`, `roleId`)
    VALUES (DEFAULT, 'imagerTp', 'explissive@gmail.com', 'emotionCntrl2', '4');


-- ------------------------------------------------------------
-- Data for table `Project_DBB`.`Dataset`
-- ------------------------------------------------------------

INSERT INTO `Project_DBB`.`Dataset` (`datasetId`, `file_name`, `creation_data`, `userId`)
    VALUES (DEFAULT, 'successfulProjects', '2022-03-10', '1');
INSERT INTO `Project_DBB`.`Dataset` (`datasetId`, `file_name`, `creation_data`, `userId`)
    VALUES (DEFAULT, 'soldComputers', '2022-01-01', '2');
INSERT INTO `Project_DBB`.`Dataset` (`datasetId`, `file_name`, `creation_data`, `userId`)
    VALUES (DEFAULT, 'fuelConsumption', '2022-06-10', '3');
INSERT INTO `Project_DBB`.`Dataset` (`datasetId`, `file_name`, `creation_data`, `userId`)
    VALUES (DEFAULT, 'avgStudyingTimePerDay', '2022-06-01', '4');

-- --------------------------------------------------------------
-- Data for table `Project_DBB`.`RequestStatus`
-- --------------------------------------------------------------

INSERT INTO `Project_DBB`.`RequestStatus` (`statusId`, `status`)
    VALUES (DEFAULT, 'completed');
INSERT INTO `Project_DBB`.`RequestStatus` (`statusId`, `status`)
    VALUES (DEFAULT, 'rejected');
INSERT INTO `Project_DBB`.`RequestStatus` (`statusId`, `status`)
    VALUES (DEFAULT, 'processing');


-- --------------------------------------------------------------
-- Data for table `Project_DBB`.`AddDataset`
-- --------------------------------------------------------------

INSERT INTO `Project_DBB`.`AddDataset` (`addId`, `file_name`, `creation_data`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'salaryStatistics', '2022-04-01', '4', '3', '3');
INSERT INTO `Project_DBB`.`AddDataset` (`addId`, `file_name`, `creation_data`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'avgStudent`sMark', '2022-02-01', '2', '1', '2');
INSERT INTO `Project_DBB`.`AddDataset` (`addId`, `file_name`, `creation_data`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'topSongs', '2015-10-25', '1', '2', '4');

-- --------------------------------------------------------------
-- Data for table `Project_DBB`.`SaveDataset`
-- --------------------------------------------------------------

INSERT INTO `Project_DBB`.`SaveDataset` (`saveId`, `name`, `link`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'successfulProjects', 'someSite.ua', '2', '3', '1');
INSERT INTO `Project_DBB`.`SaveDataset` (`saveId`, `name`, `link`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'soldComputers', 'someSite.ua', '1', '1', '2');

-- ---------------------------------------------------------------
-- Data for table `Project_DBB`.`DelDataset`
-- ---------------------------------------------------------------

INSERT INTO `Project_DBB`.`DelDataset` (`delId`, `name`, `link`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'fuelConsumption', 'someSite.ua', '4', '3', '3');
INSERT INTO `Project_DBB`.`DelDataset` (`delId`, `name`, `link`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'avgStudyingTimePerDay', 'someSite.ua', '3', '2', '4');


-- ----------------------------------------------------------------
-- Data for table `Project_DBB`.`GiveModeratorStatus`
-- ----------------------------------------------------------------

INSERT INTO `Project_DBB`.`GiveModeratorStatus` (`giveId`, `user_name`, `date`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'melo', '2022-03-25', '1', '3', '4');
INSERT INTO `Project_DBB`.`GiveModeratorStatus` (`giveId`, `user_name`, `date`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'socket', '2022-01-20', '2', '3', '2');

-- ----------------------------------------------------------------
-- Data for table `Project_DBB`.`TakeModeratorStatus`
-- ----------------------------------------------------------------

INSERT INTO `Project_DBB`.`TakeModeratorStatus` (`takeId`, `user_name`, `date`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'jav-east', '2021-12-22', '3', '3', '1');
INSERT INTO `Project_DBB`.`TakeModeratorStatus` (`takeId`, `user_name`, `date`, `userId`, `statusId`, `datasetId`)
    VALUES (DEFAULT, 'imagerTp', '2022-10-02', '4', '2', '3');
```


- RESTfull сервіс для управління даними
  Можна переглянути [тут](https://github.com/Hlb03/new_project/tree/master/src/java)