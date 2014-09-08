package edu.agh.fis.services;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.presistance.ClientFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wemstar on 06.09.14.
 */
@Component
public class ClientFileService {


    @Autowired
    private ClientFileDao clientFileDao;

    public ClientFile getByClientNo(long clientNo) {

//        List<ClientFile> clientFileList = clientFileDao.getByNo(clientNo);
//        if (clientFileList.size() != 0)
//            return clientFileList.get(0);
//        else
//            return null;
        ClientFile clientFile=new ClientFile();
        clientFile.clientNo=1;
        clientFile.name="Sylwek";
        return clientFile;
    }
}
