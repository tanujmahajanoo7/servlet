```
CREATE SCHEMA `juneuser` ;
```
```
CREATE TABLE `juneuser`.`student` (
  `id` INT NOT NULL,
  `pwd` INT NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`));
```
```
insert into student values(1,123,'Shanmbhavi',25),(2,234,'Sharath',23),(3,345,'Swapnil',25);
```
