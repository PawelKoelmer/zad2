package repository.repo;

import domain.User;

import java.util.List;

public interface UserRepository extends Repository<User> {

        List<User> withSurname(String surname, PagingInfo page);
        List<User> withName(String name, PagingInfo page);

}
