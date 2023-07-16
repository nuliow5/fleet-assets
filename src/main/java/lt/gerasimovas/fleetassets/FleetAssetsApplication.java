package lt.gerasimovas.fleetassets;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FleetAssetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetAssetsApplication.class, args);
		System.out.println("FLEET_ASSETS start");
	}

}
