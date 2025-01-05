-- Table: CLIENTE
CREATE TABLE cliente
(
    -- Identificación del cliente
    id        int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    -- Nombres del cliente
    names     varchar(100)    NOT NULL,
    -- Apellido materno del cliente
    mat_lnames varchar(100)    not null,
    -- Apellido paterno del cliente
    pat_lnames varchar(100)    not null,
    -- Número de celular del cliente
    cellphone char(9)         not null,
    -- Número de DNI del cliente
    dni       char(8)         not null,
    -- Dirección del cliente
    address   varchar(200)    not null
);

-- Table: VENDEDOR
CREATE TABLE VENDEDOR
(
    -- Identificación del vendedor
    ID            int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    -- Nombres del vendedor
    NAMES         varchar(100)    NOT NULL,
    -- Apellido materno del vendedor
    MAT_LNAMES    varchar(100)    not null,
    -- Apellido paterno del vendedor
    PAT_LNAMES    varchar(100)    not null,
    -- Número de celular del vendedor
    CELLPHONE     char(9)         not null,
    -- Fecha de contratación del vendedor (Manual)
    REGISTER_DATE date            not null,
    -- Número de DNI del vendedor
    DNI           char(8)         not null,
    -- Dirección del vendedor
    ADDRESS       varchar(200)    not null
);

-- Table: PRODUCTO
CREATE TABLE PRODUCTO
(
    -- Identificación del producto
    ID    int PRIMARY KEY NOT NULL auto_increment,
    -- Nombre del producto
    NAME  varchar(100)    NOT NULL,
    -- Precio del producto
    PRICE decimal(8, 2)   NOT NULL,
    -- Marca del producto
    BRAND varchar(100)    NOT NULL
);

-- Table: VENTA
CREATE TABLE VENTA
(
    -- Identificación de la venta
    ID         int PRIMARY KEY NOT NULL auto_increment,
    -- Fecha en que se realizó la venta (Automático)
    VENTA_DATE date            NOT NULL,
    -- Tipo de pago del producto (FÍSICO | DIGITAL)
    PAY_TYPE   char(1)         NOT NULL,
    -- Identificación del cliente
    ID_CLIENT  int             NOT NULL,
    -- Identificación del vendedor
    ID_VEND    int             NOT NULL,
    -- Declarando relaciones --
    CONSTRAINT VENTA_CLIENTE_fk FOREIGN KEY (ID_CLIENT) REFERENCES CLIENTE (ID),
    CONSTRAINT VENTA_VENDEDOR_fk FOREIGN KEY (ID_VEND) REFERENCES VENDEDOR (ID)
);

-- Table: VENTA_DETALLE
CREATE TABLE VENTA_DETALLE
(
    -- Identificación del detalle de la venta
    ID          int PRIMARY KEY NOT NULL auto_increment,
    -- Cantidad total de productos a vender (Generar desde frontend)
    TOTAL_CANT  int             NOT NULL,
    -- Precio total de productos a vender (Generar desde frontend)
    TOTAL_PRICE decimal(8, 2)   NOT NULL,
    -- Identificación de venta
    ID_VEN      int             NOT NULL,
    -- Identificación de producto
    ID_PROD     int             NOT NULL,
    CONSTRAINT VENTA_DETALLE_VENTA_fk FOREIGN KEY (ID_VEN) REFERENCES VENTA (ID),
    CONSTRAINT VENTA_DETALLE_PRODUCTO_fk FOREIGN KEY (ID_PROD) REFERENCES PRODUCTO (ID)
);
