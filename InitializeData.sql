-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ToyManager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ToyManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ToyManager` DEFAULT CHARACTER SET utf8 ;
USE `ToyManager` ;

-- -----------------------------------------------------
-- Table `ToyManager`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`category` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Code` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`order_status` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`toy_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`toy_status` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`toy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`toy` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Price` DECIMAL NOT NULL,
  `CategoryId` BIGINT ZEROFILL NOT NULL,
  `Gender` BIT NOT NULL,
  `ImageURI` VARCHAR(255) NOT NULL,
  `Description` LONGTEXT NOT NULL,
  `ToyStatusId` BIGINT ZEROFILL NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Toy_Category1_idx` (`CategoryId` ASC) ,
  INDEX `fk_toy_toy_status1_idx` (`ToyStatusId` ASC) ,
  CONSTRAINT `fk_Toy_Category1`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `ToyManager`.`category` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_toy_toy_status1`
    FOREIGN KEY (`ToyStatusId`)
    REFERENCES `ToyManager`.`toy_status` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`user_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`user_status` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`role` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Priority` INT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`user` (
  `Id` BIGINT ZEROFILL NOT NULL,
  `Username` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `FullName` VARCHAR(255) NOT NULL,
  `Gender` BIT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `PhoneNumber` CHAR(10) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `CreatedDate` TIMESTAMP NOT NULL,
  `LastModifiedDate` TIMESTAMP NOT NULL,
  `RoleId` BIGINT ZEROFILL NOT NULL,
  `UserStatusId` BIGINT ZEROFILL NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_User_UserStatus1_idx` (`UserStatusId` ASC) ,
  INDEX `fk_User_Role1_idx` (`RoleId` ASC) ,
  CONSTRAINT `fk_User_UserStatus1`
    FOREIGN KEY (`UserStatusId`)
    REFERENCES `ToyManager`.`user_status` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`RoleId`)
    REFERENCES `ToyManager`.`role` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`order` (
  `Id` BIGINT ZEROFILL NOT NULL,
  `OrderDate` TIMESTAMP NOT NULL,
  `PaymentDate` TIMESTAMP NULL,
  `LastModifiedDate` TIMESTAMP NOT NULL,
  `OrderStatusId` BIGINT ZEROFILL NOT NULL,
  `TotalPrice` DECIMAL NOT NULL,
  `UserId` BIGINT ZEROFILL NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Order_OrderStatus1_idx` (`OrderStatusId` ASC) ,
  INDEX `fk_Order_User1_idx` (`UserId` ASC) ,
  CONSTRAINT `fk_Order_OrderStatus1`
    FOREIGN KEY (`OrderStatusId`)
    REFERENCES `ToyManager`.`order_status` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`UserId`)
    REFERENCES `ToyManager`.`user` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`order_detail` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `ToyId` BIGINT ZEROFILL NOT NULL,
  `OrderId` BIGINT ZEROFILL NOT NULL,
  `Quantity` INT NOT NULL,
  `TotalPrice` DECIMAL NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_OrderDetail_Toy1_idx` (`ToyId` ASC) ,
  INDEX `fk_OrderDetail_Order1_idx` (`OrderId` ASC) ,
  CONSTRAINT `fk_OrderDetail_Toy1`
    FOREIGN KEY (`ToyId`)
    REFERENCES `ToyManager`.`toy` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetail_Order1`
    FOREIGN KEY (`OrderId`)
    REFERENCES `ToyManager`.`order` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ToyManager`.`parameter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ToyManager`.`parameter` (
  `Id` BIGINT ZEROFILL NOT NULL AUTO_INCREMENT,
  `ShopName` VARCHAR(255) NOT NULL,
  `ShopAddress` VARCHAR(255) NOT NULL,
  `ShopPhoneNumber` CHAR(10) NOT NULL,
  `ShopEmail` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




INSERT INTO `toymanager`.`order_status` (`Name`) VALUES ('Đang chờ');
INSERT INTO `toymanager`.`order_status` (`Name`) VALUES ('Đang giao');
INSERT INTO `toymanager`.`order_status` (`Name`) VALUES ('Đã giao');
INSERT INTO `toymanager`.`order_status` (`Name`) VALUES ('Hủy');

INSERT INTO `toymanager`.`user_status` (`Name`) VALUES ('Đang hoạt động');
INSERT INTO `toymanager`.`user_status` (`Name`) VALUES ('Không hoạt động');

INSERT INTO `toymanager`.`toy_status` (`Name`) VALUES ('Còn hàng');
INSERT INTO `toymanager`.`toy_status` (`Name`) VALUES ('Hết hàng');

INSERT INTO `toymanager`.`role` (`Name`, `Priority`) VALUES ('Người dùng', '0');
INSERT INTO `toymanager`.`role` (`Name`, `Priority`) VALUES ('Quản trị viên', '1');

