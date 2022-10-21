-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cmmsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cmmsdb` ;

-- -----------------------------------------------------
-- Schema cmmsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cmmsdb` DEFAULT CHARACTER SET utf8 ;
USE `cmmsdb` ;

-- -----------------------------------------------------
-- Table `maintenance_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maintenance_item` ;

CREATE TABLE IF NOT EXISTS `maintenance_item` (
  `id` INT NOT NULL,
  `mrc_id` INT NOT NULL,
  `equipment_id` INT NOT NULL,
  `completion_date` DATETIME NULL,
  `actual_duration` INT NULL,
  `tech_notes` VARCHAR(200) NULL,
  `staff_id` INT NOT NULL,
  `date_schedules` DATETIME NULL,
  `training_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `staff` ;

CREATE TABLE IF NOT EXISTS `staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `location_id` INT NOT NULL,
  `user_id` INT NULL,
  `supervisor_id` INT NULL,
  `maintenance_item_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_maintenance_item1_idx` (`maintenance_item_id` ASC),
  CONSTRAINT `fk_staff_maintenance_item1`
    FOREIGN KEY (`maintenance_item_id`)
    REFERENCES `maintenance_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NOT NULL,
  `staff_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_staff_idx` (`staff_id` ASC),
  CONSTRAINT `fk_user_staff`
    FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `street_2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state_abbrev` CHAR(2) NOT NULL,
  `zip_code` INT NOT NULL,
  `supervisor_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supervisor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supervisor` ;

CREATE TABLE IF NOT EXISTS `supervisor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `staff_id` VARCHAR(45) NOT NULL,
  `location_id` INT NOT NULL,
  `location_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `staff_id_UNIQUE` (`staff_id` ASC),
  INDEX `fk_supervisor_location1_idx` (`location_id1` ASC),
  CONSTRAINT `fk_supervisor_location1`
    FOREIGN KEY (`location_id1`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mrc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrc` ;

CREATE TABLE IF NOT EXISTS `mrc` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `periodicity` VARCHAR(10) NULL,
  `equipment_id` INT NULL,
  `tool_id` INT NULL,
  `safety_id` INT NULL,
  `required_certs` VARCHAR(100) NULL,
  `description` VARCHAR(100) NULL,
  `number_of_techs` INT NULL,
  `training_video_id` VARCHAR(250) NULL,
  `estimated_duration` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_of_techs_UNIQUE` (`number_of_techs` ASC),
  UNIQUE INDEX `training_video_id_UNIQUE` (`training_video_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment` ;

CREATE TABLE IF NOT EXISTS `equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NULL,
  `manufacturer` VARCHAR(45) NULL,
  `year` SMALLINT(4) NULL,
  `maintenance_item_id` INT NOT NULL,
  `mrc_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_equipment_maintenance_item1_idx` (`maintenance_item_id` ASC),
  INDEX `fk_equipment_mrc1_idx` (`mrc_id` ASC),
  CONSTRAINT `fk_equipment_maintenance_item1`
    FOREIGN KEY (`maintenance_item_id`)
    REFERENCES `maintenance_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_mrc1`
    FOREIGN KEY (`mrc_id`)
    REFERENCES `mrc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tools`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tools` ;

CREATE TABLE IF NOT EXISTS `tools` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `mrc_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tools_mrc1_idx` (`mrc_id` ASC),
  CONSTRAINT `fk_tools_mrc1`
    FOREIGN KEY (`mrc_id`)
    REFERENCES `mrc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `training` ;

CREATE TABLE IF NOT EXISTS `training` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `video_url` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `mrc_id` INT NULL,
  `mrc_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_training_mrc1_idx` (`mrc_id1` ASC),
  CONSTRAINT `fk_training_mrc1`
    FOREIGN KEY (`mrc_id1`)
    REFERENCES `mrc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `safety`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `safety` ;

CREATE TABLE IF NOT EXISTS `safety` (
  `id` INT NOT NULL,
  `category` VARCHAR(45) NULL,
  `mrc_id` INT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `part`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `part` ;

CREATE TABLE IF NOT EXISTS `part` (
  `part_number` INT NOT NULL,
  `mrc_id` INT NULL,
  `equipment_id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`part_number`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS cmmsadmin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'cmmsadmin'@'localhost' IDENTIFIED BY 'cmmsadmin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'cmmsadmin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `staff_id`) VALUES (1, 'admin', 'admin', 1, 'tech', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mrc`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `mrc` (`id`, `periodicity`, `equipment_id`, `tool_id`, `safety_id`, `required_certs`, `description`, `number_of_techs`, `training_video_id`, `estimated_duration`) VALUES (1, 'd', 1, 1, 1, NULL, 'test maintenance', 1, '1', 2);

COMMIT;

