package passenger.management.passengerManagementApi.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import passenger.management.passengerManagementApi.business.abstracts.PassengerService;
import passenger.management.passengerManagementApi.business.requests.CreatePassengerRequest;
import passenger.management.passengerManagementApi.business.requests.UpdatePassengerRequest;
import passenger.management.passengerManagementApi.business.responses.GetAllPassengersResponse;
import passenger.management.passengerManagementApi.business.responses.GetPassengerByIdResponse;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
	private PassengerService passengerService;
	
	public PassengerController(PassengerService passengerService) {
		this.passengerService = passengerService;
	}
	
	@GetMapping()
	public List<GetAllPassengersResponse> getAll() {
		return passengerService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		passengerService.delete(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreatePassengerRequest createPassengerRequest) {
		passengerService.add(createPassengerRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdatePassengerRequest updatePassengerRequest) {
		passengerService.update(updatePassengerRequest);
	}
	
	@GetMapping("/{id}")
	public GetPassengerByIdResponse getById(@PathVariable int id) {
		return passengerService.getById(id);
	}
	
}
