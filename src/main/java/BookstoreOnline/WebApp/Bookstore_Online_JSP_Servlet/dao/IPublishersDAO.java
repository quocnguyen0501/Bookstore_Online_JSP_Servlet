package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.PublishersModel;

import java.util.List;

public interface IPublishersDAO extends IBaseDAO{
    public void insert (PublishersModel publishersModel);
    public void delete (int id);
    public void update (PublishersModel publishersModel);

    public List<PublishersModel> selectByAll (PublishersModel publishersModel);
    public PublishersModel selectById (int id);
    public List<PublishersModel> selectByName (String name);
    public List<PublishersModel> selectAll ();
}
