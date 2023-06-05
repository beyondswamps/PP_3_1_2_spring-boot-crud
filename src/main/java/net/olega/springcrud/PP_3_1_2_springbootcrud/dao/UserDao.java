package net.olega.springcrud.PP_3_1_2_springbootcrud.dao;

import net.olega.springcrud.PP_3_1_2_springbootcrud.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
