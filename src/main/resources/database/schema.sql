CREATE DATABASE Epply;
USE Epply;

DROP TABLE if EXISTS CatalogoEstados;
CREATE TABLE CatalogoEstados(
	cveEstado INT PRIMARY KEY AUTO_INCREMENT,
	descripcion VARCHAR(40) UNIQUE NOT NULL
);

DROP TABLE if EXISTS CatalogoCiudades;
CREATE TABLE CatalogoCiudades(
	cveCiudad INT PRIMARY KEY AUTO_INCREMENT,
	cveEstado INT NOT NULL,
	descripcion VARCHAR(40) UNIQUE NOT NULL,
	CONSTRAINT fk_ciudad_estado FOREIGN KEY(cveEstado) REFERENCES CatalogoEstados(cveEstado)
);

DROP TABLE if EXISTS Usuarios;
CREATE TABLE Usuarios(
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
	esAdministrador BOOLEAN NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	apPaterno VARCHAR(25) NOT NULL,
	apMaterno VARCHAR(25) NOT NULL,
	genero CHAR(1) NOT NULL CHECK (genero = 'M' OR genero = 'F' OR genero = 'N'),
	edad TINYINT NOT NULL CHECK (edad >= 18 && edad < 100),
	email VARCHAR(45) NOT NULL UNIQUE,
	contrasena VARCHAR(25) NOT NULL,
	cveCiudad INT NOT NULL,
	linkCV VARCHAR(45),
	CONSTRAINT fk_usuario_ciudad FOREIGN KEY (cveCiudad) REFERENCES CatalogoCiudades(cveCiudad)
);

DROP TABLE if EXISTS CatalogoHabilidades;
CREATE TABLE CatalogoHabilidades(
	cveHabilidad INT PRIMARY KEY AUTO_INCREMENT,
	descripcion VARCHAR(25) UNIQUE NOT NULL
);

DROP TABLE if EXISTS Habilidad_Usuario;
CREATE TABLE Habilidad_Usuario(
	idUsuario INT NOT NULL AUTO_INCREMENT,
	cveHabilidad INT NOT NULL,
	CONSTRAINT PRIMARY KEY (idUsuario, cveHabilidad)
);

DROP TABLE if EXISTS CatalogoSectores;
CREATE TABLE CatalogoSectores(
	cveSector INT PRIMARY KEY AUTO_INCREMENT,
	descripcion VARCHAR(20) NOT NULL UNIQUE
);

DROP TABLE if EXISTS Empresas;
CREATE TABLE Empresas(
	idEmpresa INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL UNIQUE,
	sitioWeb VARCHAR(50) NOT NULL UNIQUE,
	numEmpleados INT NOT NULL CHECK (numEmpleados > 0),
	cveSector INT NOT NULL,
	verificada BOOLEAN NOT NULL,
	CONSTRAINT fk_empresa_sector FOREIGN KEY (cveSector) REFERENCES CatalogoSectores(cveSector)
);

DROP TABLE if EXISTS Vacantes;
CREATE TABLE Vacantes(
	idVacante INT AUTO_INCREMENT PRIMARY KEY,
	idEmpresa INT NOT NULL,
	titulo VARCHAR(45),
	cveCiudad INT NOT NULL,
	descripcion VARCHAR(280) NOT NULL,
	CONSTRAINT fk_vacante_empresa FOREIGN KEY (idEmpresa) REFERENCES Empresas(idEmpresa),
	CONSTRAINT fk_vacante_ciudad FOREIGN KEY (cveCiudad) REFERENCES CatalogoCiudades(cveCiudad)
);

DROP TABLE if EXISTS Habilidad_Vacante;
CREATE TABLE Habilidad_Vacante(
	idVacante INT NOT NULL AUTO_INCREMENT,
	cveHabilidad INT NOT NULL,
	CONSTRAINT PRIMARY KEY (idVacante, cveHabilidad)
);

DROP TABLE if EXISTS CatalogoEstatus;
CREATE TABLE CatalogoEstatus(
	cveEstatus INT PRIMARY KEY AUTO_INCREMENT,
	descripcion VARCHAR(10) NOT NULL CHECK(descripcion = 'En proceso' OR descripcion = 'Aceptado' OR descripcion = 'Rechazado')
);

DROP TABLE if EXISTS Usuario_Vacante;
CREATE TABLE Usuario_Vacante(
	idUsuario INT NOT NULL,
	idVacante INT NOT NULL,
	cveEstatus INT NOT NULL,
	CONSTRAINT PRIMARY KEY (idUsuario, idVacante),
	CONSTRAINT fk_usuarioVacante_usuario FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario),
	CONSTRAINT fk_usuarioVacante_vacante FOREIGN KEY (idVacante) REFERENCES Vacantes(idVacante),
	CONSTRAINT fk_usurioVacante_cveEstatus FOREIGN KEY (cveEstatus) REFERENCES CatalogoEstatus(cveEstatus)
);