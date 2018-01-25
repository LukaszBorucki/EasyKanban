package co.borucki.easykanban.dto.mapper;


import java.util.ArrayList;
import java.util.List;

import co.borucki.easykanban.dto.CustomerDTO;
import co.borucki.easykanban.dto.UserDTO;
import co.borucki.easykanban.model.Customer;
import co.borucki.easykanban.model.User;

public class Mapper {
    public static List<User> fromUserDTOToUser(List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            users.add(
                    new User(userDTO.getId()
                            , userDTO.getName()
                            , userDTO.getSurname()
                            , userDTO.getPassword()
                            , userDTO.isBlocked() > 0 ? true : false
                            , userDTO.getPermissions()
                            , userDTO.getLastLogin()
                            , userDTO.getPossibleLoginTry()));
        }
        return users;
    }

    public static Customer fromCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getName()
                , customerDTO.getMailAddress()
                , customerDTO.getMailPassword()
                , customerDTO.getMailHost()
                , customerDTO.getMailSMTPPort()
                , customerDTO.getMailTo());
    }
}
