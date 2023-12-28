package producto.producto.dao;

import org.springframework.data.repository.CrudRepository;

import producto.producto.domain.Producto;

public interface ProductoDao extends CrudRepository<Producto, String> {

     
} 