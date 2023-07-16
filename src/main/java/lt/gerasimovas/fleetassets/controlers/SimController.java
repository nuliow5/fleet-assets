package lt.gerasimovas.fleetassets.controlers;

import lt.gerasimovas.fleetassets.services.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets/sims")
public class SimController {

    @Autowired
    SimService simService;

    //TODO CRUDE



}
