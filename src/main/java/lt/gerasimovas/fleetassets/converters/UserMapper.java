//package lt.gerasimovas.fleetassets.converters;
//
//import lt.gerasimovas.fleetassets.dto.CreateUserDTO;
//import lt.gerasimovas.fleetassets.dto.UserDTO;
//import lt.gerasimovas.fleetassets.entities.UserEntity;
//import org.springframework.data.domain.Page;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserMapper {
//
//    public static UserEntity fromDtoToEntity(UserDTO userDTO) {
//        UserEntity user = null;
//        if (userDTO != null) {
//            user = new UserEntity();
//            user.setId(userDTO.getId());
//            user.setUsername(userDTO.getUsername());
//            user.setRole(userDTO.getRole());
//
//            if (userDTO instanceof CreateUserDTO) {
//                user.setPassword(((CreateUserDTO) userDTO).getPassword());
//            }
//        }
//        return user;
//    }
//
//    public static UserDTO fromEntityToDto(UserEntity user){
//        UserDTO userDTO = null;
//        if (user != null){
//            userDTO.setId(user.getId());
//            userDTO.setUsername(user.getUsername());
//            userDTO.setRole(user.getRole());
//        }
//        return userDTO;
//    }
//
//    public static List<UserDTO> fromEntitiesListToDtoList(List<UserEntity> users){
//        List<UserDTO> userDTOList = null;
//        if (users != null && !users.isEmpty()){
//            userDTOList = new ArrayList<>();
//            for (UserEntity u : users){
//                userDTOList.add(fromEntityToDto(u));
//            }
//        }
//        return userDTOList;
//    }
//
//    public static List<UserDTO> convertPageToDtoList (Page<UserEntity> userEntityPage){
//        List<UserDTO> userDTOList = null;
//        if (userEntityPage != null && !userEntityPage.isEmpty()){
//            userDTOList = new ArrayList<>();
//            for (UserEntity u : userEntityPage){
//                userDTOList.add(fromEntityToDto(u));
//            }
//        }
//        return userDTOList;
//    }
//}
