```
CREATE SCHEMA `kodapp` ;
```
```
CREATE TABLE `kodapp`.`koduser` (
  `kodid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`kodid`));
```
```
INSERT INTO `kodapp`.`koduser` (`kodid`, `password`, `name`, `email`, `gender`, `phone`) VALUES ('kod1', 'kod1', 'sam', 'sam@gmail.com', 'male', '7766');
INSERT INTO `kodapp`.`koduser` (`kodid`, `password`, `name`, `email`, `gender`, `phone`) VALUES ('kod2', 'kod2', 'sruthi', 'sruthi@gmail.com', 'female', '2383');
```
