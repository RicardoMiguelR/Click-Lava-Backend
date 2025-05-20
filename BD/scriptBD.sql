-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema clic_lava
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clic_lava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clic_lava` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `clic_lava` ;

-- -----------------------------------------------------
-- Table `clic_lava`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL COMMENT 'Almacena hash de contraseña',
  `telefono` VARCHAR(15) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idRol_fk` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_Usuario_Rol_idx` (`idRol_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Rol`
    FOREIGN KEY (`idRol_fk`)
    REFERENCES `clic_lava`.`rol` (`idRol`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`tarjeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`tarjeta` (
  `idTarjeta` INT NOT NULL AUTO_INCREMENT,
  `nombreTitular` VARCHAR(100) NOT NULL,
  `numeroTarjeta` VARCHAR(16) NOT NULL,
  `vencimiento` VARCHAR(5) NOT NULL,
  `cvv` VARCHAR(4) NOT NULL,
  `idUsuario_fk` INT NOT NULL,
  PRIMARY KEY (`idTarjeta`),
  INDEX `fk_Tarjeta_Usuario_idx` (`idUsuario_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Tarjeta_Usuario`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `clic_lava`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(100) NOT NULL,
  `colonia` VARCHAR(100) NOT NULL,
  `municipio` VARCHAR(100) NOT NULL,
  `codigoPostal` VARCHAR(5) NOT NULL,
  `fechaPedido` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` INT NOT NULL,
  `tiempo` VARCHAR(45) NOT NULL COMMENT 'Tiempo estimado de entrega',
  `idUsuario_fk` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Usuario_idx` (`idUsuario_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Usuario`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `clic_lava`.`usuario` (`idUsuario`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `monto` DECIMAL(10,2) NOT NULL,
  `fechaPago` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idTarjeta_fk` INT NOT NULL,
  `idPedido_fk` INT NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_Pago_Tarjeta_idx` (`idTarjeta_fk` ASC) VISIBLE,
  INDEX `fk_pago_pedido1_idx` (`idPedido_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Pago_Tarjeta`
    FOREIGN KEY (`idTarjeta_fk`)
    REFERENCES `clic_lava`.`tarjeta` (`idTarjeta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_pedido1`
    FOREIGN KEY (`idPedido_fk`)
    REFERENCES `clic_lava`.`pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT NOT NULL,
  `img` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clic_lava`.`pedido_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clic_lava`.`pedido_producto` (
  `idPedido_fk` INT NOT NULL,
  `idProducto_fk` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precioUnitario` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idPedido_fk`, `idProducto_fk`),
  INDEX `fk_Pedido_has_Producto_Producto_idx` (`idProducto_fk` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Producto_Pedido_idx` (`idPedido_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Producto_Pedido`
    FOREIGN KEY (`idPedido_fk`)
    REFERENCES `clic_lava`.`pedido` (`idPedido`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pedido_has_Producto_Producto`
    FOREIGN KEY (`idProducto_fk`)
    REFERENCES `clic_lava`.`producto` (`idProducto`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
