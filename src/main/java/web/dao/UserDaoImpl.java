package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        final var user1 = em.find(User.class, user.getId());
        user1.setName(user.getName());
        user1.setAge(user.getAge());
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }
}
