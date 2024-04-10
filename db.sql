USE centrocomercial;

CREATE TABLE tienda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL
);

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    nombre VARCHAR(255),
    precio DECIMAL(10,2),
    id_tienda INT,
	FOREIGN KEY (id_tienda) REFERENCES tienda(id) 
	ON DELETE CASCADE
);

CREATE TABLE compra (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    fecha_compra DATE NOT NULL,
    cantidad INT NOT NULL,
    id_cliente INT,
    id_producto INT,
    
	FOREIGN KEY (id_cliente) references cliente(id)
    ON DELETE CASCADE,
	FOREIGN KEY (id_producto) references producto(id)
	ON DELETE CASCADE
);

SELECT * FROM centrocomercial.tienda;


INSERT INTO `centrocomercial`.`tienda` (`id`, `nombre`, `ubicacion`) VALUES ('1', 'KOAJ', '1piso');
INSERT INTO `centrocomercial`.`tienda` (`nombre`, `ubicacion`) VALUES ('NIKE', '3piso');
INSERT INTO `centrocomercial`.`tienda` (`nombre`, `ubicacion`) VALUES ('BRANCHOS', '2Piso');

SELECT * FROM centrocomercial.producto;
INSERT INTO `centrocomercial`.`producto` (`nombre`, `precio`, `id_tienda`) VALUES ('zapatos', '40', '1');
INSERT INTO `centrocomercial`.`producto` (`nombre`, `precio`, `id_tienda`) VALUES ('camisas', '55', '2');
INSERT INTO `centrocomercial`.`producto` (`nombre`, `precio`, `id_tienda`) VALUES ('medias', '10', '3');

