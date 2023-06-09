-- MySQL Script generated by MySQL Workbench
-- Wed May 31 19:03:30 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Back-End
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Back-End
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Back-End` DEFAULT CHARACTER SET utf8 ;
USE `Back-End` ;

-- -----------------------------------------------------
-- Table `Back-End`.`Setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`Setor` (
  `id_setor` INT NOT NULL,
  `nomeSetor` VARCHAR(45) NULL,
  PRIMARY KEY (`id_setor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Back-End`.`Cargos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`Cargos` (
  `id_cargos` INT NOT NULL AUTO_INCREMENT,
  `nomeCargos` VARCHAR(45) NULL,
  `fk_setor` INT NULL,
  PRIMARY KEY (`id_cargos`),
  CONSTRAINT `cargo_setor`
    FOREIGN KEY (`fk_setor`)
    REFERENCES `Back-End`.`Setor` (`id_setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Back-End`.`Funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`Funcionarios` (
  `id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(80) NOT NULL,
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `cargo` INT NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `fk_setor` INT NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  CONSTRAINT `funcionario_setor`
    FOREIGN KEY (`fk_setor`)
    REFERENCES `Back-End`.`Setor` (`id_setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `funcionario_cargo`
    FOREIGN KEY (`cargo`)
    REFERENCES `Back-End`.`Cargos` (`id_cargos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Back-End`.`Urgencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`Urgencia` (
  `id_urgencia` INT NOT NULL,
  `nomeUrgencia` VARCHAR(45) NULL,
  `tempoUrgencia` VARCHAR(45) NULL,
  PRIMARY KEY (`id_urgencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Back-End`.`ChamadoStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`ChamadoStatus` (
  `idChamadoStatus` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idChamadoStatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Back-End`.`Chamados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Back-End`.`Chamados` (
  `id_chamados` INT NOT NULL AUTO_INCREMENT,
  `nomeChamado` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  `responsavelChamado` INT NOT NULL,
  `fk_urgencia` INT NOT NULL,
  `inicioChamado` DATE NOT NULL,
  `responsavelSolicitante` INT NOT NULL,
  `fk_setor` INT NOT NULL,
  `fk_chamadoStatus` INT NOT NULL,
  PRIMARY KEY (`id_chamados`),
  CONSTRAINT `chamado_urgencia`
    FOREIGN KEY (`fk_urgencia`)
    REFERENCES `Back-End`.`Urgencia` (`id_urgencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chamado_funcionario_resposavel`
    FOREIGN KEY (`responsavelChamado`)
    REFERENCES `Back-End`.`Funcionarios` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chamado_funcionario_abertura`
    FOREIGN KEY (`responsavelSolicitante`)
    REFERENCES `Back-End`.`Funcionarios` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chamado_setor`
    FOREIGN KEY (`fk_setor`)
    REFERENCES `Back-End`.`Setor` (`id_setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chamado_chamadoStatus`
    FOREIGN KEY (`fk_chamadoStatus`)
    REFERENCES `Back-End`.`ChamadoStatus` (`idChamadoStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
