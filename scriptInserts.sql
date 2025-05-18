USE clic_lava;

-- INSERT Roles
INSERT INTO rol VALUES (1, 'administrador');
INSERT INTO Rol VALUES (2, 'cliente');

-- INSERT Usuario
INSERT INTO usuario VALUES(1, "Peter", "Parker", "pparker@email.com", "RGUpp/kYdAPZ8U/J/snzvrtpQuHHijz4oDxwHf3SaJuDzxkGKEm0aOyFqdDRqRRmEZLvMPBddBzCVnVLh9v0AA==", "5512345678", "2025-05-16 00:00:00", 1);
INSERT INTO usuario VALUES(2, "Ruby", "Sunday", "rsunday@email.com", "FX1uK8PqQGDCfqKaNozGgLAtlrfmlQReR+gtAmwpp7GLwn2o3HuJXG6j2Nzujt6dg4BlKDZijf70zIn/+RRbDw==", "5509876543", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(3, "Jack", "Harkness", "jharkness@email.com", "6/Pt5gtPUoZ4pJlsSg+5wppgJQUyhu6sSUBcF39fRRegbV1BUxTImJslEnaf2PNiz9L/vphXtwBpXCgg09Xj/g==", "5512345678", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(4, "Rose", "Taylor", "rtaylor@email.com", "kje+jCXn0FLrB9hzKzLc+sbMTsVInYPrrz5iyqkaKZaBbbCGkrknwPtlTK7d09sg54sJBURUDih3SXLQMXqcLw==", "5524681357", "2025-05-16 00:00:00", 2);
INSERT INTO usuario VALUES(5, "Clara", "Oswald", "coswald@email.com", "2NnAUfxdAv/9Qu30I64smIVNlYbPGVUui2f0I+oRco1/Nu4vEgnjLriWN8kXHGnN7P0HiEj9yZQkvl7j2aLsIA==", "5597532468", "2025-05-16 00:00:00", 1);

-- INSERT Tarjeta
INSERT INTO tarjeta VALUES(1, "Peter Parker", "5656343456789098", "12/25", "245", 1); 
INSERT INTO tarjeta VALUES(2, "Ruby Sunday", "9384756823405698", "09/26", "643", 2);
INSERT INTO tarjeta VALUES(3, "Jack Harkness", "9384567150987563", "05/27", "459", 3);
INSERT INTO tarjeta VALUES(4, "Rose Taylor", "5039494555959567", "09/26", "345", 4);
INSERT INTO tarjeta VALUES(5, "Clara Oswald", "5465360929323335", "04/28", "184", 5);

-- INSERT Pedido
INSERT INTO pedido VALUES (1,"Av. Chimalhuacán 12","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-19 06:00:00", 1,"Un día", 1);
INSERT INTO pedido VALUES (2,"Calle 20 de noviembre","Las Águilas" ,"Nezahualcoyotl", "5700", "2025-05-20 08:00:00", 1, "Un día", 2);
INSERT INTO pedido VALUES (3,"Av. Pantitlán 300","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-22 09:00:00", 1, "Un día", 3);
INSERT INTO pedido VALUES (4,"Calle Vicente Gerrero 89","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-23 12:00:00", 1, "Un día", 4);
INSERT INTO pedido VALUES (5,"Av. Riva Palacio 150","Benito Juárez" ,"Nezahualcoyotl", "5700", "2025-05-23 7:00:00", 1, "Un día", 5);

-- INSERTS producto ->
INSERT INTO producto VALUES (null, "Lavadora", "Lavadora automática de alta eficiencia con múltiples ciclos de lavado. Capacidad de 10kg, ideal para familias. Sistema de ahorro de agua y energía.", 89.99, 5, "https://picsum.photos/id/237/200/300");
INSERT INTO producto VALUES (null, "Secadora", "Secadora eléctrica con tecnología de secado rápido y sensores de humedad. Capacidad de 8kg y sistema anti-arrugas. Incluye múltiples configuraciones de temperatura.", 58.79, 7, "https://picsum.photos/id/96/200/300");
INSERT INTO producto VALUES (null, "Suavitel", "Suavizante de telas concentrado con aroma floral duradero. Deja la ropa suave, fresca y sin estática. Rinde hasta 40 lavadas. Botella de 850ml.", 19.90, 10, "https://picsum.photos/id/57/200/300");
INSERT INTO producto VALUES (null, "Ace 1kg", "Detergente en polvo multiusos con partículas activas que eliminan manchas difíciles. Fórmula concentrada con blanqueador para mayor brillo en tus prendas. Envase de 1kg.", 15.35, 16, "https://picsum.photos/id/26/200/300");
INSERT INTO producto VALUES (null, "Cloralex", "Blanqueador desinfectante que elimina el 99.9% de bacterias y gérmenes. Ideal para limpieza profunda de baños, cocinas y superficies. Botella de 1 litro con tapa de seguridad.", 21.80, 12, "https://picsum.photos/id/2/200/300");
INSERT INTO producto VALUES (null, "Lavasecadora LG 12 kg WD12VVC4S6S", "Lavasecadora electrónica LG con capacidad de 12 kg. Tecnología AI DD que detecta el peso y la suavidad de los tejidos. Función Steam que elimina las bacterias y alérgenos. Panel digital intuitivo y 14 ciclos de lavado. Color: acero inoxidable.", 350.00, 3, "https://picsum.photos/id/180/200/300");
INSERT INTO producto VALUES (null, "Lavadora Samsung 20 kg WA20A3341GW/AX", "Lavadora Samsung automática de carga superior con capacidad de 20 kg. Tecnología Wobble que minimiza el enredo de la ropa. 8 ciclos de lavado y panel de control digital. Sistema EcoBubble que ahorra energía. Color: blanco.", 285.00, 5, "https://picsum.photos/id/181/200/300");
INSERT INTO producto VALUES (null, "Lavasecadora Hisense 16 kg WD5S1645BT", "Lavasecadora eléctrica Hisense con capacidad de lavado de 16 kg y secado de 10 kg. Motor Direct Motion de transmisión directa. Pantalla LED para visualización de funciones. Sistema Vapor+ que elimina arrugas y alérgenos. Color: negro.", 320.00, 4, "https://picsum.photos/id/182/200/300");
INSERT INTO producto VALUES (null, "Lavadora Koblenz 19 kg lum-19iir Frankfurt", "Lavadora automática Koblenz de carga superior con capacidad de 19 kg. 10 programas de lavado y filtro atrapa pelusas. Sistema Smart Motion con 6 movimientos de tambor diferentes. Display LED intuitivo y función de inicio diferido. Color: rojo borgoña.", 275.00, 6, "https://picsum.photos/id/183/200/300");
INSERT INTO producto VALUES (null, "Lavadora Whirlpool 18 kg 7MWTW1955EW", "Lavadora Whirlpool automática de carga superior con capacidad de 18 kg. Tecnología Xpert System que optimiza el uso de agua. Ciclo Deep Water Wash para mayor limpieza. Agitador de doble acción y sistema de dosificación inteligente. Incluye 5 años de garantía. Color: blanco.", 299.99, 4, "https://picsum.photos/id/184/200/300");

-- INSERT pedido_producto
INSERT INTO pedido_producto VALUES (1, 1, 1, 89.99);
INSERT INTO pedido_producto VALUES (1, 3, 2, 19.90);
INSERT INTO pedido_producto VALUES (2, 2, 1, 58.79);
INSERT INTO pedido_producto VALUES (2, 5, 1, 21.80);
INSERT INTO pedido_producto VALUES (3, 3, 3, 19.90);
INSERT INTO pedido_producto VALUES (3, 4, 2, 15.35);
INSERT INTO pedido_producto VALUES (4, 1, 1, 89.99);
INSERT INTO pedido_producto VALUES (4, 2, 1, 58.79);
INSERT INTO pedido_producto VALUES (5, 4, 3, 15.35);
INSERT INTO pedido_producto VALUES (5, 5, 2, 21.80);

-- INSERT pago
INSERT INTO pago VALUES (1, 129.79, '2025-05-19 06:15:00', 1, 1);
INSERT INTO pago VALUES (2, 80.59, '2025-05-20 08:10:00', 2, 2);
INSERT INTO pago VALUES (3, 90.40, '2025-05-22 09:05:00', 3, 3);
INSERT INTO pago VALUES (4, 148.78, '2025-05-23 12:10:00', 4, 4);
INSERT INTO pago VALUES (5, 89.65, '2025-05-23 07:15:00', 5, 5);

SELECT * FROM rol;
SELECT * FROM usuario;
SELECT * FROM tarjeta;
SELECT * FROM pedido;
SELECT * FROM producto;
SELECT * FROM pedido_producto;
SELECT * FROM pago;