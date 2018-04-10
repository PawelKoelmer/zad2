package repository;

import domain.User;

import java.util.List;

public interface UserRepositoryInterface {

    User getUserByEmail(String email);
    List<User> getAll();
    void add(User regiestration);

    int count();
}
