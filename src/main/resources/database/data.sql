INSERT INTO CatalogoEstados(descripcion) VALUES
	("Ciudad de México"),
	("Jalisco"),
	("Coahuila"),
	("Sonora"),
	("Yucatán"),
	("Nuevo León"),
	("Chihuahua"),
	("Nayarit"),
	("Sinaloa"),
	("Oaxaca");

INSERT INTO CatalogoCiudades(cveEstado, descripcion) VALUES
	(1, "Coyoacán"),
	(2, "Guadalajara"),
	(1, "Tlalpan"),
	(1, "Iztapalapa"),
	(1, "Iztacalco"),
	(1, "Alvara Obregón"),
	(1, "Benito Juárez"),
	(1, "Cuauhtémoc"),
	(1, "Miguel Hidalgo"),
	(1, "Azcapotzalco");

INSERT INTO Usuarios(esAdministrador, nombre, apPaterno, apMaterno, genero, edad, email, contrasena, cveCiudad) VALUES
	(TRUE, 'David', 'Gutiérrez', 'Núñez', 'M', 24, 'davidgn2k@jobs.com', 'pass123', 1),
	(FALSE, 'Alberto', 'Vázquez', 'Pérez', 'M', 50, 'alberto@outlook.com', 'pass123', 2),
	(TRUE, 'María', 'López', 'García', 'F', 30, 'maria.lopez@gmail.com', 'pass456', 3),
	(FALSE, 'Lucía', 'Rodríguez', 'Santos', 'F', 45, 'lucia.santos@outlook.com', 'pass789', 4),
	(TRUE, 'Carlos', 'Martínez', 'Ramírez', 'M', 29, 'carlos.ramirez@gmail.com', 'passabc', 5),
	(FALSE, 'Ana', 'Hernández', 'Díaz', 'F', 22, 'ana.diaz@gmail.com', 'passdef', 6),
	(TRUE, 'Jorge', 'Morales', 'Flores', 'M', 35, 'jorge.morales@jobs.com', 'passghi', 7),
	(FALSE, 'Luis', 'Sánchez', 'Torres', 'M', 28, 'luis.torres@yahoo.com', 'passjkl', 8),
	(TRUE, 'Elena', 'Ramírez', 'Ortiz', 'F', 41, 'elena.ortiz@hotmail.com', 'passmno', 9),
	(FALSE, 'Miguel', 'Gómez', 'Silva', 'M', 32, 'miguel.silva@outlook.com', 'passpqr', 10);

INSERT INTO CatalogoHabilidades(descripcion) VALUES
    ('Java'),
    ('SQL'),
    ('Python'),
    ('JavaScript'),
    ('HTML'),
    ('CSS'),
    ('C#'),
    ('Ruby'),
    ('PHP'),
    ('React');

INSERT INTO Habilidad_Usuario(idUsuario, cveHabilidad) VALUES
    (2, 1), 
    (2, 2),
    (4, 3),
    (4, 4),
    (6, 5),
    (6, 6),
    (8, 7),
    (8, 8),
    (10, 9),
    (10, 10);

INSERT INTO CatalogoSectores(descripcion) VALUES
    ('Tecnología'),
    ('Finanzas'),
    ('Salud'),
    ('Educación'),
    ('Manufactura'),
    ('Comercio'),
    ('Energía'),
    ('Transporte'),
    ('Turismo'),
    ('Construcción');

INSERT INTO Empresas(nombre, sitioWeb, numEmpleados, cveSector, verificada) VALUES
    ('Oracle', 'www.oracle.com', 30000, 1, true),
    ('Microsoft', 'www.microsoft.com', 150000, 1, true),
    ('JP Morgan', 'www.jpmorgan.com', 250000, 2, true),
    ('Pfizer', 'www.pfizer.com', 90000, 3, true),
    ('Harvard University', 'www.harvard.edu', 20000, 4, true),
    ('General Motors', 'www.gm.com', 180000, 5, true),
    ('Amazon', 'www.amazon.com', 1300000, 6, true),
    ('ExxonMobil', 'www.exxonmobil.com', 75000, 7, true),
    ('Delta Airlines', 'www.delta.com', 80000, 8, true),
    ('Hilton', 'www.hilton.com', 170000, 9, true);

