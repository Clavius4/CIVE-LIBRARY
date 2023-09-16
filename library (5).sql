-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2022 at 11:20 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admintb`
--

CREATE TABLE `admintb` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admintb`
--

INSERT INTO `admintb` (`username`, `password`) VALUES
('Mcharo', '123'),
('T21-03-04626', 'Mcharo');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `file` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `uploaded_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `bookname`, `file`, `category`, `uploaded_time`) VALUES
(1, 'practice problems', 'practiceproblems.pdf', 'Programming language', '2022-09-12 16:10:51'),
(2, 'pdf_sample', 'pdf-sample.pdf', 'Programming language', '2022-09-12 16:10:57'),
(3, 'adobe', 'c4611_sample_explain.pdf', 'Networking', '2022-09-12 16:11:02'),
(4, 'sample5', 'A17_FlightPlan.pdf', 'Programming language', '2022-09-12 16:11:06'),
(5, 'sample6', 'test.pdf', 'Programming language', '2022-09-12 16:11:12'),
(7, 'sample8', 'sample_doc.pdf', 'Networking', '2022-09-12 16:11:17'),
(8, 'sample9', 'how_to_pay1.pdf', 'Networking', '2022-09-12 16:11:25'),
(9, 'probaility', 'ST1210 Basic Probability_Lecture1a.pdf', 'Programming language', '2022-09-12 16:11:32'),
(10, 'ST1210 Basic Probability_Lecture1a.pdf', 'ST1210 Basic Probability_Lecture1a.pdf', 'Networking', '2022-09-12 16:11:39'),
(11, 'ST 1210 LECTURE 2.pdf', 'ST 1210 LECTURE 2.pdf', 'Programming language', '2022-09-12 16:11:46'),
(12, 'ST1210 Lecture 1b.pdf', 'ST1210 Lecture 1b.pdf', 'Programming language', '2022-09-12 16:11:51'),
(13, 'LECTURE 3c.pdf', 'LECTURE 3c.pdf', 'Programming language', '2022-09-12 16:11:56'),
(14, 'Timothy Pintello - Pintello, T_ Introduction to Networking with Network+-John Wiley & Sons (2012)', 'Timothy Pintello - Pintello, T_ Introduction to Networking with Network+-John Wiley & Sons (2012).pdf', 'Programming language', '2022-09-12 16:12:03'),
(15, 'Timothy Pintello - Pintello, T_ Introduction to Networking with Network+-John Wiley & Sons (2012)', 'Timothy Pintello - Pintello, T_ Introduction to Networking with Network+-John Wiley & Sons (2012).pdf', 'Programming language', '2022-09-12 16:12:08'),
(16, 'CN BOOK', 'CN121_Lecture_05  - Copy.pdf', 'Networking', '2022-09-12 16:12:13'),
(17, 'CN BOOK2', 'compnetwork.pdf', 'Networking', '2022-09-12 16:12:17'),
(18, 'COMMUNICATION PROCESS .pdf', 'COMMUNICATION PROCESS .pdf', 'Networking', '2022-09-12 16:12:24'),
(40, 'COMMUNICATION PROCESS .pdf', 'COMMUNICATION PROCESS .pdf', 'Networking', '2022-09-12 16:10:40');

-- --------------------------------------------------------

--
-- Table structure for table `book_borrow`
--

CREATE TABLE `book_borrow` (
  `id` int(255) NOT NULL,
  `book_number` varchar(255) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `borrow_date` varchar(255) NOT NULL,
  `return_date` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `borrowedbookstb`
--

CREATE TABLE `borrowedbookstb` (
  `reg_no` varchar(20) NOT NULL,
  `book_id` int(11) NOT NULL,
  `book_tittle` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `borrowed_date` varchar(50) NOT NULL,
  `deadline` varchar(50) NOT NULL,
  `id_left` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowedbookstb`
--

INSERT INTO `borrowedbookstb` (`reg_no`, `book_id`, `book_tittle`, `category`, `borrowed_date`, `deadline`, `id_left`) VALUES
('T21-03-04626', 1, 'c++', 'Programming', '13-09-2022', '16-09-2022', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` int(255) NOT NULL,
  `notification` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `reg_no` varchar(20) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `secondname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `programme` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phonenumber` varchar(255) NOT NULL,
  `pword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`reg_no`, `firstname`, `secondname`, `lastname`, `programme`, `email`, `phonenumber`, `pword`) VALUES
('T21-03-00148', 'Pius', 'Oscar', 'Pius', 'Bsc.SE', 'piusoscar2015@gmail.com', '+255746633340', 'Pius9719'),
('T21-03-00219', 'yakobo', 'Isaac', 'kalenge', 'bsc.cs', 'youngjwizzy@gmail.com', '+255 714737410', 'kalewiz'),
('T21-03-01021', 'Agripina', 'Nerey', 'Mvungi', 'Bsc-SE', 'agripinahenry08@gmail.com', '+255734987255', 'Virdiana2000'),
('T21-03-02836', 'Hamisi', 'shehe', 'shafii', 'Bsc Se', 'hamisishehe@gmail.com', '+255653918817', 'Hamisi2233'),
('T21-03-03979', 'Prince', 'A', 'Mujuni', 'Bsc.Se', 'princeaugustine@gmail.com', '+255783980796', 'princeMjn+7'),
('T21-03-04001', 'Amos', 'Abdala', 'Nyoni', 'BCS SE', 'amosnyoni2000@gmail.com', '+255676796515', '123amos'),
('T21-03-04262', 'PAUL', 'NKINGWA', 'THOMAS', 'BSC. SE', 'paulnkingwa34@gmail.com', '+255675753415', 'Clavius4@1'),
('T21-03-04626', 'GODFREY', 'ELIA', 'MCHARO', 'BSc. SE', 'mcharo@gmail.com', '+255746561545', 'Mcharo12\"'),
('T21-03-04721', 'rebeca', 'edison', 'samanda', 'SE', 'samandarebeca@gmail.com', '+255763241307', 'samanda'),
('T21-03-10230', 'Lauren', 'Abdon', 'Minde', 'BCS CE', 'laurentminde@gmail.com', '+255786789856', 'laulaulau'),
('T21-03-12876', 'Renalda', 'Freeman', 'Mallya', 'Bsc-IS', 'renaldafreeman@gmail.com', '+255673902524', 'Renny08.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admintb`
--
ALTER TABLE `admintb`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_borrow`
--
ALTER TABLE `book_borrow`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrowedbookstb`
--
ALTER TABLE `borrowedbookstb`
  ADD PRIMARY KEY (`reg_no`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`reg_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `book_borrow`
--
ALTER TABLE `book_borrow`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowedbookstb`
--
ALTER TABLE `borrowedbookstb`
  ADD CONSTRAINT `borrowedbookstb_ibfk_1` FOREIGN KEY (`reg_no`) REFERENCES `students` (`reg_no`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
