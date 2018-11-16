INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (1, 57, 'Colombia');

INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (2, 58, 'Chile');

INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (3, 34, 'Argentina');

INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (4, 28, 'Brasil');

INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (5, 48, 'Ecuador');

INSERT INTO public.pais(
            pais_id, codigo, nombre)
    VALUES (6, 46, 'Uruguay');

INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (1, 1, 'Jorge Garcia', now(), 'Cedula', 
            '11223452');

 INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (2, 2, 'Jimmy Andrade', now(), 'Cedula', 
            '1122324234');
 INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (3, 3, 'Camilo Andrade', now(), 'Cedula', 
            '156489451');
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (4, 4, 'Johan Bejarano', now(), 'Cedula', 
            '11587452');            
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (5, 5, 'Walter Magañana', now(), 'Cedula', 
            '15423652');
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (6, 6, 'Hugo Eraso', now(), 'Cedula', 
            '5649841215');
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (7, 1, 'Cristian Restrepo', now(), 'Cedula', 
            '18784852');            
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (8, 2, 'JSteven Erazo', now(), 'Cedula', 
            '11223452');
            INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (9, 3, 'Sebastian Bejarano', now(), 'Cedula', 
            '115468151');
INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (10, 4, 'Mauricio Cuchumbe', now(), 'Cedula', 
            '11894615');
            INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (11, 5, 'York Carmona', now(), 'Cedula', 
            '1178452');
            INSERT INTO public.persona(
            persona_id, pais_id, nombre_completo, fecha_nacimiento, tipo_identificacion, 
            identificacion)
    VALUES (12, 6, 'Maximo Puerta', now(), 'Cedula', 
            '118784651');            

INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (1, 1, 1);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (2, 2, 15);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (3, 3, 3);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (4, 4, 26);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (5, 5, 4);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (6, 6, 48);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (7, 7, 2);
INSERT INTO public.jugador(
            jugador_id, persona_id, ranking)
    VALUES (8, 8, 20);

INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (1, 'Jorge Garcia', 'A', 1);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (2, 'Jimmy Andrade', 'A', 15);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (3, 'Camilo Delgado', 'A', 3);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (4, 'Johan Bejarano', 'A', 26);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (5, 'Walter Magaña', 'A', 4);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (6, 'Hugo Eraso', 'A', 48);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (7, 'Cristian Restrepo', 'A', 2);
INSERT INTO public.equipo(
            equipo_id, nombre, estado, ranking)
    VALUES (8, 'JSteven Erazo', 'A',20);
    
    
insert into cancha(nombre, tipo, dimensiones, ubicacion, estado) values ('Allianz', 'C', '25x25', 'London', 'A');
insert into cancha(nombre, tipo, dimensiones, ubicacion, estado) values ('Gallard', 'A', '25x25', 'París', 'A');

insert into director(persona_id, estado) values (1,'A');
insert into director(persona_id, estado) values (2,'A');

insert into 
torneo(director_id, nombre, fecha_inicio, cupos, cupos_disponibles, estado, draw)
values (1, 'Wimbledom women', '14/01/2019', 8, 8, 'A', 'a');

insert into 
torneo(director_id, nombre, fecha_inicio, cupos, cupos_disponibles, estado, draw)
values (2, 'Wimbledom Mix', '14/01/2019', 8, 8, 'A', 'a');
    
    
INSERT INTO equipo_torneo(equipo_id, torneo_id) VALUES 
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 1),
	(8, 1),
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 2),
	(8, 2);
