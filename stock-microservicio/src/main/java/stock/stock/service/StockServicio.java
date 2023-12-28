package stock.stock.service;

public interface StockServicio {
    public boolean hayStock(String codigo);
    public void descontarStock(String codigo);
    public void agregarStock(String nombre, int cantidad);
}
