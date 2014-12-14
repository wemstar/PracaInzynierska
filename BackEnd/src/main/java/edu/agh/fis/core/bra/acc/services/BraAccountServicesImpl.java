package edu.agh.fis.core.bra.acc.services;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

/**
 * Created by wemstar on 25.09.14.
 */
@Service
@Transactional
public class BraAccountServicesImpl implements BraAccountServices {

    @Autowired
    private BraAccountDao braAccountDao;

    @Autowired
    private ClientFileDao clientFileDao;

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

    @Override
    public BraAccount addAccountToClient(long clientNo, BraAccount braAccount) {

        ClientFile clientFile = clientFileDao.find(clientNo);
        if (clientFile.getAccount() == null) clientFile.setAccount(new HashSet<BraAccount>());
        braAccount.setClientFile(clientFile);
        BraAccount braAccount1 = braAccountDao.create(braAccount);


        return braAccount1;
    }
}
