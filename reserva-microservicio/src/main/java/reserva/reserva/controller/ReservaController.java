package reserva.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reserva.reserva.client.StockClient;
import reserva.reserva.domain.ReservaDTO;
import reserva.reserva.service.ReservaServicio;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private StockClient stockClient;

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = "stockCB", fallbackMethod = "stockFallback")
    public String guardarReserva(@RequestBody ReservaDTO reservaDTO) {
        boolean hayStock = reservaDTO.getReservaItems().stream()    
            .allMatch(reservaItem -> this.stockClient.hayStock(reservaItem.getNombre()));

        if (!hayStock)
            return "No se pudo guardar, porque no hay stock";

        reservaDTO.getReservaItems().stream()    
            .forEach(reservaItem -> this.stockClient.descontarStock(reservaItem.getNombre()));

        return this.reservaServicio.guardar(reservaDTO);
    }

    private String stockFallback(@RequestBody ReservaDTO reservaDTO, RuntimeException e) {
        return "El microservicio Stock esta desconectado";
    }

}
