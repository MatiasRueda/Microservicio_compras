package reserva.reserva.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reserva.reserva.dao.ReservaDao;
import reserva.reserva.domain.ReservaDTO;


@Service
public class ReservaServicioImp implements ReservaServicio {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public String guardar(ReservaDTO reservaDTO) {
        String idReserva = UUID.randomUUID().toString();
        reservaDTO.getReservaItems().stream().forEach(reservaItem -> {
            reservaItem.setIdReserva(idReserva);
            this.reservaDao.save(reservaItem);
        });
        return "Guardado";
    }
    
}
