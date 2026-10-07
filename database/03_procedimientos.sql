USE socialsoft;

DROP PROCEDURE IF EXISTS insertarUsuarioCanalSuscripcion;
DELIMITER $$
CREATE PROCEDURE insertarUsuarioCanalSuscripcion(
    IN p_id_usuario INT,
    IN p_id_canal INT,
    IN p_id_plan_suscripcion INT
)
BEGIN
    INSERT INTO usuario_canal_suscripcion(
        id_usuario,
        id_canal,
        id_plan_suscripcion
    )
    VALUES (
        p_id_usuario,
        p_id_canal,
        p_id_plan_suscripcion
    );
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerCanalPorId;
DELIMITER $$
CREATE PROCEDURE obtenerCanalPorId(
    IN p_id INT
)
BEGIN
    SELECT *
    FROM canal
    WHERE id = p_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerPlanPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPlanPorId(
    IN p_id INT
)
BEGIN
    SELECT id, nombre, costo_mensual
    FROM plan_suscripcion
    WHERE id = p_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerUsuarioPorId;
DELIMITER $$
CREATE PROCEDURE obtenerUsuarioPorId(
    IN p_id INT
)
BEGIN
    SELECT *
    FROM usuario
    WHERE id = p_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarSuscripcionesPorUsuario;
DELIMITER $$
CREATE PROCEDURE listarSuscripcionesPorUsuario(
    IN p_id_usuario INT
)
BEGIN
    SELECT *
    FROM usuario_canal_suscripcion
    WHERE id_usuario = p_id_usuario
    ORDER BY fecha_registro DESC;
END$$
DELIMITER ;
