package producto.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import producto.producto.client.StockClient;
import producto.producto.domain.Producto;
import producto.producto.domain.ProductoDTO;
import producto.producto.service.ProductoServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private StockClient stockClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getProductos() {
        return this.productoServicio.getProductos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = "stockCB", fallbackMethod = "stockFallback")
    public String guardarProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        this.productoServicio.guardar(producto);
        this.stockClient.agregarStock(productoDTO.getNombre(), productoDTO.getStock());
        return "Producto guardado";
    }

    private String stockFallback(@RequestBody ProductoDTO productoDTO, RuntimeException e) {
        return "El microservicio Stock esta desconectado";
    }

}