INSERT INTO Vacantes(idEmpresa, titulo, cveCiudad, descripcion) VALUES
    -- Oracle
    (1, 'Software Engineer I', 1, 'Solve high-scale challenges with a global impact. Reimagine the future of technology.'),
    (1, 'Data Analyst', 1, 'Analyze complex data to provide insights and support data-driven decisions.'),
    (1, 'Cloud Architect', 2, 'Design and manage cloud infrastructure for high-availability systems.'),
    
    -- Microsoft
    (2, 'Frontend Developer', 3, 'Develop and enhance user-facing features for our global products.'),
    (2, 'Backend Engineer', 2, 'Build and maintain server-side logic, APIs, and databases.'),
    (2, 'DevOps Engineer', 3, 'Automate processes and enhance operational efficiency.'),
    
    -- JP Morgan
    (3, 'Financial Analyst', 4, 'Provide financial insights and investment strategies to clients.'),
    (3, 'Cybersecurity Analyst', 5, 'Safeguard financial data by identifying and mitigating security risks.'),
    (3, 'Business Analyst', 4, 'Analyze business processes and recommend improvements for efficiency.'),
    
    -- Pfizer
    (4, 'Pharmaceutical Research Scientist', 6, 'Lead drug discovery research and development efforts.'),
    (4, 'Regulatory Affairs Specialist', 7, 'Ensure compliance with pharmaceutical regulations globally.'),
    (4, 'Clinical Data Manager', 6, 'Manage clinical trial data to ensure quality and integrity.'),
    
    -- Harvard University
    (5, 'Academic Researcher', 8, 'Conduct cutting-edge research and publish findings in leading journals.'),
    (5, 'Lecturer', 8, 'Teach undergraduate and graduate students in your field of expertise.'),
    (5, 'Curriculum Developer', 9, 'Design and develop innovative academic programs and courses.'),
    
    -- General Motors
    (6, 'Automotive Engineer', 10, 'Design, develop, and test new vehicle technologies.'),
    (6, 'Production Manager', 10, 'Oversee the manufacturing process and ensure quality production.'),
    (6, 'Supply Chain Analyst', 1, 'Optimize supply chain processes to reduce costs and improve efficiency.'),
    
    -- Amazon
    (7, 'Logistics Manager', 2, 'Manage and improve the efficiency of logistics and supply chain operations.'),
    (7, 'Machine Learning Engineer', 3, 'Develop and implement machine learning models for various applications.'),
    (7, 'Operations Manager', 4, 'Ensure the smooth running of warehouse and fulfillment operations.'),
    
    -- ExxonMobil
    (8, 'Petroleum Engineer', 5, 'Design and develop methods to extract oil and gas from deposits.'),
    (8, 'Environmental Scientist', 6, 'Ensure that all operations comply with environmental regulations.'),
    (8, 'Energy Analyst', 5, 'Analyze trends and data in the energy sector to drive strategic decisions.'),
    
    -- Delta Airlines
    (9, 'Pilot', 7, 'Safely operate flights across domestic and international routes.'),
    (9, 'Flight Attendant', 7, 'Ensure passenger safety and provide high-quality customer service.'),
    (9, 'Operations Manager', 8, 'Oversee day-to-day operations to maintain efficiency and safety.'),
    
    -- Hilton
    (10, 'Hotel Manager', 9, 'Manage daily hotel operations, ensuring guest satisfaction and profitability.'),
    (10, 'Event Planner', 10, 'Coordinate and execute large-scale events, from conferences to weddings.'),
    (10, 'Marketing Manager', 9, 'Develop marketing strategies to promote the hotel brand and increase bookings.');


