package lt.gerasimovas.fleetassets.controlers;

import lt.gerasimovas.fleetassets.dto.TabletDTO;
import lt.gerasimovas.fleetassets.services.TabletService;
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
@RequestMapping("/assets/tablets")
public class TabletController {

    @Autowired
    private TabletService tabletService;

    @GetMapping
    public ResponseEntity<List<TabletDTO>> getAllTablets(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.tabletService.getAllDto(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TabletDTO> getTabletById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(this.tabletService.getById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Tablet by ID: %s not found", id));
        }
    }

    @PostMapping
    public ResponseEntity<TabletDTO> addTablet(@RequestBody TabletDTO tabletDTO) {
        return ResponseEntity.ok(this.tabletService.create(tabletDTO));
    }

    @PutMapping
    public ResponseEntity<TabletDTO> updateTablet(@RequestBody TabletDTO tabletDTO){
        try {
            return ResponseEntity.ok(this.tabletService.update(tabletDTO));
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Tablet by ID: %s not found", tabletDTO.getId()));
        } catch (NoSuchFieldException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteTabletById(@PathVariable long id){
        try {
            this.tabletService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Truck by ID: %s not found", id));
        }
    }


}
