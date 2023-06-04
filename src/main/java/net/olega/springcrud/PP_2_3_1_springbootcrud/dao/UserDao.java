package net.olega.springcrud.PP_2_3_1_springbootcrud.dao;


import net.olega.springcrud.PP_2_3_1_springbootcrud.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
