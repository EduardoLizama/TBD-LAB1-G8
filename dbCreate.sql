create table if not exists VOLUNTARIO
    (ID_VOLUNTARIO serial primary key,
     RUT varchar(20),
     NOMBRE_VOLUNTARIO varchar(20),
     REGION varchar(20),
     COMUNA varchar(20),
     esVisible boolean,
     CIUDAD varchar(20));    
    
create table if not exists HABILIDAD
    (ID_HABILIDAD serial primary key,
     NOMBRE_HABILIDAD varchar(20),
     DESCRIPCION varchar(40));
   
create table if not exists VOL_HABILIDAD
    (ID_VOL_HABILIDAD serial primary key,
     ID_VOLUNTARIO int,
     ID_HABILIDAD int,
     FOREIGN KEY (ID_VOLUNTARIO) REFERENCES VOLUNTARIO(ID_VOLUNTARIO),
     FOREIGN KEY (ID_HABILIDAD) REFERENCES HABILIDAD(ID_HABILIDAD));
   
create table if not exists INSTITUCION
    (ID_INSTITUCION serial primary key,
    NOMBRE_INSTITUCION varchar(20)); 
    
create table if not exists EMERGENCIA
    (ID_EMERGENCIA serial primary key,
     REGION varchar(20),
     COMUNA varchar(20),
     CIUDAD varchar(20),
     ID_INSTITUCION int,
     FOREIGN KEY (ID_INSTITUCION) REFERENCES INSTITUCION(ID_INSTITUCION));
   
create table if not exists EME_HABILIDAD
    (ID_EME_HABILIDAD serial primary key,
     ID_EMERGENCIA int,
     ID_HABILIDAD int,
     FOREIGN KEY (ID_EMERGENCIA) REFERENCES EMERGENCIA(ID_EMERGENCIA),
     FOREIGN KEY (ID_HABILIDAD) REFERENCES HABILIDAD(ID_HABILIDAD));
 
create table if not exists ESTADO_TAREA
    (ID_ESTADO_TAREA serial primary key,
    NOMBRE varchar(20));

create table if not exists TAREA
    (ID_TAREA serial primary key,
     NOMBRE_TAREA varchar(30),
     CAPACIDAD int,
     ID_EMERGENCIA int,
     id_estado_tarea int,
     esVisible boolean,
     FOREIGN KEY (ID_EMERGENCIA) REFERENCES EMERGENCIA(ID_EMERGENCIA),
     FOREIGN KEY (id_estado_tarea) REFERENCES ESTADO_TAREA(id_estado_tarea));
	 
	
create table if not exists TAREA_HABILIDAD
    (ID_TAREA_HABILIDAD serial primary key,
    ID_TAREA int,
    ID_HABILIDAD int,
    ID_ESTADO int,
    FOREIGN KEY (ID_TAREA) REFERENCES TAREA(ID_TAREA),
    FOREIGN KEY (ID_HABILIDAD) REFERENCES HABILIDAD(ID_HABILIDAD),
    FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO_TAREA(ID_ESTADO_TAREA));
    
create table if not exists RANKING
    (ID_RANKING serial primary key,
    ESTADOTAREA varchar(20),
    ID_VOLUNTARIO int,
    ID_TAREA int,
    FOREIGN KEY (ID_VOLUNTARIO) REFERENCES VOLUNTARIO(ID_VOLUNTARIO),
    FOREIGN KEY (ID_TAREA) REFERENCES TAREA(ID_TAREA));

CREATE PROCEDURE updateStateTask(Id_t bigint)
Language plpgsql as
$$
Begin
    UPDATE tarea 
    set id_estado_tarea = 3 
    WHERE id_tarea = @Id_t AND capacidad = (SELECT COUNT(*) 
                                             FROM ranking 
                                             WHERE ranking.id_tarea = @Id_t and estadoTarea = 'Completada');
end
$$
