BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO genres (genre_id, genre_name) VALUES (28, 'Action');
INSERT INTO genres (genre_id, genre_name) VALUES (12, 'Adventure');
INSERT INTO genres (genre_id, genre_name) VALUES (16, 'Animation');
INSERT INTO genres (genre_id, genre_name) VALUES (35, 'Comedy');
INSERT INTO genres (genre_id, genre_name) VALUES (27, 'Horror');
INSERT INTO genres (genre_id, genre_name) VALUES (9648, 'Mystery');
INSERT INTO genres (genre_id, genre_name) VALUES (10749, 'Romance');
INSERT INTO genres (genre_id, genre_name) VALUES (18, 'Drama');
INSERT INTO genres (genre_id, genre_name) VALUES (53, 'Thriller');
INSERT INTO genres (genre_id, genre_name) VALUES (878, 'Science Fiction');



COMMIT TRANSACTION;
