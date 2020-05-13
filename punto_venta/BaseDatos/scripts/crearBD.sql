/*
Created		28/04/2020
Modified		28/04/2020
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/

create database punto_venta;
use punto_venta;

drop table IF EXISTS VENTAS;
drop table IF EXISTS RECIBOS;
drop table IF EXISTS PRODUCTOS;
drop table IF EXISTS USUARIOS;


Create table USUARIOS (
	user_id Varchar(20) NOT NULL,
	user_password Varchar(20) NOT NULL,
	user_name Varchar(40) NOT NULL,
	user_rol Varchar(20) NOT NULL,
	user_status Varchar(20) NOT NULL,
	UNIQUE (user_id),
 Primary Key (user_id)) ENGINE = MyISAM;

Create table PRODUCTOS (
	clave Int NOT NULL,
	descripcion Varchar(100) NOT NULL,
	unidad Varchar(20),
	inventario Int,
	precio Int NOT NULL,
	UNIQUE (clave),
 Primary Key (clave)) ENGINE = MyISAM;

Create table RECIBOS (
	folio Int NOT NULL AUTO_INCREMENT,
	user_id Varchar(20) NOT NULL,
	fecha Date NOT NULL,
	hora Time NOT NULL,
	monto Int NOT NULL,
	UNIQUE (folio),
 Primary Key (folio)) ENGINE = MyISAM;

Create table VENTAS (
	clave Int NOT NULL,
	folio Int NOT NULL,
	cantidad Int NOT NULL,
	precio_final Int NOT NULL,
 Primary Key (clave,folio)) ENGINE = MyISAM;


Alter table RECIBOS add Foreign Key (user_id) references USUARIOS (user_id) on delete  restrict on update  restrict;
Alter table VENTAS add Foreign Key (clave) references PRODUCTOS (clave) on delete  restrict on update  restrict;
Alter table VENTAS add Foreign Key (folio) references RECIBOS (folio) on delete  restrict on update  restrict;


/* Users permissions */


