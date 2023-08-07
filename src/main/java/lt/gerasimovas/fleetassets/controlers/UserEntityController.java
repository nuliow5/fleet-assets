//package lt.gerasimovas.fleetassets.controlers;
//
//import lt.gerasimovas.fleetassets.dto.UserDTO;
//import lt.gerasimovas.fleetassets.enumes.Role;
//import lt.gerasimovas.fleetassets.services.UserEntityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/users")
//public class UserEntityController {
//    @Autowired
//    private UserEntityService userService;
//
//    @GetMapping
//    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(name = "role", required = false)
//                                                     Role role,
//                                                     @PageableDefault Pageable pageable) {
//
//        return ResponseEntity.ok(this.userService.getAllDto(pageable, role));
//    }
//
//    @GetMapping
//    @RequestMapping("/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
//        try {
//            return ResponseEntity.ok(this.userService.getById(id));
//        } catch (NoSuchElementException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    String.format("User by ID: %s not found", id));
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
//        try {
//            return ResponseEntity.ok(this.userService.create(userDTO));
//        } catch (IllegalArgumentException e){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
//        try {
//            return ResponseEntity.ok(this.userService.update(userDTO));
//        } catch (NoSuchFieldException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable Long id){
//        try {
//            this.userService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } catch (NoSuchElementException e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        }
//    }
//
//
//
//}
