BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_favorite_id FOREIGN KEY (user_id) REFERENCES favorites(favorite_id)
);

CREATE TABLE movies (
  movie_id INT NOT NULL PRIMARY KEY,
  original_title varchar(1000) DEFAULT NOT NULL,
  overview varchar(1000) DEFAULT NOT NULL,
  release_date date DEFAULT NOT NULL,
  vote_average AS tomato_meter decimal(4,2) DEFAULT NULL,
  poster_path varchar(1000) DEFAULT NULL,
	genre_name varchar(50) NOT NULL,
	user_id int NOT NULL,
  CONSTRAINT pk_movie PRIMARY KEY (movie_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

create table genres (
	genre_id int PRIMARY KEY,
	genre_name varchar(50) NOT NULL,
	movie_id int NOT NULL,
	CONSTRAINT fk_movie_id FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

create table favorites (
	movie_id int NOT NULL PRIMARY KEY,
	favorite_id int NOT NULL PRIMARY KEY,
	CONSTRAINT fk_favorites_movie_id FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
	CONSTRAINT fk_user_favorite_id FOREIGN KEY (favorite_id) REFERENCES users(users_id)
);

COMMIT TRANSACTION;
