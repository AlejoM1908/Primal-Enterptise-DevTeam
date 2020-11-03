SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PrimalEnterpriceDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PrimalEnterpriceDB` ;

CREATE SCHEMA IF NOT EXISTS `PrimalEnterpriceDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
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
  `usr_contrasena` VARCHAR(40) NOT NULL,
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
    usr_contrasena AS contrasena,
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
        
        IF (SELECT COUNT(*) FROM vw_getUsers WHERE usuario = username AND contrasena = pass) = 0 THEN
			select 1 AS 'error';
		ELSE
			SELECT 
            2 AS 'error',
            NOMBRE_USUARIO AS nombre,
            RANGO AS rango
            FROM vw_getUsers WHERE usuario = username AND contrasena = pass;
        END IF;
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure registrarActivo
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`registrarActivo`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `registrarActivo`(
	`p_id` INT,
    `p_usuario` VARCHAR(25),
    `p_nit` INT,
    `p_idFactura` INT,
    `p_descripcion` VARCHAR(255),
	`p_estado` VARCHAR(255),
    `p_nombre` VARCHAR(255)
)
BEGIN
	INSERT INTO activo
    VALUES(p_id,p_usuario,p_nit,p_idFactura,p_descripcion,p_estado,p_nombre);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure registrarProducto
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`registrarProducto`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `registrarProducto`(
	`p_id` INT,
    `p_usuario` VARCHAR(255),
    `p_nit` VARCHAR(255),
    `p_marca` VARCHAR(255),
    `p_tipo` VARCHAR(255),
    `p_cantidad` INT,
    `p_metodoAlm` VARCHAR(255),
    `p_lugarAlm` VARCHAR(255),
    `p_fechaCad` DATE,
    `p_nombre` VARCHAR(255),
    `p_descripcion` VARCHAR(255)
)
BEGIN
	INSERT INTO producto
    VALUES(p_id,p_usuario,p_nit,p_marca,p_tipo,p_cantidad,p_metodoAlm,p_lugarAlm,p_fechaCad,p_nombre,p_descripcion);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure buscarActivo
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`buscarActivo`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `buscarActivo`(
	`p_busqueda` VARCHAR(255),
    `p_atributo` VARCHAR(255)
)
BEGIN
	IF `p_atributo` = "nombre" THEN
		SELECT nombre_activo, descripcion_activo, estado_activo
		FROM activo
		WHERE nombre_activo LIKE CONCAT('%', `p_busqueda`, '%');
	ELSEIF `p_atributo` = "descripcion" THEN
		SELECT nombre_activo, descripcion_activo, estado_activo
		FROM activo
		WHERE descripcion_activo LIKE CONCAT('%', `p_busqueda`, '%');
	ELSEIF `p_atributo` = "estado" THEN
		SELECT nombre_activo, descripcion_activo, estado_activo
		FROM activo
		WHERE estado_activo LIKE CONCAT('%', `p_busqueda`, '%');
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure verInfoActivo
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`verInfoActivo`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `verInfoActivo`(
	`p_id` INT
)
BEGIN
	SELECT nombre_activo,descripcion_activo,estado_activo,fecha AS fecha_compra
    FROM activo NATURAL JOIN factura
    WHERE id_activo = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure verInfoProducto
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`verInfoProducto`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `verInfoProducto`(
	`p_id` INT
)
BEGIN
	SELECT nombre_producto,descripcion_producto,tipo_producto,cantidad,metodo_almacenamiento,lugar_almacenamiento,fecha_caducidad,fecha AS fecha_compra
    FROM producto NATURAL JOIN producto_factura NATURAL JOIN factura
    WHERE id = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure buscarProducto
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`buscarProducto`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `buscarProducto`(
	`p_busqueda` VARCHAR(255),
    `p_atributo` VARCHAR(255)
)
BEGIN
	IF `p_atributo` = "nombre" THEN
		SELECT nombre_producto,tipo_producto,cantidad,nombre_proveedor
		FROM producto NATURAL JOIN proveedor
		WHERE nombre_producto LIKE CONCAT('%', `p_busqueda`, '%');
	ELSEIF `p_atributo` = "tipo" THEN
		SELECT nombre_producto,tipo_producto,cantidad,nombre_proveedor
		FROM producto NATURAL JOIN proveedor
		WHERE tipo_producto LIKE CONCAT('%', `p_busqueda`, '%');
	ELSEIF `p_atributo` = "nombre proveedor" THEN
		SELECT nombre_producto,tipo_producto,cantidad,nombre_proveedor
		FROM producto NATURAL JOIN proveedor
		WHERE nombre_proveedor LIKE CONCAT('%', `p_busqueda`, '%');
    END IF;	
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure editarDatosUsuario
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`editar_datos_usuario`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `editar_datos_usuario`(
	`contrasena_nueva` VARCHAR(25),
    `email` VARCHAR(255),
    `telefono` INT,
    `nombre` VARCHAR(255),
    `usuario_actual` VARCHAR(255)
)
BEGIN
	UPDATE usuario
    SET nombre_usuario = `nombre`, contrasena = sha1(`contrasena_nueva`), email_usuario = `email`, numero_cel = `telefono`
    WHERE usuario = `usuario_actual`;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure verificarDatosRepetidosUsuario
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`verificarDatosRepetidosUsuario`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `verificarDatosRepetidosUsuario`(
	`p_usuario` VARCHAR(25),
    `p_cedula` INT,
    `p_email` VARCHAR(25)
)
BEGIN
	SELECT *
    FROM usuario
    WHERE usuario.usuario = p_usuario OR usuario.cedula = p_cedula OR usuario.email_usuario = p_email;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure verificarInicioSesion
