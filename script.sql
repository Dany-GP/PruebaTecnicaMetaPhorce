create database MetaphorceBd;
use MetaphorceBd;

create table Contratos(
	TipoContrato int primary key auto_increment,
    Nombre varchar(50) not null,
    Descripcion varchar(200) not null
);

insert into Contratos (TipoContrato,Nombre,descripcion) values
(default,"Permanent", "Es permanente"),
(default,"Fixed-Term", "Plazo fijo"),
(default,"External", "Es externo");


create table Empleados(
	id int primary key auto_increment,
    Nombre varchar(50) not null,
    Apellidos varchar(50) not null,
    FechaNacimiento date not null,
    Correo varchar(50) not null,
    Celular varchar(20) not null,
    TipoContrato int not null,
    Activo boolean not null,
    foreign key(TipoContrato) references Contratos(TipoContrato)
);




select * from Contratos;

select * from empleados  where activo=1;