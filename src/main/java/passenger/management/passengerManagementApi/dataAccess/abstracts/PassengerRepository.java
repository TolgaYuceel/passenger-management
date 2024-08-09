package passenger.management.passengerManagementApi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import passenger.management.passengerManagementApi.entities.concretes.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
