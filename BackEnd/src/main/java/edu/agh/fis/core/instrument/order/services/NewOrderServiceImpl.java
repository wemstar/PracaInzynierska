package edu.agh.fis.core.instrument.order.services;

import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.fix.SendMessage;
import edu.agh.fis.core.instrument.order.presistance.NewOrderDAO;
import edu.agh.fis.core.trader.TraderExecutor;
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

    @Autowired
    private TraderExecutor executor;

    @Autowired
    private SendMessage sendMessage;


    @Override
    public NewOrder createNewOrder(NewOrder newOrder) {
        sendMessage.sendMessage(newOrder);
        NewOrder newOrderEntity = newOrderDAO.create(newOrder);
        executor.processOrder(newOrderEntity);
        return newOrderEntity;
    }

    @Override
    public List<NewOrder> getOrdeListForClient(Long clientNo) {
        List<NewOrder> orderList = new ArrayList<NewOrder>();
        List<BraAccount> braAccounts = new ArrayList<BraAccount>(clientFileDao.find(clientNo).getAccount());
        for (BraAccount braAccount : braAccounts) orderList.addAll(braAccount.getOrders());
        return orderList;
    }

    @Override
    public void procesNewOrders(NewOrder onMarket, NewOrder newOrder) {
        if (onMarket.getAmount() == 0) newOrderDAO.delete(onMarket.getId());
        else newOrderDAO.update(onMarket);
        if (newOrder.getAmount() == 0) newOrderDAO.delete(newOrder.getId());
        else newOrderDAO.update(newOrder);
    }
}
