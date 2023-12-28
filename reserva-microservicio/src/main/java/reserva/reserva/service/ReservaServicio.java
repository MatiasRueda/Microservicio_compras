package reserva.reserva.service;

import org.springframework.web.bind.annotation.RequestBody;

import reserva.reserva.domain.ReservaDTO;

public interface ReservaServicio {
    public String guardar(@RequestBody ReservaDTO reservaDTO);
}
