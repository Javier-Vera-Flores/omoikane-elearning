-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: omoikane_db
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `asesores`
--

DROP TABLE IF EXISTS `asesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asesores` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `asesores_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asesores`
--

LOCK TABLES `asesores` WRITE;
/*!40000 ALTER TABLE `asesores` DISABLE KEYS */;
INSERT INTO `asesores` VALUES (1),(2),(3);
/*!40000 ALTER TABLE `asesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calificaciones` (
  `id_calificacion` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) NOT NULL,
  `comentarios` text,
  `id_estudiante` int(11) DEFAULT NULL,
  `id_tarea` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_calificacion`),
  KEY `id_estudiante` (`id_estudiante`),
  KEY `id_tarea` (`id_tarea`),
  CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`),
  CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`id_tarea`) REFERENCES `tareas` (`id_tarea`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (1,95,'Excelente trabajo!',4,1),(2,85,'Buen desempeño, hay que mejorar la sección 3.',4,2),(3,70,'Necesita reforzar el tema 2.',5,1),(4,100,'Trabajo perfecto, sin comentarios.',5,2),(5,90,'Muy completo.',6,1),(6,80,'Correcto, pero se puede profundizar más.',7,3),(7,75,'Buena base, a mejorar.',8,3),(8,92,'Excelente análisis del problema.',9,4),(9,65,'Revisar la sintaxis.',10,5),(10,88,'Se aplicaron correctamente los patrones.',11,6);
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiantes` (
  `id` int(11) NOT NULL,
  `id_asesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_asesor` (`id_asesor`),
  CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `estudiantes_ibfk_2` FOREIGN KEY (`id_asesor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (4,1),(5,1),(6,1),(7,2),(8,2),(9,2),(10,3),(11,3),(12,3),(13,3);
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones_padre`
--

DROP TABLE IF EXISTS `notificaciones_padre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificaciones_padre` (
  `id_notificacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_padre` int(11) DEFAULT NULL,
  `mensaje` text NOT NULL,
  `fecha_envio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_notificacion`),
  KEY `id_padre` (`id_padre`),
  CONSTRAINT `notificaciones_padre_ibfk_1` FOREIGN KEY (`id_padre`) REFERENCES `padres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones_padre`
--

LOCK TABLES `notificaciones_padre` WRITE;
/*!40000 ALTER TABLE `notificaciones_padre` DISABLE KEYS */;
INSERT INTO `notificaciones_padre` VALUES (1,14,'El progreso de su hijo Estudiante 1 ha sido actualizado.','2025-08-04 08:04:30'),(2,14,'El estudiante Estudiante 1 ha obtenido una calificación de 85 en Examen de UML.','2025-08-04 08:04:30'),(3,15,'El progreso de su hijo Estudiante 2 ha sido actualizado.','2025-08-04 08:04:30'),(4,15,'El estudiante Estudiante 2 ha obtenido una calificación de 100 en Examen de UML.','2025-08-04 08:04:30'),(5,16,'El progreso de su hijo Estudiante 3 ha sido actualizado.','2025-08-04 08:04:30'),(6,17,'El progreso de su hijo Estudiante 4 ha sido actualizado.','2025-08-04 08:04:30'),(7,17,'El estudiante Estudiante 4 ha obtenido una calificación de 80 en Análisis de Requerimientos.','2025-08-04 08:04:30'),(8,18,'El progreso de su hijo Estudiante 5 ha sido actualizado.','2025-08-04 08:04:30'),(9,18,'El estudiante Estudiante 5 ha obtenido una calificación de 75 en Análisis de Requerimientos.','2025-08-04 08:04:30'),(10,14,'Recordatorio: Próxima tarea vence en 2 días.','2025-08-04 08:04:30');
/*!40000 ALTER TABLE `notificaciones_padre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padres`
--

DROP TABLE IF EXISTS `padres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `padres` (
  `id` int(11) NOT NULL,
  `id_estudiante` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_estudiante` (`id_estudiante`),
  CONSTRAINT `padres_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `padres_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padres`
--

LOCK TABLES `padres` WRITE;
/*!40000 ALTER TABLE `padres` DISABLE KEYS */;
INSERT INTO `padres` VALUES (14,4),(15,5),(16,6),(17,7),(18,8);
/*!40000 ALTER TABLE `padres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progreso`
--

DROP TABLE IF EXISTS `progreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `progreso` (
  `id_progreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `puntaje_promedio` decimal(5,2) DEFAULT NULL,
  `id_estudiante` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_progreso`),
  KEY `id_estudiante` (`id_estudiante`),
  CONSTRAINT `progreso_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progreso`
--

LOCK TABLES `progreso` WRITE;
/*!40000 ALTER TABLE `progreso` DISABLE KEYS */;
INSERT INTO `progreso` VALUES (1,'2023-01-15',90.00,4),(2,'2023-02-15',87.50,4),(3,'2023-01-20',85.00,5),(4,'2023-02-20',92.50,5),(5,'2023-01-25',90.00,6),(6,'2023-01-28',80.00,7),(7,'2023-02-05',75.00,8),(8,'2023-02-10',92.00,9),(9,'2023-02-12',65.00,10),(10,'2023-02-18',88.00,11);
/*!40000 ALTER TABLE `progreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tareas` (
  `id_tarea` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text,
  `tipo_tarea` enum('Examen','TareaPractica') NOT NULL,
  `id_asesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_asesor` (`id_asesor`),
  CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_asesor`) REFERENCES `asesores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
INSERT INTO `tareas` VALUES (1,'Introducción a Patrones','Tarea sobre el concepto de patrones de diseño.','TareaPractica',1),(2,'Examen de UML','Evaluación sobre diagramas de UML y su aplicación.','Examen',1),(3,'Análisis de Requerimientos','Requerimientos para el proyecto Omoikane.','TareaPractica',2),(4,'Patrones Creacionales','Tarea práctica sobre el uso de Factory Method y Singleton.','TareaPractica',2),(5,'Examen de GRASP','Examen sobre los patrones GRASP.','Examen',3),(6,'Patrones de Comportamiento','Tarea sobre Estrategia y Observador.','TareaPractica',3),(7,'Proyecto Final','Entrega del proyecto final del sistema Omoikane.','TareaPractica',1),(8,'Quiz 1','Examen rápido de introducción.','Examen',2),(9,'Quiz 2','Examen rápido de patrones creacionales.','Examen',3),(10,'Tarea 10','Tarea complementaria de refactorización.','TareaPractica',1);
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo_electronico` varchar(255) NOT NULL,
  `tipo_usuario` enum('Estudiante','Asesor','Padre') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Asesor Principal','asesor.principal@omoikane.com','Asesor'),(2,'Beatriz González','bgonzalez@azc.uam.mx','Asesor'),(3,'Bryan Mendiola','bmendiola@omoikane.com','Asesor'),(4,'Estudiante 1','estudiante1@omoikane.com','Estudiante'),(5,'Estudiante 2','estudiante2@omoikane.com','Estudiante'),(6,'Estudiante 3','estudiante3@omoikane.com','Estudiante'),(7,'Estudiante 4','estudiante4@omoikane.com','Estudiante'),(8,'Estudiante 5','estudiante5@omoikane.com','Estudiante'),(9,'Estudiante 6','estudiante6@omoikane.com','Estudiante'),(10,'Estudiante 7','estudiante7@omoikane.com','Estudiante'),(11,'Estudiante 8','estudiante8@omoikane.com','Estudiante'),(12,'Estudiante 9','estudiante9@omoikane.com','Estudiante'),(13,'Estudiante 10','estudiante10@omoikane.com','Estudiante'),(14,'Padre 1','padre1@omoikane.com','Padre'),(15,'Padre 2','padre2@omoikane.com','Padre'),(16,'Padre 3','padre3@omoikane.com','Padre'),(17,'Padre 4','padre4@omoikane.com','Padre'),(18,'Padre 5','padre5@omoikane.com','Padre');
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

-- Dump completed on 2025-08-04  2:14:13
