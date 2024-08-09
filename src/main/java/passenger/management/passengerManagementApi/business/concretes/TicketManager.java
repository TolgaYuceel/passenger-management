package passenger.management.passengerManagementApi.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import passenger.management.passengerManagementApi.business.abstracts.TicketService;
import passenger.management.passengerManagementApi.business.requests.CreateTicketRequest;
import passenger.management.passengerManagementApi.business.requests.DeleteTicketRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllTicketsResponse;
import passenger.management.passengerManagementApi.dataAccess.abstracts.PassengerRepository;
import passenger.management.passengerManagementApi.dataAccess.abstracts.TicketRepository;
import passenger.management.passengerManagementApi.entities.concretes.Passenger;
import passenger.management.passengerManagementApi.entities.concretes.Ticket;

@Service
public class TicketManager implements TicketService {
	private TicketRepository ticketRepository;
	private PassengerRepository passengerRepository;

	@Autowired
	public TicketManager(TicketRepository ticketRepository, PassengerRepository passengerRepository) {
		this.ticketRepository = ticketRepository;
		this.passengerRepository = passengerRepository;
	}

	@Override
	public List<GetAllTicketsResponse> getAll() {
	    List<Ticket> tickets = ticketRepository.findAll();
	    List<GetAllTicketsResponse> responses = new ArrayList<>();
	    
	    for (Ticket t : tickets) {
	        GetAllTicketsResponse getAllTicketsResponse = new GetAllTicketsResponse();
	        getAllTicketsResponse.setId(t.getId());
	        getAllTicketsResponse.setPassanger_name(t.getPassenger().getFirst_name());
	        getAllTicketsResponse.setBoarding_time(t.getBoarding_time());
	    
	        responses.add(getAllTicketsResponse);
	    }
	    
	    return responses;
	}

	@Override
	public void add(CreateTicketRequest createTicketRequest) {
		Ticket ticket = new Ticket();
		Passenger passenger = passengerRepository.findById(createTicketRequest.getPassenger_id())
		        .orElseThrow(() -> new RuntimeException("Passenger with ID " + createTicketRequest.getPassenger_id() + " not found."));
		
		ticket.setBoarding_time(createTicketRequest.getBoarding_time());
		ticket.setGate(createTicketRequest.getGate());
		ticket.setSeat_number(createTicketRequest.getSeat_number());
		ticket.setPassenger(passenger);
		
		this.ticketRepository.save(ticket);
	}

	@Override
	public void delete(DeleteTicketRequest deleteTicketRequest) {
		List<Ticket> tickets = this.ticketRepository.findAll();
		
		for (Ticket ticket : tickets) {
			if(ticket.getId() == deleteTicketRequest.getId()) {
				this.ticketRepository.delete(ticket);
			}
		}
	}

}
