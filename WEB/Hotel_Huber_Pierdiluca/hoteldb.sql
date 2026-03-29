-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Jan 2024 um 13:24
-- Server-Version: 10.4.28-MariaDB
-- PHP-Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `hoteldb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `news`
--

CREATE TABLE `news` (
  `nID` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `imagepath` varchar(50) NOT NULL,
  `postDate` date NOT NULL DEFAULT current_timestamp(),
  `postTime` time NOT NULL DEFAULT current_timestamp(),
  `fk_uID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `news`
--

INSERT INTO `news` (`nID`, `title`, `description`, `imagepath`, `postDate`, `postTime`, `fk_uID`) VALUES
(71, 'Titel', 'lorem ipsum', 'uploads/news/thumb/luigi.jpg', '2024-01-11', '12:49:56', 6),
(72, 'Neuer post', 'weiterrer text', 'uploads/news/thumb/Hallwylfjellet.jpg', '2024-01-11', '12:50:18', 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservations`
--

CREATE TABLE `reservations` (
  `rID` int(11) NOT NULL,
  `room` int(3) NOT NULL,
  `currDate` date NOT NULL,
  `currTime` time NOT NULL,
  `dateStart` date NOT NULL,
  `dateEnd` date NOT NULL,
  `price` int(11) NOT NULL,
  `fk_uID` int(11) NOT NULL,
  `extras` enum('Frühstück','Parkplatz','Haustiere') DEFAULT NULL,
  `status` enum('neu','bestätigt','storniert','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `reservations`
--

INSERT INTO `reservations` (`rID`, `room`, `currDate`, `currTime`, `dateStart`, `dateEnd`, `price`, `fk_uID`, `extras`, `status`) VALUES
(1, 101, '2024-01-01', '11:51:44', '2024-01-23', '2024-01-30', 230, 6, 'Frühstück', 'storniert'),
(2, 102, '2024-01-11', '12:26:02', '2024-01-25', '2024-01-30', 570, 2, 'Haustiere', 'neu');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `uID` int(11) NOT NULL,
  `uemail` varchar(100) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `upassword` varchar(260) NOT NULL,
  `sex` enum('male','female','other') NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT 0,
  `isActive` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`uID`, `uemail`, `uname`, `upassword`, `sex`, `firstname`, `lastname`, `isAdmin`, `isActive`) VALUES
(2, 'ruffy@monkeyd.com', 'Mugiwara', '$2y$10$MQ0o2txi/aFhwupZg0dtd.91j4VeMynJ2i7C6mGqnPkB6D2KKGb7O', 'male', 'Monkey D.', 'Ruffy', 0, 1),
(3, 'testarina@test.at', 'Test1234', '$2y$10$Nkbba6OPcbZFDHJmFOpaJehaQ939uD6JrKjuU2YCHzj36uK6mgz6q', 'female', 'testa', 'testara', 0, 1),
(6, 'admin@gmail.com', 'AdminUser', '$2y$10$JOI4.zBRqcZ6rQ9D7zIwp.BNVFcWALGgiXujFOGrke8LdumsYPg9i', 'other', 'Admin', 'admin', 1, 1),
(7, 'karl.heinz@gmx.at', 'KarlHeinz', '$2y$10$cuqyMCMKm4.AnSCkSAXFG.pWL6BQmpkMa83V3hSDEW7L3P8UQHX1W', '', 'Karl Heinz', 'Hotelbesucher', 0, 0),
(8, 'gutenberg@business.com', 'GutSabi', '$2y$10$QNN32a4skxw5xYQWlB.Skuz.wQZyfmg5i6EfiktIZTJD0jHmMtViK', '', 'Sabine', 'Gutenberg', 0, 1),
(9, 'alice@wunderland.at', 'EatDaCake', '$2y$10$MXsOb68YxTzj6z/FykdNOuiM1Qd/BFlAvSDfKY6ikwVl9iPmuk9Ma', 'other', 'Alicio', 'Im Wunderland', 0, 1),
(10, 'passwort@gmail.com', 'Geheim', '$2y$10$5Ok7ez9weXQfhTAnDVPI/OGiYOJqy2u11uewKBIbtpVpRxfXohcV2', 'other', 'passwort', 'passwort', 0, 1),
(11, 'Bob@bob.bob', 'Bob', '$2y$10$JIR2cxafK6D2JjSAryUQQ.83/B5yy7FvsONzCbmXzMeSv4GOVmRGa', 'female', 'Bobalicious', 'Bob', 0, 1),
(12, 'kageyama@mob.com', '100%', '$2y$10$KJaHdmZneDOazwmiP44raONdCfaoI5hX/ujBu/7CvZt8ZngkmS7bO', 'male', 'Kageyama', 'psycho', 0, 1),
(13, 'bob@gmail.com', 'Bob1234', '$2y$10$3GS6TquvMuzWrilX82eKLu480i547oTbKbF2VuErgCz/5iRlsyJnG', 'other', 'Bob', 'Bob', 0, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`nID`);

--
-- Indizes für die Tabelle `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`rID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `news`
--
ALTER TABLE `news`
  MODIFY `nID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT für Tabelle `reservations`
--
ALTER TABLE `reservations`
  MODIFY `rID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `uID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
