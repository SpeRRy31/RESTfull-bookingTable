package app.service;

import app.dto.ReservationDTO;
import app.entity.Reservation;
import app.mapper.ReservationMapper;
import app.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    // Отримати всі резервації
    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Отримати резервацію за ID
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Резервацію не знайдено"));
        return reservationMapper.toDTO(reservation);
    }

    // Створити нову резервацію
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(savedReservation);
    }

    // Оновити резервацію
    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Резервацію не знайдено"));

        reservation.setTableId(reservationDTO.getTableId());
        reservation.setUserId(reservationDTO.getUserId());
        reservation.setName(reservationDTO.getName());
        reservation.setPhone(reservationDTO.getPhone());

        Reservation updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(updatedReservation);
    }

    // Видалити резервацію
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Резервацію не знайдено");
        }
        reservationRepository.deleteById(id);
    }
}
