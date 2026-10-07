USE socialsoft;

CREATE TABLE canal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    fecha_creacion DATE NOT NULL,
    numero_seguidores INT NOT NULL,
    categoria VARCHAR(80) NOT NULL
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(120) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    edad INT NOT NULL,
    ciudad VARCHAR(80) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(120) NOT NULL UNIQUE,
    profesion VARCHAR(120) NOT NULL
);

CREATE TABLE plan_suscripcion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE,
    costo_mensual DECIMAL(10,2) NOT NULL
);

CREATE TABLE resolucion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE plan_resolucion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_plan_suscripcion INT NOT NULL,
    id_resolucion INT NOT NULL,
    CONSTRAINT fk_pr_plan FOREIGN KEY (id_plan_suscripcion) REFERENCES plan_suscripcion(id),
    CONSTRAINT fk_pr_resolucion FOREIGN KEY (id_resolucion) REFERENCES resolucion(id),
    CONSTRAINT uq_pr UNIQUE (id_plan_suscripcion, id_resolucion)
);

CREATE TABLE beneficio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE plan_beneficio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_plan_suscripcion INT NOT NULL,
    id_beneficio INT NOT NULL,
    CONSTRAINT fk_pb_plan FOREIGN KEY (id_plan_suscripcion) REFERENCES plan_suscripcion(id),
    CONSTRAINT fk_pb_beneficio FOREIGN KEY (id_beneficio) REFERENCES beneficio(id),
    CONSTRAINT uq_pb UNIQUE (id_plan_suscripcion, id_beneficio)
);

CREATE TABLE usuario_canal_suscripcion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_canal INT NOT NULL,
    id_plan_suscripcion INT NOT NULL,
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVA',
    CONSTRAINT fk_ucs_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT fk_ucs_canal FOREIGN KEY (id_canal) REFERENCES canal(id),
    CONSTRAINT fk_ucs_plan FOREIGN KEY (id_plan_suscripcion) REFERENCES plan_suscripcion(id),
    CONSTRAINT uq_ucs_usuario_canal UNIQUE (id_usuario, id_canal)
);

CREATE TABLE metodo_pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE pago_suscripcion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_canal_suscripcion INT NOT NULL,
    id_metodo_pago INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha_pago DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    CONSTRAINT fk_pago_ucs FOREIGN KEY (id_usuario_canal_suscripcion) REFERENCES usuario_canal_suscripcion(id),
    CONSTRAINT fk_pago_metodo FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago(id)
);

CREATE TABLE dispositivo_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_dispositivo_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);