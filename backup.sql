-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: primalEnterpricedb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activos`
--

DROP TABLE IF EXISTS `activos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activos` (
  `act_id` int NOT NULL AUTO_INCREMENT,
  `act_usuario` varchar(25) NOT NULL,
  `act_nit` int NOT NULL,
  `act_factura_id` int NOT NULL,
  `act_estado` varchar(25) NOT NULL,
  `act_nombre` varchar(80) NOT NULL,
  `act_descripcion` varchar(255) DEFAULT NULL,
  `act_marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`act_id`),
  UNIQUE KEY `Nombre_UNIQUE` (`act_nombre`),
  KEY `FK_Activo_Provee_Proveedor` (`act_nit`),
  KEY `FK_Activo_Registro_Usuario` (`act_usuario`),
  KEY `FK_Activo_Vende_Factura` (`act_factura_id`),
  CONSTRAINT `FK_Activo_Provee_Proveedor` FOREIGN KEY (`act_nit`) REFERENCES `proveedores` (`pve_nit`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Activo_Registro_Usuario` FOREIGN KEY (`act_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Activo_Vende_Factura` FOREIGN KEY (`act_factura_id`) REFERENCES `facturas` (`fac_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos`
--

LOCK TABLES `activos` WRITE;
/*!40000 ALTER TABLE `activos` DISABLE KEYS */;
/*!40000 ALTER TABLE `activos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_proveedor`
--

DROP TABLE IF EXISTS `factura_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura_proveedor` (
  `fve_factura_id` int NOT NULL,
  `fve_nit` int NOT NULL,
  PRIMARY KEY (`fve_factura_id`,`fve_nit`),
  KEY `FK_Factura_Registra_Proveedor` (`fve_nit`),
  CONSTRAINT `FK_Factura_Registra_Factura` FOREIGN KEY (`fve_factura_id`) REFERENCES `facturas` (`fac_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Factura_Registra_Proveedor` FOREIGN KEY (`fve_nit`) REFERENCES `proveedores` (`pve_nit`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_proveedor`
--

LOCK TABLES `factura_proveedor` WRITE;
/*!40000 ALTER TABLE `factura_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `fac_id` int NOT NULL AUTO_INCREMENT,
  `fac_usuario` varchar(25) NOT NULL,
  `fac_valor` double NOT NULL,
  `fac_fecha` date NOT NULL,
  `fac_tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`fac_id`),
  KEY `FK_Factura_Registra_Usuario` (`fac_usuario`),
  CONSTRAINT `FK_Factura_Registra_Usuario` FOREIGN KEY (`fac_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produccion_producto`
--

DROP TABLE IF EXISTS `produccion_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produccion_producto` (
  `prp_produccion_id` int NOT NULL,
  `prp_producto_id` int NOT NULL,
  `prp_cantidad_producto` int NOT NULL,
  PRIMARY KEY (`prp_produccion_id`,`prp_producto_id`),
  KEY `FK_Produccion_Pertenece_Producto` (`prp_producto_id`),
  CONSTRAINT `FK_Produccion_Pertenece_Produccion` FOREIGN KEY (`prp_produccion_id`) REFERENCES `producciones` (`prd_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Produccion_Pertenece_Producto` FOREIGN KEY (`prp_producto_id`) REFERENCES `productos` (`pru_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produccion_producto`
--

LOCK TABLES `produccion_producto` WRITE;
/*!40000 ALTER TABLE `produccion_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produccion_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producciones`
--

DROP TABLE IF EXISTS `producciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producciones` (
  `prd_id` int NOT NULL AUTO_INCREMENT,
  `prd_usuario` varchar(25) NOT NULL,
  `prd_estado` varchar(25) NOT NULL,
  `prd_tipo` varchar(20) NOT NULL,
  `prd_fecha_comienzo` date DEFAULT NULL,
  `prd_fecha_finalizacion` date DEFAULT NULL,
  PRIMARY KEY (`prd_id`),
  KEY `FK_Produccion_Registra_Usuario` (`prd_usuario`),
  CONSTRAINT `FK_Produccion_Registra_Usuario` FOREIGN KEY (`prd_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producciones`
--

LOCK TABLES `producciones` WRITE;
/*!40000 ALTER TABLE `producciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `producciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productlowamount`
--

DROP TABLE IF EXISTS `productlowamount`;
/*!50001 DROP VIEW IF EXISTS `productlowamount`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productlowamount` AS SELECT 
 1 AS `nombre`,
 1 AS `cantidad`,
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `producto_factura`
--

DROP TABLE IF EXISTS `producto_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_factura` (
  `pfa_factura_id` int NOT NULL,
  `pfa_producto_id` int NOT NULL,
  PRIMARY KEY (`pfa_factura_id`,`pfa_producto_id`),
  KEY `FK_Producto_Registra_Producto` (`pfa_producto_id`),
  CONSTRAINT `FK_Producto_Registra_Factura` FOREIGN KEY (`pfa_factura_id`) REFERENCES `facturas` (`fac_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Producto_Registra_Producto` FOREIGN KEY (`pfa_producto_id`) REFERENCES `productos` (`pru_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_factura`
--

LOCK TABLES `producto_factura` WRITE;
/*!40000 ALTER TABLE `producto_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `pru_id` int NOT NULL AUTO_INCREMENT,
  `pru_usuario` varchar(25) NOT NULL,
  `pru_nit` int NOT NULL,
  `pru_marca` varchar(80) NOT NULL,
  `pru_tipo` varchar(20) NOT NULL,
  `pru_cantidad` int NOT NULL DEFAULT '0',
  `pru_metodo_almacenamiento` varchar(255) NOT NULL,
  `pru_lugar_almacenamiento` varchar(255) NOT NULL,
  `pru_nombre` varchar(80) NOT NULL,
  `pru_descripcion` varchar(255) NOT NULL,
  `pru_fecha_caducidad` date DEFAULT NULL,
  `pru_estado` int NOT NULL,
  PRIMARY KEY (`pru_id`),
  KEY `FK_Producto_Provee_Proveedor` (`pru_nit`),
  KEY `FK_Producto_Registra_Usuario` (`pru_usuario`),
  CONSTRAINT `FK_Producto_Provee_Proveedor` FOREIGN KEY (`pru_nit`) REFERENCES `proveedores` (`pve_nit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Producto_Registra_Usuario` FOREIGN KEY (`pru_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productstoexpire`
--

DROP TABLE IF EXISTS `productstoexpire`;
/*!50001 DROP VIEW IF EXISTS `productstoexpire`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productstoexpire` AS SELECT 
 1 AS `nombre`,
 1 AS `id`,
 1 AS `fecha_caducidad`,
 1 AS `diff`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `pve_nit` int NOT NULL,
  `pve_usuario` varchar(25) NOT NULL,
  `pve_nombre` varchar(80) NOT NULL,
  `pve_direccion` varchar(100) NOT NULL,
  `pve_email` varchar(100) NOT NULL,
  PRIMARY KEY (`pve_nit`),
  KEY `FK_Proveedor_Registra_Usuario` (`pve_usuario`),
  CONSTRAINT `FK_Proveedor_Registra_Usuario` FOREIGN KEY (`pve_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonos` (
  `tel_id` int NOT NULL AUTO_INCREMENT,
  `tel_usuario` varchar(25) DEFAULT NULL,
  `tel_proveedor` int DEFAULT NULL,
  `tel_telefono` int NOT NULL,
  PRIMARY KEY (`tel_id`),
  UNIQUE KEY `tel_telefono_UNIQUE` (`tel_telefono`),
  KEY `fk_telefonos_usuarios1_idx` (`tel_usuario`),
  KEY `fk_telefonos_proveedores1_idx` (`tel_proveedor`),
  CONSTRAINT `fk_telefonos_proveedores1` FOREIGN KEY (`tel_proveedor`) REFERENCES `proveedores` (`pve_nit`),
  CONSTRAINT `fk_telefonos_usuarios1` FOREIGN KEY (`tel_usuario`) REFERENCES `usuarios` (`usr_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
INSERT INTO `telefonos` VALUES (6,'fredy',NULL,7834765),(7,'andrea',NULL,852963),(8,'david',NULL,45678),(9,'karen',NULL,785421);
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usr_usuario` varchar(25) NOT NULL,
  `usr_rango` varchar(40) NOT NULL,
  `usr_contrasena` varchar(40) NOT NULL,
  `usr_email` varchar(100) NOT NULL,
  `usr_nombre` varchar(80) NOT NULL,
  `usr_direccion` varchar(100) DEFAULT NULL,
  `usr_cedula` int DEFAULT NULL,
  `usr_estado` int NOT NULL,
  PRIMARY KEY (`usr_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('andrea','Secretario/a','7c4a8d09ca3762af61e59520943dc26494f8941b','email@email.com','andrea','cra cra cra',12345678,1),('david','Administrador de inventario','7c4a8d09ca3762af61e59520943dc26494f8941b','email@email.com','david','cra cra dir',12345678,1),('fredy','Administrador','930eea3844ee3748616c090aff3f01ee76762ba4','email@email.com','fredy','cra88 #67s-36',1012416293,1),('karen','Administrador de producciones','7c4a8d09ca3762af61e59520943dc26494f8941b','email@email.com','karen','dir dir dir',123456987,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_getactives`
--

DROP TABLE IF EXISTS `vw_getactives`;
/*!50001 DROP VIEW IF EXISTS `vw_getactives`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getactives` AS SELECT 
 1 AS `id`,
 1 AS `nit`,
 1 AS `factura`,
 1 AS `nombre`,
 1 AS `estado`,
 1 AS `marca`,
 1 AS `fecha_factura`,
 1 AS `descripcion`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getproductions`
--

DROP TABLE IF EXISTS `vw_getproductions`;
/*!50001 DROP VIEW IF EXISTS `vw_getproductions`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getproductions` AS SELECT 
 1 AS `id`,
 1 AS `usuario`,
 1 AS `estado`,
 1 AS `fecha_comienzo`,
 1 AS `fecha_finalizacion`,
 1 AS `tipo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getproducts`
--

DROP TABLE IF EXISTS `vw_getproducts`;
/*!50001 DROP VIEW IF EXISTS `vw_getproducts`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getproducts` AS SELECT 
 1 AS `id`,
 1 AS `usuario`,
 1 AS `nit`,
 1 AS `nombre_proveedor`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `tipo`,
 1 AS `cantidad`,
 1 AS `metodo_almacenaje`,
 1 AS `ubicacion`,
 1 AS `descripcion`,
 1 AS `fecha_factura`,
 1 AS `fecha_caducidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getproviders`
--

DROP TABLE IF EXISTS `vw_getproviders`;
/*!50001 DROP VIEW IF EXISTS `vw_getproviders`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getproviders` AS SELECT 
 1 AS `nit`,
 1 AS `telefono`,
 1 AS `nombre`,
 1 AS `email`,
 1 AS `direccion`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getusers`
--

DROP TABLE IF EXISTS `vw_getusers`;
/*!50001 DROP VIEW IF EXISTS `vw_getusers`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getusers` AS SELECT 
 1 AS `usuario`,
 1 AS `telefono`,
 1 AS `contrasena`,
 1 AS `rango`,
 1 AS `nombre`,
 1 AS `cedula`,
 1 AS `email`,
 1 AS `direccion`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'primalEnterpricedb'
--
/*!50003 DROP PROCEDURE IF EXISTS `ActiveInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActiveInfo`(
	IN activeId INT
)
BEGIN
	SELECT nombre,descripcion,estado,fecha_factura AS fecha_compra
    FROM vw_getActives
    WHERE id = activeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `activesList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `bloqueo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bloqueo`(
	IN nombre VARCHAR(80)
)
BEGIN
	UPDATE usuarios SET usr_estado =2 WHERE usr_usuario =nombre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `decreaceInventory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser`(
	IN userName varchar(25)
)
BEGIN
	UPDATE usuarios
    SET usr_estado = 3
    WHERE usr_usuario = userName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editUserData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertProvider` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
	SET pass = SHA1(contrasena);
    INSERT INTO usuarios VALUES (usuario,rango,pass,email,nombre,direccion,cedula,1); 
    INSERT INTO telefonos VALUES (NULL,usuario,NULL,telefono);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
		select SHA1(userPass) INTO pass;
        
        IF (SELECT COUNT(*) FROM vw_getUsers WHERE usuario = username AND contrasena = pass) = 0 THEN
			select 1 AS 'error';
			ELSE IF(SELECT COUNT(*) FROM usuarios WHERE usr_usuario = username AND usr_estado= 2)
			then select 4 AS 'error';
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
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `productInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `productInfo`(
	IN productId INT
)
BEGIN
	SELECT nombre,descripcion,tipo,cantidad,metodo_almacenamiento,lugar_almacenamiento,fecha_caducidad,fecha_factura AS fecha_compra
    FROM vw_getProduct WHERE id = productId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `productionsList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `productList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `providerList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registerActive` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registerProduct` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `userList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verifyRepeatedUserData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verifyRepeatedUserData`(
	IN userName VARCHAR(25),
    IN numCedula INT,
    IN UsrEmail VARCHAR(25)
)
BEGIN
	SELECT *
    FROM vw_getUsers
    WHERE usuario = userName OR cedula = numCedula OR email = usrEmail;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `productlowamount`
--

/*!50001 DROP VIEW IF EXISTS `productlowamount`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productlowamount` AS select `productos`.`pru_nombre` AS `nombre`,`productos`.`pru_cantidad` AS `cantidad`,`productos`.`pru_id` AS `id` from `productos` where ((`productos`.`pru_cantidad` <= 5) and (`productos`.`pru_estado` <> 2)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productstoexpire`
--

/*!50001 DROP VIEW IF EXISTS `productstoexpire`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productstoexpire` AS select `productos`.`pru_nombre` AS `nombre`,`productos`.`pru_id` AS `id`,`productos`.`pru_fecha_caducidad` AS `fecha_caducidad`,(to_days(`productos`.`pru_fecha_caducidad`) - to_days(now())) AS `diff` from `productos` where (((to_days(`productos`.`pru_fecha_caducidad`) - to_days(now())) < 5) and (`productos`.`pru_fecha_caducidad` is not null) and (`productos`.`pru_estado` <> 2)) order by (to_days(`productos`.`pru_fecha_caducidad`) - to_days(now())) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getactives`
--

/*!50001 DROP VIEW IF EXISTS `vw_getactives`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getactives` AS select `activos`.`act_id` AS `id`,`activos`.`act_nit` AS `nit`,`activos`.`act_factura_id` AS `factura`,`activos`.`act_nombre` AS `nombre`,`activos`.`act_estado` AS `estado`,`activos`.`act_marca` AS `marca`,`facturas`.`fac_fecha` AS `fecha_factura`,`activos`.`act_descripcion` AS `descripcion` from (`activos` left join `facturas` on((`activos`.`act_factura_id` = `facturas`.`fac_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getproductions`
--

/*!50001 DROP VIEW IF EXISTS `vw_getproductions`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getproductions` AS select `producciones`.`prd_id` AS `id`,`producciones`.`prd_usuario` AS `usuario`,`producciones`.`prd_estado` AS `estado`,`producciones`.`prd_fecha_comienzo` AS `fecha_comienzo`,`producciones`.`prd_fecha_finalizacion` AS `fecha_finalizacion`,`producciones`.`prd_tipo` AS `tipo` from `producciones` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getproducts`
--

/*!50001 DROP VIEW IF EXISTS `vw_getproducts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getproducts` AS select `productos`.`pru_id` AS `id`,`productos`.`pru_usuario` AS `usuario`,`productos`.`pru_nit` AS `nit`,`proveedores`.`pve_nombre` AS `nombre_proveedor`,`productos`.`pru_nombre` AS `nombre`,`productos`.`pru_marca` AS `marca`,`productos`.`pru_tipo` AS `tipo`,`productos`.`pru_cantidad` AS `cantidad`,`productos`.`pru_metodo_almacenamiento` AS `metodo_almacenaje`,`productos`.`pru_lugar_almacenamiento` AS `ubicacion`,`productos`.`pru_descripcion` AS `descripcion`,`facturas`.`fac_fecha` AS `fecha_factura`,`productos`.`pru_fecha_caducidad` AS `fecha_caducidad` from (((`productos` left join `proveedores` on((`productos`.`pru_nit` = `proveedores`.`pve_nit`))) left join `producto_factura` on((`productos`.`pru_id` = `producto_factura`.`pfa_producto_id`))) left join `facturas` on((`producto_factura`.`pfa_factura_id` = `facturas`.`fac_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getproviders`
--

/*!50001 DROP VIEW IF EXISTS `vw_getproviders`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getproviders` AS select `proveedores`.`pve_nit` AS `nit`,`telefonos`.`tel_telefono` AS `telefono`,`proveedores`.`pve_nombre` AS `nombre`,`proveedores`.`pve_email` AS `email`,`proveedores`.`pve_direccion` AS `direccion` from (`proveedores` join `telefonos`) where (`telefonos`.`tel_proveedor` = `proveedores`.`pve_nit`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getusers`
--

/*!50001 DROP VIEW IF EXISTS `vw_getusers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getusers` AS select `usuarios`.`usr_usuario` AS `usuario`,`telefonos`.`tel_telefono` AS `telefono`,`usuarios`.`usr_contrasena` AS `contrasena`,`usuarios`.`usr_rango` AS `rango`,`usuarios`.`usr_nombre` AS `nombre`,`usuarios`.`usr_cedula` AS `cedula`,`usuarios`.`usr_email` AS `email`,`usuarios`.`usr_direccion` AS `direccion` from (`usuarios` left join `telefonos` on((`telefonos`.`tel_usuario` = `usuarios`.`usr_usuario`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04  5:14:36
