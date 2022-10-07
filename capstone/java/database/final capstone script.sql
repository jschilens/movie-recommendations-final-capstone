BEGIN TRANSACTION;
DROP TABLE IF EXISTS public.users, public.movies, public.genres, public.genre_names, public.movie_lists, public.movie_favorited, public.movie_saved;
-- Table: public.movies
-- DROP TABLE public.movies;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
)
CREATE TABLE IF NOT EXISTS public.movies
(
    id integer NOT NULL,
    original_title character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    overview character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    release_date date NOT NULL,
    vote_average numeric(4,2),
    poster_path character varying(1000) COLLATE pg_catalog."default",
    CONSTRAINT movies_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE public.movies
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.movies TO final_capstone_appuser;
GRANT ALL ON TABLE public.movies TO final_capstone_owner;
GRANT ALL ON TABLE public.movies TO postgres;-- Table: public.genres
-- DROP TABLE public.genres;
CREATE TABLE IF NOT EXISTS public.genres
(
    genre_ids integer NOT NULL,
    movie_id integer NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (genre_ids, movie_id),
    CONSTRAINT fk_movie_id FOREIGN KEY (movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.genres
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.genres TO final_capstone_appuser;
GRANT ALL ON TABLE public.genres TO final_capstone_owner;
GRANT ALL ON TABLE public.genres TO postgres;

CREATE TABLE IF NOT EXISTS public.genre_names
(
    genre_ids integer NOT NULL,
    genre_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT genre_names_pkey PRIMARY KEY (genre_ids)
)
TABLESPACE pg_default;
ALTER TABLE public.genres
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.genre_names TO final_capstone_appuser;
GRANT ALL ON TABLE public.genres TO final_capstone_owner;
GRANT ALL ON TABLE public.genres TO postgres;


CREATE TABLE IF NOT EXISTS public.movie_favorited
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    favorite_movie_id integer,
    CONSTRAINT favorite_movie_id FOREIGN KEY (favorite_movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT favorited_pkey PRIMARY KEY (user_id, favorite_movie_id),
    CONSTRAINT saved_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.movie_favorited
    OWNER to postgres;
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE public.movie_favorited TO final_capstone_appuser;
GRANT ALL ON TABLE public.movie_favorited TO postgres;
ALTER TABLE public.movie_favorited
    ALTER COLUMN user_id
    SET (n_distinct=0);
ALTER TABLE public.movie_favorited
    ALTER COLUMN favorite_movie_id
    SET (n_distinct=0);

CREATE TABLE IF NOT EXISTS public.movie_saved
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    saved_movie_id integer,
    CONSTRAINT saved_movie_id FOREIGN KEY (saved_movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
	CONSTRAINT saved_pkey PRIMARY KEY (user_id, saved_movie_id),
    CONSTRAINT saved_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.movie_saved
    OWNER to postgres;
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE public.movie_saved TO final_capstone_appuser;
GRANT ALL ON TABLE public.movie_saved TO postgres;
ALTER TABLE public.movie_saved
    ALTER COLUMN user_id
    SET (n_distinct=0);
ALTER TABLE public.movie_saved
    ALTER COLUMN saved_movie_id
    SET (n_distinct=0);
	
INSERT INTO genre_names (genre_ids, genre_name) VALUES
	(28, 'Action'),
	(12, 'Adventure'),
	(16, 'Animation'),
	(35, 'Comedy'),
	(10751, 'Family'),
	(14, 'Fantasy'),
	(27, 'Horror'),BEGIN TRANSACTION;
DROP TABLE IF EXISTS public.users, public.movies, public.genres, public.genre_names, public.movie_lists, public.movie_favorited, public.movie_saved;
-- Table: public.movies
-- DROP TABLE public.movies;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE IF NOT EXISTS public.movies
(
    id integer NOT NULL,
    original_title character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    overview character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    release_date date NOT NULL,
    vote_average numeric(4,2),
    poster_path character varying(1000) COLLATE pg_catalog."default",
    CONSTRAINT movies_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE public.movies
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.movies TO final_capstone_appuser;
GRANT ALL ON TABLE public.movies TO final_capstone_owner;
GRANT ALL ON TABLE public.movies TO postgres;-- Table: public.genres
-- DROP TABLE public.genres;
CREATE TABLE IF NOT EXISTS public.genres
(
    genre_ids integer NOT NULL,
    movie_id integer NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (genre_ids, movie_id),
    CONSTRAINT fk_movie_id FOREIGN KEY (movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.genres
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.genres TO final_capstone_appuser;
GRANT ALL ON TABLE public.genres TO final_capstone_owner;
GRANT ALL ON TABLE public.genres TO postgres;

CREATE TABLE IF NOT EXISTS public.genre_names
(
    genre_ids integer NOT NULL,
    genre_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT genre_names_pkey PRIMARY KEY (genre_ids)
)
TABLESPACE pg_default;
ALTER TABLE public.genres
    OWNER to postgres;
GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.genre_names TO final_capstone_appuser;
GRANT ALL ON TABLE public.genres TO final_capstone_owner;
GRANT ALL ON TABLE public.genres TO postgres;


CREATE TABLE IF NOT EXISTS public.movie_favorited
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    favorite_movie_id integer,
    CONSTRAINT favorite_movie_id FOREIGN KEY (favorite_movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT favorited_pkey PRIMARY KEY (user_id, favorite_movie_id),
    CONSTRAINT saved_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.movie_favorited
    OWNER to postgres;
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE public.movie_favorited TO final_capstone_appuser;
GRANT ALL ON TABLE public.movie_favorited TO postgres;
ALTER TABLE public.movie_favorited
    ALTER COLUMN user_id
    SET (n_distinct=0);
ALTER TABLE public.movie_favorited
    ALTER COLUMN favorite_movie_id
    SET (n_distinct=0);

CREATE TABLE IF NOT EXISTS public.movie_saved
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    saved_movie_id integer,
    CONSTRAINT saved_movie_id FOREIGN KEY (saved_movie_id)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
	CONSTRAINT saved_pkey PRIMARY KEY (user_id, saved_movie_id),
    CONSTRAINT saved_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE public.movie_saved
    OWNER to postgres;
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE public.movie_saved TO final_capstone_appuser;
GRANT ALL ON TABLE public.movie_saved TO postgres;
ALTER TABLE public.movie_saved
    ALTER COLUMN user_id
    SET (n_distinct=0);
ALTER TABLE public.movie_saved
    ALTER COLUMN saved_movie_id
    SET (n_distinct=0);
	
INSERT INTO genre_names (genre_ids, genre_name) VALUES
	(28, 'Action'),
	(12, 'Adventure'),
	(16, 'Animation'),
	(35, 'Comedy'),
	(10751, 'Family'),
	(14, 'Fantasy'),
	(27, 'Horror'),
	(9648, 'Mystery'),
	(10749, 'Romance'),
	(878, 'Science Fiction'),
	(53, 'Thriller');

-- ROLLBACK;
COMMIT;
	(9648, 'Mystery'),
	(10749, 'Romance'),
	(878, 'Science Fiction'),
	(53, 'Thriller');

-- ROLLBACK;
COMMIT;