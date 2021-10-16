package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reserva;
import co.usa.ciclo3.ciclo3.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository metodosCrud;

    public List<Reserva> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reserva> getReserva(int idReserva) {
        return metodosCrud.getReserva(idReserva);
    }

    public Reserva save(Reserva Reserva) {
        if (Reserva.getIdReservation()== null) {
            return metodosCrud.save(Reserva);
        } else {
            Optional<Reserva> e = metodosCrud.getReserva(Reserva.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(Reserva);
            } else {
                return Reserva;
            }
        }
    }

    public Reserva update(Reserva Reserva) {
        if (Reserva.getIdReservation() != null) {
            Optional<Reserva> e = metodosCrud.getReserva(Reserva.getIdReservation());
            if (!e.isEmpty()) {
                if (Reserva.getStartDate()!= null) {
                    e.get().setStartDate(Reserva.getStartDate());
                }
                if (Reserva.getDevolutionDate()!= null) {
                    e.get().setDevolutionDate(Reserva.getDevolutionDate());
                }
                if (Reserva.getClient()!= null) {
                    e.get().setClient(Reserva.getClient());
                }
                if (Reserva.getCabin()!= null) {
                    e.get().setCabin(Reserva.getCabin());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Reserva;
            }
        } else {
            return Reserva;
        }
    }

    public boolean deleteReserva(int ReservaId) {
        Boolean aBoolean = getReserva(ReservaId).map(Reserva -> {
            metodosCrud.delete(Reserva);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
