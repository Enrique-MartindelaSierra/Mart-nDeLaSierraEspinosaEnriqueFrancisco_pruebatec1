-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-01-2024 a las 12:28:24
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(1, 'Horcajada', 'DevOps', '2022-07-07', 'Isabel', 50000),
(2, 'Martin de la sierra Espinosa', 'Programador', '2024-02-10', 'David Manuel', 20000),
(3, 'Beves', 'Research and Development', '2023-07-06', 'Lindsey', 476.81),
(4, 'Schollick', 'Human Resources', '2023-02-27', 'Lizzie', 167.64),
(5, '55', '55', '5555-11-11', '55', 55),
(6, 'Oloshkin', 'Engineering', '2023-07-31', 'Frederich', 597.6),
(7, 'Bumphrey', 'Training', '2023-04-29', 'Shanon', 288.52),
(8, 'Gallaher', 'Legal', '2023-08-04', 'Barrie', 713.21),
(9, 'Kellar', 'Services', '2023-03-02', 'Gerrard', 702.39),
(10, 'Lidington', 'Services', '2023-04-11', 'Erich', 434.77),
(11, 'Edgars', 'Marketing', '2023-12-23', 'Vonny', 296.66),
(12, 'Risdale', 'Sales', '2023-03-11', 'Rina', 439.6),
(13, 'Green', 'Training', '2023-06-10', 'Noelani', 625.16),
(14, 'Woolaghan', 'Product Management', '2023-04-28', 'Pebrook', 341.56),
(15, 'Borgnol', 'Marketing', '2023-12-21', 'Corbie', 373.95),
(16, 'Nijssen', 'Sales', '2023-04-25', 'Joellen', 388.66),
(17, 'Craik', 'Services', '2023-07-12', 'Wendell', 169.28),
(18, 'Scudder', 'Accounting', '2023-07-04', 'Rodrick', 132.04),
(19, 'Baudic', 'Human Resources', '2023-04-15', 'Mollie', 367.07),
(20, 'Pallaske', 'Business Development', '2023-11-12', 'Allin', 196.86),
(21, 'Kenvin', 'Engineering', '2023-09-28', 'Fredek', 599.14),
(22, 'Sperling', 'Product Management', '2023-04-07', 'Maryl', 925.39),
(23, 'Jouanet', 'Services', '2023-01-10', 'Haleigh', 389.14),
(24, 'Doncom', 'Product Management', '2023-01-09', 'Christie', 536.29),
(25, 'Grellier', 'Research and Development', '2023-06-08', 'Bailie', 705.24),
(26, 'Threadgold', 'Training', '2023-07-24', 'Daria', 678.9),
(27, 'Lapides', 'Product Management', '2023-02-03', 'Bondy', 399.59),
(28, 'Finden', 'Research and Development', '2023-04-22', 'Janel', 348.88),
(29, 'O\'Conor', 'Training', '2023-10-14', 'Ty', 770.83),
(30, 'Winterbotham', 'Product Management', '2023-12-01', 'Elisha', 594.89),
(31, 'Bondesen', 'Marketing', '2023-12-02', 'Lyndsie', 606.53),
(32, 'Vaan', 'Accounting', '2023-09-14', 'Sherlocke', 607.88),
(33, 'Chaddock', 'Business Development', '2023-12-20', 'Burke', 865.93),
(34, 'Cowx', 'Business Development', '2023-07-20', 'Mario', 510.99),
(35, 'Rudledge', 'Research and Development', '2023-03-17', 'Gideon', 395.87),
(36, 'Rean', 'Legal', '2023-07-03', 'Monty', 180.63),
(37, 'Kirgan', 'Training', '2023-07-30', 'Paule', 100.2),
(38, 'Buye', 'Research and Development', '2023-03-27', 'Aviva', 459.29),
(39, 'Lethley', 'Research and Development', '2023-07-25', 'Judas', 525.6),
(40, 'Piscopo', 'Research and Development', '2023-10-28', 'Lavinie', 473.03),
(41, 'Bigg', 'Marketing', '2023-05-19', 'Abraham', 808.66),
(42, 'Carous', 'Human Resources', '2023-06-24', 'Hazlett', 306.07),
(43, 'Gullifant', 'Marketing', '2023-08-26', 'Caritta', 579.49),
(44, 'Esparza', 'Training', '2023-03-20', 'Grete', 154.62),
(45, 'Jennions', 'Support', '2023-10-09', 'Raye', 611.28),
(46, 'Northfield', 'Engineering', '2023-01-27', 'Dwayne', 735.94),
(47, 'Helsby', 'Legal', '2023-09-25', 'Natal', 595.82),
(48, 'Trehearn', 'Services', '2023-01-03', 'Alonzo', 455.45),
(49, 'Winning', 'Engineering', '2023-06-25', 'Swen', 728.74),
(50, 'Menlow', 'Services', '2023-12-12', 'Barbe', 370.65),
(51, 'Pawelski', 'Research and Development', '2023-11-18', 'Byron', 278.8);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
