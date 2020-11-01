CREATE SCHEMA `testepismo`;

USE `testepismo`;

CREATE TABLE `testepismo`.`Accounts` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Document_Number` BIGINT(20) NULL,
  PRIMARY KEY (`Id`));
  
CREATE TABLE `testepismo`.`OperationsTypes` (
  `Id` INT NOT NULL,
  `Description` VARCHAR(100) NULL,
  PRIMARY KEY (`Id`));
  
CREATE TABLE `testepismo`.`Transactions` (
  `Id` INT(100) NOT NULL AUTO_INCREMENT,
  `Account_Id` INT(11) NULL,
  `OperationType_Id` INT NULL,
  `Amount` DECIMAL(10,3) NULL,
  `EventDate` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Transactions_Accounts_idx` (`Account_Id` ASC),
  INDEX `FK_Transactions_OperationsTypes_idx` (`OperationType_Id` ASC),
  CONSTRAINT `FK_Transactions_Accounts`
    FOREIGN KEY (`Account_Id`)
    REFERENCES `testepismo`.`Accounts` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Transactions_OperationsTypes`
    FOREIGN KEY (`OperationType_Id`)
    REFERENCES `testepismo`.`OperationsTypes` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
insert into testepismo.OperationsTypes values (1, 'COMPRA A VISTA');
insert into testepismo.OperationsTypes values (2, 'COMPRA PARCELADA');
insert into testepismo.OperationsTypes values (3, 'SAQUE');
insert into testepismo.OperationsTypes values (4, 'PAGAMENTO');