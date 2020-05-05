use punto_venta;
INSERT INTO productos (clave, descripcion, unidad, inventario, precio) 
VALUES (1285, "Jabon en barra", "pieza", 25, 15), 
	(2562, "Aceite de 1lt", "pieza", 18, 30), 
    (3142, "Jabon en polvo de 1kg", "pieza", 24, 24), 
    (4896, "Huevo blanco 1kg", "pieza", 18, 40), 
    (2785, "Aceite de 1lt", "caja", 2, 300);

select * from productos;