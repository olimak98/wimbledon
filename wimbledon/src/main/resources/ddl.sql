CREATE TABLE pais(
   pais_id serial NOT NULL PRIMARY KEY,
   codigo varchar (255) NOT NULL,
   nombre varchar (225) NOT NULL
);

CREATE TABLE persona(
   persona_id serial NOT NULL PRIMARY KEY,
   pais_id serial NOT NULL,
   nombre_completo varchar (255) NOT NULL,
   fecha_nacimiento timestamp NOT NULL,
   tipo_identificacion varchar (225) NOT NULL,
   identificacion varchar (255) NOT NULL,
   FOREIGN KEY (pais_id) REFERENCES pais(pais_id)
);

CREATE TABLE director(
   director_id serial NOT NULL PRIMARY KEY,
   persona_id serial NOT NULL,
   estado varchar (1) NOT NULL,
   FOREIGN KEY (persona_id) REFERENCES persona(persona_id)
);

CREATE TABLE torneo(
   torneo_id serial NOT NULL PRIMARY KEY,
   director_id serial NOT NULL,
   nombre varchar (255) NOT NULL,
   fecha_inicio timestamp,
   cupos integer NOT NULL,
   cupos_disponibles integer NOT NULL,
   estado varchar (1) NOT NULL, 
   draw varchar (255),
   FOREIGN KEY (director_id) REFERENCES director(director_id)
);

CREATE TABLE equipo(
   equipo_id serial NOT NULL PRIMARY KEY,
   nombre varchar (255) NOT NULL,
   ranking integer NOT NULL,
   estado varchar (1) NOT NULL
);

CREATE TABLE jugador(
   jugador_id serial NOT NULL PRIMARY KEY,
   persona_id serial NOT NULL,
   ranking integer NOT NULL,
   FOREIGN KEY (persona_id) REFERENCES persona(persona_id)
   
);

CREATE TABLE jugador_equipo(
   jugador_equipo_id serial NOT NULL PRIMARY KEY,
   jugador_id serial NOT NULL,
   equipo_id serial NOT NULL,
   FOREIGN KEY (jugador_id) REFERENCES jugador(jugador_id),
   FOREIGN KEY (equipo_id) REFERENCES equipo(equipo_id)
);

CREATE TABLE juez(
   juez_id serial NOT NULL PRIMARY KEY,
   persona_id serial NOT NULL,
   estado varchar (1) NOT NULL,
   FOREIGN KEY (persona_id) REFERENCES persona(persona_id)
);

CREATE TABLE juez_torneo(
   juez_torneo_id serial NOT NULL PRIMARY KEY,
   juez_id serial NOT NULL,
   torneo_id serial NOT NULL,
   FOREIGN KEY (juez_id) REFERENCES juez(juez_id),
   FOREIGN KEY (torneo_id) REFERENCES torneo(torneo_id)
);

CREATE TABLE equipo_torneo(
   equipo_torneo_id serial NOT NULL PRIMARY KEY,
   equipo_id serial NOT NULL,
   torneo_id serial NOT NULL,
   FOREIGN KEY (equipo_id) REFERENCES equipo(equipo_id),
   FOREIGN KEY (torneo_id) REFERENCES torneo(torneo_id)
);

CREATE TABLE ronda(
   ronda_id serial NOT NULL PRIMARY KEY,
   torneo_id serial NOT NULL,
   premio integer,
   puntos_atp integer,
   numero integer,
   FOREIGN KEY (torneo_id) REFERENCES torneo(torneo_id)
);

CREATE TABLE cancha(
   cancha_id serial NOT NULL PRIMARY KEY,
   nombre varchar (255) NOT NULL,
   tipo varchar (1) NOT NULL,
   dimensiones varchar (255) NOT NULL,
   ubicacion varchar (255) NOT NULL,
   estado varchar (1) NOT NULL
);

CREATE TABLE partido(
   partido_id serial NOT NULL PRIMARY KEY,
   cancha_id serial,
   juez_id serial,
   equipo1_id serial NOT NULL,
   equipo2_id serial NOT NULL,
   equipo_ganador_id serial,
   ronda_id serial NOT NULL,
   numero_encuentro integer,
   fecha timestamp,
   puntuacion varchar (255),
   duracion integer,
   estado varchar (1) NOT NULL,
   FOREIGN KEY (cancha_id) REFERENCES cancha(cancha_id),
   FOREIGN KEY (juez_id) REFERENCES juez(juez_id),
   FOREIGN KEY (equipo1_id) REFERENCES equipo(equipo_id),
   FOREIGN KEY (equipo2_id) REFERENCES equipo(equipo_id),
   FOREIGN KEY (equipo_ganador_id) REFERENCES equipo(equipo_id),
   FOREIGN KEY (ronda_id) REFERENCES ronda(ronda_id)
);

CREATE TABLE reserva_cancha(
   reserva_cancha_id serial NOT NULL PRIMARY KEY,
   cancha_id serial NOT NULL,
   partido_id serial NOT NULL,
   fecha timestamp,
   FOREIGN KEY (cancha_id) REFERENCES cancha(cancha_id),
   FOREIGN KEY (partido_id) REFERENCES partido(partido_id)   
);

CREATE TABLE set(
   set_id serial NOT NULL PRIMARY KEY,
   partido_id serial NOT NULL,
   equipo1_id serial NOT NULL,
   equipo2_id serial NOT NULL,
   puntos_equipo1 integer,
   puntos_equipo2 integer,
   FOREIGN KEY (partido_id) REFERENCES partido(partido_id),
   FOREIGN KEY (equipo1_id) REFERENCES equipo(equipo_id),
   FOREIGN KEY (equipo2_id) REFERENCES equipo(equipo_id)
);