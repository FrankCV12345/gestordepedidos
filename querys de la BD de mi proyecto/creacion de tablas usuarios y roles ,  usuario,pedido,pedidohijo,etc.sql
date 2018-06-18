/*creado desde adminFCV*/
/*CREANDO SECUENCIAS*/
create sequence id_pedido
 start with 1
 increment by 1;
 
create sequence id_usuario
 start with 1
 increment by 1;
/*CREANDO TABLAS*/
create table usuario(
id_usuario int primary key,
nombres varchar(20),
apellidos varchar(100),
puesto varchar(20),
telefono varchar(9),
nom_usuario char(8),
contrasenia char(8)
);
/*INSERTO DATOS */
insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'frank','campos vilchez','administrador','990418363','frankcv','entrada3');

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'lucas','ramos  peres','operario','990718363','lucasrp','entrada3');

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'juana','lopez rojas','operario','990418383','juanalr','entrada3');

select nom_usuario,contrasenia from adminFCV.usuario where nom_usuario='frankcv' and contrasenia ='entrada3' ;
select * from usuario where nom_usuario = 'frankcv' and contrasenia = 'entrada3'
/*CREANDO USUARIOS*/
create user frankcv identified by entrada3;
create user lucasrp identified by entrada3;
create user juanalr identified by entrada3;
