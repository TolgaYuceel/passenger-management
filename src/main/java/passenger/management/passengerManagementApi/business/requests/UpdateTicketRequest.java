package passenger.management.passengerManagementApi.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketRequest {
	private int id;
	private int seat_number;
	private String boarding_time;
	private String gate;
}