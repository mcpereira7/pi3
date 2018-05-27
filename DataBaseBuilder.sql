CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `board` (
  `idboard` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `background` varchar(45) DEFAULT NULL,
  `arquivado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idboard`),
  KEY `FK_Board_Usuario_idx` (`idusuario`),
  CONSTRAINT `FK_Board_Usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `card` (
  `idcard` int(11) NOT NULL AUTO_INCREMENT,
  `idboard` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
  `arquivado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idcard`),
  KEY `FK_Card_Board_idx` (`idboard`),
  CONSTRAINT `FK_Card_Board` FOREIGN KEY (`idboard`) REFERENCES `board` (`idboard`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `poonotes`.`usuario` 
ADD COLUMN `idboarddefault` INT(11) NULL AFTER `senha`;

ALTER TABLE `poonotes`.`usuario` 
ADD INDEX `FK_Usuario_Board_idx` (`idboarddefault` ASC);
ALTER TABLE `poonotes`.`usuario` 
ADD CONSTRAINT `FK_Usuario_Board`
  FOREIGN KEY (`idboarddefault`)
  REFERENCES `poonotes`.`board` (`idboard`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `poonotes`.`usuario` 
DROP FOREIGN KEY `FK_Usuario_Board`;
ALTER TABLE `poonotes`.`usuario` 
CHANGE COLUMN `idboarddefault` `idboarddefault` INT(11) NOT NULL AFTER `idusuario`,
ADD UNIQUE INDEX `idboarddefault_UNIQUE` (`idboarddefault` ASC);
ALTER TABLE `poonotes`.`usuario` 
ADD CONSTRAINT `FK_Usuario_Board`
  FOREIGN KEY (`idboarddefault`)
  REFERENCES `poonotes`.`board` (`idboard`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;