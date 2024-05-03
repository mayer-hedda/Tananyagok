-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Nov 29. 16:29
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `strategiai_jatek`
--
CREATE DATABASE IF NOT EXISTS `strategiai_jatek` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `strategiai_jatek`;

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `createEmber` ()   INSERT INTO `ember`
VALUE ()$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEmber` ()   SELECT * FROM `ember`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllHouse` ()   SELECT * FROM `haz`$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ember`
--

CREATE TABLE `ember` (
  `id` int(11) NOT NULL,
  `eletero` int(3) NOT NULL DEFAULT 100
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `ember`
--

INSERT INTO `ember` (`id`, `eletero`) VALUES
(1, 100),
(2, 100),
(3, 100),
(4, 100),
(5, 100),
(6, 100),
(7, 100),
(8, 100),
(9, 100),
(10, 100),
(11, 100),
(12, 100),
(13, 100),
(14, 100),
(15, 100);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `haz`
--

CREATE TABLE `haz` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `haz`
--

INSERT INTO `haz` (`id`) VALUES
(1),
(2),
(3);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `ember`
--
ALTER TABLE `ember`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `haz`
--
ALTER TABLE `haz`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `ember`
--
ALTER TABLE `ember`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT a táblához `haz`
--
ALTER TABLE `haz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
