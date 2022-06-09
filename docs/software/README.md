# Реалізація інформаційного та програмного забезпечення

В рамках проекту розробляється: 
- SQL-скрипт для створення на початкового наповнення бази даних
  
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
```


- RESTfull сервіс для управління даними

