package passenger.management.passengerManagementApi.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequest {
	private int passenger_id;
	private int seat_number;
	private String gate;
	private String boarding_time;	
}
