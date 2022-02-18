package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.DiscountDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.DiscountsModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IDiscountService;

import java.util.List;

public class DiscountService implements IDiscountService {
    private final DiscountDAO discountDAO;

    private static DiscountService instance;

    private DiscountService () {
        discountDAO = DiscountDAO.getInstance();
    }

    public static DiscountService getInstance() {
        if (instance == null) {
            instance = new DiscountService();
        }
        return instance;
    }

    @Override
    public void insert(DiscountsModel discountsModel) {
        discountDAO.insert(discountsModel);
    }

    @Override
    public void delete(int id) {
        discountDAO.delete(id);
    }

    @Override
    public void update(DiscountsModel discountsModel) {
        discountDAO.update(discountsModel);
    }

    @Override
    public List<DiscountsModel> selectByAll(DiscountsModel discountsModel) {
        return discountDAO.selectByAll(discountsModel);
    }

    @Override
    public DiscountsModel selectById(int id) {
        return discountDAO.selectById(id);
    }

    @Override
    public List<DiscountsModel> selectByName(String name) {
        return discountDAO.selectByName(name);
    }

    @Override
    public List<DiscountsModel> selectByValue(Double value) {
        return discountDAO.selectByValue(value);
    }

    @Override
    public List<DiscountsModel> selectAll() {
        return discountDAO.selectAll();
    }
}
