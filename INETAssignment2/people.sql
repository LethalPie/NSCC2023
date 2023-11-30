-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 05, 2023 at 08:03 PM
-- Server version: 8.0.31
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inet2005`
--

-- --------------------------------------------------------

--
-- Table structure for table `people`
--

CREATE TABLE `people` (
  `id` int NOT NULL,
  `firstName` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `city` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `people`
--

INSERT INTO `people` (`id`, `firstName`, `lastName`, `email`, `city`, `age`) VALUES
(1, 'Jane', 'Doe', 'jane.doe@yahoo.com', 'Houston', 31),
(2, 'John', 'Taylor', 'john.taylor@yahoo.com', 'Los Angeles', 38),
(3, 'Charlie', 'Brown', 'charlie.brown@outlook.com', 'Los Angeles', 41),
(4, 'Charlie', 'Doe', 'charlie.doe@yahoo.com', 'Houston', 24),
(5, 'Bob', 'Johnson', 'bob.johnson@yahoo.com', 'Houston', 40),
(6, 'Alice', 'Doe', 'alice.doe@yahoo.com', 'Chicago', 59),
(7, 'Alice', 'Smith', 'alice.smith@gmail.com', 'New York', 62),
(8, 'Charlie', 'Doe', 'charlie.doe@gmail.com', 'Houston', 41),
(9, 'Bob', 'Taylor', 'bob.taylor@outlook.com', 'New York', 32),
(10, 'Bob', 'Doe', 'bob.doe@yahoo.com', 'New York', 26),
(11, 'Charlie', 'Brown', 'charlie.brown@yahoo.com', 'Los Angeles', 60),
(12, 'Jane', 'Smith', 'jane.smith@yahoo.com', 'Miami', 29),
(13, 'Alice', 'Brown', 'alice.brown@outlook.com', 'Houston', 60),
(14, 'John', 'Doe', 'john.doe@yahoo.com', 'New York', 26),
(15, 'Eve', 'Brown', 'eve.brown@yahoo.com', 'Chicago', 41),
(16, 'John', 'Doe', 'john.doe@gmail.com', 'Los Angeles', 54),
(17, 'Alice', 'Doe', 'alice.doe@yahoo.com', 'Houston', 25),
(18, 'Eve', 'Brown', 'eve.brown@yahoo.com', 'Houston', 45),
(19, 'Charlie', 'Brown', 'charlie.brown@gmail.com', 'Miami', 21),
(20, 'Bob', 'Smith', 'bob.smith@outlook.com', 'Houston', 58),
(21, 'Alice', 'Doe', 'alice.doe@outlook.com', 'New York', 39),
(22, 'Charlie', 'Johnson', 'charlie.johnson@yahoo.com', 'Los Angeles', 24),
(23, 'Bob', 'Brown', 'bob.brown@yahoo.com', 'Houston', 48),
(24, 'John', 'Doe', 'john.doe@gmail.com', 'Miami', 56),
(25, 'Eve', 'Smith', 'eve.smith@outlook.com', 'Houston', 44),
(26, 'Bob', 'Brown', 'bob.brown@gmail.com', 'Chicago', 47),
(27, 'Charlie', 'Johnson', 'charlie.johnson@yahoo.com', 'Los Angeles', 21),
(28, 'John', 'Smith', 'john.smith@outlook.com', 'Houston', 34),
(29, 'Jane', 'Smith', 'jane.smith@outlook.com', 'Miami', 63),
(30, 'Eve', 'Brown', 'eve.brown@yahoo.com', 'New York', 39),
(31, 'Bob', 'Johnson', 'bob.johnson@gmail.com', 'Miami', 65),
(32, 'John', 'Doe', 'john.doe@outlook.com', 'Chicago', 59),
(33, 'Bob', 'Smith', 'bob.smith@outlook.com', 'New York', 24),
(34, 'Alice', 'Taylor', 'alice.taylor@yahoo.com', 'Chicago', 26),
(35, 'John', 'Brown', 'john.brown@outlook.com', 'Houston', 50),
(36, 'Jane', 'Brown', 'jane.brown@yahoo.com', 'Miami', 56),
(37, 'Alice', 'Brown', 'alice.brown@outlook.com', 'Miami', 51),
(38, 'Jane', 'Doe', 'jane.doe@gmail.com', 'Miami', 46),
(39, 'Charlie', 'Doe', 'charlie.doe@yahoo.com', 'New York', 18),
(40, 'John', 'Doe', 'john.doe@outlook.com', 'Miami', 57),
(41, 'Alice', 'Doe', 'alice.doe@yahoo.com', 'Miami', 49),
(42, 'John', 'Brown', 'john.brown@gmail.com', 'Los Angeles', 37),
(43, 'Eve', 'Smith', 'eve.smith@gmail.com', 'New York', 28),
(44, 'John', 'Smith', 'john.smith@outlook.com', 'New York', 23),
(45, 'Eve', 'Brown', 'eve.brown@yahoo.com', 'New York', 50),
(46, 'Eve', 'Taylor', 'eve.taylor@gmail.com', 'Houston', 33),
(47, 'Jane', 'Smith', 'jane.smith@outlook.com', 'Los Angeles', 40),
(48, 'Alice', 'Taylor', 'alice.taylor@outlook.com', 'Los Angeles', 59),
(49, 'Eve', 'Johnson', 'eve.johnson@outlook.com', 'Los Angeles', 21),
(50, 'John', 'Brown', 'john.brown@yahoo.com', 'New York', 33),
(51, 'Alice', 'Taylor', 'alice.taylor@outlook.com', 'Los Angeles', 59),
(52, 'John', 'Taylor', 'john.taylor@outlook.com', 'Chicago', 28),
(53, 'Charlie', 'Taylor', 'charlie.taylor@yahoo.com', 'New York', 34),
(54, 'Charlie', 'Brown', 'charlie.brown@outlook.com', 'Chicago', 37),
(55, 'Bob', 'Johnson', 'bob.johnson@outlook.com', 'Chicago', 52),
(56, 'Alice', 'Smith', 'alice.smith@yahoo.com', 'Los Angeles', 50),
(57, 'Eve', 'Doe', 'eve.doe@gmail.com', 'New York', 42),
(58, 'Bob', 'Johnson', 'bob.johnson@gmail.com', 'Miami', 60),
(59, 'John', 'Doe', 'john.doe@gmail.com', 'New York', 35),
(60, 'Charlie', 'Taylor', 'charlie.taylor@outlook.com', 'Chicago', 63),
(61, 'Jane', 'Doe', 'jane.doe@yahoo.com', 'Los Angeles', 30),
(62, 'Jane', 'Johnson', 'jane.johnson@outlook.com', 'Los Angeles', 22),
(63, 'Bob', 'Doe', 'bob.doe@outlook.com', 'Houston', 34),
(64, 'Eve', 'Brown', 'eve.brown@gmail.com', 'Miami', 57),
(65, 'Eve', 'Smith', 'eve.smith@outlook.com', 'Houston', 58),
(66, 'Charlie', 'Brown', 'charlie.brown@yahoo.com', 'Houston', 41),
(67, 'Bob', 'Doe', 'bob.doe@yahoo.com', 'Los Angeles', 36),
(68, 'John', 'Johnson', 'john.johnson@yahoo.com', 'Houston', 30),
(69, 'Alice', 'Johnson', 'alice.johnson@outlook.com', 'Miami', 32),
(70, 'Jane', 'Taylor', 'jane.taylor@outlook.com', 'Los Angeles', 40),
(71, 'Bob', 'Smith', 'bob.smith@yahoo.com', 'Chicago', 24),
(72, 'Jane', 'Doe', 'jane.doe@gmail.com', 'New York', 43),
(73, 'Bob', 'Doe', 'bob.doe@gmail.com', 'Chicago', 22),
(74, 'Jane', 'Johnson', 'jane.johnson@outlook.com', 'Miami', 65),
(75, 'Jane', 'Johnson', 'jane.johnson@outlook.com', 'Miami', 22),
(76, 'Alice', 'Doe', 'alice.doe@outlook.com', 'Miami', 35),
(77, 'Bob', 'Johnson', 'bob.johnson@gmail.com', 'Miami', 52),
(78, 'Eve', 'Smith', 'eve.smith@gmail.com', 'Houston', 63),
(79, 'Jane', 'Brown', 'jane.brown@yahoo.com', 'Los Angeles', 40),
(80, 'Eve', 'Brown', 'eve.brown@outlook.com', 'Chicago', 54),
(81, 'Alice', 'Taylor', 'alice.taylor@yahoo.com', 'Chicago', 33),
(82, 'Alice', 'Taylor', 'alice.taylor@gmail.com', 'Miami', 50),
(83, 'Eve', 'Johnson', 'eve.johnson@yahoo.com', 'Houston', 33),
(84, 'Jane', 'Doe', 'jane.doe@yahoo.com', 'Houston', 50),
(85, 'Eve', 'Johnson', 'eve.johnson@outlook.com', 'Chicago', 38),
(86, 'Bob', 'Johnson', 'bob.johnson@gmail.com', 'New York', 43),
(87, 'Charlie', 'Doe', 'charlie.doe@outlook.com', 'Miami', 22),
(88, 'John', 'Taylor', 'john.taylor@gmail.com', 'Los Angeles', 55),
(89, 'Bob', 'Taylor', 'bob.taylor@gmail.com', 'Chicago', 58),
(90, 'Charlie', 'Smith', 'charlie.smith@gmail.com', 'New York', 33),
(91, 'Bob', 'Doe', 'bob.doe@gmail.com', 'Chicago', 63),
(92, 'Bob', 'Taylor', 'bob.taylor@outlook.com', 'Houston', 32),
(93, 'Charlie', 'Johnson', 'charlie.johnson@gmail.com', 'Houston', 27),
(94, 'Alice', 'Brown', 'alice.brown@outlook.com', 'Chicago', 22),
(95, 'Alice', 'Doe', 'alice.doe@outlook.com', 'Chicago', 43),
(96, 'Alice', 'Taylor', 'alice.taylor@yahoo.com', 'Houston', 50),
(97, 'Jane', 'Brown', 'jane.brown@outlook.com', 'Miami', 61),
(98, 'John', 'Johnson', 'john.johnson@outlook.com', 'Miami', 19),
(99, 'Bob', 'Taylor', 'bob.taylor@yahoo.com', 'Houston', 21),
(100, 'Bob', 'Johnson', 'bob.johnson@yahoo.com', 'Houston', 58);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `people`
--
ALTER TABLE `people`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
