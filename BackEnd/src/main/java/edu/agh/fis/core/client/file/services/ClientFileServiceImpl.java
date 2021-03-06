package edu.agh.fis.core.client.file.services;


import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wemstar on 06.09.14.
 */
@Service
@Transactional
public class ClientFileServiceImpl implements ClientFileService {


    @Autowired
    private ClientFileDao clientFileDao;


    @Override
    public ClientFile getByClientNo(long clientNo) {
        return clientFileDao.find(clientNo);
    }

    @Override
    public ClientFile createClientFile(ClientFile clientFile) {
        return clientFileDao.create(clientFile);
    }

    @Override
    public void updateClientFile(ClientFile clientFile) {
        clientFileDao.update(clientFile);
    }

    @Override
    public void deleteClientFile(long clientNo) {
        clientFileDao.delete(clientNo);
    }

    @Override
    public List<ClientFile> getByTemplate(ClientFile template) {
        return clientFileDao.findByTemplete(template);
    }
}
