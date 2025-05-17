-- INSERT Roles
SELECT * FROM rol;
INSERT INTO rol (`nombreRol`) VALUES ('administrador');
INSERT INTO Rol (`nombreRol`) VALUES ('cliente');

-- INSERT Usuario
SELECT * FROM usuario;
INSERT INTO usuario VALUES(1, "Peter", "Parker", "pparker@email.com", "RGUpp/kYdAPZ8U/J/snzvrtpQuHHijz4oDxwHf3SaJuDzxkGKEm0aOyFqdDRqRRmEZLvMPBddBzCVnVLh9v0AA==", "5512345678", "2025-05-16 00:00:00", 1);
INSERT INTO usuario VALUES(2, "Ruby", "Sunday", "rsunday@email.com", "FX1uK8PqQGDCfqKaNozGgLAtlrfmlQReR+gtAmwpp7GLwn2o3HuJXG6j2Nzujt6dg4BlKDZijf70zIn/+RRbDw==", "5509876543", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(3, "Jack", "Harkness", "jharkness@email.com", "6/Pt5gtPUoZ4pJlsSg+5wppgJQUyhu6sSUBcF39fRRegbV1BUxTImJslEnaf2PNiz9L/vphXtwBpXCgg09Xj/g==", "5512345678", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(4, "Rose", "Taylor", "rtaylor@email.com", "kje+jCXn0FLrB9hzKzLc+sbMTsVInYPrrz5iyqkaKZaBbbCGkrknwPtlTK7d09sg54sJBURUDih3SXLQMXqcLw==", "5524681357", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(5, "Clara", "Oswald", "coswald@email.com", "2NnAUfxdAv/9Qu30I64smIVNlYbPGVUui2f0I+oRco1/Nu4vEgnjLriWN8kXHGnN7P0HiEj9yZQkvl7j2aLsIA==", "5597532468", "2025-05-16 00:00:00", 1);

-- INSERT Tarjeta
SELECT * FROM tarjeta;
INSERT INTO tarjeta VALUES(01, "Peter Parker", "5656343456789098", "12/25", "245", 1); 
INSERT INTO tarjeta VALUES(02, "Ruby Sunday", "9384756823405698", "09/26", "643", 2);
INSERT INTO tarjeta VALUES(03, "Jack Harkness", "9384567150987563", "05/27", "459", 3);
INSERT INTO tarjeta VALUES(04, "Rose Taylor", "5039494555959567", "09/26", "345", 4);
INSERT INTO tarjeta VALUES(05, "Clara Oswald", "5465360929323335", "04/28", "184", 5);

-- INSERT Pedido
SELECT * FROM pedido;
INSERT INTO pedido VALUES (1,"Av. Chimalhuacán 12","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-19 06:00:00", 1,"Un día", 1);
INSERT INTO pedido VALUES (2,"Calle 20 de noviembre","Las Águilas" ,"Nezahualcoyotl", "5700", "2025-05-20 08:00:00", 1, "Un día", 2);
INSERT INTO pedido VALUES (3,"Av. Pantitlán 300","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-22 09:00:00", 1, "Un día", 3);
INSERT INTO pedido VALUES (4,"Calle Vicente Gerrero 89","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-23 12:00:00", 1, "Un día", 4);
INSERT INTO pedido VALUES (5,"Av. Riva Palacio 150","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-23 7:00:00", 1, "Un día", 5);
