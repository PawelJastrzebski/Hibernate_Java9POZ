CREATE TABLE `test`.`person` (
  `idperson` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`idperson`));

INSERT INTO `test`.`person` (`idperson`, `name`, `surname`, `age`) VALUES ('1', 'bob', 'bobsurname', '20');
INSERT INTO `test`.`person` (`idperson`, `name`, `surname`, `age`) VALUES ('2', 'tom', 'tomsurname', '30');
INSERT INTO `test`.`person` (`idperson`, `name`, `surname`, `age`) VALUES ('3', 'jerry', 'jerrysurname', '40');


CREATE TABLE `test`.`dog` (
  `idDog` INT NOT NULL,
  `person_id` INT NULL,
  PRIMARY KEY (`idDog`));

