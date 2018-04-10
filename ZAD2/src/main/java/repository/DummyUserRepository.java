package repository;

import domain
        .User;

import java.util.ArrayList;
import java.util.List;

public class DummyUserRepository implements UserRepositoryInterface {

    private static List<User> db = new ArrayList<User>();

    @Override
    public User getUserByEmail(String email) {
        for(User regiestration:db){
            if(regiestration.getEmail().equalsIgnoreCase(email))
                return regiestration;
        }
        return null;
    }

    public List<User> getAll(){
        return db;
    }


    @Override
    public void add(User regiestration) {
    db.add(regiestration);
    }
    @Override
    public int count() {
        return db.size();
    }


}
