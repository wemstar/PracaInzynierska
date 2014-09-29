package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;

import java.util.List;

/**
 * Created by wemstar on 13.09.14.
 */
public interface ClientFileDao {
    List<ClientFile> getByNo(long clientNo);

    void save(ClientFile clientFile);
}
