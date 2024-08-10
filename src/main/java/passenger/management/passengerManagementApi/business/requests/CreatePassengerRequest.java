package passenger.management.passengerManagementApi.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePassengerRequest {
	@NotNull
	@NotBlank
	private String first_name;
	
	@NotNull
	@NotBlank
	private String last_name;
	
	@NotNull
	@NotBlank
	private String nationality;
}
