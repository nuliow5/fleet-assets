//package lt.gerasimovas.fleetassets;
//
//import lt.gerasimovas.fleetassets.auth.AuthenticationService;
//import lt.gerasimovas.fleetassets.entities.UserEntity;
//import lt.gerasimovas.fleetassets.enumes.Role;
//import lt.gerasimovas.fleetassets.repositories.UserEntityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Simulate {
//    @Autowired
//    UserEntityRepository userEntityRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @EventListener(ApplicationReadyEvent.class)
//    public void startApp(AuthenticationService service){
//        if(userEntityRepository.findAll().isEmpty()){
//            UserEntity employee = new UserEntity();
//            employee.setEmail("root");
//            employee.setPassword(passwordEncoder.encode("root"));
//            employee.setRole(Role.ADMIN);
//            userEntityRepository.saveAndFlush(employee);
//            System.out.println("Admin token: " + service.register(employee).getAccessToken());
//        }
//
//    }
//
//}
