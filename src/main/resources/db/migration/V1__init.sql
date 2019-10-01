CREATE TABLE public.city (
	"name" varchar(100) NOT NULL,
	geo varchar(100) NOT NULL,
	country text NULL,
	id serial NOT NULL,
	CONSTRAINT city_pk PRIMARY KEY (id)
);

CREATE TABLE public.cinema (
	id serial NOT NULL,
	city serial NOT NULL,
	"name" varchar(100) NOT NULL,
	description text NULL,
	geo varchar(100) NULL,
	address varchar(100) NULL,
	CONSTRAINT cinema_pk PRIMARY KEY (id),
	CONSTRAINT cinema_fk FOREIGN KEY (city) REFERENCES public.city(id)
);

CREATE TABLE public.movie (
	id serial8 NOT NULL,
	name_native varchar(150) NOT NULL,
	"year" varchar(4) NULL,
	description text NULL,
	poster_img text NULL,
	name_original text NULL,
	CONSTRAINT movie_pk PRIMARY KEY (id)
);

CREATE TABLE public.movie_session (
	id serial8 NOT NULL,
	film_id serial NOT NULL,
	cinema_id serial NOT NULL,
	"date" date NOT NULL,
	"cost" int NOT NULL,
	hall varchar(32) NULL,
	hashcode varchar(32) NULL,
	CONSTRAINT movie_session_pk PRIMARY KEY (id),
	CONSTRAINT movie_session_film_fk FOREIGN KEY (film_id) REFERENCES public.movie(id),
	CONSTRAINT movie_session_cinema_fk FOREIGN KEY (cinema_id) REFERENCES public.cinema(id)
);
