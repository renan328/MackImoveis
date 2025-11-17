package proj.rest.mackimoveis.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proj.rest.mackimoveis.models.Reserva;
import proj.rest.mackimoveis.repositories.ReservaRepository;

@RestController
@RequestMapping("/reserva")

public class ReservaController {
        private final ReservaRepository reservaRepository;

        public ReservaController(ReservaRepository reservaRepository){
            this.reservaRepository = reservaRepository;
        }

        @GetMapping("/api/reserva")
        Iterable<Reserva> getReserva(){
            return reservaRepository.findAll();
        }

        
        @PostMapping
        public Reserva criarReserva (@RequestBody Reserva r) throws Exception{
            Reserva criarReserva = reservaRepository.save(r);
            return criarReserva;
        }

        @GetMapping("/api/reserva/{id}")
        Optional<Reserva> getReserva(@PathVariable long id){
            return reservaRepository.findById(id);
        }
        // esse aqui tem que ser dois? Um para o usuario e um para o locator?
        @PutMapping("/api/reserva/{reservaId}")
        Optional<Reserva> updateReserva(@RequestBody Reserva reservaRequest, @PathVariable long reservaId){
            Optional<Reserva> opt = this.getReserva(reservaId);
            if(opt.isPresent()){
                Reserva reserva = opt.get();
                if (reservaRequest.getId() == reserva.getId()) {
                    reserva.setUsuario(reservaRequest.getId());
                }
            }
        }
}
