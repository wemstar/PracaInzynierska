package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.presistance.AbstractDAO;

import java.util.List;

/**
 * interfejs do wyciągania klasy BraAccount  z Bazy danych
 * @see  edu.agh.fis.entity.client.file.ClientFile
 */
public interface ClientFileDao extends AbstractDAO<ClientFile> {

    List<ClientFile> findByTemplete(ClientFile template);
}
