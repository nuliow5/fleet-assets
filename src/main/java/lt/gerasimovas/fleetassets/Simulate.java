//package lt.gerasimovas.fleetassets;
//
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
//    public void startApp(){
//        if(userEntityRepository.findAll().isEmpty()){
//            UserEntity employee = new UserEntity();
//            employee.setUsername("admin");
//            employee.setPassword(passwordEncoder.encode("admin"));
//            employee.setRole(Role.ADMIN);
//            userEntityRepository.saveAndFlush(employee);
//        }
//
//    }
//
//}