INSERT INTO Habilidad_Vacante(idVacante, cveHabilidad) VALUES
    -- Oracle job openings
    (1, 1), -- Software Engineer I requires Java
    (1, 2), -- Software Engineer I requires SQL
    (1, 4), -- Software Engineer I requires JavaScript
    (2, 2), -- Data Analyst requires SQL
    (2, 3), -- Data Analyst requires Python
    (2, 7), -- Data Analyst requires C#
    (3, 1), -- Cloud Architect requires Java
    (3, 6), -- Cloud Architect requires CSS
    (3, 10), -- Cloud Architect requires React

    -- Microsoft job openings
    (4, 4), -- Frontend Developer requires JavaScript
    (4, 5), -- Frontend Developer requires HTML
    (4, 6), -- Frontend Developer requires CSS
    (5, 1), -- Backend Engineer requires Java
    (5, 2), -- Backend Engineer requires SQL
    (5, 3), -- Backend Engineer requires Python
    (6, 3), -- DevOps Engineer requires Python
    (6, 9), -- DevOps Engineer requires PHP
    (6, 7), -- DevOps Engineer requires C#

    -- JP Morgan job openings
    (7, 2), -- Financial Analyst requires SQL
    (7, 3), -- Financial Analyst requires Python
    (7, 4), -- Financial Analyst requires JavaScript
    (8, 8), -- Cybersecurity Analyst requires Ruby
    (8, 3), -- Cybersecurity Analyst requires Python
    (8, 2), -- Cybersecurity Analyst requires SQL
    (9, 2), -- Business Analyst requires SQL
    (9, 4), -- Business Analyst requires JavaScript
    (9, 3), -- Business Analyst requires Python

    -- Pfizer job openings
    (10, 3), -- Pharmaceutical Research Scientist requires Python
    (10, 1), -- Pharmaceutical Research Scientist requires Java
    (10, 2), -- Pharmaceutical Research Scientist requires SQL
    (11, 7), -- Regulatory Affairs Specialist requires C#
    (11, 9), -- Regulatory Affairs Specialist requires PHP
    (12, 2), -- Clinical Data Manager requires SQL
    (12, 3), -- Clinical Data Manager requires Python

    -- Harvard University job openings
    (13, 3), -- Academic Researcher requires Python
    (13, 1), -- Academic Researcher requires Java
    (13, 2), -- Academic Researcher requires SQL
    (14, 4), -- Lecturer requires JavaScript
    (14, 5), -- Lecturer requires HTML
    (15, 6), -- Curriculum Developer requires CSS
    (15, 9), -- Curriculum Developer requires PHP

    -- General Motors job openings
    (16, 1), -- Automotive Engineer requires Java
    (16, 2), -- Automotive Engineer requires SQL
    (16, 4), -- Automotive Engineer requires JavaScript
    (17, 2), -- Production Manager requires SQL
    (17, 6), -- Production Manager requires CSS
    (17, 7), -- Production Manager requires C#
    (18, 3), -- Supply Chain Analyst requires Python
    (18, 2), -- Supply Chain Analyst requires SQL

    -- Amazon job openings
    (19, 3), -- Logistics Manager requires Python
    (19, 2), -- Logistics Manager requires SQL
    (20, 3), -- Machine Learning Engineer requires Python
    (20, 10), -- Machine Learning Engineer requires React
    (21, 7), -- Operations Manager requires C#
    (21, 2), -- Operations Manager requires SQL

    -- ExxonMobil job openings
    (22, 1), -- Petroleum Engineer requires Java
    (22, 2), -- Petroleum Engineer requires SQL
    (23, 3), -- Environmental Scientist requires Python
    (23, 8), -- Environmental Scientist requires Ruby
    (24, 2), -- Energy Analyst requires SQL

    -- Delta Airlines job openings
    (25, 2), -- Pilot requires SQL
    (25, 4), -- Pilot requires JavaScript
    (26, 6), -- Flight Attendant requires CSS
    (26, 5), -- Flight Attendant requires HTML
    (27, 2), -- Operations Manager requires SQL

    -- Hilton job openings
    (28, 2), -- Hotel Manager requires SQL
    (28, 7), -- Hotel Manager requires C#
    (29, 9), -- Event Planner requires PHP
    (29, 6), -- Event Planner requires CSS
    (30, 4), -- Marketing Manager requires JavaScript
    (30, 5); -- Marketing Manager requires HTML

INSERT INTO CatalogoEstatus(descripcion) VALUES 
	('En proceso'), 
	('Aceptado'), 
	('Rechazado');