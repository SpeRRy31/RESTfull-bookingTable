package app.service;

import app.entity.Reservation;
import app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Отримати всі резервування
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Отримати резервування за id
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Створити нове резервування
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Оновити резервування
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setReservationTime(reservationDetails.getReservationTime());
        reservation.setName(reservationDetails.getName());
        reservation.setPhone(reservationDetails.getPhone());
        reservation.setUser(reservationDetails.getUser());
        reservation.setTable(reservationDetails.getTable());
        reservation.setRestaurant(reservationDetails.getRestaurant());

        return reservationRepository.save(reservation);
    }

    // Видалити резервування
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationRepository.delete(reservation);
    }
}
