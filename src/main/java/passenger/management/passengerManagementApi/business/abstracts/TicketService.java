package passenger.management.passengerManagementApi.business.abstracts;

import java.util.List;

import passenger.management.passengerManagementApi.business.requests.CreateTicketRequest;
import passenger.management.passengerManagementApi.business.requests.UpdateTicketRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllTicketsResponse;
import passenger.management.passengerManagementApi.business.responses.GetTicketByIdResponse;

public interface TicketService {
	List<GetAllTicketsResponse> getAll();
	GetTicketByIdResponse getById(int id);
	
	void add(CreateTicketRequest createTicketRequest);
	void update(UpdateTicketRequest updateTicketRequest);
	void delete(int id);
}
