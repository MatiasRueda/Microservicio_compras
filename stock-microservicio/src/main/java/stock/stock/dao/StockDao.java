package stock.stock.dao;

import org.springframework.data.repository.CrudRepository;

import stock.stock.domain.Stock;


public interface StockDao extends CrudRepository<Stock, String> {
}
