-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2022 at 12:31 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kps`
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
-- Table structure for table `crimes_commited`
--

CREATE TABLE `crimes_commited` (
  `id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `solved` tinyint(1) NOT NULL,
  `date_commited` date NOT NULL,
  `ob_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crimes_commited`
--

INSERT INTO `crimes_commited` (`id`, `description`, `solved`, `date_commited`, `ob_number`) VALUES
(1, 'Robbery with violence', 0, '2022-07-13', 11);

-- --------------------------------------------------------

--
-- Table structure for table `criminals`
--

CREATE TABLE `criminals` (
  `Criminal_ID` int(50) NOT NULL,
  `Criminal_Name` varchar(50) NOT NULL,
  `Criminal_National_ID` int(50) NOT NULL,
  `Date_of_Arrest` date NOT NULL,
  `Next_Of_Kin` varchar(50) NOT NULL,
  `Crime_ID` int(50) NOT NULL,
  `Term` int(11) NOT NULL,
  `Suspect` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `criminals`
--

INSERT INTO `criminals` (`Criminal_ID`, `Criminal_Name`, `Criminal_National_ID`, `Date_of_Arrest`, `Next_Of_Kin`, `Crime_ID`, `Term`, `Suspect`) VALUES
(1, 'Sifa Ngari', 19181881, '2022-07-19', 'None', 1, 67, 0);

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
-- Indexes for table `crimes_commited`
--
ALTER TABLE `crimes_commited`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `criminals`
--
ALTER TABLE `criminals`
  ADD PRIMARY KEY (`Criminal_ID`);

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