-- -----------------------------------------------------

USE `PrimalEnterpriceDB`;
DROP procedure IF EXISTS `PrimalEnterpriceDB`.`verificarInicioSesion`;

DELIMITER $$
USE `PrimalEnterpriceDB`$$
CREATE PROCEDURE `verificarInicioSesion`(
	`p_usuario` VARCHAR(25),
    `p_contrasena` VARCHAR(25)
)
BEGIN
	SELECT *
    FROM usuario
    WHERE usuario.usuario = p_usuario AND usuario.contrasena = p_contrasena;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`productos_baja_cantidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`productos_baja_cantidad`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`productos_baja_cantidad` ;
USE `PrimalEnterpriceDB`;
CREATE OR REPLACE VIEW `productos_baja_cantidad` AS 
SELECT `productos`.`pru_nombre` AS `nombre_producto`,`productos`.`pru_cantidad` AS `cantidad`,`productos`.`pru_id` AS `id` 
FROM `productos` 
WHERE (`productos`.`pru_cantidad` <= 5);

-- -----------------------------------------------------
-- View `PrimalEnterpriceDB`.`productos_por_vencer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PrimalEnterpriceDB`.`productos_por_vencer`;
DROP VIEW IF EXISTS `PrimalEnterpriceDB`.`productos_por_vencer` ;
USE `PrimalEnterpriceDB`;
CREATE OR REPLACE VIEW `productos_por_vencer` AS 
SELECT `productos`.`pru_nombre` AS `nombre_producto`,`productos`.`pru_id` AS `id`,`productos`.`pru_fecha_caducidad` AS `fecha_caducidad`,(to_days(`productos`.`pru_fecha_caducidad`) - to_days(now())) AS `diff` 
FROM `productos` 
WHERE (((to_days(`productos`.`pru_fecha_caducidad`) - to_days(now())) < 5) and (`productos`.`pru_fecha_caducidad` is not null)) 
ORDER BY (to_days(`productos`.`pru_fecha_caducidad`) - to_days(now()));

SET SQL_MODE = '';
DROP USER IF EXISTS Admin;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'Admin' IDENTIFIED BY 'HTNT^256FbzNNO6eInk$';

GRANT ALL ON `PrimalEnterpriceDB`.* TO 'Admin';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
