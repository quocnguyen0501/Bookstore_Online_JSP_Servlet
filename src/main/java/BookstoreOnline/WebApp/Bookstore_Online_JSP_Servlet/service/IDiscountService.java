package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.DiscountsModel;

import java.util.List;

public interface IDiscountService {
    public void insert (DiscountsModel discountsModel);
    public void delete (int id);
    public void update (DiscountsModel discountsModel);

    public List<DiscountsModel> selectByAll (DiscountsModel discountsModel);
    public DiscountsModel selectById (int id);
    public List<DiscountsModel> selectByName (String name);
    public List<DiscountsModel> selectByValue (Double value);
    public List<DiscountsModel> selectAll ();
}
