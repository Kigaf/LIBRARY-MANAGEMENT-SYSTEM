-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2022 at 09:52 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_Id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `price` int(100) NOT NULL,
  `publisher_year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_Id`, `name`, `publisher`, `price`, `publisher_year`) VALUES
(1, 'john', 'john', 700, 2000),
(2, 'java tutorial', 'tutor', 4000, 2010),
(3, 'C PROGRAMMING', 'KEN', 5000, 2000),
(4, 'humanity', 'wathiongo', 5000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book`
--

CREATE TABLE `issue_book` (
  `book_Id` int(10) NOT NULL,
  `Student_ID` int(10) NOT NULL,
  `IssueDate` date NOT NULL,
  `DueDate` date NOT NULL,
  `Return_Book` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue_book`
--

INSERT INTO `issue_book` (`book_Id`, `Student_ID`, `IssueDate`, `DueDate`, `Return_Book`) VALUES
(1, 1, '2022-11-09', '2022-11-09', ''),
(1, 1, '2022-11-09', '2022-11-15', 'No'),
(57, 1, '2022-11-09', '2022-11-15', 'No'),
(1, 1, '2022-11-08', '2022-11-15', 'No'),
(1, 2, '2022-11-08', '2022-11-15', 'No'),
(2, 1, '2022-11-08', '2022-11-15', 'YES'),
(1, 3, '2022-11-09', '2022-11-16', 'No'),
(4, 4, '2022-11-09', '2022-11-17', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Student_ID` int(100) NOT NULL,
  `Sname` text NOT NULL,
  `gender` char(10) NOT NULL,
  `coursename` varchar(100) NOT NULL,
  `faculty` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Student_ID`, `Sname`, `gender`, `coursename`, `faculty`) VALUES
(1, 'john', 'MALE', 'ANIMAL SCIENCE', 'MEDICINE'),
(2, 'juma', 'MALE', 'BIOCHEMISTRY', 'MEDICINE'),
(3, 'KEN', 'MALE', 'BIOCHEMISTRY', 'SOCIAL SCIENCES'),
(4, 'akumu aska', 'FEMALE', 'SOCIAL SCIENCE', 'HUMANITIES');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `USER_ID` int(10) NOT NULL,
  `USERNAME` text NOT NULL,
  `PASSWORD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USER_ID`, `USERNAME`, `PASSWORD`) VALUES
(1, 'user', 'pass');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_Id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Student_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `USER_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
