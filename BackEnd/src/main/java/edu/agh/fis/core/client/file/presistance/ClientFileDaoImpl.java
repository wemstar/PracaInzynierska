package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wemstar on 06.09.14.
 */
@Repository
@Transactional(readOnly = true)
public class ClientFileDaoImpl extends AbstractDAOImpl<ClientFile> implements ClientFileDao {





}
