create table if not exists VOLUNTARIO
    (ID_VOLUNTARIO serial primary key,
     RUT varchar(20),
     NOMBRE_VOLUNTARIO varchar(20),
     REGION varchar(20),
     COMUNA varchar(20),
     CIUDAD varchar(20));    
    
create table if not exists HABILIDAD
    (ID_HABILIDAD serial primary key,
     NOMBRE_HABILIDAD varchar(20),
     DESCRIPCION varchar(20));
   
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
 
create table if not exists TAREA
    (ID_TAREA serial primary key,
     NOMBRE_TAREA varchar(20),
     CAPACIDAD int,
     ID_EMERGENCIA int,
     FOREIGN KEY (ID_EMERGENCIA) REFERENCES EMERGENCIA(ID_EMERGENCIA));

create table if not exists TAREA_HABILIDAD
    (ID_TAREA_HABILIDAD serial primary key,
    ID_TAREA int,
     ID_HABILIDAD int,
     ID_ESTADO int,
     FOREIGN KEY (ID_TAREA) REFERENCES TAREA(ID_TAREA)),
    FOREIGN KEY (ID_HABILIDAD) REFERENCES HABILIDAD(ID_HABILIDAD);
    FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO_TAREA(ID_ESTADO_TAREA)),
    
create table if not exists ESTADO_TAREA
    (ID_ESTADO_TAREA serial primary key,
    NOMBRE varchar(20);
    
create table if not exists RANKING
    (ID_RANKING serial primary key,
    NOMBRE varchar(20),
    ID_VOLUNTARIO int,
    ID_TAREA int,
    FOREIGN KEY (ID_VOLUNTARIO) REFERENCES VOLUNTARIO(ID_VOLUNTARIO),
    FOREIGN KEY (ID_TAREA) REFERENCES TAREA(ID_TAREA));
    
