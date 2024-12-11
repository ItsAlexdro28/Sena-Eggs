-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: prod_gallinas
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `analisis_alertas`
--

DROP TABLE IF EXISTS `analisis_alertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis_alertas` (
  `analisis_id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_analisis` enum('rendimiento','tendencias','alerta') NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`analisis_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `analisis_alertas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis_alertas`
--

LOCK TABLES `analisis_alertas` WRITE;
/*!40000 ALTER TABLE `analisis_alertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `analisis_alertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuraciones_usuario`
--

DROP TABLE IF EXISTS `configuraciones_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuraciones_usuario` (
  `configuracion_id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `notificaciones` tinyint(1) DEFAULT '1',
  `tema` varchar(50) DEFAULT 'light',
  `idioma` varchar(50) DEFAULT 'es',
  PRIMARY KEY (`configuracion_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `configuraciones_usuario_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuraciones_usuario`
--

LOCK TABLES `configuraciones_usuario` WRITE;
/*!40000 ALTER TABLE `configuraciones_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuraciones_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gallinas`
--

DROP TABLE IF EXISTS `gallinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gallinas` (
  `gallina_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `grupo_id` int DEFAULT NULL,
  `estado` enum('activo','inactivo') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`gallina_id`),
  KEY `grupo_id` (`grupo_id`),
  CONSTRAINT `gallinas_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupos` (`grupo_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallinas`
--

LOCK TABLES `gallinas` WRITE;
/*!40000 ALTER TABLE `gallinas` DISABLE KEYS */;
/*!40000 ALTER TABLE `gallinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos` (
  `grupo_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produccion_diaria`
--

DROP TABLE IF EXISTS `produccion_diaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produccion_diaria` (
  `produccion_id` int NOT NULL AUTO_INCREMENT,
  `gallina_id` int NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`produccion_id`),
  UNIQUE KEY `gallina_id` (`gallina_id`,`fecha`),
  CONSTRAINT `produccion_diaria_ibfk_1` FOREIGN KEY (`gallina_id`) REFERENCES `gallinas` (`gallina_id`) ON DELETE CASCADE,
  CONSTRAINT `produccion_diaria_chk_1` CHECK ((`cantidad` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produccion_diaria`
--

LOCK TABLES `produccion_diaria` WRITE;
/*!40000 ALTER TABLE `produccion_diaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `produccion_diaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_eventos`
--

DROP TABLE IF EXISTS `registro_eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_eventos` (
  `evento_id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`evento_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `registro_eventos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_eventos`
--

LOCK TABLES `registro_eventos` WRITE;
/*!40000 ALTER TABLE `registro_eventos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportes_produccion`
--

DROP TABLE IF EXISTS `reportes_produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes_produccion` (
  `reporte_id` int NOT NULL AUTO_INCREMENT,
  `produccion_id` int NOT NULL,
  `analisis_id` int NOT NULL,
  PRIMARY KEY (`reporte_id`),
  KEY `produccion_id` (`produccion_id`),
  KEY `analisis_id` (`analisis_id`),
  CONSTRAINT `reportes_produccion_ibfk_1` FOREIGN KEY (`produccion_id`) REFERENCES `produccion_diaria` (`produccion_id`) ON DELETE CASCADE,
  CONSTRAINT `reportes_produccion_ibfk_2` FOREIGN KEY (`analisis_id`) REFERENCES `analisis_alertas` (`analisis_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes_produccion`
--

LOCK TABLES `reportes_produccion` WRITE;
/*!40000 ALTER TABLE `reportes_produccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportes_produccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumen_produccion`
--

DROP TABLE IF EXISTS `resumen_produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resumen_produccion` (
  `resumen_id` int NOT NULL AUTO_INCREMENT,
  `grupo_id` int NOT NULL,
  `fecha` date NOT NULL,
  `total_huevos` int NOT NULL,
  PRIMARY KEY (`resumen_id`),
  UNIQUE KEY `grupo_id` (`grupo_id`,`fecha`),
  CONSTRAINT `resumen_produccion_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupos` (`grupo_id`) ON DELETE CASCADE,
  CONSTRAINT `resumen_produccion_chk_1` CHECK ((`total_huevos` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumen_produccion`
--

LOCK TABLES `resumen_produccion` WRITE;
/*!40000 ALTER TABLE `resumen_produccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `resumen_produccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `perfil` enum('admin','user') NOT NULL DEFAULT 'user',
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-10 21:13:32
