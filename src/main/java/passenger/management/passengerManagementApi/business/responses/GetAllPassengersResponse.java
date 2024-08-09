package passenger.management.passengerManagementApi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPassengersResponse {
	private int id;
	private String first_name;
	private String last_name;
	private String nationality;
}
