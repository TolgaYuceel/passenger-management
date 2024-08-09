package passenger.management.passengerManagementApi.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import passenger.management.passengerManagementApi.business.abstracts.PassengerService;
import passenger.management.passengerManagementApi.business.requests.CreatePassengerRequest;
import passenger.management.passengerManagementApi.business.requests.DeletePassengerRequest;
import passenger.management.passengerManagementApi.business.requests.UpdatePassengerRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllPassengersResponse;
import passenger.management.passengerManagementApi.business.responses.GetPassengerByIdResponse;
import passenger.management.passengerManagementApi.dataAccess.abstracts.PassengerRepository;
import passenger.management.passengerManagementApi.entities.concretes.Passenger;

@Service
public class PassengerManager implements PassengerService {
	private PassengerRepository passengerRepository;
	
	@Autowired
	public PassengerManager(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	@Override
	public List<GetAllPassengersResponse> getAll() {
		List<Passenger> passengers = passengerRepository.findAll();
		List<GetAllPassengersResponse> responses = new ArrayList<>();
		
		for (Passenger passenger : passengers) {
			GetAllPassengersResponse getAllPassengersResponse = new GetAllPassengersResponse();
			getAllPassengersResponse.setFirst_name(passenger.getFirst_name());
			getAllPassengersResponse.setLast_name(passenger.getLast_name());
			getAllPassengersResponse.setId(passenger.getId());
			getAllPassengersResponse.setNationality(passenger.getNationality());
			responses.add(getAllPassengersResponse);
		}
		return responses;
		
		
	}

	@Override
	public void delete(DeletePassengerRequest deletePassengerRequest) {
		List<Passenger> passenger = passengerRepository.findAll();
		for (Passenger p : passenger) {
			if(deletePassengerRequest.getId() == p.getId()) {
				passengerRepository.delete(p);
			}
		}
	}

	@Override
	public void add(CreatePassengerRequest createPassengerRequest) {
		Passenger passenger = new Passenger();
		// Don't Repeat Yourself
		passenger.setFirst_name(createPassengerRequest.getFirst_name());
		passenger.setLast_name(createPassengerRequest.getLast_name());
		passenger.setNationality(createPassengerRequest.getNationality());
		
		this.passengerRepository.save(passenger);
	}

	@Override
	public void update(UpdatePassengerRequest updatePassengerRequest) {
		Passenger passenger = new Passenger();
		// Don't Repeat Yourself
		passenger.setId(updatePassengerRequest.getId());
		passenger.setFirst_name(updatePassengerRequest.getFirst_name());
		passenger.setNationality(updatePassengerRequest.getNationality());
		passenger.setLast_name(updatePassengerRequest.getLast_name());
		
		this.passengerRepository.save(passenger);
	}

	@Override
	public GetPassengerByIdResponse getById(int id) {
		Passenger passenger = this.passengerRepository.findById(id).orElseThrow();
		GetPassengerByIdResponse response = new GetPassengerByIdResponse();
		response.setFirst_name(passenger.getFirst_name());
		response.setLast_name(passenger.getLast_name());
		
		return response;
	}

}
