package passenger.management.passengerManagementApi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTicketsResponse {
	private int id;
	private String boarding_time; 
	private String passanger_name;
}
