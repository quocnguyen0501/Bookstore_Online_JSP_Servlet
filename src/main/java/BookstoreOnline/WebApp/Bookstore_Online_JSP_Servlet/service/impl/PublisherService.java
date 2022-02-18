package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.PublishersDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.PublishersModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IPublisherService;

import java.util.List;

public class PublisherService implements IPublisherService {
    private final PublishersDAO publishersDAO;

    private static PublisherService instance;

    private PublisherService () {
        publishersDAO = PublishersDAO.getInstance();
    }

    public static PublisherService getInstance() {
        if (instance == null) {
            instance = new PublisherService();
        }
        return instance;
    }

    @Override
    public void insert(PublishersModel publishersModel) {
        publishersDAO.insert(publishersModel);
    }

    @Override
    public void delete(int id) {
        publishersDAO.delete(id);
    }

    @Override
    public void update(PublishersModel publishersModel) {
        publishersDAO.update(publishersModel);
    }

    @Override
    public List<PublishersModel> selectByAll(PublishersModel publishersModel) {
        return publishersDAO.selectByAll(publishersModel);
    }

    @Override
    public PublishersModel selectById(int id) {
        return publishersDAO.selectById(id);
    }

    @Override
    public List<PublishersModel> selectByName(String name) {
        return publishersDAO.selectByName(name);
    }

    @Override
    public List<PublishersModel> selectAll() {
        return publishersDAO.selectAll();
    }
}
