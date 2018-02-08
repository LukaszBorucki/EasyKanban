package co.borucki.easykanban.dto.mapper;


import java.util.ArrayList;
import java.util.List;

import co.borucki.easykanban.dto.AppConfigurationDTO;
import co.borucki.easykanban.dto.CustomerDTO;
import co.borucki.easykanban.dto.IncomingMessageDTO;
import co.borucki.easykanban.dto.ProductDTO;
import co.borucki.easykanban.dto.UserDTO;
import co.borucki.easykanban.model.AppConfiguration;
import co.borucki.easykanban.model.Customer;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.model.Product;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.statics.DateTimeCounter;
import co.borucki.easykanban.statics.ImageBitmap;

public class Mapper {
    public static User fromUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getId()
                , userDTO.getName()
                , userDTO.getSurname()
                , userDTO.getPassword()
                , userDTO.isBlocked() > 0
                , userDTO.getPermissions()
                , userDTO.getLastLogin()
                , userDTO.getPossibleLoginTry());
    }

    public static List<User> fromUserDTOToUser(List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            users.add(fromUserDTOToUser(userDTO));
        }
        return users;
    }

    public static Customer fromCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getName()
                , customerDTO.getMailAddress()
                , customerDTO.getMailPassword()
                , customerDTO.getMailHost()
                , customerDTO.getMailSMTPPort()
                , customerDTO.getMailTo()
                , customerDTO.getLicenceOwner());
    }

    public static Product fromProductDTOToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getProductId()
                , ImageBitmap.decodeImageFromStringToByteArray(productDTO.getPhoto())
                , productDTO.getDescription()
                , productDTO.getRackNo()
                , productDTO.getRackShelfNo()
                , productDTO.getRackShelfRowNo()
                , productDTO.getProducer()
                , productDTO.getUnit());


    }

    public static List<Product> fromProductDTOToProduct(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            products.add(fromProductDTOToProduct(productDTO));
        }
        return products;
    }

    public static IncomingMessage fromIncomingMessageDTOToIncomingMessage(IncomingMessageDTO message) {
        return new IncomingMessage(
                message.getId()
                , message.getSubject()
                , message.getFrom()
                , DateTimeCounter.getDateTime()
                , false
                , message.getContents()
        );
    }

    public static List<IncomingMessage> fromIncomingMessageDTOToIncomingMessage(List<IncomingMessageDTO> messages) {
        List<IncomingMessage> incomingMessages = new ArrayList<>();
        for (IncomingMessageDTO message : messages) {
            incomingMessages.add(fromIncomingMessageDTOToIncomingMessage(message));
        }
        return incomingMessages;
    }

    public static AppConfiguration fromAppConfigurationDTOToAppConfiguration(AppConfigurationDTO configurationDTO) {
        return new AppConfiguration(configurationDTO.getCommercialLicence() > 0
                , configurationDTO.getRefreshProducts() > 0
                , configurationDTO.getRefreshUsers() > 0
                , configurationDTO.getRefreshStyle() > 0
                , configurationDTO.getDelAllData() > 0
                , configurationDTO.getCodeType()
                , configurationDTO.getSendLog() > 0);
    }

    public static List<AppConfiguration> fromAppConfigurationDTOToAppConfiguration(List<AppConfigurationDTO> configurationDTOs) {
        List<AppConfiguration> configurations = new ArrayList<>();
        for (AppConfigurationDTO configurationDTO : configurationDTOs) {
            configurations.add(fromAppConfigurationDTOToAppConfiguration(configurationDTO));
        }
        return configurations;
    }
}
