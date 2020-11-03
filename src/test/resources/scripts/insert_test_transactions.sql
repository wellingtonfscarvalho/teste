CREATE TABLE IF NOT EXISTS Accounts (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Document_Number` BIGINT(20) NULL,
  PRIMARY KEY (`Id`));

CREATE TABLE IF NOT EXISTS OperationsTypes (
  `Id` INT NOT NULL,
  `Description` VARCHAR(100) NULL,
  PRIMARY KEY (`Id`));
  
insert into Accounts (Document_Number) values (123456789789);

insert into OperationsTypes values (1, 'COMPRA A VISTA');
insert into OperationsTypes values (2, 'COMPRA PARCELADA');
insert into OperationsTypes values (3, 'SAQUE');
insert into OperationsTypes values (4, 'PAGAMENTO');