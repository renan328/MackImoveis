package proj.rest.mackimoveis.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import proj.rest.mackimoveis.models.Reserva;

public interface ReservaRepository extends CrudRepository <Reserva, Long>{
    Optional<Reserva> findByUsuarioId(Long usuarioId);
} 
