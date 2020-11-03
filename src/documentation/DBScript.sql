SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PrimalEnterpriceDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PrimalEnterpriceDB` ;

CREATE SCHEMA IF NOT EXISTS `PrimalEnterpriceDB` DEFAULT CHARACTER SET utf8 ;
USE `PrimalEnterpriceDB` ;

-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`activos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`activos` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`activos` (
  `act_id` INT NOT NULL AUTO_INCREMENT,
  `act_usuario` VARCHAR(25) NOT NULL,
  `act_nit` INT NOT NULL,
  `act_factura_id` INT NOT NULL,
  `act_estado` VARCHAR(25) NOT NULL,
  `act_nombre` VARCHAR(80) NOT NULL,
  `act_descripcion` VARCHAR(255) NULL,
  PRIMARY KEY (`act_id`),
  INDEX `FK_Activo_Provee_Proveedor` (`act_nit` ASC) VISIBLE,
  INDEX `FK_Activo_Registro_Usuario` (`act_usuario` ASC) VISIBLE,
  INDEX `FK_Activo_Vende_Factura` (`act_factura_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`act_nombre` ASC) VISIBLE,
  CONSTRAINT `FK_Activo_Provee_Proveedor`
    FOREIGN KEY (`act_nit`)
    REFERENCES `PrimalEnterpriceDB`.`proveedores` (`pve_nit`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Activo_Registro_Usuario`
    FOREIGN KEY (`act_usuario`)
    REFERENCES `PrimalEnterpriceDB`.`usuarios` (`usr_usuario`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Activo_Vende_Factura`
    FOREIGN KEY (`act_factura_id`)
    REFERENCES `PrimalEnterpriceDB`.`facturas` (`fac_id`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`factura_proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`factura_proveedor` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`factura_proveedor` (
  `fve_factura_id` INT NOT NULL,
  `fve_nit` INT NOT NULL,
  PRIMARY KEY (`fve_factura_id`, `fve_nit`),
  INDEX `FK_Factura_Registra_Proveedor` (`fve_nit` ASC) VISIBLE,
  CONSTRAINT `FK_Factura_Registra_Factura`
    FOREIGN KEY (`fve_factura_id`)
    REFERENCES `PrimalEnterpriceDB`.`facturas` (`fac_id`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Factura_Registra_Proveedor`
    FOREIGN KEY (`fve_nit`)
    REFERENCES `PrimalEnterpriceDB`.`proveedores` (`pve_nit`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`facturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`facturas` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`facturas` (
  `fac_id` INT NOT NULL AUTO_INCREMENT,
  `fac_usuario` VARCHAR(25) NOT NULL,
  `fac_valor` DOUBLE NOT NULL,
  `fac_fecha` DATE NOT NULL,
  `fac_tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`fac_id`),
  INDEX `FK_Factura_Registra_Usuario` (`fac_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Factura_Registra_Usuario`
    FOREIGN KEY (`fac_usuario`)
    REFERENCES `PrimalEnterpriceDB`.`usuarios` (`usr_usuario`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`produccion_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`produccion_producto` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`produccion_producto` (
  `prp_produccion_id` INT NOT NULL,
  `prp_producto_id` INT NOT NULL,
  PRIMARY KEY (`prp_produccion_id`, `prp_producto_id`),
  INDEX `FK_Produccion_Pertenece_Producto` (`prp_producto_id` ASC) VISIBLE,
  CONSTRAINT `FK_Produccion_Pertenece_Produccion`
    FOREIGN KEY (`prp_produccion_id`)
    REFERENCES `PrimalEnterpriceDB`.`producciones` (`prd_id`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Produccion_Pertenece_Producto`
    FOREIGN KEY (`prp_producto_id`)
    REFERENCES `PrimalEnterpriceDB`.`productos` (`pru_id`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`producciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`producciones` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`producciones` (
  `prd_id` INT NOT NULL AUTO_INCREMENT,
  `prd_usuario` VARCHAR(25) NOT NULL,
  `prd_estado` VARCHAR(25) NOT NULL,
  `prd_tipo` VARCHAR(20) NOT NULL,
  `prd_fecha_comienzo` DATE NULL DEFAULT NULL,
  `prd_fecha_finalizacion` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`prd_id`),
  INDEX `FK_Produccion_Registra_Usuario` (`prd_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Produccion_Registra_Usuario`
    FOREIGN KEY (`prd_usuario`)
    REFERENCES `PrimalEnterpriceDB`.`usuarios` (`usr_usuario`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`producto_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`producto_factura` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`producto_factura` (
  `pfa_factura_id` INT NOT NULL,
  `pfa_producto_id` INT NOT NULL,
  PRIMARY KEY (`pfa_factura_id`, `pfa_producto_id`),
  INDEX `FK_Producto_Registra_Producto` (`pfa_producto_id` ASC) VISIBLE,
  CONSTRAINT `FK_Producto_Registra_Factura`
    FOREIGN KEY (`pfa_factura_id`)
    REFERENCES `PrimalEnterpriceDB`.`facturas` (`fac_id`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Producto_Registra_Producto`
    FOREIGN KEY (`pfa_producto_id`)
    REFERENCES `PrimalEnterpriceDB`.`productos` (`pru_id`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`productos` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`productos` (
  `pru_id` INT NOT NULL AUTO_INCREMENT,
  `pru_usuario` VARCHAR(25) NOT NULL,
  `pru_nit` INT NOT NULL,
  `pru_marca` VARCHAR(80) NOT NULL,
  `pru_tipo` VARCHAR(20) NOT NULL,
  `pru_cantidad` INT NOT NULL DEFAULT 0,
  `pru_metodo_almacenamiento` VARCHAR(255) NOT NULL,
  `pru_lugar_almacenamiento` VARCHAR(255) NOT NULL,
  `pru_nombre` VARCHAR(80) NOT NULL,
  `pru_descripcion` VARCHAR(255) NOT NULL,
  `pru_fecha_caducidad` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`pru_id`),
  INDEX `FK_Producto_Provee_Proveedor` (`pru_nit` ASC) VISIBLE,
  INDEX `FK_Producto_Registra_Usuario` (`pru_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Producto_Provee_Proveedor`
    FOREIGN KEY (`pru_nit`)
    REFERENCES `PrimalEnterpriceDB`.`proveedores` (`pve_nit`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_Producto_Registra_Usuario`
    FOREIGN KEY (`pru_usuario`)
    REFERENCES `PrimalEnterpriceDB`.`usuarios` (`usr_usuario`)
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`proveedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`proveedores` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`proveedores` (
  `pve_nit` INT NOT NULL,
  `pve_usuario` VARCHAR(25) NOT NULL,
  `pve_telefono_id` INT NOT NULL,
  `pve_nombre` VARCHAR(80) NOT NULL,
  `pve_direccion` VARCHAR(100) NOT NULL,
  `pve_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`pve_nit`),
  INDEX `FK_Proveedor_Registra_Usuario` (`pve_usuario` ASC) VISIBLE,
  INDEX `fk_Proveedor_telefonos1_idx` (`pve_telefono_id` ASC) VISIBLE,
  CONSTRAINT `FK_Proveedor_Registra_Usuario`
    FOREIGN KEY (`pve_usuario`)
    REFERENCES `PrimalEnterpriceDB`.`usuarios` (`usr_usuario`)
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `fk_Proveedor_telefonos1`
    FOREIGN KEY (`pve_telefono_id`)
    REFERENCES `PrimalEnterpriceDB`.`telefonos` (`tel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`telefonos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`telefonos` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`telefonos` (
  `tel_id` INT NOT NULL AUTO_INCREMENT,
  `tel_telefono` INT NOT NULL,
  PRIMARY KEY (`tel_id`),
  UNIQUE INDEX `tel_telefono_UNIQUE` (`tel_telefono` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PrimalEnterpriceDB`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `PrimalEnterpriceDB`.`usuarios` (
  `usr_usuario` VARCHAR(25) NOT NULL,
  `usr_telefonos_id` INT NOT NULL,
  `usr_rango` VARCHAR(40) NOT NULL,
  `usr_contraseña` VARCHAR(40) NOT NULL,
  `usr_email` VARCHAR(100) NOT NULL,
  `usr_nombre` VARCHAR(80) NOT NULL,
  `usr_direccion` VARCHAR(100) NULL,
  `usr_cedula` INT NULL,
  PRIMARY KEY (`usr_usuario`),
  INDEX `fk_usuarios_telefonos1_idx` (`usr_telefonos_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_telefonos1`
    FOREIGN KEY (`usr_telefonos_id`)
    REFERENCES `PrimalEnterpriceDB`.`telefonos` (`tel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`vw_getProductions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`vw_getProductions`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`vw_getProductions` ;
USE `PrimalEnterpriceDB`;
CREATE  OR REPLACE VIEW vw_getProductions AS SELECT
	prd_id AS id,
    prd_estado AS estado,
    prd_fecha_comienzo AS fecha_comienzo,
    prd_fecha_finalizacion AS fecha_finalizacion,
    prd_tipo AS tipo
FROM producciones;

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`vw_getUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`vw_getUsers`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`vw_getUsers` ;
USE `PrimalEnterpriceDB`;
CREATE  OR REPLACE VIEW vw_getUsers AS SELECT 
	usr_usuario AS usuario,
    usr_telefonos_id AS telefono_id,
    usr_contraseña AS contraseña,
    usr_Rango AS rango,
    usr_nombre AS nombre,
	usr_cedula AS cedula,
    usr_email AS email,
    usr_direccion AS direccion
FROM usuarios;

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`vw_getProducts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`vw_getProducts`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`vw_getProducts` ;
USE `PrimalEnterpriceDB`;
CREATE  OR REPLACE VIEW vw_getProducts AS SELECT
	pru_id AS id,
    pru_usuario AS usuario,
    pru_nit AS nit,
    pru_nombre AS nombre,
    pru_marca AS marca,
    pru_tipo AS tipo,
    pru_cantidad AS cantidad,
    pru_metodo_almacenamiento AS metodo_almacenaje,
    pru_lugar_almacenamiento AS ubicacion,
    pru_descripcion AS descripcion,
    pru_fecha_caducidad AS fecha_caducidad
FROM productos;

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`vw_getProviders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`vw_getProviders`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`vw_getProviders` ;
USE `PrimalEnterpriceDB`;
CREATE  OR REPLACE VIEW vw_getProviders AS SELECT
	pve_nit AS nit,
    pve_usuario AS usuario,
    pve_telefono_id AS telefono_id,
    pve_nombre AS nombre,
    pve_email AS email,
    pve_direccion AS direccion
FROM proveedores;

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`vw_getActives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`vw_getActives`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`vw_getActives` ;
USE `PrimalEnterpriceDB`;
CREATE  OR REPLACE VIEW vw_getActives AS SELECT
	act_id AS id,
    act_nit AS nit,
    act_factura_id AS factura,
    act_nombre AS nombre,
    act_estado AS estado,
    act_descripcion AS descripcion
FROM activos;


-- -----------------------------------------------------
-- procedure userList
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`userList`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE userList(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getUsers WHERE CASE paramether
		WHEN 'cedula' THEN
			cedula = search
		WHEN 'celular' THEN
			celular = search
		WHEN 'email' THEN
			email = search
		WHEN 'dirección' THEN
			direccion = search
		WHEN 'nombre' THEN
			nombre = search
		ELSE
			usuario IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure productList
-- -----------------------------------------------------

DROP procedure IF EXISTS `PrimalEnterpriceDB`.`productList`;

DELIMITER $$
CREATE PROCEDURE productList(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getProducts WHERE CASE paramether
		WHEN 'nombre' THEN
			nombre = search
		WHEN 'marca' THEN
			marca = search
		WHEN 'tipo' THEN
			tipo = search
		WHEN 'cantidad' THEN
			cantidad = search
		WHEN 'ubicacion' THEN
			ubicacion <= search
		WHEN 'nit' THEN
			nit = search
		ELSE
			id IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure providerList
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`providerList`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE providerList(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getProviders WHERE CASE paramether
		WHEN 'nombre' THEN
			nombre = search
		WHEN 'email' THEN
			email = search
		WHEN 'direccion' THEN
			direccion = search
		WHEN 'telefono' THEN
			telefono = search
		WHEN 'nit' THEN
			nit = search
		ELSE
			nit IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure activesList
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`activesList`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE activesList(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getActives WHERE CASE paramether
		WHEN 'nombre' THEN
			nombre = search
		WHEN 'estado' THEN
			estado = search
		WHEN 'nit' THEN
			nit = search
		WHEN 'factura' THEN
			factura = search
		ELSE
			id IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure productionsList
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`productionsList`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE productionsList(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getProductions WHERE CASE paramether
		WHEN 'estado' THEN
			estado = search
		WHEN 'fecha_comienzo' THEN
			fecha_comienzo = search
		WHEN 'fecha_finalizacion' THEN
			fecha_finalizacion = search
		WHEN 'tipo' THEN
			tipo = search
		ELSE
			id IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure login
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`login`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE login(
	in username varchar(45),
    in userPass varchar(45)
)
BEGIN
	DECLARE valor INT;
    DECLARE pass varchar(40);
    
    SELECT COUNT(*) INTO valor FROM vw_getUsers WHERE usuario = username;
    
	IF valor = 0 THEN
		SELECT 0 AS 'error';
	ELSEIF valor = 1 THEN
		select SHA1(userPass) INTO pass;
        
        IF (SELECT COUNT(*) FROM vw_getUsers WHERE usuario = username AND contraseña = pass) = 0 THEN
			select 1 AS 'error';
		ELSE
			SELECT 
            2 AS 'error',
            NOMBRE_USUARIO AS nombre,
            RANGO AS rango
            FROM vw_getUsers WHERE usuario = username AND contraseña = pass;
        END IF;
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- Stored Procedure 'InsertarUsr' for creating new Users
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS InsertarUsr;
DELIMITER |

CREATE PROCEDURE InsertarUsr 
(IN nombreUsr VARCHAR(45), 
IN numCed int, 
IN rang VARCHAR(255),
IN Contr VARCHAR(45),
IN Num_Cel int,
IN Email_Usr VARCHAR(255),
IN Direcc_Casa VARCHAR(255),
IN Usr VARCHAR(255))

BEGIN
	INSERT INTO usuario VALUES (Usr,numCed,rang,Contr,Num_Cel,Email_Usr,Direcc_Casa,nombreUsr);  
END|
DELIMITER ;


-- -----------------------------------------------------
-- Stored Procedure 'InsertarProv' for creating new providers
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS InsertarProv;
DELIMITER |

CREATE PROCEDURE InsertarProv 
(IN nombreProv VARCHAR(255), 
IN Nit_num int,IN Num_tel int,
IN Email_Prov VARCHAR(255),
IN Direcc_Tie VARCHAR(255),
IN Usr VARCHAR(255))

BEGIN
	INSERT INTO proveedor VALUES (Nit_num,Usr,nombreProv,Direcc_Tie,Num_tel,Email_Prov);  
END|
DELIMITER ;


-- -----------------------------------------------------
-- Stored Procedure 'Busq_Rol' for filtering by Rol
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS Busq_Rol;
DELIMITER |

CREATE PROCEDURE Busq_Rol 
(IN rang VARCHAR(255) )
BEGIN
	SELECT * FROM usuario WHERE RANGO=rang;
END|
DELIMITER ;


-- -----------------------------------------------------
-- Stored Procedure 'Busq_Individual' for view each user individually
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS Busq_Individual;
DELIMITER |

CREATE PROCEDURE Busq_Individual 
(IN Usr VARCHAR(255) )
BEGIN
	SELECT * FROM usuario WHERE USUARIO=Usr;
END|
DELIMITER ;


-- -----------------------------------------------------
-- Stored Procedure 'eliminar_usr' for delete users Individually
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS eliminar_usr;
DELIMITER |

CREATE PROCEDURE eliminar_usr 
(IN Usr varchar(255) )
BEGIN
	delete from usuario
    where USUARIO=Usr;
END|
DELIMITER ;


-- -----------------------------------------------------
-- Stored Procedure 'disminucion_inventario' for update products Individually
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS disminucion_inventario;
DELIMITER |

CREATE PROCEDURE disminucion_inventario 
(IN Num_items int,
IN ID_item int )
BEGIN
	DECLARE inventario int DEFAULT 0;
	select CANTIDAD 
    into inventario
    from producto
    where ID_item=producto.ID;
    if inventario-Num_items>=0 then
    update producto set CANTIDAD = inventario-Num_items
    where ID_item=producto.ID;
    end if;
    
END|
DELIMITER ;

SET SQL_MODE = '';
DROP USER IF EXISTS Admin;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'Admin' IDENTIFIED BY 'HTNT^256FbzNNO6eInk$';

GRANT ALL ON `PrimalEnterpriceDB`.* TO 'Admin';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;