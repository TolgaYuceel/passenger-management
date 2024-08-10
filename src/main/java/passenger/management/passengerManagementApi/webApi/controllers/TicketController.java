package passenger.management.passengerManagementApi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import passenger.management.passengerManagementApi.business.abstracts.TicketService;
import passenger.management.passengerManagementApi.business.requests.CreateTicketRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllTicketsResponse;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<GetAllTicketsResponse> getAll() {
        return ticketService.getAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateTicketRequest createTicketRequest) {
    	this.ticketService.add(createTicketRequest);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable int id) {
    	this.ticketService.delete(id);
    }
}
