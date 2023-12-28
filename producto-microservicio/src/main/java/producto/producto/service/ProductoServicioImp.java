package producto.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import producto.producto.dao.ProductoDao;
import producto.producto.domain.Producto;

@Service
public class ProductoServicioImp implements ProductoServicio {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos() {
        return (List<Producto>) this.productoDao.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        this.productoDao.save(producto);
    }

}
