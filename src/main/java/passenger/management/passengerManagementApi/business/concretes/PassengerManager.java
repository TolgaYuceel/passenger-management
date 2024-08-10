package passenger.management.passengerManagementApi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import passenger.management.passengerManagementApi.business.abstracts.PassengerService;
import passenger.management.passengerManagementApi.business.requests.CreatePassengerRequest;
import passenger.management.passengerManagementApi.business.requests.UpdatePassengerRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllPassengersResponse;
import passenger.management.passengerManagementApi.business.responses.GetPassengerByIdResponse;
import passenger.management.passengerManagementApi.core.utilities.mappers.ModelMapperService;
import passenger.management.passengerManagementApi.dataAccess.abstracts.PassengerRepository;
import passenger.management.passengerManagementApi.entities.concretes.Passenger;

@Service
public class PassengerManager implements PassengerService {
	private PassengerRepository passengerRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public PassengerManager(PassengerRepository passengerRepository, ModelMapperService modelMapperService) {
		this.passengerRepository = passengerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllPassengersResponse> getAll() {
		List<Passenger> passengers = passengerRepository.findAll();
		List<GetAllPassengersResponse> passengersResponse = passengers.stream()
				.map(passenger -> this.modelMapperService.forResponse().map(passenger, GetAllPassengersResponse.class))
				.collect(Collectors.toList());
	
		return passengersResponse;	
	}

	@Override
	public void delete(int id) {
		this.passengerRepository.deleteById(id);
	}

	@Override
	public void add(CreatePassengerRequest createPassengerRequest) {
		Passenger passeneger =  this.modelMapperService.forRequest().map(createPassengerRequest, Passenger.class);
		this.passengerRepository.save(passeneger);
	}

	@Override
	public void update(UpdatePassengerRequest updatePassengerRequest) {
		Passenger passenger = this.modelMapperService.forRequest().map(updatePassengerRequest, Passenger.class);	
		this.passengerRepository.save(passenger);
	}

	@Override
	public GetPassengerByIdResponse getById(int id) {
		Passenger passenger = this.passengerRepository.findById(id).orElseThrow();
		GetPassengerByIdResponse response = this.modelMapperService.forResponse().map(passenger, GetPassengerByIdResponse.class);
		
		return response;
	}

}
