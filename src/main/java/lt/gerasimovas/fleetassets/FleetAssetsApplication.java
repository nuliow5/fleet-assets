package lt.gerasimovas.fleetassets;

import lt.gerasimovas.fleetassets.auth.AuthenticationService;
import lt.gerasimovas.fleetassets.auth.RegisterRequest;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static lt.gerasimovas.fleetassets.enumes.Role.ADMIN;
import static lt.gerasimovas.fleetassets.enumes.Role.MANAGER;

@SpringBootApplication
public class FleetAssetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetAssetsApplication.class, args);
		System.out.println("FLEET_ASSETS start");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}

}
