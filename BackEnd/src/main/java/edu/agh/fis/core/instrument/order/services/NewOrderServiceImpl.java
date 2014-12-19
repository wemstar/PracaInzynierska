package edu.agh.fis.core.instrument.order.services;

import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.instrument.order.presistance.NewOrderDAO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.instrument.order.NewOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 17.12.14.
 */
@Service
public class NewOrderServiceImpl implements NewOrderService {

    @Autowired
    private NewOrderDAO newOrderDAO;
    @Autowired
    private ClientFileDao clientFileDao;
    @Override
    public NewOrder procesOrder(NewOrder newOrder) {


        return newOrderDAO.create(newOrder);
    }

    @Override
    public List<NewOrder> getOrdeListForClient(Long clientNo) {
        List<NewOrder> orderList = new ArrayList<NewOrder>();
        List<BraAccount> braAccounts = new ArrayList<BraAccount>(clientFileDao.find(clientNo).getAccount());
        for (BraAccount braAccount : braAccounts) orderList.addAll(braAccount.getOrders());
        return orderList;
    }
}
