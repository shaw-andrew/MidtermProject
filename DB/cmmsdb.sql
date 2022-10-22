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
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_type` ;

CREATE TABLE IF NOT EXISTS `equipment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NULL,
  `manufacturer` VARCHAR(45) NULL,
  `year` SMALLINT(4) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `frequency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `frequency` ;

CREATE TABLE IF NOT EXISTS `frequency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maintenance_requirement_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maintenance_requirement_card` ;

CREATE TABLE IF NOT EXISTS `maintenance_requirement_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL,
  `number_of_techs` INT NULL,
  `training_video_id` VARCHAR(250) NULL,
  `estimated_duration_in_hours` DOUBLE NULL,
  `frequency_id` INT NOT NULL,
  `equipment_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_of_techs_UNIQUE` (`number_of_techs` ASC),
  UNIQUE INDEX `training_video_id_UNIQUE` (`training_video_id` ASC),
  INDEX `fk_maintenance_requirement_card_frequency1_idx` (`frequency_id` ASC),
  INDEX `fk_maintenance_requirement_card_equipment_type1_idx` (`equipment_type_id` ASC),
  CONSTRAINT `fk_maintenance_requirement_card_frequency1`
    FOREIGN KEY (`frequency_id`)
    REFERENCES `frequency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_maintenance_requirement_card_equipment_type1`
    FOREIGN KEY (`equipment_type_id`)
    REFERENCES `equipment_type` (`id`)
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
  `user_id` INT NOT NULL,
  `manager_id` INT NULL,
  `supervised_location_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_location1_idx` (`location_id` ASC),
  INDEX `fk_staff_user1_idx` (`user_id` ASC),
  INDEX `fk_staff_staff1_idx` (`manager_id` ASC),
  INDEX `fk_staff_location2_idx` (`supervised_location_id` ASC),
  CONSTRAINT `fk_staff_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_staff1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_location2`
    FOREIGN KEY (`supervised_location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment` ;

CREATE TABLE IF NOT EXISTS `equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipment_type_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `image_url` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_equipment_equipment_type1_idx` (`equipment_type_id` ASC),
  INDEX `fk_equipment_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_equipment_equipment_type1`
    FOREIGN KEY (`equipment_type_id`)
    REFERENCES `equipment_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maintenance_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maintenance_item` ;

CREATE TABLE IF NOT EXISTS `maintenance_item` (
  `id` INT NOT NULL,
  `completion_date` DATETIME NULL,
  `actual_duration_in_hours` DOUBLE NULL,
  `tech_notes` VARCHAR(200) NULL,
  `schedule_start_date` DATETIME NULL,
  `maintenance_requirement_card_id` INT NOT NULL,
  `equipment_id` INT NOT NULL,
  `schedule_end_date` DATETIME NULL,
  `staff_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_maintenance_item_maintenance_requirement_card1_idx` (`maintenance_requirement_card_id` ASC),
  INDEX `fk_maintenance_item_equipment1_idx` (`equipment_id` ASC),
  INDEX `fk_maintenance_item_staff1_idx` (`staff_id` ASC),
  CONSTRAINT `fk_maintenance_item_maintenance_requirement_card1`
    FOREIGN KEY (`maintenance_requirement_card_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_maintenance_item_equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_maintenance_item_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tool`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tool` ;

CREATE TABLE IF NOT EXISTS `tool` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
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
  PRIMARY KEY (`id`),
  INDEX `fk_training_mrc1_idx` (`mrc_id` ASC),
  CONSTRAINT `fk_training_mrc1`
    FOREIGN KEY (`mrc_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
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
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `part`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `part` ;

CREATE TABLE IF NOT EXISTS `part` (
  `part_number` INT UNSIGNED NOT NULL,
  `description` VARCHAR(45) NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `card_has_tool`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `card_has_tool` ;

CREATE TABLE IF NOT EXISTS `card_has_tool` (
  `maintenance_requirement_card_id` INT NOT NULL,
  `tool_id` INT NOT NULL,
  PRIMARY KEY (`maintenance_requirement_card_id`, `tool_id`),
  INDEX `fk_maintenance_requirement_card_has_tool_tool1_idx` (`tool_id` ASC),
  INDEX `fk_maintenance_requirement_card_has_tool_maintenance_requir_idx` (`maintenance_requirement_card_id` ASC),
  CONSTRAINT `fk_maintenance_requirement_card_has_tool_maintenance_requirem1`
    FOREIGN KEY (`maintenance_requirement_card_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_maintenance_requirement_card_has_tool_tool1`
    FOREIGN KEY (`tool_id`)
    REFERENCES `tool` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `card_has_safety`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `card_has_safety` ;

CREATE TABLE IF NOT EXISTS `card_has_safety` (
  `safety_id` INT NOT NULL,
  `maintenance_requirement_card_id` INT NOT NULL,
  PRIMARY KEY (`safety_id`, `maintenance_requirement_card_id`),
  INDEX `fk_safety_has_maintenance_requirement_card_maintenance_requ_idx` (`maintenance_requirement_card_id` ASC),
  INDEX `fk_safety_has_maintenance_requirement_card_safety1_idx` (`safety_id` ASC),
  CONSTRAINT `fk_safety_has_maintenance_requirement_card_safety1`
    FOREIGN KEY (`safety_id`)
    REFERENCES `safety` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_safety_has_maintenance_requirement_card_maintenance_requir1`
    FOREIGN KEY (`maintenance_requirement_card_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `certification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certification` ;

CREATE TABLE IF NOT EXISTS `certification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `card_has_certification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `card_has_certification` ;

CREATE TABLE IF NOT EXISTS `card_has_certification` (
  `certification_id` INT NOT NULL,
  `maintenance_requirement_card_id` INT NOT NULL,
  PRIMARY KEY (`certification_id`, `maintenance_requirement_card_id`),
  INDEX `fk_certification_has_maintenance_requirement_card_maintenan_idx` (`maintenance_requirement_card_id` ASC),
  INDEX `fk_certification_has_maintenance_requirement_card_certifica_idx` (`certification_id` ASC),
  CONSTRAINT `fk_certification_has_maintenance_requirement_card_certificati1`
    FOREIGN KEY (`certification_id`)
    REFERENCES `certification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certification_has_maintenance_requirement_card_maintenance1`
    FOREIGN KEY (`maintenance_requirement_card_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `certification_has_staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certification_has_staff` ;

CREATE TABLE IF NOT EXISTS `certification_has_staff` (
  `certification_id` INT NOT NULL,
  `staff_id` INT NOT NULL,
  PRIMARY KEY (`certification_id`, `staff_id`),
  INDEX `fk_certification_has_staff_staff1_idx` (`staff_id` ASC),
  INDEX `fk_certification_has_staff_certification1_idx` (`certification_id` ASC),
  CONSTRAINT `fk_certification_has_staff_certification1`
    FOREIGN KEY (`certification_id`)
    REFERENCES `certification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certification_has_staff_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `card_has_part`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `card_has_part` ;

CREATE TABLE IF NOT EXISTS `card_has_part` (
  `maintenance_requirement_card_id` INT NOT NULL,
  `part_id` INT NOT NULL,
  PRIMARY KEY (`maintenance_requirement_card_id`, `part_id`),
  INDEX `fk_maintenance_requirement_card_has_part_part1_idx` (`part_id` ASC),
  INDEX `fk_maintenance_requirement_card_has_part_maintenance_requir_idx` (`maintenance_requirement_card_id` ASC),
  CONSTRAINT `fk_maintenance_requirement_card_has_part_maintenance_requirem1`
    FOREIGN KEY (`maintenance_requirement_card_id`)
    REFERENCES `maintenance_requirement_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_maintenance_requirement_card_has_part_part1`
    FOREIGN KEY (`part_id`)
    REFERENCES `part` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`) VALUES (1, 'admin', 'admin', 1, 'supervisor');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`) VALUES (2, 'tech', 'tech', 1, 'tech');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipment_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `equipment_type` (`id`, `name`, `model`, `manufacturer`, `year`) VALUES (1, 'mechanical', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `frequency`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `frequency` (`id`, `name`, `description`) VALUES (1, 'daily', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `maintenance_requirement_card`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `maintenance_requirement_card` (`id`, `description`, `number_of_techs`, `training_video_id`, `estimated_duration_in_hours`, `frequency_id`, `equipment_type_id`) VALUES (1, 'test maintenance', 1, '1', 2, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `location` (`id`, `street`, `street_2`, `city`, `state_abbrev`, `zip_code`) VALUES (1, '123 A St.', NULL, 'Denver', 'CO', 80205);

COMMIT;


-- -----------------------------------------------------
-- Data for table `staff`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `staff` (`id`, `first_name`, `last_name`, `location_id`, `user_id`, `manager_id`, `supervised_location_id`) VALUES (1, 'John', 'Appleseed', 1, 1, 1, 1);
INSERT INTO `staff` (`id`, `first_name`, `last_name`, `location_id`, `user_id`, `manager_id`, `supervised_location_id`) VALUES (2, 'Jane', 'Doe', 1, 2, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `equipment` (`id`, `equipment_type_id`, `location_id`, `name`, `description`, `image_url`) VALUES (1, 1, 1, 'conveyer', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `maintenance_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `maintenance_item` (`id`, `completion_date`, `actual_duration_in_hours`, `tech_notes`, `schedule_start_date`, `maintenance_requirement_card_id`, `equipment_id`, `schedule_end_date`, `staff_id`) VALUES (1, NULL, NULL, NULL, NULL, 1, 1, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tool`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `tool` (`id`, `name`) VALUES (1, 'screwdriver');

COMMIT;


-- -----------------------------------------------------
-- Data for table `training`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `training` (`id`, `category`, `video_url`, `description`, `mrc_id`) VALUES (1, 'general', 'abc', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `safety`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `safety` (`id`, `category`, `description`) VALUES (1, 'general', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `part`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `part` (`part_number`, `description`, `id`, `cost`) VALUES (1, NULL, 1, 5.99);

COMMIT;


-- -----------------------------------------------------
-- Data for table `certification`
-- -----------------------------------------------------
START TRANSACTION;
USE `cmmsdb`;
INSERT INTO `certification` (`id`, `name`, `description`) VALUES (1, 'general maintenance', NULL);

COMMIT;

