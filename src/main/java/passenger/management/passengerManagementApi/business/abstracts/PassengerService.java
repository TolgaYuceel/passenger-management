package passenger.management.passengerManagementApi.business.abstracts;

import java.util.List;

import passenger.management.passengerManagementApi.business.requests.CreatePassengerRequest;
import passenger.management.passengerManagementApi.business.requests.UpdatePassengerRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllPassengersResponse;
import passenger.management.passengerManagementApi.business.responses.GetPassengerByIdResponse;

public interface PassengerService {
	List<GetAllPassengersResponse> getAll();
	GetPassengerByIdResponse getById(int id);
	
	void add(CreatePassengerRequest createPassengerRequest);
	void update(UpdatePassengerRequest updatePassengerRequest);
	void delete(int id);
}
