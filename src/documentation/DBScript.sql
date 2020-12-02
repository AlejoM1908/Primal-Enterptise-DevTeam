-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `primalenterpricedb` DEFAULT CHARACTER SET utf8 ;
USE `primalenterpricedb` ;

-- -----------------------------------------------------
-- Table `primalenterpricedb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`usuarios` (
  `usr_usuario` VARCHAR(25) NOT NULL,
  `usr_rango` VARCHAR(40) NOT NULL,
  `usr_contrasena` VARCHAR(40) NOT NULL,
  `usr_email` VARCHAR(100) NOT NULL,
  `usr_nombre` VARCHAR(80) NOT NULL,
  `usr_direccion` VARCHAR(100) NULL DEFAULT NULL,
  `usr_cedula` INT NULL DEFAULT NULL,
  `usr_estado` INT NOT NULL,
  PRIMARY KEY (`usr_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`proveedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`proveedores` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`proveedores` (
  `pve_nit` INT NOT NULL,
  `pve_usuario` VARCHAR(25) NOT NULL,
  `pve_nombre` VARCHAR(80) NOT NULL,
  `pve_direccion` VARCHAR(100) NOT NULL,
  `pve_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`pve_nit`),
  INDEX `FK_Proveedor_Registra_Usuario` (`pve_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Proveedor_Registra_Usuario`
    FOREIGN KEY (`pve_usuario`)
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`facturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`facturas` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`facturas` (
  `fac_id` INT NOT NULL AUTO_INCREMENT,
  `fac_usuario` VARCHAR(25) NOT NULL,
  `fac_valor` DOUBLE NOT NULL,
  `fac_fecha` DATE NOT NULL,
  `fac_tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`fac_id`),
  INDEX `FK_Factura_Registra_Usuario` (`fac_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Factura_Registra_Usuario`
    FOREIGN KEY (`fac_usuario`)
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`activos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`activos` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`activos` (
  `act_id` INT NOT NULL AUTO_INCREMENT,
  `act_usuario` VARCHAR(25) NOT NULL,
  `act_nit` INT NOT NULL,
  `act_factura_id` INT NOT NULL,
  `act_estado` VARCHAR(25) NOT NULL,
  `act_nombre` VARCHAR(80) NOT NULL,
  `act_descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `act_marca` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`act_id`),
  UNIQUE INDEX `Nombre_UNIQUE` (`act_nombre` ASC) VISIBLE,
  INDEX `FK_Activo_Provee_Proveedor` (`act_nit` ASC) VISIBLE,
  INDEX `FK_Activo_Registro_Usuario` (`act_usuario` ASC) VISIBLE,
  INDEX `FK_Activo_Vende_Factura` (`act_factura_id` ASC) VISIBLE,
  CONSTRAINT `FK_Activo_Provee_Proveedor`
    FOREIGN KEY (`act_nit`)
    REFERENCES `primalenterpricedb`.`proveedores` (`pve_nit`)
    ON UPDATE CASCADE,
  CONSTRAINT `FK_Activo_Registro_Usuario`
    FOREIGN KEY (`act_usuario`)
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_Activo_Vende_Factura`
    FOREIGN KEY (`act_factura_id`)
    REFERENCES `primalenterpricedb`.`facturas` (`fac_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`factura_proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`factura_proveedor` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`factura_proveedor` (
  `fve_factura_id` INT NOT NULL,
  `fve_nit` INT NOT NULL,
  PRIMARY KEY (`fve_factura_id`, `fve_nit`),
  INDEX `FK_Factura_Registra_Proveedor` (`fve_nit` ASC) VISIBLE,
  CONSTRAINT `FK_Factura_Registra_Factura`
    FOREIGN KEY (`fve_factura_id`)
    REFERENCES `primalenterpricedb`.`facturas` (`fac_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_Factura_Registra_Proveedor`
    FOREIGN KEY (`fve_nit`)
    REFERENCES `primalenterpricedb`.`proveedores` (`pve_nit`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`producciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`producciones` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`producciones` (
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
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`productos` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`productos` (
  `pru_id` INT NOT NULL AUTO_INCREMENT,
  `pru_usuario` VARCHAR(25) NOT NULL,
  `pru_nit` INT NOT NULL,
  `pru_marca` VARCHAR(80) NOT NULL,
  `pru_tipo` VARCHAR(20) NOT NULL,
  `pru_cantidad` INT NOT NULL DEFAULT '0',
  `pru_metodo_almacenamiento` VARCHAR(255) NOT NULL,
  `pru_lugar_almacenamiento` VARCHAR(255) NOT NULL,
  `pru_nombre` VARCHAR(80) NOT NULL,
  `pru_descripcion` VARCHAR(255) NOT NULL,
  `pru_fecha_caducidad` DATE NULL DEFAULT NULL,
  `pru_estado` INT NOT NULL,
  PRIMARY KEY (`pru_id`),
  INDEX `FK_Producto_Provee_Proveedor` (`pru_nit` ASC) VISIBLE,
  INDEX `FK_Producto_Registra_Usuario` (`pru_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_Producto_Provee_Proveedor`
    FOREIGN KEY (`pru_nit`)
    REFERENCES `primalenterpricedb`.`proveedores` (`pve_nit`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_Producto_Registra_Usuario`
    FOREIGN KEY (`pru_usuario`)
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`produccion_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`produccion_producto` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`produccion_producto` (
  `prp_produccion_id` INT NOT NULL,
  `prp_producto_id` INT NOT NULL,
  `prp_cantidad_producto` INT NOT NULL,
  PRIMARY KEY (`prp_produccion_id`, `prp_producto_id`),
  INDEX `FK_Produccion_Pertenece_Producto` (`prp_producto_id` ASC) VISIBLE,
  CONSTRAINT `FK_Produccion_Pertenece_Produccion`
    FOREIGN KEY (`prp_produccion_id`)
    REFERENCES `primalenterpricedb`.`producciones` (`prd_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `FK_Produccion_Pertenece_Producto`
    FOREIGN KEY (`prp_producto_id`)
    REFERENCES `primalenterpricedb`.`productos` (`pru_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`producto_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`producto_factura` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`producto_factura` (
  `pfa_factura_id` INT NOT NULL,
  `pfa_producto_id` INT NOT NULL,
  PRIMARY KEY (`pfa_factura_id`, `pfa_producto_id`),
  INDEX `FK_Producto_Registra_Producto` (`pfa_producto_id` ASC) VISIBLE,
  CONSTRAINT `FK_Producto_Registra_Factura`
    FOREIGN KEY (`pfa_factura_id`)
    REFERENCES `primalenterpricedb`.`facturas` (`fac_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_Producto_Registra_Producto`
    FOREIGN KEY (`pfa_producto_id`)
    REFERENCES `primalenterpricedb`.`productos` (`pru_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `primalenterpricedb`.`telefonos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`telefonos` ;

CREATE TABLE IF NOT EXISTS `primalenterpricedb`.`telefonos` (
  `tel_id` INT NOT NULL AUTO_INCREMENT,
  `tel_usuario` VARCHAR(25) NULL DEFAULT NULL,
  `tel_proveedor` INT NULL DEFAULT NULL,
  `tel_telefono` INT NOT NULL,
  PRIMARY KEY (`tel_id`),
  UNIQUE INDEX `tel_telefono_UNIQUE` (`tel_telefono` ASC) VISIBLE,
  INDEX `fk_telefonos_usuarios1_idx` (`tel_usuario` ASC) VISIBLE,
  INDEX `fk_telefonos_proveedores1_idx` (`tel_proveedor` ASC) VISIBLE,
  CONSTRAINT `fk_telefonos_proveedores1`
    FOREIGN KEY (`tel_proveedor`)
    REFERENCES `primalenterpricedb`.`proveedores` (`pve_nit`),
  CONSTRAINT `fk_telefonos_usuarios1`
    FOREIGN KEY (`tel_usuario`)
    REFERENCES `primalenterpricedb`.`usuarios` (`usr_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

# J1$9P!a6
INSERT INTO `PrimalEnterpriceDB`.`usuarios` 
VALUE("Admin","admin","b69948501d89b5aff7726b649a27264bcd139dc1","None","Admin","None",0,1);

-- -----------------------------------------------------
-- procedure ActiveInfo
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`ActiveInfo`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActiveInfo`(
	IN activeId INT
)
BEGIN
	SELECT nombre,descripcion,estado,fecha_factura AS fecha_compra
    FROM vw_getActives
    WHERE id = activeId;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure activesList
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`activesList`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `activesList`(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT nit, nombre, estado, marca, descripcion
    FROM vw_getActives WHERE CASE paramether
		WHEN 'nombre' THEN
			nombre LIKE CONCAT('%',search,'%')
		WHEN 'estado' THEN
			estado LIKE CONCAT('%',search,'%')
		WHEN 'nit' THEN
			nit = search
		WHEN 'marca' THEN
			marca LIKE CONCAT('%',search,'%')
		WHEN 'factura' THEN
			factura = search
		WHEN 'descripcion' THEN
			descripcion LIKE CONCAT('%',search,'%')
		ELSE
			id IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure decreaceInventory
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`decreaceInventory`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `decreaceInventory`(
	IN Num_items INT,
	IN ID_item INT
)
BEGIN
    DECLARE inventario INT DEFAULT 0;  
    SELECT pru_cantidad
    INTO inventario
    FROM productos
    WHERE pru_id = ID_item;
    IF (inventario - Num_items) >= 0 THEN
    UPDATE productos SET pru_cantidad = (inventario - Num_items)
    WHERE pru_id = ID_item;
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure deleteUser
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`deleteUser`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser`(
	IN userName varchar(25)
)
BEGIN
	UPDATE usuarios
    SET usr_estado = 3
    WHERE usr_usuario = userName;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure editUserData
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`editUserData`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `editUserData`(
	IN contrasena_nueva VARCHAR(25),
    IN email VARCHAR(100),
    IN telefono INT,
    IN nombre VARCHAR(80),
    IN usuario_actual VARCHAR(25)
)
BEGIN
	UPDATE usuarios JOIN telefonos
    SET usr_nombre = nombre, usr_contrasena = SHA1(contrasena_nueva), usr_email = email, tel_telefono = telefono
    WHERE usr_usuario = usuario_actual AND tel_usuario = usr_usuario;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insertProvider
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`insertProvider`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProvider`(
	IN nombre VARCHAR(80), 
	IN nit INT,
	IN telefono INT,
	IN email VARCHAR(100),
	IN direccion VARCHAR(100),
	IN usuario VARCHAR(25)
)
BEGIN
    INSERT INTO telefonos VALUES (NULL,NULL,nit,telefono);
	INSERT INTO proveedores VALUES (nit,usuario,nombre,direccion,email);  
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insertUser
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`insertUser`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUser`(
	IN nombre VARCHAR(80), 
	IN cedula int, 
	IN rango VARCHAR(40),
	IN contrasena VARCHAR(25),
	IN telefono int,
	IN email VARCHAR(100),
	IN direccion VARCHAR(100),
	IN usuario VARCHAR(25)
)
BEGIN
	DECLARE pass VARCHAR(40);
    INSERT INTO telefonos VALUES (NULL,usuario,NULL,telefono);
	SET pass = SHA1(contrasena);
    INSERT INTO usuarios VALUES (usuario,rango,contrasena,email,nombre,direccion,cedula,1);  
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure login
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`login`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(
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
		SELECT SHA1(userPass) INTO pass;
        
        IF (SELECT COUNT(*) FROM vw_getUsers WHERE usuario = username AND contrasena = pass) = 0 THEN
			select 1 AS 'error';
		ELSE
			SELECT 
            2 AS 'error',
            usuario,
            rango,
            contrasena,
            telefono,
            email,
            direccion,
            nombre
            FROM vw_getUsers WHERE usuario = username AND contrasena = pass;
        END IF;
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure productInfo
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`productInfo`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `productInfo`(
	IN productId INT
)
BEGIN
	SELECT nombre,descripcion,tipo,cantidad,metodo_almacenamiento,lugar_almacenamiento,fecha_caducidad,fecha_factura AS fecha_compra
    FROM vw_getProduct WHERE id = productId;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure productList
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`productList`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `productList`(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getProducts WHERE CASE paramether
		WHEN 'nombre' THEN
			nombre LIKE CONCAT('%',search,'%')
		WHEN 'nombre_proveedor' THEN
			nombre_proveedor LIKE CONCAT('%',search,'%')
		WHEN 'marca' THEN
			marca LIKE CONCAT('%',search,'%')
		WHEN 'tipo' THEN
			tipo = search
		WHEN 'cantidad' THEN
			cantidad = search
		WHEN 'ubicacion' THEN
			ubicacion LIKE CONCAT('%',search,'%')
		WHEN 'nit' THEN
			nit = search
		ELSE
			id IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure productionsList
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`productionsList`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `productionsList`(
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
-- procedure providerList
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`providerList`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `providerList`(
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
-- procedure registerActive
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`registerActive`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `registerActive`(
	IN id INT,
    IN usuario VARCHAR(25),
    IN nit INT,
    IN id_factura INT,
    IN descripcion VARCHAR(255),
	IN estado VARCHAR(25),
    IN nombre VARCHAR(80)
)
BEGIN
	INSERT INTO activos
    VALUES(id,usuario,nit,id_factura,estado,nombre,descripcion);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure registerProduct
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`registerProduct`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `registerProduct`(
	IN id INT,
    IN usuario VARCHAR(25),
    IN nit INT,
    IN marca VARCHAR(80),
    IN tipo VARCHAR(20),
    IN cantidad INT,
    IN metodo_almacenamiento VARCHAR(255),
    IN lugar_almacenamiento VARCHAR(255),
    IN fecha_caducidad DATE,
    IN nombre VARCHAR(80),
    IN descripcion VARCHAR(255)
)
BEGIN
	INSERT INTO productos
    VALUES(id,usuario,nit,marca,tipo,cantidad,metodo_almacenamiento,lugar_almacenamiento,nombre,descripcion,fecha_caducidad,1);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure userList
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`userList`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `userList`(
	IN paramether VARCHAR(45),
    IN search VARCHAR(100)
)
BEGIN
	SELECT * FROM vw_getUsers WHERE CASE paramether
		WHEN 'cedula' THEN
			cedula = search
		WHEN 'telefono' THEN
			telefono = search
		WHEN 'email' THEN
			email = search
		WHEN 'dirección' THEN
			direccion = search
		WHEN 'rango' THEN
			rango = search
		WHEN 'nombre' THEN
			nombre = search
		WHEN 'usuario' THEN
			usuario = search
		ELSE
			usuario IS NOT NULL
		END;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure verifyRepeatedUserData
-- -----------------------------------------------------

USE `primalenterpricedb`;
DROP procedure IF EXISTS `primalenterpricedb`.`verifyRepeatedUserData`;

DELIMITER $$
USE `primalenterpricedb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `verifyRepeatedUserData`(
	IN userName VARCHAR(25),
    IN numCedula INT,
    IN UsrEmail VARCHAR(25)
)
BEGIN
	SELECT *
    FROM vw_getUsers
    WHERE usuario = userName OR cedula = numCedula OR email = usrEmail;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- View `primalenterpricedb`.`productlowamount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`productlowamount`;
DROP VIEW IF EXISTS `primalenterpricedb`.`productlowamount` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`productlowamount` AS select `primalenterpricedb`.`productos`.`pru_nombre` AS `nombre`,`primalenterpricedb`.`productos`.`pru_cantidad` AS `cantidad`,`primalenterpricedb`.`productos`.`pru_id` AS `id` from `primalenterpricedb`.`productos` where ((`primalenterpricedb`.`productos`.`pru_cantidad` <= 5) and (`primalenterpricedb`.`productos`.`pru_estado` <> 2));

-- -----------------------------------------------------
-- View `primalenterpricedb`.`productstoexpire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`productstoexpire`;
DROP VIEW IF EXISTS `primalenterpricedb`.`productstoexpire` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`productstoexpire` AS select `primalenterpricedb`.`productos`.`pru_nombre` AS `nombre`,`primalenterpricedb`.`productos`.`pru_id` AS `id`,`primalenterpricedb`.`productos`.`pru_fecha_caducidad` AS `fecha_caducidad`,(to_days(`primalenterpricedb`.`productos`.`pru_fecha_caducidad`) - to_days(now())) AS `diff` from `primalenterpricedb`.`productos` where (((to_days(`primalenterpricedb`.`productos`.`pru_fecha_caducidad`) - to_days(now())) < 5) and (`primalenterpricedb`.`productos`.`pru_fecha_caducidad` is not null) and (`primalenterpricedb`.`productos`.`pru_estado` <> 2)) order by (to_days(`primalenterpricedb`.`productos`.`pru_fecha_caducidad`) - to_days(now()));

-- -----------------------------------------------------
-- View `primalenterpricedb`.`vw_getactives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`vw_getactives`;
DROP VIEW IF EXISTS `primalenterpricedb`.`vw_getactives` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`vw_getactives` AS select `primalenterpricedb`.`activos`.`act_id` AS `id`,`primalenterpricedb`.`activos`.`act_nit` AS `nit`,`primalenterpricedb`.`activos`.`act_factura_id` AS `factura`,`primalenterpricedb`.`activos`.`act_nombre` AS `nombre`,`primalenterpricedb`.`activos`.`act_estado` AS `estado`,`primalenterpricedb`.`activos`.`act_marca` AS `marca`,`primalenterpricedb`.`facturas`.`fac_fecha` AS `fecha_factura`,`primalenterpricedb`.`activos`.`act_descripcion` AS `descripcion` from (`primalenterpricedb`.`activos` left join `primalenterpricedb`.`facturas` on((`primalenterpricedb`.`activos`.`act_factura_id` = `primalenterpricedb`.`facturas`.`fac_id`)));

-- -----------------------------------------------------
-- View `primalenterpricedb`.`vw_getproductions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`vw_getproductions`;
DROP VIEW IF EXISTS `primalenterpricedb`.`vw_getproductions` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`vw_getproductions` AS select `primalenterpricedb`.`producciones`.`prd_id` AS `id`,`primalenterpricedb`.`producciones`.`prd_usuario` AS `usuario`,`primalenterpricedb`.`producciones`.`prd_estado` AS `estado`,`primalenterpricedb`.`producciones`.`prd_fecha_comienzo` AS `fecha_comienzo`,`primalenterpricedb`.`producciones`.`prd_fecha_finalizacion` AS `fecha_finalizacion`,`primalenterpricedb`.`producciones`.`prd_tipo` AS `tipo` from `primalenterpricedb`.`producciones`;

-- -----------------------------------------------------
-- View `primalenterpricedb`.`vw_getproducts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`vw_getproducts`;
DROP VIEW IF EXISTS `primalenterpricedb`.`vw_getproducts` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`vw_getproducts` AS select `primalenterpricedb`.`productos`.`pru_id` AS `id`,`primalenterpricedb`.`productos`.`pru_usuario` AS `usuario`,`primalenterpricedb`.`productos`.`pru_nit` AS `nit`,`primalenterpricedb`.`proveedores`.`pve_nombre` AS `nombre_proveedor`,`primalenterpricedb`.`productos`.`pru_nombre` AS `nombre`,`primalenterpricedb`.`productos`.`pru_marca` AS `marca`,`primalenterpricedb`.`productos`.`pru_tipo` AS `tipo`,`primalenterpricedb`.`productos`.`pru_cantidad` AS `cantidad`,`primalenterpricedb`.`productos`.`pru_metodo_almacenamiento` AS `metodo_almacenaje`,`primalenterpricedb`.`productos`.`pru_lugar_almacenamiento` AS `ubicacion`,`primalenterpricedb`.`productos`.`pru_descripcion` AS `descripcion`,`primalenterpricedb`.`facturas`.`fac_fecha` AS `fecha_factura`,`primalenterpricedb`.`productos`.`pru_fecha_caducidad` AS `fecha_caducidad` from (((`primalenterpricedb`.`productos` left join `primalenterpricedb`.`proveedores` on((`primalenterpricedb`.`productos`.`pru_nit` = `primalenterpricedb`.`proveedores`.`pve_nit`))) left join `primalenterpricedb`.`producto_factura` on((`primalenterpricedb`.`productos`.`pru_id` = `primalenterpricedb`.`producto_factura`.`pfa_producto_id`))) left join `primalenterpricedb`.`facturas` on((`primalenterpricedb`.`producto_factura`.`pfa_factura_id` = `primalenterpricedb`.`facturas`.`fac_id`)));

-- -----------------------------------------------------
-- View `primalenterpricedb`.`vw_getproviders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`vw_getproviders`;
DROP VIEW IF EXISTS `primalenterpricedb`.`vw_getproviders` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`vw_getproviders` AS select `primalenterpricedb`.`proveedores`.`pve_nit` AS `nit`,`primalenterpricedb`.`telefonos`.`tel_telefono` AS `telefono`,`primalenterpricedb`.`proveedores`.`pve_nombre` AS `nombre`,`primalenterpricedb`.`proveedores`.`pve_email` AS `email`,`primalenterpricedb`.`proveedores`.`pve_direccion` AS `direccion` from (`primalenterpricedb`.`proveedores` join `primalenterpricedb`.`telefonos`) where (`primalenterpricedb`.`telefonos`.`tel_proveedor` = `primalenterpricedb`.`proveedores`.`pve_nit`);

-- -----------------------------------------------------
-- View `primalenterpricedb`.`vw_getusers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primalenterpricedb`.`vw_getusers`;
DROP VIEW IF EXISTS `primalenterpricedb`.`vw_getusers` ;
USE `primalenterpricedb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primalenterpricedb`.`vw_getusers` AS select `primalenterpricedb`.`usuarios`.`usr_usuario` AS `usuario`,`primalenterpricedb`.`telefonos`.`tel_telefono` AS `telefono`,`primalenterpricedb`.`usuarios`.`usr_contrasena` AS `contrasena`,`primalenterpricedb`.`usuarios`.`usr_rango` AS `rango`,`primalenterpricedb`.`usuarios`.`usr_nombre` AS `nombre`,`primalenterpricedb`.`usuarios`.`usr_cedula` AS `cedula`,`primalenterpricedb`.`usuarios`.`usr_email` AS `email`,`primalenterpricedb`.`usuarios`.`usr_direccion` AS `direccion` from (`primalenterpricedb`.`usuarios` left join `primalenterpricedb`.`telefonos` on((`primalenterpricedb`.`telefonos`.`tel_usuario` = `primalenterpricedb`.`usuarios`.`usr_usuario`)));

CREATE USER 'Admin' IDENTIFIED BY 'HTNT^256FbzNNO6eInk$';
GRANT ALL ON `PrimalEnterpriceDB`.* TO 'Admin';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;