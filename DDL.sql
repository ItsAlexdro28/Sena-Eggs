DROP DATABASE IF EXISTS prod_gallinas;

CREATE DATABASE prod_gallinas;

USE prod_gallinas;

CREATE TABLE Usuarios (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL CHECK (email LIKE '%_@__%.__%'), 
    contrasena VARCHAR(255) NOT NULL, 
    perfil ENUM('admin', 'user') DEFAULT 'user' NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Grupos (
    grupo_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE, 
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Gallinas (
    gallina_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE, 
    fecha_nacimiento DATE CHECK (fecha_nacimiento <= CURRENT_DATE), 
    grupo_id INT,
    estado ENUM('activo', 'inactivo') DEFAULT 'activo' NOT NULL,
    FOREIGN KEY (grupo_id) REFERENCES Grupos(grupo_id) 
);

CREATE TABLE Produccion_Diaria (
    produccion_id INT AUTO_INCREMENT PRIMARY KEY,
    gallina_id INT NOT NULL,
    fecha DATE NOT NULL CHECK (fecha <= CURRENT_DATE), 
    cantidad INT NOT NULL CHECK (cantidad >= 0), 
    FOREIGN KEY (gallina_id) REFERENCES Gallinas(gallina_id),
    UNIQUE (gallina_id, fecha)
);

CREATE TABLE Resumen_Produccion (
    resumen_id INT AUTO_INCREMENT PRIMARY KEY,
    grupo_id INT NOT NULL,
    fecha DATE NOT NULL CHECK (fecha <= CURRENT_DATE), 
    total_huevos INT NOT NULL CHECK (total_huevos >= 0), 
    FOREIGN KEY (grupo_id) REFERENCES Grupos(grupo_id),
    UNIQUE (grupo_id, fecha)
);

CREATE TABLE Analisis_Alertas (
    analisis_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_analisis ENUM('rendimiento', 'tendencias', 'alerta') NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);

CREATE TABLE Configuraciones_Usuario (
    configuracion_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    notificaciones BOOLEAN DEFAULT TRUE,
    tema VARCHAR(50) DEFAULT 'light',
    idioma VARCHAR(50) DEFAULT 'es',
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);

CREATE TABLE Reportes_Produccion (
    reporte_id INT AUTO_INCREMENT PRIMARY KEY,
    produccion_id INT NOT NULL,
    analisis_id INT NOT NULL,
    FOREIGN KEY (produccion_id) REFERENCES Produccion_Diaria(produccion_id),
    FOREIGN KEY (analisis_id) REFERENCES Analisis_Alertas(analisis_id)
);

CREATE TABLE Registro_Eventos (
    evento_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descripcion TEXT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);
