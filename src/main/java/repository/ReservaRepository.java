package repository;

import domain.Reserva;
import domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findBySalonAndFechaAndHoraInicioBeforeAndHoraFinAfter(Salon salon, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin);
}