CREATE DATABASE  IF NOT EXISTS `music_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `music_app`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: music_app
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userpl_id` int NOT NULL,
  `user_id` int NOT NULL,
  `track_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`userpl_id`),
  KEY `FK_TRACK_ID_idx` (`track_id`),
  KEY `FK_USER_ID_idx` (`user_id`),
  CONSTRAINT `FK_TRACK_ID` FOREIGN KEY (`track_id`) REFERENCES `tracks` (`idTracks`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_USERPL_ID` FOREIGN KEY (`userpl_id`) REFERENCES `userplaylists` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,3,2,4),(2,3,2,2);
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracks` (
  `idTracks` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'unknown',
  `artist` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'unknown',
  `album` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'unknown',
  `genre` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'unknown',
  `release_year` varchar(20) NOT NULL DEFAULT 'N/A',
  `duration` varchar(20) NOT NULL DEFAULT 'N/A',
  PRIMARY KEY (`idTracks`),
  UNIQUE KEY `idTracks_UNIQUE` (`idTracks`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracks`
--

LOCK TABLES `tracks` WRITE;
/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
INSERT INTO `tracks` VALUES (1,'Girls like you','Maroon 5 ft. Cardi B','Love song','Pop','2018','4:31'),(2,'Sugar','sweet love','sweet','Pop','2018','4:30'),(4,'I need you','Miggle Wings','Falling in love','dance','2018','4:35'),(5,'Chay ngay di','Son Tung MTP','Chay','Pop/Rock','2018','4:33');
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `confirmpassword` varchar(200) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',NULL,'1'),(2,'user1','user123','user123','0'),(3,'user2','user123','user123','0'),(4,'user3','user123','user123','0'),(5,'user4','user123','user123','0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userplaylists`
--

DROP TABLE IF EXISTS `userplaylists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userplaylists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_playlist` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `userplaylists_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userplaylists`
--

LOCK TABLES `userplaylists` WRITE;
/*!40000 ALTER TABLE `userplaylists` DISABLE KEYS */;
INSERT INTO `userplaylists` VALUES (3,'Hi',2);
/*!40000 ALTER TABLE `userplaylists` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-08 10:42:06
