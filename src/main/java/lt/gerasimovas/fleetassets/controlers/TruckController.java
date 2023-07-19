package lt.gerasimovas.fleetassets.controlers;

import lt.gerasimovas.fleetassets.dto.TruckDTO;
import lt.gerasimovas.fleetassets.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping
    ResponseEntity<List<TruckDTO>> getAllTrucks(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.truckService.getAllDto(pageable));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<TruckDTO> getTruckById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.truckService.getById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Truck by ID: %s not found", id));
        }
    }

    @PostMapping
    public ResponseEntity<TruckDTO> addTruck(@RequestBody TruckDTO truckDTO) {
        return ResponseEntity.ok(this.truckService.create(truckDTO));
    }

    @PutMapping
    public ResponseEntity<TruckDTO> updateTruck(@RequestBody TruckDTO truckDTO) {
        try {
            return ResponseEntity.ok(this.truckService.update(truckDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Truck by ID: %s not found", truckDTO.getId()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruckById(@PathVariable Long id) {
        try {
            this.truckService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Truck by ID: %s not found", id));
        }
    }


}
