/*CREATE database ProyectoDS;*/
USE ProyectoDS;
CREATE TABLE Locales(
IDLocales int NOT NULL,
Nombre varchar(50),
Direccion varchar(100),
Telefono varchar(10),
Internet INT,
PRIMARY KEY(IDLocales),
CONSTRAINT CHKInternet CHECK (Internet=1 OR Internet=0)
);
CREATE TABLE Articulos(
IDArticulos int NOT NULL,
Marca varchar(50),
Modelo varchar(50),
Precio float,
Color varchar(50),
IDLocales int NOT NULL,
PRIMARY KEY(IDArticulos),
FOREIGN KEY(IDLocales) REFERENCES Locales(IDLocales)
);
CREATE TABLE Cocinas(
IDCocina int NOT NULL,
Induccion int,
IDArticulos int NOT NULL,
Nombre varchar(50),
PRIMARY KEY(IDCocina),
CONSTRAINT CHKInduccion CHECK (Induccion=1 OR Induccion=0),
FOREIGN KEY(IDArticulos) REFERENCES Articulos(IDArticulos)
);
CREATE TABLE Refrigeradoras(
IDRefrigeradora int NOT NULL,
IDArticulos int NOT NULL,
Nombre varchar(50),
PRIMARY KEY(IDRefrigeradora),
FOREIGN KEY(IDArticulos) REFERENCES Articulos(IDArticulos)
);
CREATE TABLE Lavadoras(
IDLavadoras int NOT NULL,
IDArticulos int NOT NULL,
Nombre varchar(50),
PRIMARY KEY(IDLavadoras),
FOREIGN KEY(IDArticulos) REFERENCES Articulos(IDArticulos)
);
CREATE TABLE Personas(
IDPersonas int NOT NULL,
Nombre varchar(50),
Apellido varchar(50),
Cedula varchar(10),
Telefono varchar(10),
Direccion varchar(100),
PRIMARY KEY(IDPersonas)
);
CREATE TABLE Usuarios(
Usuario varchar(50) NOT NULL,
Clave varchar(50) NOT NULL,
Tipo varchar(20),
IDPersonas int NOT NULL,
IDLocales int NOT NULL,
PRIMARY KEY(Usuario),
FOREIGN KEY(IDLocales) REFERENCES Locales(IDLocales),
FOREIGN KEY(IDPersonas) REFERENCES Personas(IDPersonas)
);
CREATE TABLE Administrador(
IDAdmin int NOT NULL,
Usuario varchar(50) NOT NULL,
PRIMARY KEY(IDAdmin),
FOREIGN KEY(Usuario) REFERENCES Usuarios(Usuario)
);
CREATE TABLE Gerente(
IDGerente int NOT NULL,
Usuario varchar(50) NOT NULL,
PRIMARY KEY(IDGerente),
FOREIGN KEY(Usuario) REFERENCES Usuarios(Usuario)
);
CREATE TABLE Vendedor(
IDVendedor int NOT NULL,
Usuario varchar(50) NOT NULL,
PRIMARY KEY(IDVendedor),
FOREIGN KEY(Usuario) REFERENCES Usuarios(Usuario)
);
CREATE TABLE Cliente(
IDCliente int NOT NULL,
Correo varchar(50) NOT NULL,
IDPersonas int NOT NULL,
IDLocales int NOT NULL,
IDVendedor int NOT NULL,
PRIMARY KEY(IDCliente),
FOREIGN KEY(IDLocales) REFERENCES Locales(IDLocales),
FOREIGN KEY(IDPersonas) REFERENCES Personas(IDPersonas),
FOREIGN KEY(IDVendedor) REFERENCES Vendedor(IDVendedor)
);
CREATE TABLE Documentos(
IDDoc int NOT NULL,
Ruc varchar(13),
IDCliente int NOT NULL,
Fecha Date,
Codigo varchar(15),
IDLocales int NOT NULL,
PRIMARY KEY(IDDoc),
FOREIGN KEY(IDLocales) REFERENCES Locales(IDLocales),
FOREIGN KEY(IDCliente) REFERENCES Cliente(IDCliente),
);
CREATE TABLE Facturas(
IDFacturas int NOT NULL,
IDDoc int NOT NULL,
Valor float,
IVA float,
ValorFinal float,
PRIMARY KEY(IDFacturas),
FOREIGN KEY(IDDoc) REFERENCES Documentos(IDDoc)
);
CREATE TABLE NotasCredito(
IDNCredito int NOT NULL,
IDDoc int NOT NULL,
Valor float,
Devolucion varchar(100),
Descripcion varchar(100),
PRIMARY KEY(IDNCredito),
FOREIGN KEY(IDDoc) REFERENCES Documentos(IDDoc)
);
CREATE TABLE ComprobanteRetencion(
IDCRentencion int NOT NULL,
IDDoc int NOT NULL,
Impuesto float,
PRIMARY KEY(IDCRentencion),
FOREIGN KEY(IDDoc) REFERENCES Documentos(IDDoc)
);
CREATE TABLE Transaccion(
IDTRANS int NOT NULL,
Fecha date,
Hora Datetime,
IDCliente int NOT NULL,
PRIMARY KEY(IDTRANS),
FOREIGN KEY(IDCliente) REFERENCES Cliente(IDCliente)
);
CREATE TABLE Pago(
IDPago int NOT NULL,
Tipo varchar(50),
ValorPagado float,
Saldo float,
IDTRANS int NOT NULL,
IDVendedor int NOT NULL,
PRIMARY KEY(IDPago),
FOREIGN KEY(IDTRANS) REFERENCES Transaccion(IDTRANS),
FOREIGN KEY(IDVendedor) REFERENCES Vendedor(IDVendedor),
CONSTRAINT CHKTipo CHECK (Tipo='Efectivo' OR Tipo='Visa'),
);
CREATE TABLE Ventas(
IDVentas int NOT NULL,
PrecioFinal float,
Fecha date,
IDPago int NOT NULL,
IDArticulos int NOT NULL,
IDTRANS int NOT NULL,
IDVendedor int NOT NULL,
IDCliente int NOT NULL,
PRIMARY KEY(IDVentas),
FOREIGN KEY(IDTRANS) REFERENCES Transaccion(IDTRANS),
FOREIGN KEY(IDVendedor) REFERENCES Vendedor(IDVendedor),
FOREIGN KEY(IDArticulos) REFERENCES Articulos(IDArticulos),
FOREIGN KEY(IDCliente) REFERENCES Cliente(IDCliente),
FOREIGN KEY(IDPago) REFERENCES Pago(IDPago)
);
CREATE TABLE Cotizaciones(
IDCotizacion int NOT NULL,
PrecioFinal float,
IDArticulos int NOT NULL,
IDTRANS int NOT NULL,
IDVendedor int NOT NULL,
PRIMARY KEY(IDCotizacion),
FOREIGN KEY(IDTRANS) REFERENCES Transaccion(IDTRANS),
FOREIGN KEY(IDVendedor) REFERENCES Vendedor(IDVendedor),
FOREIGN KEY(IDArticulos) REFERENCES Articulos(IDArticulos)
);


