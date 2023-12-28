package producto.producto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "stock-microservicio")
public interface StockClient {

    @PutMapping("/api/stock/agregar/{nombre}/{cantidad}") 
    void agregarStock(@PathVariable String nombre, @PathVariable int cantidad);
}
