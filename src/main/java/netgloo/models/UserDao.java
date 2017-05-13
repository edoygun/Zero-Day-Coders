package netgloo.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
  
  @Autowired
  private SessionFactory _sessionFactory;

  //private EntityManager em;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  @Transactional
  public void save(Product product) {
    getSession().save(product);
    return;
  }
  
  public void delete(Product product) {
    getSession().delete(product);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Product> getAll() {
    return getSession().createQuery("from Product").list();
  }
  
  /*public User getByEmail(String email) {
    return (Product) getSession().createQuery(
        "from Product where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }*/

  public User getById(long id) {
    return (User) getSession().load(User.class, id);
  }

  public void update(Product product) {
    getSession().update(product);
    return;
  }

} // class UserDao
