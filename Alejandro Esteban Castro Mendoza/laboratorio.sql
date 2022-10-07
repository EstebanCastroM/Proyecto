-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2021 a las 06:49:30
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `laboratorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `codigo` varchar(50) NOT NULL,
  `hora` varchar(50) NOT NULL,
  `dia` varchar(50) NOT NULL,
  `mes` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`codigo`, `hora`, `dia`, `mes`, `tipo`) VALUES
('', '11:00', '23', 'Abril', 'Analis Sanguineo'),
('457', '07:00', '23', 'Enero', 'Radiografia'),
('457', '15:00', '13', 'Julio', 'Revision');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(50) NOT NULL,
  `edad` int(10) NOT NULL,
  `domicilio` varchar(50) NOT NULL,
  `codigo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `edad`, `domicilio`, `codigo`) VALUES
('Paco', 35, 'Av. La Mancha 123', '457');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `nombre` varchar(50) NOT NULL,
  `edad` int(10) NOT NULL,
  `rfc` varchar(14) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `salario` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nombre`, `edad`, `rfc`, `codigo`, `tipo`, `salario`) VALUES
('Maria Sanchez', 23, 'MSGRL43456H', '9654', 'Laboratorista', 0.00),
('Andrea Sepulveda', 21, 'AJHDSS3456L', '4683', 'Administrativo', 0.00),
('Paco el Chato', 35, 'RFTSGHL3456K', '5687', 'Administrativo', 0.00),
('Sandra Fernandez', 21, 'ERTSGQ234L', '9346', 'Administrativo', 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `codigo` int(10) NOT NULL,
  `existencia` int(10) NOT NULL,
  `precio` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`nombre`, `tipo`, `codigo`, `existencia`, `precio`) VALUES
('Pasta Dental', 'Higiene', 456, 3, '8.00'),
('Atun', 'Enlatados', 123, 6, '6.00'),
('CocaCola', 'Bebidas', 968, 15, '17.50'),
('Yakult', 'Bebida', 654, 15, '6.00'),
('Cheetos', 'Comestibles', 369, 9, '15.00'),
('Papel Higienico', 'Higiene', 835, 12, '8.00'),
('Cacahuates', 'Comestibles', 863, 32, '6.00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
