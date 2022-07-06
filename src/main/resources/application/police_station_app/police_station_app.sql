-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2022 at 07:05 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `police station app`
--

-- --------------------------------------------------------

--
-- Table structure for table `cases`
--

CREATE TABLE `cases` (
  `OB Number` int(50) NOT NULL,
  `Officer ID` int(50) NOT NULL,
  `Date/Time` datetime(6) NOT NULL,
  `Victim National ID` int(50) NOT NULL,
  `Case Description` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `crimes committed`
--

CREATE TABLE `crimes committed` (
  `Crime ID` int(50) NOT NULL,
  `Date Committed` date NOT NULL,
  `Crime Solved` tinyint(1) NOT NULL,
  `OB Number` int(50) NOT NULL,
  `Crime Description` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `criminals`
--

CREATE TABLE `criminals` (
  `Criminal ID` int(50) NOT NULL,
  `Criminal Name` varchar(50) NOT NULL,
  `Criminal National ID` int(50) NOT NULL,
  `Date of Arrest` date NOT NULL,
  `Next Of Kin` varchar(50) NOT NULL,
  `Crime ID` int(50) NOT NULL,
  `Term Serving In Jail` varchar(50) NOT NULL,
  `Suspect` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `officers`
--

CREATE TABLE `officers` (
  `Officers ID` int(50) NOT NULL,
  `Officers Name` varchar(50) NOT NULL,
  `National ID` int(50) NOT NULL,
  `Patrol Unit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `weapons list`
--

CREATE TABLE `weapons list` (
  `Weapons ID` int(50) NOT NULL,
  `Weapons Name` varchar(50) NOT NULL,
  `Weapons Type` varchar(50) NOT NULL,
  `Weapon Status` tinyint(1) NOT NULL,
  `Officer ID` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cases`
--
ALTER TABLE `cases`
  ADD PRIMARY KEY (`OB Number`);

--
-- Indexes for table `crimes committed`
--
ALTER TABLE `crimes committed`
  ADD PRIMARY KEY (`Crime ID`);

--
-- Indexes for table `criminals`
--
ALTER TABLE `criminals`
  ADD PRIMARY KEY (`Criminal ID`);

--
-- Indexes for table `officers`
--
ALTER TABLE `officers`
  ADD PRIMARY KEY (`Officers ID`);

--
-- Indexes for table `weapons list`
--
ALTER TABLE `weapons list`
  ADD PRIMARY KEY (`Weapons ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
