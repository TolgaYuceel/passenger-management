package passenger.management.passengerManagementApi.business.abstracts;

import java.util.List;

import passenger.management.passengerManagementApi.business.requests.CreateTicketRequest;
import passenger.management.passengerManagementApi.business.requests.DeleteTicketRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllTicketsResponse;

public interface TicketService {
	List<GetAllTicketsResponse> getAll();
	
	void add(CreateTicketRequest createTicketRequest);
	void delete(DeleteTicketRequest deleteTicketRequest);
}
