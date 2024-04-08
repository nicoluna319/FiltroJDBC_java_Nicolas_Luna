CREATE TABLE tienda(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
ubicacion VARCHAR(255) );

CREATE TABLE producto(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
precio DECIMAL(10,2) NOT NULL,
id_tienda INT,
FOREIGN KEY (id_tienda) REFERENCES tienda(id) ON DELETE CASCADE);

CREATE TABLE cliente(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
email VARCHAR(255));

CREATE TABLE compra(
id INT AUTO_INCREMENT PRIMARY KEY,
fecha_compra DATE NOT NULL,
cantidad INT(11),

id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE,

id_producto INT,
FOREIGN KEY (id_producto) REFERENCES producto(id)
);








