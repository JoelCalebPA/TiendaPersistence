DROP DATABASE IF EXISTS db_tienda;
-- -----------------------------------------------------
-- Schema db_tienda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_tienda` DEFAULT CHARACTER SET utf8 ;
USE `db_tienda` ;

-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_categoria` (
  `id_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_tienda`.`tbl_cliente`;
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(30) NULL DEFAULT NULL,
  `usuario` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_marca` (
  `id_marca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` INT(11) NOT NULL,
  `id_marca` INT(11) NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT(11) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_producto`),
  CONSTRAINT `fk_pro_categ`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `db_tienda`.`tbl_categoria` (`id_categoria`),
  CONSTRAINT `fk_pro_marca`
    FOREIGN KEY (`id_marca`)
    REFERENCES `db_tienda`.`tbl_marca` (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_venta` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `pago_total` DECIMAL(10,2) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_venta`),
  INDEX `fk_venta_cliente` (`id_cliente` ASC),
  CONSTRAINT `fk_venta_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `db_tienda`.`tbl_cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_tienda`.`tbl_detalle_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_tienda`.`tbl_detalle_venta`;
CREATE TABLE IF NOT EXISTS `db_tienda`.`tbl_detalle_venta` (
  `id_venta` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio` INT(11) NOT NULL,
  `estado` INT(11) NULL DEFAULT '1',
  INDEX `fk_deta_producto` (`id_producto` ASC),
  INDEX `fk_deta_venta` (`id_venta` ASC),
  PRIMARY KEY (`id_venta`, `id_producto`),
  CONSTRAINT `fk_deta_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `db_tienda`.`tbl_producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deta_venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `db_tienda`.`tbl_venta` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert  into tbl_categoria(descripcion) values('Monitor');
insert  into tbl_categoria(descripcion) values('Memoria RAM');
insert  into tbl_categoria(descripcion) values('Impresoras');
insert  into tbl_categoria(descripcion) values('Disco Duro');
insert  into tbl_categoria(descripcion) values('Teclado');
insert  into tbl_categoria(descripcion) values('Mouse');
insert  into tbl_categoria(descripcion) values('Case');
insert  into tbl_categoria(descripcion) values('Fuente');
insert  into tbl_categoria(descripcion) values('Motherboard');
insert  into tbl_categoria(descripcion) values('Microprocesasor');
insert  into tbl_categoria(descripcion) values('Tarjeta de Video');
insert  into tbl_categoria(descripcion) values('Microfono');
insert  into tbl_categoria(descripcion) values('Memoria USB');
insert  into tbl_categoria(descripcion) values('Router');
insert  into tbl_categoria(descripcion) values('Switch');

