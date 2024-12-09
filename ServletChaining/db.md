```
CREATE SCHEMA `juneuser` ;
```
```
CREATE TABLE `juneuser`.`students` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `m1` INT NULL,
  `m2` INT NULL,
  `m3` INT NULL,
  PRIMARY KEY (`id`));
```
```
INSERT INTO `juneuser`.`students` (`id`, `name`, `m1`, `m2`, `m3`) VALUES ('1', 'Sahil', '90', '90', '90');
INSERT INTO `juneuser`.`students` (`id`, `name`, `m1`, `m2`, `m3`) VALUES ('2', 'Sushil', '80', '80', '80');
```
