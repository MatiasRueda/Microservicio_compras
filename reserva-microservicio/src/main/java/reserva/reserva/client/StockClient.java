package reserva.reserva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "stock-microservicio")
public interface StockClient {

    @GetMapping("/api/stock/verificar/{nombre}")
    boolean hayStock(@PathVariable String nombre);

    @PutMapping("/api/stock/descontar/{nombre}")
    void descontarStock(@PathVariable String nombre);
    
}
