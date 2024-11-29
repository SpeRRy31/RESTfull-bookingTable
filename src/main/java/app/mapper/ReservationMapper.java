package app.mapper;

import app.dto.ReservationDTO;
import app.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    // Перетворення з Entity у DTO
    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setTableId(reservation.getTableId());
        dto.setUserId(reservation.getUserId());
        dto.setName(reservation.getName());
        dto.setPhone(reservation.getPhone());
        return dto;
    }

    // Перетворення з DTO у Entity
    public Reservation toEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setTableId(dto.getTableId());
        reservation.setUserId(dto.getUserId());
        reservation.setName(dto.getName());
        reservation.setPhone(dto.getPhone());
        return reservation;
    }
}
