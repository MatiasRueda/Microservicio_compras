package reserva.reserva.dao;

import org.springframework.data.repository.CrudRepository;

import reserva.reserva.domain.Reserva;

public interface ReservaDao extends CrudRepository<Reserva, Long>{

}
