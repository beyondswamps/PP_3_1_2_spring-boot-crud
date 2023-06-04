package net.olega.springcrud.PP_2_3_1_springbootcrud.service;


import net.olega.springcrud.PP_2_3_1_springbootcrud.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