INSERT INTO "Locales" ("IDLocales", "Nombre", "Direccion", "Telefono", "Internet") VALUES
(1,	'Matriz',	'Calle 25',	'1800600600',	0),
(2,	'Sucursal','Calle 30',	'1800600500',	0),
(3,	'Bodega',	'Calle 35',	'1800600400',	0)

INSERT INTO Articulos (IDArticulos,Marca,Modelo,Precio,Color,IDLocales) VALUES
(2,'Indurama','CU-0946',349.98999,	'Negro',	1),
(1,'Indurama','CU-0945',249.990005,	'Blanco',	1),
(3,'Durex','RE-8345',599.98999,'Gris',1),
(4,'Durex','RE-8346',799.98999,'Negro',1),
(5,'Mabe','LA-2345',689.98999,'Blanco',1),
(6,'Mabe','LA-2346',789.98999,'Blanco',1),
(7,'Mabe','LA-2347',349.98999,'Gris',1),
(8,'Indurama','CU-0945',249.990005,'Blanco',2)

INSERT INTO "Cocinas" ("IDCocina", "Induccion", "IDArticulos", "Nombre") VALUES
(1,	1,	1,	'Cocina'),
(2,	1,	2,	'Cocina')

INSERT INTO "Refrigeradoras" ("IDRefrigeradora", "IDArticulos", "Nombre") VALUES
(1,	3,	'Refrigeradora'),
(2,	4,	'Refrigeradora')

INSERT INTO "Lavadoras" ("IDLavadoras", "IDArticulos", "Nombre") VALUES
(1,	5,	'Lavadora'),
(2,	6,	'Lavadora'),
(3,	7,	'Lavadora')

