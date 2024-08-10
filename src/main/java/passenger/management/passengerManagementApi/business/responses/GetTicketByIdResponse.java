package passenger.management.passengerManagementApi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTicketByIdResponse {
	private String passenger_name;
	private String boarding_time;
	private int seat_number;
}
