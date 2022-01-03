insert into VOLUNTARIO (RUT, NOMBRE_VOLUNTARIO, REGION, COMUNA, esVisible, CIUDAD) values
(12343123, 'Antonio Silva', 'Araucanía', 'Temuco', true, 'Temuco'),
(14557679, 'Rebeca Poblete', 'Araucanía', 'Temuco', true, 'Temuco'),
(13113423, 'Mark Anthony', 'Arica y Parinacota', 'Arica', true, 'Azapa'),
(11456732, 'Jack Black', 'Valparaiso', 'Concón', true, 'Concón'),
(14534232, 'Mauricio Vicencio', 'Metropolitana', 'Santiago', true, 'Ciudad Gótica'),
(16454313, 'Iosif Stalin', 'Moscovia', 'Kremlin', false, 'Moscú');

insert into HABILIDAD (NOMBRE_HABILIDAD, DESCRIPCION) values
('Vehículo', 'Tiene vehículo y licencia para manejarlo'),
('Piloto Avioneta', 'Pilotea avionetas'),
('Buceo', 'Tiene experiencia como buzo'),
('Primeros Auxilios', 'Posee conocimiento en primeros auxilios'),
('Notebook', 'Posee un notebook personal');

insert into VOL_HABILIDAD (ID_VOLUNTARIO, ID_HABILIDAD) values
(1, 1),
(1, 4),
(2, 1),
(2, 3),
(2, 4);
   
insert into INSTITUCION (NOMBRE_INSTITUCION) values
('Rescate Andino'),
('Bomberos de Chile'),
('Cruz Roja'),
('Avengers');

insert into EMERGENCIA (REGION, COMUNA, CIUDAD, ID_INSTITUCION) values
('Araucania', 'Temuco', 'Temuco', 4),
('Arica y Parinacota', 'Arica', 'Azapa', 1),
('Los Lagos', 'Osorno', 'Pichil', 2),
('Valparaiso', 'Concón', 'Concón', 3);

   
insert into EME_HABILIDAD (ID_EMERGENCIA, ID_HABILIDAD) values
(1, 1),
(2, 1),
(2, 3);

insert into ESTADO_TAREA (NOMBRE) values
('No empezada'),
('En proceso'),
('Completada'),
('Cancelada');

insert into TAREA (NOMBRE_TAREA, CAPACIDAD, ID_EMERGENCIA, ID_estado_tarea) values
('Llevar bolsas de Basura', 1, 1, 2),
('Limpiar escombros', 2, 1, 2),
('Evacuar heridos', 1, 1, 2),
('Llevar agua para beber', 2, 3, 2),
('Registro de heridos', 1, 3, 2),
('Curar heridos', 2, 3, 2);

insert into TAREA_HABILIDAD (ID_TAREA, ID_HABILIDAD) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 5),
(4, 4);

insert into RANKING(estadotarea, id_voluntario, id_tarea)
values
('En proceso', 1, 2),
('En proceso', 1, 1),
('En proceso', 1, 4),
('En proceso', 1, 3);