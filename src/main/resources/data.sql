-- INSERTAR PLAYLISTS
INSERT INTO play_list (id, name, mood) VALUES (1, 'Musica para entrenar', 'Energética');
INSERT INTO play_list (id, name, mood) VALUES (2, 'Salsita para el corazón', 'Romántica');
INSERT INTO play_list (id, name, mood) VALUES (3, 'Clasicos del reggaeton', 'Fiestera');

INSERT INTO track (title, duration, rank, artist_name, album_title, artist_picture, album_cover, playlist_id)
VALUES
    ('Titanium (feat. Sia)', 245, 956365, 'David Guetta', 'Nothing but the Beat (Ultimate Edition)', 'https://api.deezer.com/artist/542/image', 'https://api.deezer.com/album/6168389/image', 1),
    ('Scarface (Push It To The Limit)', 178, 606801, 'Paul Engemann', 'Scarface (Expanded Motion Picture Soundtrack)', 'https://api.deezer.com/artist/13112/image', 'https://api.deezer.com/album/342918347/image', 1),
    ('Believer', 202, 978978, 'Imagine Dragons', 'Evolve', 'https://api.deezer.com/artist/416239/image', 'https://api.deezer.com/album/68346981/image', 1),

    ('Algo Que Se Quede', 220, 569305, 'Grupo Niche', 'Algo Que Se Quede', 'https://api.deezer.com/artist/16107/image', 'https://api.deezer.com/album/172876722/image', 2),
    ('Soledad', 286, 349010, 'La-33', 'La-33', 'https://api.deezer.com/artist/434201/image', 'https://api.deezer.com/album/7684975/image', 2),

    ('Zun Da Da', 304, 584242, 'Zion', 'The Perfect Melody', 'https://api.deezer.com/artist/17046/image', 'https://api.deezer.com/album/13922392/image', 3),
    ('Tu príncipe', 205, 496692, 'Daddy Yankee', 'Barrio Fino (Bonus Track Version)', 'https://api.deezer.com/artist/3839/image', 'https://api.deezer.com/album/691271171/image', 3),
    ('El Fenomeno', 234, 450474, 'Arcángel', 'El Fenomeno', 'https://api.deezer.com/artist/5536564/image', 'https://api.deezer.com/album/42989651/image', 3);
