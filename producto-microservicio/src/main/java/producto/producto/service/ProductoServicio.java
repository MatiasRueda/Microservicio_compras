package producto.producto.service;

import java.util.List;

import producto.producto.domain.Producto;

public interface ProductoServicio {
    public List<Producto> getProductos();
    public void guardar(Producto producto);
}
