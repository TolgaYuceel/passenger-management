package passenger.management.passengerManagementApi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPassengerByIdResponse {
	private String first_name;
	private String last_name;
}
