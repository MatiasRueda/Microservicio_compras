package stock.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stock.stock.service.StockServicio;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockServicio stockServicio;

    @GetMapping("/verificar/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public boolean hayStock(@PathVariable String nombre) {
        return this.stockServicio.hayStock(nombre);
    }

    @PutMapping("/descontar/{nombre}") 
    @ResponseStatus(HttpStatus.OK)
    public void descontarStock(@PathVariable String nombre) {
        this.stockServicio.descontarStock(nombre);
    }

    @PutMapping("/agregar/{nombre}/{cantidad}") 
    @ResponseStatus(HttpStatus.OK)
    public void agregarStock(@PathVariable String nombre, @PathVariable int cantidad) {
        this.stockServicio.agregarStock(nombre, cantidad);
    }

}
