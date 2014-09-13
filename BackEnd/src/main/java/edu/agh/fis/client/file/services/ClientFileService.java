package edu.agh.fis.client.file.services;

import edu.agh.fis.client.file.presistance.ClientFileDao;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wemstar on 06.09.14.
 */
@Component
public class ClientFileService {


    @Autowired
    private ClientFileDao clientFileDao;
    private static final Logger logger = Logger.getLogger(ClientFileService.class.getName());
    public ClientFile getByClientNo(long clientNo) {

        List<ClientFile> clientFileList = clientFileDao.getByNo(clientNo);
        if (clientFileList.size() != 0) {
            logger.info(clientFileList.get(0).toString());
            return new ClientFile();
        }
        else
            return null;


    }

    public void createClient(ClientFile clientFile) {

        clientFileDao.save(clientFile);
    }
}
