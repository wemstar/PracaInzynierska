package edu.agh.fis.core.bra.acc.services;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.entity.bra.acc.BraAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wemstar on 25.09.14.
 */
@Service
public class BraAccountServicesImpl implements BraAccountServices {

    @Autowired
    private BraAccountDao braAccountDao;

    @Override
    public BraAccount getBraAcc(long braNo) {
        return braAccountDao.find(braNo);
    }

    @Override
    public void updateBraAcc(BraAccount braAccount) {
        braAccountDao.update(braAccount);

    }

    @Override
    public BraAccount createBraAcc(BraAccount braAccount) {
        return braAccountDao.create(braAccount);
    }

    @Override
    public void deleteBraAcc(long braNo) {
        braAccountDao.delete(braNo);

    }
}
