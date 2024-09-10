CREATE TABLE ingrediente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(64) NOT NULL,
    descripcion VARCHAR(256),
    calorias FLOAT CHECK (calorias >= 0),
    carbohidratos FLOAT CHECK (carbohidratos >= 0),
    proteinas FLOAT CHECK (proteinas >= 0),
    grasas FLOAT CHECK (grasas >= 0)
);

CREATE TABLE plato (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(64) NOT NULL,
    descripcion VARCHAR(256),
    otros_ingredientes TEXT,
    cantidad_ingrediente_principal FLOAT NOT NULL CHECK (cantidad_ingrediente_principal >= 0),
    calorias FLOAT CHECK (calorias >= 0),
    carbohidratos FLOAT CHECK (carbohidratos >= 0),
    proteinas FLOAT CHECK (proteinas >= 0),
    grasas FLOAT CHECK (grasas >= 0),
    favorito BOOLEAN DEFAULT FALSE,
    ingrediente_id BIGINT NOT NULL,
    FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id)
);
