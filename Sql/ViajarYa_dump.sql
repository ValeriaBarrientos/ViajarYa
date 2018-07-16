CREATE DATABASE  IF NOT EXISTS `viajarya` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `viajarya`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: viajarya
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
  `id_auto` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `combustible` varchar(45) NOT NULL,
  `patente` varchar(10) NOT NULL,
  `aireacondicionado` bit(1) DEFAULT NULL,
  `calefaccion` bit(1) DEFAULT NULL,
  `cantidad_de_asientos` smallint(2) NOT NULL,
  `calificacion` smallint(1) NOT NULL,
  `capacidad_de_baul` varchar(45) DEFAULT NULL,
  `foto` varchar(500) DEFAULT NULL,
  `id_propietario` int(11) NOT NULL,
  `cuenta` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id_auto`,`id_propietario`),
  UNIQUE KEY `id_Auto_UNIQUE` (`id_auto`),
  UNIQUE KEY `patente_UNIQUE` (`patente`),
  KEY `fk_Auto_Usuario1_idx` (`id_propietario`),
  CONSTRAINT `fk_Auto_Usuario1` FOREIGN KEY (`id_propietario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Gol 1.6 I Trendline Plus 2009','Volkswagen','gris','nafta','ICY 585','','',4,9,'grande',' ',1,''),(2,'Clio 1.2 Pack Plus 2007','Renault','rojo','nafta','JVC 177','','',4,9,'chica',' ',1,''),(3,'Fiesta 1.3 Clx 1998','Ford','rojo','nafta','CGR 372','','',4,7,'chica',' ',2,''),(4,'307 2.0 Hdi Xs 90cv Mp3 2007','Peugeot','negro','diesel','FGI 633','','',4,8,'mediana',' ',3,'');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calificacion` (
  `id_calificacion` int(11) NOT NULL AUTO_INCREMENT,
  `puntuacion` smallint(5) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `Viaje_has_Usuario_Viaje_id_viaje` int(11) NOT NULL,
  `Viaje_has_Usuario_Usuario_id_usuario` int(11) NOT NULL,
  `Viaje_has_Usuario_Auto_id_auto` int(11) NOT NULL,
  PRIMARY KEY (`id_calificacion`,`Viaje_has_Usuario_Viaje_id_viaje`,`Viaje_has_Usuario_Usuario_id_usuario`,`Viaje_has_Usuario_Auto_id_auto`),
  KEY `fk_calificacion_Viaje_has_Usuario1_idx` (`Viaje_has_Usuario_Viaje_id_viaje`,`Viaje_has_Usuario_Usuario_id_usuario`,`Viaje_has_Usuario_Auto_id_auto`),
  CONSTRAINT `fk_calificacion_Viaje_has_Usuario1` FOREIGN KEY (`Viaje_has_Usuario_Viaje_id_viaje`, `Viaje_has_Usuario_Usuario_id_usuario`, `Viaje_has_Usuario_Auto_id_auto`) REFERENCES `viaje_has_usuario` (`viaje_id_viaje`, `usuario_id_usuario`, `auto_id_auto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (1,5,'puntualidad y charlas muy amenas',1,5,2),(2,1,'Se durmió al volante.',6,5,4),(3,4,'Todo ok!',5,5,4),(4,4,'Todo ok!',5,5,4);
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id_Ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Tandil'),(2,'Buenos Aires'),(3,'Ayacucho'),(4,'Rauch'),(5,'Olavarria'),(6,'Azul'),(7,'Necochea'),(8,'Loberia'),(9,'Miramar'),(10,'Mar del Plata'),(11,'Barker'),(12,'Bahia Blanca'),(13,'Junin'),(14,'Benito Juarez'),(15,'Balcarce'),(16,'San Manuel'),(17,'Tres Arroyos'),(18,'La Plata');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad_has_viaje`
--

DROP TABLE IF EXISTS `ciudad_has_viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad_has_viaje` (
  `Ciudad_id_Ciudad` int(11) NOT NULL,
  `Viaje_id_viaje` int(11) NOT NULL,
  PRIMARY KEY (`Ciudad_id_Ciudad`,`Viaje_id_viaje`),
  KEY `fk_Ciudad_has_Viaje_Viaje1_idx` (`Viaje_id_viaje`),
  KEY `fk_Ciudad_has_Viaje_Ciudad1_idx` (`Ciudad_id_Ciudad`),
  CONSTRAINT `fk_Ciudad_has_Viaje_Ciudad1` FOREIGN KEY (`Ciudad_id_Ciudad`) REFERENCES `ciudad` (`id_ciudad`),
  CONSTRAINT `fk_Ciudad_has_Viaje_Viaje1` FOREIGN KEY (`Viaje_id_viaje`) REFERENCES `viaje` (`id_viaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_has_viaje`
--

LOCK TABLES `ciudad_has_viaje` WRITE;
/*!40000 ALTER TABLE `ciudad_has_viaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad_has_viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `mail` varchar(45) NOT NULL,
  `pass` varchar(15) NOT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `genero` char(1) CHARACTER SET big5 COLLATE big5_chinese_ci NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juan','Perez','154455566','Alem 234','Tandil','1970-10-14','juanp@gmail.com','1234',' ','m',''),(2,'Maria','Garcia','154455577','Paz 600','Tandil','1980-08-24','mariag@gmail.com','1234',' ','f',''),(3,'Alejandro','Campitelli','154455888','Alem 100','Tandil','1979-11-03','alejandroc@gmail.com','ale123',' ','m',''),(4,'Leandro','Mazza','154422266','Montiel 340','Tandil','1988-06-11','leandrom@gmail.com','lea123',' ','m',''),(5,'Valeria','Barrientos','154455333','Brandsen 544','Tandil','1974-05-14','valeriab@gmail.com','vale123',' ','f',''),(6,'Diego','Diaz','0249 154678934','Colon 100','Tandil','1988-06-08','diegod@gmail.com','diego123',' ','m',''),(7,'Liliana','Gíboli','0249 154678934','Doreing 100','Tandil','1988-06-08','lilianag@gmail.com','lili123',' ','f',''),(8,'federico','mazza','123132123','alem 123','Tandil','2008-06-01','fedemazza@gmail.com','fede123',' ','m',''),(9,'Pablo','Marmol','154454446','Paz 780','Tandil','1988-12-24','pablom@gmail.com','pablo123',' ','m',''),(10,'Pedro','Lopez','0249154232345','Rodriguez 1244','Tandil','1969-09-11','pedrol@gmail.com','pedro123',' ','m',''),(11,'Javier ','Mascherano','024015467893','9 de Julio 234','Tandil','1988-02-09','javierm@gmail.com','javi123',' ','m',''),(12,'Paulina','Rubio','024915232435','Chacabuco 123','Tandil','1979-08-14','paulina@hotmail.com','pau123',' ','f',''),(13,'Maria Laura','Fernanadez','02411546773','Laprida 1234','Olavarria','1965-10-04','marialaura@gmail.com','maria123',' ','f',''),(14,'Luis ','Suarez','011 154676767','San Juan 1546','Buenos Aires','1993-06-11','luisz@hotmail.com','luis123',' ','m',''),(15,'Carla','Petersen','0226 154232476','Formosa 567','Ayacucho','1990-03-07','carlap@gmail.com','carla123',' ','f',''),(16,'Jose','Meolans','0249 1543276765','Colombia 54','Tandil','1986-06-02','josem@gmail.com','jose123',' ','m',''),(17,'Daniela','Mercuri','0249 154322467','Paz 567','Tandil','1980-08-28','danielam@gmail.com','dani123',' ','f',''),(18,'Carlos','Gardel','0249 154232311','Pinto 123','Tandil','1954-07-21','carlosg@gmail.com','car123','  ','m','');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje` (
  `id_viaje` int(11) NOT NULL AUTO_INCREMENT,
  `origen` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `gastos_aproximados` double NOT NULL,
  `fechayhora_partida` datetime NOT NULL,
  `lugar_salida` varchar(100) NOT NULL,
  `mascota` bit(1) DEFAULT NULL,
  `fumador` bit(1) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_viaje`),
  UNIQUE KEY `id_viaje_UNIQUE` (`id_viaje`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (1,'Tandil','Olavarria',105,'2018-06-17 17:15:00','Paz 134','','\0','2018-06-10 00:00:00'),(2,'Tandil','Mar del Plata',133,'2018-06-20 09:00:00','Rivadavia y España','','\0','2018-06-10 00:00:00'),(3,'Rauch','Tandil',55,'2018-06-19 19:30:00','Colon 123','','','2018-06-10 00:00:00'),(4,'Tandil','Olavarria',105,'2018-06-21 11:15:00','Buzon 453','\0','\0','2018-06-10 00:00:00'),(5,'Tandil','La Plata',300,'2018-06-28 07:00:00','Buzon y Portugal','','\0','2018-04-10 00:00:00'),(6,'Tandil','La Plata',300,'2018-04-28 07:00:00','Buzon y Portugal','','\0','2018-04-10 00:00:00'),(7,'Tandil','Necochea',280,'2018-08-15 07:00:00','Arana 22','','\0','2018-06-17 00:00:00'),(8,'Necochea','Tandil',280,'2018-08-20 10:00:00','Av 59 y 60','\0','\0','2018-06-17 00:00:00'),(9,'Ayacucho','Tandil',155,'2018-07-23 07:00:00','Belgrano 120','','\0','2018-04-27 00:00:00'),(10,'Tandil','Olavarria',105,'2018-07-09 13:00:00','Paz 134','\0','\0','2018-06-27 00:00:00'),(11,'Tandil','Mar del Plata',133,'2018-07-20 09:00:00','Av.España 678','','\0','2018-07-24 00:00:00'),(12,'Rauch','Tandil',55,'2018-07-19 19:00:00','Colombia 123','','','2018-07-26 00:00:00'),(13,'Tandil','Ayacucho',200,'2018-07-21 11:30:00','Buzon 300','\0','\0','2018-05-30 00:00:00'),(14,'Tandil','Buenos Aires',500,'2018-07-18 16:00:00','Paz 333','','\0','2018-06-09 00:00:00'),(15,'Tandil','Azul',250,'2018-09-01 22:00:00','Alem 120','\0','','2018-06-09 00:00:00'),(16,'Tandil','Olavarria',150,'2018-07-19 13:00:00','Av Colon 344','','\0','2018-06-14 00:00:00');
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje_has_usuario`
--

DROP TABLE IF EXISTS `viaje_has_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje_has_usuario` (
  `Viaje_id_viaje` int(11) NOT NULL,
  `Usuario_id_usuario` int(11) NOT NULL,
  `Auto_id_auto` int(11) NOT NULL,
  PRIMARY KEY (`Viaje_id_viaje`,`Usuario_id_usuario`,`Auto_id_auto`),
  KEY `fk_Viaje_has_Usuario_Usuario1_idx` (`Usuario_id_usuario`),
  KEY `fk_Viaje_has_Usuario_Viaje1_idx` (`Viaje_id_viaje`),
  KEY `fk_Viaje_has_Usuario_Auto1_idx` (`Auto_id_auto`),
  CONSTRAINT `fk_Viaje_has_Usuario_Auto1` FOREIGN KEY (`Auto_id_auto`) REFERENCES `auto` (`id_auto`),
  CONSTRAINT `fk_Viaje_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_Viaje_has_Usuario_Viaje1` FOREIGN KEY (`Viaje_id_viaje`) REFERENCES `viaje` (`id_viaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje_has_usuario`
--

LOCK TABLES `viaje_has_usuario` WRITE;
/*!40000 ALTER TABLE `viaje_has_usuario` DISABLE KEYS */;
INSERT INTO `viaje_has_usuario` VALUES (1,1,2),(3,1,1),(4,1,2),(9,1,1),(10,1,1),(13,1,2),(14,1,1),(15,1,2),(2,2,3),(7,2,3),(8,2,3),(16,2,3),(5,3,4),(6,3,4),(11,3,4),(12,3,4),(5,4,4),(1,5,2),(5,5,4),(6,5,4),(7,5,3),(8,5,3),(11,5,4),(12,5,4),(15,5,2);
/*!40000 ALTER TABLE `viaje_has_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-16 10:21:01
