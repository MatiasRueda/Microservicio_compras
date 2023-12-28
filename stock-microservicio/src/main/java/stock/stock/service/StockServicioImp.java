package stock.stock.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock.stock.dao.StockDao;
import stock.stock.domain.Stock;

@Service
public class StockServicioImp implements StockServicio {

    @Autowired
    private StockDao stockDao;

    public boolean hayStock(String nombre){
        Optional<Stock> stock = this.stockDao.findById(nombre);
        stock.orElseThrow(() -> new RuntimeException("No encontro el producto con nombre: " + nombre));
        return stock.get().getCantidad() > 0;
    }

    public void descontarStock(String nombre) {
        Optional<Stock> stock = this.stockDao.findById(nombre);
        stock.orElseThrow(() -> new RuntimeException("No encontro el producto con nombre: " + nombre));
        Stock stockNuevo = stock.get();
        stockNuevo.setCantidad(stock.get().getCantidad() - 1);
        this.stockDao.save(stockNuevo);
    }

    public void agregarStock(String nombre, int cantidad) {
        Stock stockNuevo = new Stock();
        stockNuevo.setNombre(nombre);
        stockNuevo.setCantidad(cantidad);
        this.stockDao.save(stockNuevo);
    }
}
