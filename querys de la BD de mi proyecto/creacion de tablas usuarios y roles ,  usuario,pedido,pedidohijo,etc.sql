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
 create sequence seq_id_admin
 start with 1
 increment by 1;
/*CREANDO TABLAS*/
create table administradores(
idadministrador int primary key ,
nombres varchar(20),
apellidos varchar(100),
nivel varchar(1),
telefono varchar(9),
nom_usuario char(8),
contrasenia char(8)
);

select * from usuario;

create table usuario(
id_usuario int primary key,
nombres varchar(20),
apellidos varchar(100),
puesto varchar(20),
telefono varchar(9),
nom_usuario char(8),
contrasenia char(8),
idadministrador int,
estado char(1) default '0',
foreign key (idadministrador) references administradores(idadministrador)
);

create table pedidos_padre(
id_pedidos_padre int primary key,
id_usuario int,
fecha_registro date,
nom_cliente varchar(150),
estado char(1) default '0',
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

/*INSERTO DATOS USUARIOS */
insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia,estado,idadministrador)
values(id_usuario.nextval,'frank','campos vilchez','administrador','990418363','frankcv','entrada3','0',1);

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia,estado,idadministrador)
values(id_usuario.nextval,'lucas','ramos  peres','operario','990718363','lucasrp','entrada3','0',1);

insert into usuario(id_usuario,nombres,apellidos,puesto,telefono,nom_usuario,contrasenia,estado,idadministrador)
values(id_usuario.nextval,'juana','lopez rojas','operario','990418383','juanalr','entrada3','0',1);
select * from usuario;

/*INSERTO ADMINISTRADORES*/
insert into administradores values(seq_id_admin.nextval,'maria',' aguirre aguirre','1','990418383','mariaagi','entrada3');
/*CREANDO USUARIOS*/
create user frankcv identified by entrada3;
create user lucasrp identified by entrada3;
create user juanalr identified by entrada3;

/*procedimientos almacenados */
 create or replace procedure modifica_unidades( nvounidades  int, idHijo  int) is
begin
  UPDATE peidos_hijo ph SET ph.unidades =  nvounidades
     WHERE ph.id_pedidos_hijo = idHijo;
   update peidos_hijo ph set ph.sub_total = (select precio_unitario * unidades from peidos_hijo  where id_pedidos_hijo =idhijo ) 
   where id_pedidos_hijo =idhijo;
     commit;
end modifica_unidades;

create or replace procedure modifica_precio(precio  decimal, idHijo  int) is
begin
  UPDATE peidos_hijo ph SET ph.precio_unitario =  precio
     WHERE ph.id_pedidos_hijo = idhijo;
   update peidos_hijo ph set ph.sub_total = (select precio_unitario * unidades from peidos_hijo  where id_pedidos_hijo =idhijo ) 
   where id_pedidos_hijo =idhijo;
   commit;
end modifica_precio;

begin 
   modifica_unidades(21,91);
  end;
  select * from peidos_hijo;

/* PROBANDO*/


