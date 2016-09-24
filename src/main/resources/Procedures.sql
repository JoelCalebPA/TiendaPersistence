USE `db_tienda` ;

DROP PROCEDURE IF EXISTS spEliminarProducto;
CREATE PROCEDURE spEliminarProducto(idProducto int)
	update tbl_producto 
    set estado = 0 
    where id_producto = idProducto;

DROP PROCEDURE IF EXISTS spListarProductos;
CREATE PROCEDURE spListarProductos()
	select p.id_producto, p.descripcion, p.id_categoria, p.id_marca, p.precio, p.stock
    from tbl_producto p 
    where estado = 1;
    
DROP PROCEDURE IF EXISTS spListarProductosPorCategoria;
CREATE PROCEDURE spListarProductosPorCategoria( idCategoria int )
	select p.id_producto, p.descripcion, p.id_categoria, p.id_marca, p.precio, p.stock
    from tbl_producto p inner join tbl_categoria c 
    on p.id_categoria = c.id_categoria 
    where p.id_categoria = idCategoria and p.estado = 1;
    
DROP PROCEDURE IF EXISTS spListarProductosPorMarca;
CREATE PROCEDURE spListarProductosPorMarca( idMarca int )
	select p.id_producto, p.descripcion, p.id_categoria, p.id_marca, p.precio, p.stock
    from tbl_producto p inner join tbl_marca m 
    on p.id_marca = m.id_marca 
    where p.id_marca = idMarca and p.estado = 1;