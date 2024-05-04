-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 08, 2023 at 08:35 PM
-- Server version: 5.7.24
-- PHP Version: 8.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `weblocal`
--
CREATE DATABASE IF NOT EXISTS `weblocal` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `weblocal`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addGazoraAllas` (IN `inputDate` VARCHAR(20), IN `inputOraAllas` INT)   INSERT INTO `gazora` (`gazora`.`month`, `gazora`.`kobmeter`, `gazora`.`gazoraID`)
VALUES (inputDate, inputOraAllas, 1)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addTask` (IN `taskName` VARCHAR(100), IN `taskDescription` VARCHAR(500), IN `selectUserID` INT)   INSERT INTO `task` (`task`.`name`, `task`.`description`, `task`.`date`, `task`.`userID`)
VALUES (taskName, taskDescription, NOW(), selectUserID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addWord` (IN `english` VARCHAR(100), IN `hungarian` VARCHAR(100))   INSERT INTO `englishwords` (`englishwords`.`englishWord`, `englishwords`.`hungarianWord`)
VALUES (english, hungarian)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllGazoraAllas` ()   SELECT * FROM `gazora`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllNotCompleteTasks` ()   SELECT * FROM `task` WHERE `task`.`status` = 0$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUserName` ()   SELECT `user`.`username`, `user`.`ID` FROM `user`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllWords` ()   SELECT * FROM `englishwords`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getTodayCompleteTasks` (IN `today` DATE)   SELECT * FROM `task` 
WHERE `task`.`status` = 1 AND `task`.`date` = today$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `name` VARCHAR(100), IN `pass` VARCHAR(100))   SELECT * FROM `user` WHERE `user`.`username` = name AND `user`.`password` = pass$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `register` (IN `name` VARCHAR(100), IN `pass` VARCHAR(100), IN `emailV` VARCHAR(100))   INSERT INTO `user` (`user`.`username`, `user`.`password`, `user`.`email`)
VALUES (name, pass, emailV)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `taskCompleted` (IN `taskId` INT)   BEGIN

	UPDATE `task` SET `task`.`status` = 1
	WHERE `task`.`ID` = taskId;
    
    UPDATE `task` SET `task`.`ended` = NOW()
	WHERE `task`.`ID` = taskId;
    
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `taskNotCompleted` (IN `taskId` INT)   UPDATE `task` SET `task`.`status` = 0
WHERE `task`.`ID` = taskId$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `englishwords`
--

CREATE TABLE `englishwords` (
  `ID` int(11) NOT NULL,
  `englishWord` varchar(100) NOT NULL,
  `hungarianWord` varchar(100) NOT NULL,
  `megjelenes` int(11) NOT NULL DEFAULT '0',
  `talalat` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `englishwords`
--

INSERT INTO `englishwords` (`ID`, `englishWord`, `hungarianWord`, `megjelenes`, `talalat`) VALUES
(1, 'both', 'mindkettő', 0, 1),
(2, 'feeling', 'érzés', 0, 1),
(3, 'sales', 'értékesítés', 0, 1),
(4, 'delicious', 'finom', 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `gazora`
--

CREATE TABLE `gazora` (
  `ID` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `month` varchar(20) NOT NULL,
  `kobmeter` int(11) NOT NULL,
  `gazoraID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gazora`
--

INSERT INTO `gazora` (`ID`, `date`, `month`, `kobmeter`, `gazoraID`) VALUES
(10, '2023-04-06 07:58:21', '2023-04-06', 8882, 1);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `ID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `date` date NOT NULL,
  `ended` date DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`ID`, `name`, `description`, `date`, `ended`, `status`, `userID`) VALUES
(39, 'szoftver tesztelés beadandó', '2 A/4-es oldal (word)', '2023-03-16', '2023-03-16', 1, 2),
(41, 'angol esszé', 'Marknak levél', '2023-03-16', '2023-03-16', 1, 2),
(42, 'szakmai angol ppt', '', '2023-03-16', '2023-03-16', 1, 2),
(44, 'English words card', '', '2023-03-29', '2023-04-09', 1, 1),
(47, 'teregetni', '', '2023-03-30', '2023-04-05', 1, 1),
(48, 'asd', '', '2023-03-31', '2023-03-31', 1, 1),
(49, 'konyha', 'mosogatás, felmosás, pakolás', '2023-04-11', '2023-04-20', 1, 4),
(50, 'java hf', 'oop-t átnézni, egy set utasítást megírni függvényben', '2023-04-11', '2023-04-13', 0, 4),
(51, 'mosni', 'világosakat', '2023-04-11', '2023-04-12', 0, 4),
(52, 'kitenni a kukát', 'kék vagy barna', '2023-04-11', NULL, 0, 4),
(53, 'elmenni boltba', 'kenyér, th, ', '2023-04-11', '2023-04-11', 1, 4),
(54, 'számlák', 'net', '2023-04-11', '2023-04-20', 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `username`, `password`, `email`) VALUES
(3, 'papgergely', 'a8d2185e44e9783b4d0dded299da52ae', 'gerfomaxpro@gmail.com'),
(4, 'eepseelona', '9da6413039964fcbf31cb0e35dc7ca8c', 'eepseelona@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `englishwords`
--
ALTER TABLE `englishwords`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `gazora`
--
ALTER TABLE `gazora`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `englishwords`
--
ALTER TABLE `englishwords`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `gazora`
--
ALTER TABLE `gazora`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