INSERT INTO "Personas" ("IDPersonas", "Nombre", "Apellido", "Cedula", "Telefono", "Direccion") VALUES
(1,	'Manuel',	'Garcia',	'0947384954',	'0980008000',	'Calle 1'),
(2,	'Daniela',	'Salazar',	'0939283475',	'0970007000',	'Calle 2'),
(3,	'Ricardo',	'Montalvo',	'0938273495',	'0960006000',	'Calle 3'),
(4,	'Elisa',	'Jimenez',	'1309483920',	'0950005000',	'Calle 4'),
(5,	'Paul',	'Gonzabay',	'1304384956',	'0940004000',	'Calle 5'),
(6,	'Emilia',	'Torres',	'0938495849',	'0930003000',	'Calle 6'),
(7,	'Julio',	'Moreno',	'0937283495',	'0920002000',	'Calle 7'),
(8,	'Melissa',	'Miranda',	'0938473829',	'0910001000',	'Calle 8'),
(9,	'Israel',	'Pimentel',	'0928394059',	'0912345670',	'Avenida 1'),
(10,	'Belen',	'Bermudez',	'0937281948',	'0912345671',	'Avenida 2'),
(11,	'Joan',	'Sanchez',	'0938293049',	'0912345672',	'Avenida 3')

INSERT INTO "Usuarios" ("Usuario", "Clave", "IDPersonas", "IDLocales") VALUES
('mangar',	'80008000',	1,	1),
('dansal',	'70007000',	2,	1),
('paugon',	'40004000',	5,	1),
('ricmon',	'60006000',	3,	2),
('elijim',	'50005000',	4,	3),
('emitor',	'30003000',	6,	1),
('julmor',	'20002000',	7,	2),
('melmir',	'10001000',	8,	2)

INSERT INTO "Administrador" ("IDAdmin", "Usuario") VALUES
(1,	'mangar')

INSERT INTO "Gerente" ("IDGerente", "Usuario") VALUES
(1,	'dansal'),
(2,	'ricmon'),
(3,	'elijim')

INSERT INTO "Vendedor" ("IDVendedor", "Usuario") VALUES
(1,	'paugon'),
(2,	'emitor'),
(3,	'julmor'),
(4,	'melmir')

INSERT INTO "Cliente" ("IDCliente", "Correo", "IDPersonas", "IDLocales", "IDVendedor") VALUES
(1,	'isrpim@gmail.com',	9,	1,	1),
(2,	'belber@gmail.com',	10,	2,	3),
(3,	'joasan@gmail.com',	11,	2,	3)

INSERT INTO "Documentos" ("IDDoc", "RUC", "IDCliente", "Fecha", "Codigo", "IDLocales") VALUES
(1,'0928394059001',1,'2018-08-17','FA-001',1),
(2,'0937281948002',2,'2018-08-17','CR-001',2),
(3,'0938292049001',3,'2018-08-17','NC-001',2),
(4,'0937281948002',2,'2018-08-17','FA-002',2)


INSERT INTO "Facturas" ("IDFacturas", "IDDoc", "Valor", "IVA", "ValorFinal") VALUES
(1,	1,	599.98999,	0.119999997,	671.98999),
(2,	4,	249.990005,	0.119999997,	279.98999)

INSERT INTO "ComprobanteRetencion" ("IDCRentencion", "IDDoc", "Impuesto") VALUES
(1,	2,	93.4000015)

INSERT INTO "NotasCredito" ("IDNCredito", "IDDoc", "Valor", "Devolucion", "Descripcion") VALUES
(1,	3,	89.0299988,	'Algun valor',	'Algun valor')

INSERT INTO "Transaccion" ("IDTrans", "Fecha", "Hora", "IDCliente") VALUES
(2,	'2018-08-18',	'14:00:00',	2),
(3,	'2018-08-18',	'15:00:00',	3),
(1,	'2018-08-17',	'09:00:00',	1)

INSERT INTO"Pago" ("IDPago", "Tipo", "ValorPagado", "Saldo", "IDTrans", "IDVendedor") VALUES
(2,	'Visa',	279.98999,	0,	2,	3),
(1,	'Efectivo',	700,	28.0100002,	1,	1)

INSERT INTO Cotizaciones ("IDCotizacion", "PrecioFinal", "IDArticulos", "IDTrans", "IDVendedor") VALUES
(1,	279.98999,	8,	3,	3)

INSERT INTO Ventas("IDVentas", "PrecioFinal", "IDPago", "IDArticulos", "IDTrans", "IDVendedor", "Fecha", "IDCliente") VALUES
(1	,671.98999	,1	,3	,1	,1	,'2018-08-17'	,1),
(2	,279.98999	,2	,8	,2	,3	,'2018-08-18'	,2)
