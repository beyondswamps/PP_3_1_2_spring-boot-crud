package net.olega.springcrud.PP_3_1_2_springbootcrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import net.olega.springcrud.PP_3_1_2_springbootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//    @PersistenceContext
    final private EntityManagerFactory entityManagerFactory;

    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManagerFactory
                .createEntityManager()
                .persist(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return entityManagerFactory
                .createEntityManager()
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return entityManagerFactory
                .createEntityManager()
                .find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManagerFactory
                .createEntityManager()
                .merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        entityManagerFactory
                .createEntityManager()
                .createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
