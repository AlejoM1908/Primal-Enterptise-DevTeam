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
  PRIMARY KEY (`act_id`),
  UNIQUE KEY `Nombre_UNIQUE` (`act_nombre`),
  KEY `FK_Activo_Provee_Proveedor` (`act_nit`),
  KEY `FK_Activo_Registro_Usuario` (`act_usuario`),
  KEY `FK_Activo_Vende_Factura` (`act_factura_id`),
  CONSTRAINT `FK_Activo_Provee_Proveedor` FOREIGN KEY (`act_nit`) REFERENCES `proveedores` (`pve_nit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Activo_Registro_Usuario` FOREIGN KEY (`act_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Activo_Vende_Factura` FOREIGN KEY (`act_factura_id`) REFERENCES `facturas` (`fac_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
INSERT INTO `facturas` VALUES (1,'Pepito',123456,'2005-05-05','normal');
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
  PRIMARY KEY (`prp_produccion_id`,`prp_producto_id`),
  KEY `FK_Produccion_Pertenece_Producto` (`prp_producto_id`),
  CONSTRAINT `FK_Produccion_Pertenece_Produccion` FOREIGN KEY (`prp_produccion_id`) REFERENCES `producciones` (`prd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producciones`
--

LOCK TABLES `producciones` WRITE;
/*!40000 ALTER TABLE `producciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `producciones` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`pru_id`),
  KEY `FK_Producto_Provee_Proveedor` (`pru_nit`),
  KEY `FK_Producto_Registra_Usuario` (`pru_usuario`),
  CONSTRAINT `FK_Producto_Provee_Proveedor` FOREIGN KEY (`pru_nit`) REFERENCES `proveedores` (`pve_nit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Producto_Registra_Usuario` FOREIGN KEY (`pru_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (3,'Pepito',12346789,'Doritos','comestible',15,'Seco,frio','bodega1','chitos','doritos negros','2001-05-20');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `pve_nit` int NOT NULL,
  `pve_usuario` varchar(25) NOT NULL,
  `pve_telefono_id` int NOT NULL,
  `pve_nombre` varchar(80) NOT NULL,
  `pve_direccion` varchar(100) NOT NULL,
  `pve_email` varchar(100) NOT NULL,
  PRIMARY KEY (`pve_nit`),
  KEY `FK_Proveedor_Registra_Usuario` (`pve_usuario`),
  KEY `fk_Proveedor_telefonos1_idx` (`pve_telefono_id`),
  CONSTRAINT `FK_Proveedor_Registra_Usuario` FOREIGN KEY (`pve_usuario`) REFERENCES `usuarios` (`usr_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_Proveedor_telefonos1` FOREIGN KEY (`pve_telefono_id`) REFERENCES `telefonos` (`tel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (12346789,'Pepito',6,'test','test','tst');
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
  `tel_telefono` int NOT NULL,
  PRIMARY KEY (`tel_id`),
  UNIQUE KEY `tel_telefono_UNIQUE` (`tel_telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
INSERT INTO `telefonos` VALUES (4,2),(5,1234),(7,12547),(6,123456),(1,789456),(3,987654),(2,9517853),(9,1254789654);
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
  `usr_telefonos_id` int NOT NULL,
  `usr_rango` varchar(40) NOT NULL,
  `usr_contraseña` varchar(40) NOT NULL,
  `usr_email` varchar(100) NOT NULL,
  `usr_nombre` varchar(80) NOT NULL,
  `usr_direccion` varchar(100) DEFAULT NULL,
  `usr_cedula` int DEFAULT NULL,
  PRIMARY KEY (`usr_usuario`),
  KEY `fk_usuarios_telefonos1_idx` (`usr_telefonos_id`),
  CONSTRAINT `fk_usuarios_telefonos1` FOREIGN KEY (`usr_telefonos_id`) REFERENCES `telefonos` (`tel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Pepito',1,'rango','fd723c40e57040744a18db59e811b59aaebb7704','email@com','nombre','direccion',123456),('u',4,'r','40bd001563085fc35165329ea1ff5c5ecbdbbeef','e','n','d',1),('us',5,'r','8cb2237d0679ca88db6464eac60da96345513964','em','m','dr',123),('usr',6,'r','7c4a8d09ca3762af61e59520943dc26494f8941b','eml@com','nr','drt',12345),('Usrt',9,'adasdas','06374955a3294e2ded48dd66572b8ea91c04f615','asd@sdasd','abc','asdasd',10214),('usuario',3,'ninguno','2fb5e13419fc89246865e7a324f476ec624e8740','email','este','direccion',123456);
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
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `tipo`,
 1 AS `cantidad`,
 1 AS `metodo_almacenaje`,
 1 AS `ubicacion`,
 1 AS `descripcion`,
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
 1 AS `usuario`,
 1 AS `telefono_id`,
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
 1 AS `telefono_id`,
 1 AS `contraseña`,
 1 AS `rango`,
 1 AS `nombre`,
 1 AS `cedula`,
 1 AS `email`,
 1 AS `direccion`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'primalEnterpricedb'
--
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Busq_Individual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Busq_Individual`(IN Usr VARCHAR(255) )
BEGIN
	SELECT * FROM usuarios WHERE usr_usuario=Usr;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Busq_Rol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Busq_Rol`(IN rang VARCHAR(255) )
BEGIN
	SELECT * FROM usuarios WHERE usr_rango=rang;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `disminucion_inventario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `disminucion_inventario`(IN Num_items int,
IN ID_item int )
BEGIN
    DECLARE inventario int DEFAULT 0;  
    select pru_cantidad
    into inventario
    from productos
    where ID_item=pru_id;
    if inventario-Num_items>=0 then
    update productos set pru_cantidad = inventario-Num_items
    where ID_item=pru_id;
    end if;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_usr` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_usr`(IN Usr varchar(255) )
BEGIN
	delete from usuarios
    where usr_usuario=Usr;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarProv` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarProv`(IN nombreProv VARCHAR(255), 
IN Nit_num int,IN Num_tel int,
IN Email_Prov VARCHAR(255),
IN Direcc_Tie VARCHAR(255),
IN Usr VARCHAR(255))
BEGIN
	DECLARE identificador int DEFAULT 0;
    INSERT INTO telefonos VALUES (null,Num_tel);
    select tel_id into identificador FROM telefonos ORDER by tel_id desc limit 1;
	INSERT INTO proveedor VALUES (Nit_num,Usr,identificador,nombreProv,Direcc_Tie,Email_Prov);  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarUsr` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarUsr`(
IN nombreUsr VARCHAR(80), 
IN numCed int, 
IN rang VARCHAR(40),
IN Contr VARCHAR(25),
IN Num_Cel int,
IN Email_Usr VARCHAR(100),
IN Direcc_Casa VARCHAR(100),
IN Usr VARCHAR(25))
BEGIN
	declare contrasena varchar(40);
	DECLARE identificador int DEFAULT 0;
    INSERT INTO telefonos VALUES (null,Num_Cel);
    select tel_id into identificador FROM telefonos ORDER by tel_id desc limit 1;
    set contrasena = sha1(`contr`);
    INSERT INTO usuarios VALUES (Usr,identificador,rang,contrasena,Email_Usr,nombreUsr,Direcc_Casa,numCed);  
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
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50001 VIEW `vw_getactives` AS select `activos`.`act_id` AS `id`,`activos`.`act_nit` AS `nit`,`activos`.`act_factura_id` AS `factura`,`activos`.`act_nombre` AS `nombre`,`activos`.`act_estado` AS `estado`,`activos`.`act_descripcion` AS `descripcion` from `activos` */;
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
/*!50001 VIEW `vw_getproductions` AS select `producciones`.`prd_id` AS `id`,`producciones`.`prd_estado` AS `estado`,`producciones`.`prd_fecha_comienzo` AS `fecha_comienzo`,`producciones`.`prd_fecha_finalizacion` AS `fecha_finalizacion`,`producciones`.`prd_tipo` AS `tipo` from `producciones` */;
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
/*!50001 VIEW `vw_getproducts` AS select `productos`.`pru_id` AS `id`,`productos`.`pru_usuario` AS `usuario`,`productos`.`pru_nit` AS `nit`,`productos`.`pru_nombre` AS `nombre`,`productos`.`pru_marca` AS `marca`,`productos`.`pru_tipo` AS `tipo`,`productos`.`pru_cantidad` AS `cantidad`,`productos`.`pru_metodo_almacenamiento` AS `metodo_almacenaje`,`productos`.`pru_lugar_almacenamiento` AS `ubicacion`,`productos`.`pru_descripcion` AS `descripcion`,`productos`.`pru_fecha_caducidad` AS `fecha_caducidad` from `productos` */;
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
/*!50001 VIEW `vw_getproviders` AS select `proveedores`.`pve_nit` AS `nit`,`proveedores`.`pve_usuario` AS `usuario`,`proveedores`.`pve_telefono_id` AS `telefono_id`,`proveedores`.`pve_nombre` AS `nombre`,`proveedores`.`pve_email` AS `email`,`proveedores`.`pve_direccion` AS `direccion` from `proveedores` */;
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
/*!50001 VIEW `vw_getusers` AS select `usuarios`.`usr_usuario` AS `usuario`,`usuarios`.`usr_telefonos_id` AS `telefono_id`,`usuarios`.`usr_contraseña` AS `contraseña`,`usuarios`.`usr_rango` AS `rango`,`usuarios`.`usr_nombre` AS `nombre`,`usuarios`.`usr_cedula` AS `cedula`,`usuarios`.`usr_email` AS `email`,`usuarios`.`usr_direccion` AS `direccion` from `usuarios` */;
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

-- Dump completed on 2020-11-09  9:52:24
