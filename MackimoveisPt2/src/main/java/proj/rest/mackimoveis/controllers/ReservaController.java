package proj.rest.mackimoveis.controllers;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.mackimoveis.models.Reserva;
import proj.rest.mackimoveis.repositories.ReservaRepository;

@RestController
@RequestMapping("/api/reserva")

public class ReservaController {
    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping()
    Iterable<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    
    @GetMapping("/{id}")
    Optional<Reserva> getReserva(@PathVariable long id) {
        return reservaRepository.findById(id);
    }

    
    @GetMapping("/usuario/{id}")
    Optional<Reserva> getReservaUsuario(@PathVariable long id) {
        return reservaRepository.findByUsuarioId(id);
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva r) throws Exception {
        Reserva reserva = reservaRepository.save(r);
        reserva.getPropriedade().setDisponivel(false);
        return reserva;
    }

    // esse aqui tem que ser dois? Um para o usuario e um para o locator?
    @PutMapping("/{reservaId}")
    Optional<Reserva> updateReserva(@RequestBody Reserva reservaRequest, @PathVariable long reservaId) {
        Optional<Reserva> opt = this.getReserva(reservaId);
        if (opt.isPresent()) {
            Reserva reserva = opt.get();
            if (reservaRequest.getId() == reserva.getId()) {
                reserva.setPropriedade(reservaRequest.getPropriedade());
                reserva.setUsuario(reservaRequest.getUsuario());
                reserva.setCheckIn(reservaRequest.getCheckIn());
                reserva.setCheckOut(reservaRequest.getCheckOut());
                reservaRepository.save(reserva);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar reserva " + reservaId);
    }

    @DeleteMapping("/{id}")
    public void deletReserva(@PathVariable long reservaid){
        reservaRepository.deleteById(reservaid);
    }


}
