 /*creado desde adminFCV*/
/*CREANDO SECUENCIAS*/
create sequence id_pedido
 start with 1
 increment by 1;
 create sequence id_pedido_hijo
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
select * from usuario;

create table pedidos_padre(
id_pedidos_padre int primary key,
id_usuario int,
fecha_registro date,
nom_cliente varchar(150),
foreign key(id_usuario)
references usuario(id_usuario)
);

create table peidos_hijo(
id_pedidos_hijo int primary key,
id_pedidos_padre int,
categoria varchar(30),
unidades int,
precio_unitario decimal(8,2),
fecha_entrega date,
detalle varchar(500),
Sub_total decimal(8,2),
foreign key(id_pedidos_padre)
references   pedidos_padre(id_pedidos_padre)   
);

/*INSERTO DATOS */
insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'frank','campos vilchez','administrador','990418363','frankcv','entrada3');

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'lucas','ramos  peres','operario','990718363','lucasrp','entrada3');

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia)
values(id_usuario.nextval,'juana','lopez rojas','operario','990418383','juanalr','entrada3');

insert into pedidos_padre(id_pedidos_padre,id_usuario,fecha_registro,nom_cliente)
values(id_pedido.nextval,2,sysdate,'ana jara');
select * from pedidos_padre;
insert  into peidos_hijo values(id_pedido_hijo.nextval,21,'chompas',5,25,'05/07/2018','con rayas rojas',125);
select * from pedidos_padre;
select nom_usuario,contrasenia from adminFCV.usuario where nom_usuario='frankcv' and contrasenia ='entrada3' ;
select * from usuario where nom_usuario = 'frankcv' and contrasenia = 'entrada3'
select  * from peidos_hijo where id_pedidos_padre =142;
/*CREANDO USUARIOS*/
create user frankcv identified by entrada3;
create user lucasrp identified by entrada3;
create user juanalr identified by entrada3;
