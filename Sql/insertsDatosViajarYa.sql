database - forward engineer


-- inserts en ciudad
insert into ciudad (nombre) values ('Tandil');
insert into ciudad (nombre) values ('Buenos Aires');
insert into ciudad (nombre) values ('Ayacucho');
insert into ciudad (nombre) values ('Rauch');
insert into ciudad (nombre) values ('Olavarria');
insert into ciudad (nombre) values ('Azul');
insert into ciudad (nombre) values ('Necochea');
insert into ciudad (nombre) values ('Loberia');
insert into ciudad (nombre) values ('Miramar');
insert into ciudad (nombre) values ('Mar del Plata');
insert into ciudad (nombre) values ('Barker');
insert into ciudad (nombre) values ('Bahia Blanca');
insert into ciudad (nombre) values ('Junin');
insert into ciudad (nombre) values ('Benito Juarez');
insert into ciudad (nombre) values ('Balcarce');
insert into ciudad (nombre) values ('San Manuel');
insert into ciudad (nombre) values ('Tres Arroyos');
insert into ciudad (nombre) values ('La Plata');

-- inserts en usuario
insert into usuario(nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta ) values ('Liliana','Gíboli',154455566,'Doreing 100','Tandil','1970/10/14','lilianag@gmail.com','lili123',' ' ,'f',1,1);
insert into usuario(nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta ) values ('Diego','Diaz',154455577,'Pellegrini 100','Tandil','1980/08/24','diegod@gmail.com','diego123',' ' ,'m',1,1);
insert into usuario(nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta ) values ('Alejandro','Campitelli',154455888,'Alem 100','Tandil','1979/11/03','alejandroc@gmail.com','ale123',' ' ,'m',1,1);
insert into usuario(nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta ) values ('Leandro','Mazza',154422266,'Montiel 340','Tandil','1988/06/11','leandrom@gmail.com','lea123',' ' ,'m',1,1);
insert into usuario(nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta ) values ('Valeria','Barrientos',154455333,'Brandsen 603','Tandil','1974/05/14','valeriab@gmail.com','vale123',' ' ,'f',1,1);

-- inserts en viaje
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','Olavarria',105,'2018/06/17 17:15:00','Paz 134',1,0,'2018/06/10' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','Mar del Plata',133,'2018/06/20 09:00:00','Rivadavia y España',1,0,'2018/06/10' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Rauch','Tandil',55,'2018/06/19 19:30:00','Colon 123',1,1,'2018/06/10' ); 
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','Olavarria',105,'2018/06/21 11:15:00','Buzon 453',0,0,'2018/06/10' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','La Plata',300,'2018/06/28 07:00:00','Buzon y Portugal',1,0,'2018/04/10' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','La Plata',300,'2018/04/28 07:00:00','Buzon y Portugal',1,0,'2018/04/10' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Tandil','Necochea',280,'2018/08/15 07:00:00','Arana 22',1,0,'2018/06/17' );
insert into viaje (origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values ('Necochea','Tandil',280,'2018/08/20 10:00:00','Av 59 y 60',0,0,'2018/06/17' );

-- inserts en viaje_has_usuario

insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (1,1,2);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (2,2,3);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (3,1,1);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (4,1,2);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (5,3,4);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (6,3,4);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (7,2,3);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (8,2,3);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (1,5,2);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (5,5,4);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (6,5,4);
insert into viaje_has_usuario (Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values (7,5,3);






update viaje set fechayhora_partida ='2018/04/28 07:00:00'
where id_viaje = 6;

-- inserts en auto
insert into auto (marca,modelo,color,combustible,patente,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,foto,Usuario_id_usuario) values ('Volkswagen','Gol 1.6 I Trendline Plus 2009','gris','nafta','ICY 585',1,1,4,9,'grande',' ',1);
insert into auto (marca,modelo,color,combustible,patente,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,foto,Usuario_id_usuario) values ('Renault', 'Clio 1.2 Pack Plus 2007','rojo','nafta','JVC 177',1,1,4,9,'chica',' ',1);
insert into auto (marca,modelo,color,combustible,patente,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,foto,Usuario_id_usuario) values ('Ford','Fiesta 1.3 Clx 1998','rojo','nafta','CGR 372',1,1,4,7,'chica',' ',2);
insert into auto (marca,modelo,color,combustible,patente,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,foto,Usuario_id_usuario) values ('Peugeot','307 2.0 Hdi Xs 90cv Mp3 2007','negro','diesel','FGI 633',1,1,4,8,'mediana',' ',3);

