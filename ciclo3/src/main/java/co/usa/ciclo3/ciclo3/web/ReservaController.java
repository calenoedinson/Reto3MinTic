package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Reserva;
import co.usa.ciclo3.ciclo3.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservaController {

    @Autowired
    private ReservaService servicio;

    @GetMapping("/all")
    public List<Reserva> getReservas() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> getReservas(@PathVariable("id") int ReservaId) {
        return servicio.getReserva(ReservaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva Reserva) {
        return servicio.save(Reserva);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva Reserva) {
        return servicio.update(Reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ReservaId) {
        return servicio.deleteReserva(ReservaId);
    }
}