insert into tbl_marca(nombre) values ('INTEL');
insert into tbl_marca(nombre) values ('AMD');
insert into tbl_marca(nombre) values ('ASUS');
insert into tbl_marca(nombre) values ('GIGABYTE');
insert into tbl_marca(nombre) values ('COOL MASTER');
insert into tbl_marca(nombre) values ('EVGA');
insert into tbl_marca(nombre) values ('KINGSTON');
insert into tbl_marca(nombre) values ('TOSHIBA');
insert into tbl_marca(nombre) values ('SANDISK');
insert into tbl_marca(nombre) values ('ECS');
insert into tbl_marca(nombre) values ('MSI');
insert into tbl_marca(nombre) values ('GENIUS ');
insert into tbl_marca(nombre) values ('LOGITECH');
insert into tbl_marca(nombre) values ('THERMALTAKE');
insert into tbl_marca(nombre) values ('HP');
insert into tbl_marca(nombre) values ('EPSON');
insert into tbl_marca(nombre) values ('TP-LINK');
insert into tbl_marca(nombre) values ('D-LINK');

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(2,7,'KINGSTON 4GB MEMORIA RAM DIMM DDR3 1333',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(2,7,'KINGSTON 4G D3 1600 KHX FURY ROJO',169,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(2,7,'KINGSTON HYPERX SAVAGE 4GB D3 1600 KHX',190,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(2,7,'KINGSTON 4GB DDR3 1866 KHX SAVAGE',208,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(2,7,'KINGSTON 8GB MEMORIA DIMM DDR3 1333',288,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,2,'PROCESADOR AMD A6-6420K 4.20GHZ FM2',239,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,2,'PROCESADOR AMD FX-8320 AM3+ 3.5 GHZ',589,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,2,'PROCESADOR AMD FX-9590 AM3+ 4.70GHZ',959,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,1,'PROCESADOR INTEL CORE I7-3770 3.4GHZ',1180,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,1,'PROCESADOR INTEL CORE I5-4690 3.50 GHZ',840,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(10,1,'PROCESADOR INTEL CORE I3-3250 3.50GHZ',450,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,10,'MB ECS AMD 960G AM3+ SVL DDR3',270,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,10,'MOTHERBOARD ECS INTEL B85H3-M SVL DDR3',245,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,3,'MB ASUS AMD 970 AM3+ DDR3 R2.0',305,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,3,'MOTHERBOARD ASUS INTEL B85M-E SVL DDR3',329,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,4,'MOTHERBOARD GIGABYTE AMD 970 AM3+ S/L DDR3',369,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,4,'MOTHERBOARD GIGABYTE INTEL Z97-HD3P S/V/L DDR3',467,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,11,'MB MSI INTEL H97 GAMING 3 DDR3',489,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(9,11,'MOTHERBOARD MSI INTEL B85M-G43 SVL DDR3',285,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(5,12,'MICROSOFT KB+MSE WRLS 2000',143,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(5,13,'KB+MS LOG WIRELESS MK270 (LAT',83,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(5,12,'MICROSOFT KB+MSE WRLSS 3000',158,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(5,13,'Logitech Wireless Combo MK330',153,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(6,13,'MOUSE LOGITECH M317 CHRISTAL BLANCO USB',65,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(6,12,'MICROSOFT MSE MOB SCULPT MOBIL',78,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(6,13,'MOUSE LOGITECH G600S GAMING BLACK',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(6,12,'Microsoft Mse Sculpt Ergonomic',145,10);


insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,11,'VGA 1G PC MSI G210 DDR3',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,11,'VGA 2G PC MSI GT610 DDR3',199,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,3,'VGA 1G PC ASUS R5 230 SL DDR3',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,3,'VGA 2G PC ASUS GT730 CSM DDR3',245,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,6,'TARJETA DE VIDEO VGA PC EVGA GT740 2GB DDR3',378,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(11,4,'VGA 1G PC GIGABYTE GT610 FAN DDR3',167,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(7,14,'CASE THERMALTAKE CORE A41 MID TOWER',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(7,14,'MINI CASE THERMALTAKE ARMOR A30I NEGRO',409,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(7,14,'CASE THERMALTAKE CHASER A31 BLACK ED',309,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(7,14,'CASE THERMALTAKE URBAN S41 MID TOWER',459,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(3,15,'Impresora HP Deskjet Ink Advantage 1515',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(3,15,'HP LASERJET COLOR MFPM177FW',1280,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(3,16,'IMPRESORA EPSON MULTIFUNCIONAL WIFI L365 TINTA CONTINUA',778,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(3,16,'IMPRESORA EPSON MULTIFUNCIONAL L220 TINTA CONTINUA',718,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(15,17,'8-PORT 10/100M SWITCH',135,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(15,18,'SWITCH DLINK 24PT 10/100',200,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(14,17,'WIRELESS N300 VPN SOHO ROUTER',356,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(14,18,'150MBPS WIRELESS ADSL2+ ROUTER',89,10);

insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(13,9,'USB Sandisk 4GB Cruzer Blade',14,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(13,9,'USB SanDisk Cruzer Orbit 8GB',16,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(13,7,'KING USB DTMCK/8GB BLACK',20,10);
insert into tbl_producto(id_categoria,id_marca,descripcion,precio,stock) values(13,7,'USB KINGSTON 8GB DT MICRODUO OTG',19,10);