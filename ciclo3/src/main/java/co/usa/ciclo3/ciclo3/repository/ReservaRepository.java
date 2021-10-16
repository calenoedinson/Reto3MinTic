package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Reserva;
import co.usa.ciclo3.ciclo3.repository.crud.ReservaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAll() {
        return (List<Reserva>) reservaCrudRepository.findAll();
    }

    public Optional<Reserva> getReserva(int id) {
        return reservaCrudRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaCrudRepository.save(reserva);
    }

    public void delete(Reserva reserva) {
        reservaCrudRepository.delete(reserva);
    }

}
