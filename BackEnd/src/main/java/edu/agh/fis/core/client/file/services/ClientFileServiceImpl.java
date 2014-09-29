package edu.agh.fis.core.client.file.services;


import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wemstar on 06.09.14.
 */
@Service
public class ClientFileServiceImpl implements ClientFileService {


    @Autowired
    private ClientFileDao clientFileDao;


    private static final Logger logger = Logger.getLogger(ClientFileServiceImpl.class.getName());

    @Override
    public ClientFile getByClientNo(long clientNo) {

        List<ClientFile> clientFileList = clientFileDao.getByNo(clientNo);
        if (clientFileList.size() != 0) {
            logger.info(clientFileList.get(0).toString());
            return new ClientFile();
        } else
            return null;


    }

    @Override
    public void createClient(ClientFile clientFile) {

        clientFileDao.save(clientFile);
    }
}
