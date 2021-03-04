-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2021 at 04:43 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `netcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `developer`
--

CREATE TABLE `developer` (
  `id` bigint(20) NOT NULL,
  `developer_code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `developer`
--

INSERT INTO `developer` (`id`, `developer_code`, `email`, `image_url`, `job_title`, `name`, `phone`) VALUES
(1, '84a08d29-1422-49ff-9e7f-ed410ccf585e', 'test@commmmmsdfsdfsdf', 'urlImage', 'test2', 'mejhajlosdffsdsd', '12345'),
(3, 'd33e1390-9175-4975-bf75-20c835ab5e51', 'test@commmmmsdfsdfsdffdsf', 'urlImagefsddfs', 'test253', 'mejhajlosdffsdsdsdfsfd', '123453455'),
(6, '5ac9c0c2-6261-4a89-87f8-816739b6049d', 'test@commmmmsdfsdfsdffdsf12345', 'urlImagefsddfs', 'test25334343', 'mejhajlosdffsdsdsdfsfd', '666'),
(7, '1709e742-ece8-4949-aa52-13b38be7fead', 'test@commmmmsdfsdfsdffdsf', 'urlImagefsddfs', 'test25334343', 'mejhajlosdffsdsdsdfsfd', '666'),
(8, '7cfa10dd-ebe2-451d-864d-468eea0c887a', 'test@commmmmsdfsdfsdffdsf12345', 'urlImagefsddfs', 'test25334343', 'mejhajlosdffsdsdsdfsfd', '666');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `privilege` int(11) NOT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `description`, `email`, `name`, `password`, `privilege`, `surname`, `username`) VALUES
(1, 'description2', 'wr@lol.comdfsfsd', 'developer2', 'developer12345', 54335435, 'loolll', 'kevin54321'),
(2, 'description5', 'wr@lol.fsdfsd', 'user', 'user', 54335435, 'user', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `developer`
--
ALTER TABLE `developer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `developer`
--
ALTER TABLE `developer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
