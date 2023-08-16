-- MySQL Script generated by MySQL Workbench
-- Wed Apr 26 11:59:14 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET GLOBAL time_zone = '+00:00';
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categories` (
  `categoryId` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`announces`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`announces` (
  `announcementId` INT NOT NULL AUTO_INCREMENT,
  `announcementTitle` VARCHAR(200) NOT NULL,
  `announcementDescription` TEXT(10000) NOT NULL,
  `publishDate` DATETIME NULL,
  `closeDate` DATETIME NULL,
  `announcementDisplay` ENUM('Y', 'N') NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`announcementId`),
  INDEX `fk_announces_categories_idx` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `fk_announces_categories`
    FOREIGN KEY (`categoryId`)
    REFERENCES `mydb`.`categories` (`categoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;