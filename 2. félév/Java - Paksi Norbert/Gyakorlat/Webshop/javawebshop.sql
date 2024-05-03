-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Gép: localhost:3306
-- Létrehozás ideje: 2023. Júl 16. 00:20
-- Kiszolgáló verziója: 5.7.24
-- PHP verzió: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `javawebshop`
--
CREATE DATABASE IF NOT EXISTS `javawebshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `javawebshop`;

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `createAddress` (IN `countryIN` VARCHAR(30), IN `postcodeIN` CHAR(4), IN `cityIN` VARCHAR(30), IN `home_addressIN` VARCHAR(100), IN `commentIN` TEXT)   INSERT INTO `address` (`address`.`country`, `address`.`postcode`, `address`.`city`, `address`.`home_address`,`address`.`comment`)
VALUES (countryIN, postcodeIN, cityIN, home_addressIN, commentIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createBasket` (IN `user_idIN` INT, IN `product_idIN` INT, IN `quantityIN` INT, IN `upload_timeIN` DATE, IN `statusIN` ENUM('kosárban','törölve','megvéve'), IN `delete_timeIN` DATE)   INSERT INTO `basket` (`basket`.`user_id`, `basket`.`product_id`, `basket`.`quantity`, `basket`.`upload_time`, `basket`.`status`, `basket`.`delete_time`)
VALUES (user_idIN, product_idIN, quantityIN, upload_timeIN, statusIN, delete_timeIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createCategory` (IN `nameIN` VARCHAR(50))   INSERT INTO `category` (`category`.`name`)
VALUES (nameIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createCupon` (IN `cupon_codeIN` VARCHAR(20), IN `validity_startIN` DATE, IN `validity_endIN` DATE, IN `statusIN` INT)   INSERT INTO `cupon` (`cupon`.`cupon_code`, `cupon`.`validity_start`, `cupon`.`validity_end`, `cupon`.`status`)
VALUES (cupon_codeIN, validity_startIN, validity_endIN, statusIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createOrder` (IN `user_idIN` INT, IN `dateIN` DATE, IN `statusIN` INT, IN `sum_priceIN` INT, IN `address_idIN` INT, IN `modifierIN` INT, IN `modification_dateIN` DATE, IN `cupon_idIN` INT)   INSERT INTO `order` (`order`.`user_id`, `order`.`date`, `order`.`status`, `order`.`sum_price`, `order`.`address_id`, `order`.`modifier`, `order`.`modification_date`, `order`.`cupon_id`)
VALUES (user_idIN, dateIN, statusIN, sum_priceIN, address_idIN, modifierIN, modification_dateIN, cupon_idIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createOrder_products` (IN `product_idIN` INT, IN `product_quantityIN` INT, IN `order_idIN` INT)   INSERT INTO `order_products` (`order_products`.`product_id`, `order_products`.`product_quantity`, `order_products`.`order_id`)
VALUES (product_idIN, product_quantityIN, order_idIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createProduct` (IN `priceIN` INT, IN `nameIN` VARCHAR(100), IN `category_idIN` INT, IN `imageIN` VARCHAR(100), IN `descriptionIN` TEXT, IN `stockIN` INT)   INSERT INTO `product` (`product`.`price`, `product`.`name`, `product`.`category_id`, `product`.`image`, `product`.`description`, `product`.`stock`)
VALUES (priceIN, nameIN, category_idIN, imageIN, descriptionIN, stockIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createProduct_modification` (IN `product_idIN` INT, IN `old_priceIN` INT, IN `old_nameIN` VARCHAR(100), IN `old_category_idIN` INT, IN `old_imageIN` VARCHAR(100), IN `old_descriptionIN` TEXT, IN `old_stockIN` INT, IN `new_priceIN` INT, IN `new_nameIN` VARCHAR(100), IN `new_category_idIN` INT, IN `new_imageIN` VARCHAR(100), IN `new_descriptionIN` TEXT, IN `new_stockIN` INT, IN `modifierIN` INT, IN `modification_dateIN` TIMESTAMP)   INSERT INTO `product_modification` (`product_modification`.`product_id`, `product_modification`.`old_price`, `product_modification`.`old_name`, `product_modification`.`old_category_id`, `product_modification`.`old_image`, `product_modification`.`old_description`, `product_modification`.`old_stock`, `product_modification`.`new_price`, `product_modification`.`new_name`, `product_modification`.`new_category_id`, `product_modification`.`new_image`, `product_modification`.`new_description`, `product_modification`.`new_stock`, `product_modification`.`modifier`, `product_modification`.`modification_date`)
VALUES (product_idIN, old_priceIN, old_nameIN, old_category_idIN, old_imageIN, old_descriptionIN, old_stockIN, new_priceIN, new_nameIN, new_category_idIN, new_imageIN, new_descriptionIN, new_stockIN, modifierIN, modification_dateIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createProduct_type` (IN `product_idIN` INT, IN `type_idIN` INT)   INSERT INTO `product_type` (`product_type`.`product_id`, `product_type`.`type_id`)
VALUES (product_idIN, type_idIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createType` (IN `nameIN` VARCHAR(50))   INSERT INTO `type` (`type`.`name`)
VALUES (nameIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createUser` (IN `usernameIN` VARCHAR(100), IN `emailIN` VARCHAR(100), IN `passwordIN` VARCHAR(100), IN `rankIN` ENUM('admin','vásárló'), IN `phoneIN` VARCHAR(11), IN `surenameIN` VARCHAR(50), IN `forenameIN` VARCHAR(50), IN `statusIN` INT)   INSERT INTO `user` (`user`.`username`, `user`.`email`, `user`.`password`, `user`.`rank`, `user`.`phone`, `user`.`surename`, `user`.`forename`, `user`.`status`, `user`.`last_login`, `user`.`registration_time`)
VALUES (usernameIN, emailIN, SHA1(passwordIN), rankIN, phoneIN, surenameIN, forenameIN, statusIN, NULL, CURRENT_TIMESTAMP())$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createUser_addresses` (IN `user_idIN` INT, IN `address_idIN` INT, IN `typeIN` ENUM('otthoni','munkahelyi','kedvenc'), IN `creation_dateIN` DATE)   INSERT INTO `user_addresses` (`user_addresses`.`user_id`, `user_addresses`.`address_id`, `user_addresses`.`type`, `user_addresses`.`creation_date`)
VALUES (user_idIN, address_idIN, typeIN, sreation_dateIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAddress` (IN `idIN` INT)   DELETE FROM `address` WHERE `address`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBasket` (IN `idIN` INT)   DELETE FROM `basket` WHERE `basket`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCategory` (IN `idIN` INT)   DELETE FROM `category` WHERE `category`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCupon` (IN `idIN` INT)   DELETE FROM `cupon` WHERE `cupon`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteOrder` (IN `idIN` INT)   DELETE FROM `order` WHERE `order`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteOrder_products` (IN `idIN` INT)   DELETE FROM `order_products` WHERE `order_products`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProduct` (IN `idIN` INT)   DELETE FROM `product` WHERE `product`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProduct_modification` (IN `idIN` INT)   DELETE FROM `product_modification` WHERE `product_modification`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProduct_type` (IN `idIN` INT)   DELETE FROM `product_type` WHERE `product_type`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteType` (IN `idIN` INT)   DELETE FROM `type` WHERE `type`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `idIN` INT)   DELETE FROM `user` WHERE `user`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser_address` (IN `idIN` INT)   DELETE FROM `user_address` WHERE `user_address`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `emailIN` VARCHAR(100), IN `passwordIN` VARCHAR(100), OUT `idOUT` INT(11))   SELECT `user`.`ID` INTO idOUT FROM `user` 
WHERE `user`.`email` = emailIN AND `user`.`password` = SHA1(passwordIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateAddress` (IN `idIN` INT, IN `newCountryIN` VARCHAR(30), IN `newPostcodeIN` CHAR(4), IN `newCityIN` VARCHAR(30), IN `newHome_addressIN` VARCHAR(100), IN `newCommentIN` TEXT)   UPDATE `address`
SET `address`.`country` = newCountryIN, `address`.`postcode` = newPostcodeIN, `address`.`city` = newCityIN, `address`.`home_address` = newHome_addressIN, `address`.`comment` = newCommentIN
WHERE `address`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBasket` (IN `idIN` INT, IN `newUser_idIN` INT, IN `newProduct_idIN` INT, IN `newQuantityIN` INT, IN `newUpload_timeIN` DATE, IN `newStatusIN` ENUM('kosárban','törölve','megvéve'), IN `newDelete_timeIN` DATE)   UPDATE `basket`
SET `basket`.`user_id` = newUser_idIN, `basket`.`product_id` = newProduct_idIN, `basket`.`quantity` = newQuantityIN, `basket`.`upload_time` = newUpload_timeIN, `basket`.`status` = newStatusIN, `basket`.`delete_time` = newDelete_timeIN
WHERE `basket`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCategory` (IN `idIN` INT, IN `newNameIN` VARCHAR(50))   UPDATE `category`
SET `category`.`name` = newNameIN
WHERE `category`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCupon` (IN `idIN` INT, IN `newCupon_codeIN` VARCHAR(20), IN `newValidity_startIN` DATE, IN `newValidity_endIN` DATE, IN `newStatusIN` INT)   UPDATE `cupon`
SET `cupon`.`cupon_code` = newCupon_codeIN, `cupon`.`validity_start` = newValidity_startIN, `cupon`.`validity_end` = newValidity_endIN, `cupon`.`status` = newStatusIN
WHERE `cupon`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateOrder` (IN `idIN` INT, IN `newUser_idIN` INT, IN `newDateIN` DATE, IN `newStatusIN` INT, IN `newSum_priceIN` INT, IN `newAddress_idIN` INT, IN `newModifierIN` INT, IN `newModification_dateIN` DATE, IN `newCupon_idIN` INT)   UPDATE `order`
SET `order`.`user_id` = newUser_idIN. `order`.`date` = newDateIN, `order`.`status` = newStatusIN, `order`.`sum_price` = newSum_priceIN, `order`.`address_id` = newAddress_idIN, `order`.`modifier` = newModifierIN, `order`.`modification_date` = newModification_dateIN, `order`.`cupon_id` = newCupon_idIN
WHERE `order`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateOrder_products` (IN `idIN` INT, IN `newProduct_idIN` INT, IN `newProduct_quantityIN` INT, IN `newOrder_idIN` INT)   UPDATE `order_products`
SET `order_products`.`product_id` = newProduct_idIN, `order_products`.`product_quantity` = newProduct_quantityIN, `order_products`.`order_id` = newOrder_idIN
WHERE `order_products`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProduct` (IN `idIN` INT, IN `newPriceIN` INT, IN `newNameIN` VARCHAR(100), IN `newCategory_idIN` INT, IN `newImageIN` VARCHAR(100), IN `newDescriptionIN` TEXT, IN `newStockIN` INT)   UPDATE `product`
SET `product`.`price` = newPriceIN, `product`.`name` = newNameIN, `product`.`category_id` = newCategory_idIN, `product`.`image` = newImageIN, `product`.`description` = newDescriptionIN, `product`.`stock` = newStockIN
WHERE `product`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProduct_modification` (IN `idIN` INT, IN `newProduct_idIN` INT, IN `newOld_priceIN` INT, IN `newOld_nameIN` VARCHAR(100), IN `newOld_category_idIN` INT, IN `newOld_imageIN` VARCHAR(100), IN `newOld_descriptionIN` TEXT, IN `newOld_stockIN` INT, IN `newNew_priceIN` INT, IN `newNew_nameIN` VARCHAR(100), IN `newNew_category_idIN` INT, IN `newNew_imageIN` VARCHAR(100), IN `newNew_descriptionIN` TEXT, IN `newNew_stockIN` INT, IN `newModifierIN` INT, IN `newModification_dateIN` TIMESTAMP)   UPDATE `product_modification`
SET `product_modification`.`product_id` = newProduct_idIN, `product_modification`.`old_price` = newOld_priceIN, `product_modification`.`old_name` = newOld_nameIN, `product_modification`.`old_category_id` = newOld_category_idIN, `product_modification`.`old_image` = newOld_imageIN, `product_modification`.`old_description` = newOld_descriptionIN, `product_modification`.`old_stock` = newOld_stockIN, `product_modification`.`new_price` = newNew_priceIN, `product_modification`.`new_name` = newNew_nameIN, `product_modification`.`new_category_id` = newNew_category_idIN, `product_modification`.`new_image` = newNew_imageIN, `product_modification`.`new_description` = newNew_descriptionIN, `product_modification`.`new_stock` = newNew_stockIN, `product_modification`.`modifier` = newModifierIN, `product_modification`.`modification_date` = newModification_dateIN
WHERE `product_modification`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProduct_type` (IN `idIN` INT, IN `newProduct_idIN` INT, IN `newType_idIN` INT)   UPDATE `product_type`
SET `product_type`.`product_id` = newProduct_idIN, `product_type`.`type_id` = newType_idIN
WHERE `product_type`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateType` (IN `idIN` INT, IN `newNameIN` VARCHAR(50))   UPDATE `type`
SET `type`.`name` = newNameIN
WHERE `type`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser` (IN `idIN` INT, IN `newUsernameIN` VARCHAR(100), IN `newEmailIN` VARCHAR(100), IN `newPasswordIN` VARCHAR(100), IN `newRankIN` ENUM('admin','vásárló'), IN `newPhoneIN` VARCHAR(11), IN `newSurenameIN` VARCHAR(50), IN `newForenameIN` VARCHAR(50), IN `newStatusIN` INT, IN `newLast_loginIN` DATE, IN `newRegistration_timeIN` TIMESTAMP)   UPDATE `user`
SET `user`.`username` = newUsernameIN, `user`.`email` = newEmailIN, `user`.`password` = newPasswordIN, `user`.`rank` = newRankIn, `user`.`phone` = newPhoneIN, `user`.`surename` = newSurenameIN, `user`.`forename` = newForenameIN, `user`.`status` = newStatusIn, `user`.`last_login` = newLast_loginIN, `user`.`registration_time` = newRegistration_timeIN
WHERE `user`.`ID` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser_addresses` (IN `idIN` INT, IN `newUser_idIN` INT, IN `newAddress_idIN` INT, IN `newTypeIN` ENUM('otthoni','munkahelyi','kedvenc'), IN `newCreatin_dateIN` DATE)   UPDATE `user_addresses`
SET `user_addresses`.`user_id` = newUser_idIN, `user_addresses`.`address_id` = newAddress_idIN, `user_addresses`.`type` = newTypeIN, `user_addresses`.`creation_date` = newCreation_dateIN
WHERE `user_addresses`.`ID` = idIN$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `address`
--

CREATE TABLE `address` (
  `ID` int(11) NOT NULL,
  `country` varchar(30) NOT NULL,
  `postcode` char(4) NOT NULL,
  `city` varchar(30) NOT NULL,
  `home_address` varchar(100) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `basket`
--

CREATE TABLE `basket` (
  `ID` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `upload_time` date NOT NULL,
  `status` enum('kosárban','törölve','megvéve') NOT NULL,
  `delete_time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cupon`
--

CREATE TABLE `cupon` (
  `ID` int(11) NOT NULL,
  `cupon_code` varchar(20) NOT NULL,
  `validity_start` date NOT NULL,
  `validity_end` date NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `order`
--

CREATE TABLE `order` (
  `ID` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` int(11) NOT NULL,
  `sum_price` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `modifier` int(11) NOT NULL,
  `modification_date` date NOT NULL,
  `cupon_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `order_products`
--

CREATE TABLE `order_products` (
  `ID` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product`
--

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category_id` int(11) NOT NULL,
  `image` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product_modification`
--

CREATE TABLE `product_modification` (
  `ID` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `old_price` int(11) NOT NULL,
  `old_name` varchar(100) NOT NULL,
  `old_category_id` int(11) NOT NULL,
  `old_image` varchar(100) NOT NULL,
  `old_description` text NOT NULL,
  `old_stock` int(11) NOT NULL,
  `new_price` int(11) NOT NULL,
  `new_name` varchar(100) NOT NULL,
  `new_category_id` int(11) NOT NULL,
  `new_image` varchar(100) NOT NULL,
  `new_description` text NOT NULL,
  `new_stock` int(11) NOT NULL,
  `modifier` int(11) NOT NULL,
  `modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product_type`
--

CREATE TABLE `product_type` (
  `ID` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `type`
--

CREATE TABLE `type` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rank` enum('admin','vásárló') NOT NULL,
  `phone` varchar(11) NOT NULL,
  `surename` varchar(50) NOT NULL,
  `forename` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `last_login` date DEFAULT NULL,
  `registration_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`ID`, `username`, `email`, `password`, `rank`, `phone`, `surename`, `forename`, `status`, `last_login`, `registration_time`) VALUES
(1, 'admin', 'admin@gmail.com', 'f865b53623b121fd34ee5426c792e5c33af8c227', 'vásárló', '123456', 'ad', 'min', 1, NULL, '2023-05-30 11:35:25'),
(2, 'admin1', 'admin1@gmail.com', 'f865b53623b121fd34ee5426c792e5c33af8c227', 'vásárló', '123456789', 'Nagy', 'Anna', 1, NULL, '2023-05-30 12:18:41');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_addresses`
--

CREATE TABLE `user_addresses` (
  `ID` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `type` enum('othoni','munkahelyi','kedvenc') NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `cupon`
--
ALTER TABLE `cupon`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `order_products`
--
ALTER TABLE `order_products`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `product_modification`
--
ALTER TABLE `product_modification`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `product_type`
--
ALTER TABLE `product_type`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- A tábla indexei `user_addresses`
--
ALTER TABLE `user_addresses`
  ADD PRIMARY KEY (`ID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `address`
--
ALTER TABLE `address`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `basket`
--
ALTER TABLE `basket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `cupon`
--
ALTER TABLE `cupon`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `order`
--
ALTER TABLE `order`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `order_products`
--
ALTER TABLE `order_products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `product`
--
ALTER TABLE `product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `product_modification`
--
ALTER TABLE `product_modification`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `product_type`
--
ALTER TABLE `product_type`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `type`
--
ALTER TABLE `type`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `user_addresses`
--
ALTER TABLE `user_addresses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
