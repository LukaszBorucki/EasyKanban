package co.borucki.easykanban.statics;

import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;

public class RemoveAllData {
    private static final EventLogRepository mEventLogRepo = EventLogRepositoryImpl.getInstance();
    private static final IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private static final ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
    private static final ScannedProductRepository mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();
    private static final UserRepository mUserRepo = UserRepositoryImpl.getInstance();

    public static void removeAll() {
        mEventLogRepo.removeAll();
        mMessageRepo.removeAll();
        mProductRepo.removeAll();
        mScannedProductRepo.removeAll();
        mUserRepo.removeAll();
    }
}
