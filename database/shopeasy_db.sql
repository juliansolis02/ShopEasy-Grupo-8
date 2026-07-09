/*==========================================================
    SHOP EASY
    Script de datos iniciales
    Autor: Equipo ShopEasy
==========================================================*/

CREATE DATABASE IF NOT EXISTS shopeasy_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE shopeasy_db;

/*----------------------------------------------------------
  Limpiar datos existentes
----------------------------------------------------------*/

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE producto;
TRUNCATE TABLE categoria;

ALTER TABLE producto AUTO_INCREMENT = 1;
ALTER TABLE categoria AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

/*----------------------------------------------------------
  Categorías
----------------------------------------------------------*/

INSERT INTO categoria (id, nombre) VALUES
(1,'Tecnología'),
(2,'Zapatos'),
(3,'Bebidas'),
(4,'Frutas y Verduras'),
(5,'Snacks');

/*----------------------------------------------------------
  Productos
----------------------------------------------------------*/

INSERT INTO producto
(nombre, descripcion, precio, stock, imagen, categoria_id)
VALUES

('Mouse Logitech G203',
 'Mouse gamer RGB',
 15000,
 5,
 'https://placehold.co/300x220/F4C400/000000?text=Mouse',
 1),

('Teclado Mecánico',
 'Teclado mecánico retroiluminado',
 28000,
 10,
 'https://placehold.co/300x220/F4C400/000000?text=Teclado',
 1),

('Audífonos Bluetooth',
 'Audífonos inalámbricos con micrófono',
 22000,
 6,
 'https://placehold.co/300x220/F4C400/000000?text=Audifonos',
 1),

('Monitor Samsung 24"',
 'Monitor Full HD de 24 pulgadas',
 95000,
 3,
 'https://placehold.co/300x220/F4C400/000000?text=Monitor',
 1),

('Zapatos Deportivos',
 'Zapatos cómodos para uso diario',
 25000,
 5,
 'https://placehold.co/300x220/F4C400/000000?text=Zapatos',
 2),

('Sandalias',
 'Sandalias casuales',
 12000,
 8,
 'https://placehold.co/300x220/F4C400/000000?text=Sandalias',
 2),

('Botas',
 'Botas impermeables',
 38000,
 4,
 'https://placehold.co/300x220/F4C400/000000?text=Botas',
 2),

('Coca Cola Original 3L',
 'Bebida gaseosa',
 2000,
 12,
 'https://placehold.co/300x220/F4C400/000000?text=Coca+Cola',
 3),

('Sprite 3L',
 'Bebida gaseosa sabor limón',
 1800,
 9,
 'https://placehold.co/300x220/F4C400/000000?text=Sprite',
 3),

('Agua Embotellada',
 'Botella de agua 600 ml',
 800,
 20,
 'https://placehold.co/300x220/F4C400/000000?text=Agua',
 3),

('Banano',
 'Banano fresco por unidad',
 300,
 20,
 'https://placehold.co/300x220/F4C400/000000?text=Banano',
 4),

('Manzana Roja',
 'Manzana fresca',
 450,
 15,
 'https://placehold.co/300x220/F4C400/000000?text=Manzana',
 4),

('Lechuga',
 'Lechuga fresca',
 900,
 7,
 'https://placehold.co/300x220/F4C400/000000?text=Lechuga',
 4),

('Chocolate Snickers',
 'Chocolate individual',
 1200,
 8,
 'https://placehold.co/300x220/F4C400/000000?text=Snickers',
 5),

('Picaritas',
 'Snack de maíz',
 500,
 14,
 'https://placehold.co/300x220/F4C400/000000?text=Picaritas',
 5),

('Galletas Oreo',
 'Paquete de galletas',
 1500,
 11,
 'https://placehold.co/300x220/F4C400/000000?text=Oreo',
 5);
