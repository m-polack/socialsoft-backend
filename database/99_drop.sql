DROP DATABASE IF EXISTS socialsoft;
CREATE DATABASE IF NOT EXISTS socialsoft;
USE socialsoft;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS pago_suscripcion;
DROP TABLE IF EXISTS metodo_pago;
DROP TABLE IF EXISTS dispositivo_usuario;
DROP TABLE IF EXISTS plan_beneficio;
DROP TABLE IF EXISTS beneficio;
DROP TABLE IF EXISTS plan_resolucion;
DROP TABLE IF EXISTS resolucion;
DROP TABLE IF EXISTS usuario_canal_suscripcion;
DROP TABLE IF EXISTS plan_suscripcion;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS canal;

SET FOREIGN_KEY_CHECKS = 1;