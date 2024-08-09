package passenger.management.passengerManagementApi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import passenger.management.passengerManagementApi.entities.concretes.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
