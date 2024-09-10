INSERT INTO ingrediente (nombre, descripcion, calorias, carbohidratos, proteinas, grasas) VALUES 
('Pollo', 'Pechuga de pollo sin piel', 165, 0, 31, 3.6),
('Arroz', 'Arroz blanco cocido', 130, 28, 2.4, 0.3),
('Brócoli', 'Brócoli al vapor', 55, 11, 3.7, 0.6),
('Aguacate', 'Aguacate fresco', 160, 9, 2, 15),
('Tomate', 'Tomate fresco en rodajas', 18, 3.9, 0.9, 0.2),
('Pasta', 'Pasta de trigo integral cocida', 158, 30, 6, 1.5),
('Espinaca', 'Espinaca fresca al vapor', 23, 3.6, 2.9, 0.4),
('Salmon', 'Salmón a la plancha', 206, 0, 22, 13),
('Queso', 'Queso cheddar rallado', 402, 1.3, 24, 33),
('Huevo', 'Huevo cocido', 155, 1.1, 13, 11),
('Atún', 'Atún enlatado al natural', 116, 0, 26, 1),
('Lechuga', 'Lechuga fresca en rodajas', 14, 2.9, 1.4, 0.2),
('Pepino', 'Pepino fresco en rodajas', 16, 3.6, 0.7, 0.1),
('Zanahoria', 'Zanahoria fresca en rodajas', 41, 9.6, 0.9, 0.2),
('Avena', 'Avena cocida con agua', 68, 12, 2.4, 1.4);


INSERT INTO plato (nombre, descripcion, otros_ingredientes, cantidad_ingrediente_principal, calorias, carbohidratos, proteinas, grasas, favorito, ingrediente_id) VALUES 
('Pollo con Arroz', 'Pechuga de pollo acompañada de arroz y brócoli', 'Arroz,Brócoli', 50, 350, 28, 33, 4.5, true, 1),
('Ensalada de Aguacate', 'Ensalada fresca con aguacate, tomate y brócoli', 'Tomate,Brócoli', 75, 200, 14, 6.6, 8.3, false, 4),
('Arroz con Tomate', 'Arroz blanco mezclado con tomate fresco', 'Tomate', 80, 250, 30, 3.3, 0.5, false, 2),
('Brócoli al Vapor', 'Brócoli al vapor con aceite de oliva', '', 95, 55, 11, 3.7, 0.6, false, 3),
('Pechuga de Pollo', 'Pechuga de pollo a la plancha con especias', '', 100, 165, 0, 31, 3.6, false, 1),
('Pasta con Queso', 'Pasta de trigo integral con queso cheddar rallado', 'Queso', 75, 580, 31.3, 30, 34.5, true, 6),
('Ensalada de Espinaca y Huevo', 'Ensalada fresca de espinaca con huevo cocido', 'Huevo', 35, 178, 4.7, 15.9, 5.4, false, 7),
('Salmón con Brócoli', 'Salmón a la plancha con brócoli al vapor', 'Brócoli', 75, 261, 11, 29.7, 13.6, true, 8),
('Pollo con Espinaca', 'Pechuga de pollo a la plancha con espinaca fresca', 'Espinaca', 90, 188, 3.6, 33.9, 4.0, false, 1),
('Tortilla de Huevo y Queso', 'Tortilla de huevo con queso cheddar', 'Queso', 80, 557, 2.4, 37, 44.4, true, 9),
('Ensalada de Atún', 'Ensalada fresca de lechuga, pepino y atún', 'Lechuga,Pepino', 40, 146, 5.9, 28.1, 1.3, false, 10),
('Zanahorias con Brócoli', 'Zanahorias frescas y brócoli al vapor', 'Brócoli', 60, 96, 20.6, 4.6, 0.8, false, 13),
('Pollo con Avena', 'Pechuga de pollo acompañada de avena cocida', 'Avena', 75, 233, 12, 34, 5, false, 1),
('Pasta con Espinaca y Queso', 'Pasta de trigo integral con espinaca y queso cheddar rallado', 'Espinaca,Queso', 80, 603, 31.3, 33.3, 35, true, 6),
('Salmón con Zanahorias', 'Salmón a la plancha acompañado de zanahorias frescas', 'Zanahoria', 65, 247, 9.6, 27.9, 13.2, false, 8);
