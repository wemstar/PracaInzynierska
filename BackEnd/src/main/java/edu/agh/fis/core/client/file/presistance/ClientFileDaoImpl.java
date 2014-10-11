package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wemstar on 06.09.14.
 */
@Repository
@Transactional(readOnly = true)
public class ClientFileDaoImpl extends AbstractDAOImpl<ClientFile> implements ClientFileDao {


}
