package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        updatedUser.setId(id);
        em.merge(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
