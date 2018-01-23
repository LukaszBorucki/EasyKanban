package co.borucki.easykanban.statics;

import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;

public class SampleData {


    public static void loadUsers() {
        UserRepository mRepository = UserRepositoryImpl.getInstance();
        mRepository.saveUser(new User(1, "Jan", "Nowak", "1111", false, 15, "2015-12-14 09:08:12", 10));
        mRepository.saveUser(new User(2, "Sebek", "Kowalski", "2222", false, 15, "2015-12-14 09:08:12", 10));
        mRepository.saveUser(new User(3, "Antek", "Dzidziuś", "3333", false, 15, "2015-12-14 09:08:12", 10));
    }

    public static void loadMessages() {
        IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();

        mMessageRepo.saveMessage(new IncomingMessage(8,"test","Dostawca","2017-05-12 14:19:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(9,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(10,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(11,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(12,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(13,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(14,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(15,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(16,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(17,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(18,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(19,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));
        mMessageRepo.saveMessage(new IncomingMessage(20,"test","Dostawca","2017-05-12 14:20:12",false,"W dniu dzisiejszym została nadana paczka z towarem"));

    }

    public static void AddStockTaking(){
        ScannedProductRepository mRepo = ScannedProductRepositoryImpl.getInstance();
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:21","STOCKTAKING"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","STOCKTAKING"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","STOCKTAKING"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","USED"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","USED"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","RECEIVED"));
        mRepo.save(new ScannedProduct(0,"010 1212",1,"2018-01-22 13:09:58","RECEIVED"));
    }

}
