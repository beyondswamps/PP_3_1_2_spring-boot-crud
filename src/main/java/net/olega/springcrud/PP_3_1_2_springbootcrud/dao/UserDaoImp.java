package net.olega.springcrud.PP_3_1_2_springbootcrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.olega.springcrud.PP_3_1_2_springbootcrud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    final private EntityManager entityManager;

    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager
                .persist(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return entityManager
                .find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager
                .merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        entityManager
                .createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
