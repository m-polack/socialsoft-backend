USE socialsoft;

INSERT INTO plan_suscripcion (nombre, costo_mensual) VALUES
('BASICA', 9.90),
('PREMIUM', 19.90),
('VIP', 29.90);

INSERT INTO resolucion (nombre, descripcion) VALUES
('SD', 'Resolución estándar'),
('HD', 'Alta definición'),
('4K', 'Ultra alta definición');

INSERT INTO plan_resolucion (id_plan_suscripcion, id_resolucion) VALUES
(1, 1),

(2, 1),
(2, 2),

(3, 1),
(3, 2),
(3, 3);

INSERT INTO beneficio (nombre, descripcion) VALUES
('Acceso al canal', 'Permite visualizar el canal contratado'),
('Grabación de programas', 'Permite grabar programas del canal'),
('Multidispositivo', 'Permite ver el canal en más de un dispositivo'),
('Soporte prioritario', 'Permite acceder a soporte preferencial'),
('Sin publicidad adicional', 'Reduce la publicidad adicional del servicio'),
('Control parental', 'Permite configurar restricciones de contenido'),
('Reproducción en diferido', 'Permite ver programas emitidos recientemente');

INSERT INTO plan_beneficio (id_plan_suscripcion, id_beneficio) VALUES
(1, 1),
(1, 6),

(2, 1),
(2, 2),
(2, 6),
(2, 7),

(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(3, 7);

INSERT INTO canal (nombre, descripcion, fecha_creacion, numero_seguidores, categoria) VALUES
('CinePlus', 'Canal dedicado a películas', '2020-05-10', 150000, 'Entretenimiento'),
('TechWorld', 'Tecnología y review de gadgets', '2018-11-22', 87000, 'Tecnología'),
('FitnessPro', 'Entrenamientos y salud', '2021-01-15', 56000, 'Salud'),
('CocinaMaster', 'Recetas y clases de cocina', '2019-08-03', 120000, 'Gastronomía'),
('MusicLive', 'Conciertos en vivo y sesiones', '2021-09-12', 98000, 'Música'),
('GameZone', 'Gameplay y streams', '2020-02-18', 210000, 'Videojuegos'),
('TravelNow', 'Viajes y experiencias', '2017-06-30', 45000, 'Viajes'),
('EduMaster', 'Cursos y tutoriales', '2019-11-10', 76000, 'Educación'),
('AutoTech', 'Autos y tecnología', '2022-03-05', 35000, 'Tecnología'),
('FashionStyle', 'Moda y tendencias', '2021-04-22', 68000, 'Moda');

INSERT INTO usuario (nombre_completo, dni, edad, ciudad, fecha_nacimiento, telefono, correo, profesion) VALUES
('Ana Paredes', '74581236', 28, 'Lima', '1997-03-14', '987654321', 'ana@gmail.com', 'Ingeniera de Sistemas'),
('Luis Rojas', '81245960', 32, 'Arequipa', '1993-07-22', '953214876', 'lrojas@gmail.com', 'Administrador'),
('Marta Salas', '70125648', 27, 'Cusco', '1998-01-05', '981234567', 'martasalas@gmail.com', 'Contadora'),
('Jorge Quispe', '78451230', 35, 'Lima', '1990-11-18', '999111222', 'jquispe@gmail.com', 'Analista de Datos'),
('Elena Torres', '76543218', 29, 'Trujillo', '1996-04-09', '912345678', 'etorres@gmail.com', 'Diseñadora Gráfica'),
('Daniel Medina', '78654321', 30, 'Piura', '1995-09-13', '934567812', 'dmedina@gmail.com', 'Profesor');

INSERT INTO usuario_canal_suscripcion 
(id_usuario, id_canal, id_plan_suscripcion, estado) VALUES
(1, 1, 3, 'ACTIVA'),
(1, 2, 2, 'ACTIVA'),
(2, 3, 1, 'ACTIVA'),
(3, 4, 2, 'ACTIVA'),
(4, 6, 3, 'ACTIVA'),
(5, 10, 1, 'ACTIVA'),
(6, 8, 2, 'ACTIVA');

INSERT INTO metodo_pago (nombre) VALUES
('Tarjeta de crédito'),
('Tarjeta de débito'),
('Yape'),
('Plin'),
('Transferencia');

INSERT INTO pago_suscripcion 
(id_usuario_canal_suscripcion, id_metodo_pago, monto, fecha_pago, estado) VALUES
(1, 1, 29.90, '2026-06-01', 'PAGADO'),
(2, 2, 19.90, '2026-06-02', 'PAGADO'),
(3, 3, 9.90, '2026-06-03', 'PAGADO'),
(4, 4, 19.90, '2026-06-04', 'PAGADO'),
(5, 1, 29.90, '2026-06-05', 'PAGADO');

INSERT INTO dispositivo_usuario
(id_usuario, nombre, tipo, sistema_operativo, activo) VALUES
(1, 'Smart TV Samsung', 'Televisor', 'Tizen', TRUE),
(1, 'iPhone Ana', 'Celular', 'iOS', TRUE),
(2, 'Laptop Luis', 'Laptop', 'Windows', TRUE),
(3, 'Tablet Marta', 'Tablet', 'Android', TRUE),
(4, 'Smart TV LG', 'Televisor', 'webOS', TRUE);