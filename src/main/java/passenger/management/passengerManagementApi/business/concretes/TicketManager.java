package passenger.management.passengerManagementApi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import passenger.management.passengerManagementApi.business.abstracts.TicketService;
import passenger.management.passengerManagementApi.business.requests.CreateTicketRequest;
import passenger.management.passengerManagementApi.business.requests.UpdateTicketRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllTicketsResponse;
import passenger.management.passengerManagementApi.business.responses.GetTicketByIdResponse;
import passenger.management.passengerManagementApi.core.utilities.mappers.ModelMapperService;
import passenger.management.passengerManagementApi.dataAccess.abstracts.PassengerRepository;
import passenger.management.passengerManagementApi.dataAccess.abstracts.TicketRepository;
import passenger.management.passengerManagementApi.entities.concretes.Passenger;
import passenger.management.passengerManagementApi.entities.concretes.Ticket;

@Service
public class TicketManager implements TicketService {
	private TicketRepository ticketRepository;
	private PassengerRepository passengerRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public TicketManager(TicketRepository ticketRepository, PassengerRepository passengerRepository,
			ModelMapperService modelMapperService) {
		this.ticketRepository = ticketRepository;
		this.passengerRepository = passengerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllTicketsResponse> getAll() {
	    List<Ticket> tickets = ticketRepository.findAll();

	    List<GetAllTicketsResponse> responses = tickets.stream()
	        .map(ticket -> {
	            GetAllTicketsResponse response = modelMapperService.forResponse().map(ticket, GetAllTicketsResponse.class);
	            response.setPassanger_name(ticket.getPassenger().getFirst_name() + " " + ticket.getPassenger().getLast_name());
	            return response;
	        })
	        .collect(Collectors.toList());

	    return responses;
	}

	@Override
	public void add(CreateTicketRequest createTicketRequest) {
		Passenger passenger = passengerRepository.findById(createTicketRequest.getPassenger_id())
				.orElseThrow(() -> new RuntimeException(
						"Passenger with Id " + createTicketRequest.getPassenger_id() + " not found."));

		Ticket ticket = modelMapperService.forRequest().map(createTicketRequest, Ticket.class);
		ticket.setPassenger(passenger);

		this.ticketRepository.save(ticket);
	}

	@Override
	public void delete(int id) {
		this.ticketRepository.deleteById(id);
	}

	@Override
	public GetTicketByIdResponse getById(int id) {
		Ticket ticket = this.ticketRepository.findById(id).orElseThrow();
		GetTicketByIdResponse response = this.modelMapperService.forResponse().map(ticket, GetTicketByIdResponse.class);
		response.setPassenger_name(ticket.getPassenger().getFirst_name() + " " + ticket.getPassenger().getLast_name());
		
		return response;
	}

	@Override
	public void update(UpdateTicketRequest updateTicketRequest) {
	    Ticket ticket = this.ticketRepository.findById(updateTicketRequest.getId())
	        .orElseThrow(() -> new RuntimeException("Ticket not found"));

	    ticket.setSeat_number(updateTicketRequest.getSeat_number());
	    ticket.setBoarding_time(updateTicketRequest.getBoarding_time());
	    ticket.setGate(updateTicketRequest.getGate());

	    this.ticketRepository.save(ticket);
	}
}
