CREATE DATABASE `poonotes` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `board` (
  `idcaderno` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `background` varchar(45) DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `arquivado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idcaderno`),
  KEY `FK_Usuario_Caderno_idx` (`idusuario`),
  CONSTRAINT `FK_Usuario_Caderno` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `card` (
  `idcard` int(11) NOT NULL AUTO_INCREMENT,
  `idboard` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
  `arquivado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idcard`),
  KEY `FK_Card_Caderno_idx` (`idboard`),
  CONSTRAINT `FK_Card_Caderno` FOREIGN KEY (`idboard`) REFERENCES `board` (`idcaderno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `board` (
  `idcaderno` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `background` varchar(45) DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `arquivado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idcaderno`),
  KEY `FK_Usuario_Caderno_idx` (`idusuario`),
  CONSTRAINT `FK_Usuario_Caderno` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;