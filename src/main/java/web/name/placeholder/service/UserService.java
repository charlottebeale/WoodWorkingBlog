package web.name.placeholder.service;

import web.name.placeholder.models.User;
import web.name.placeholder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    @Autowired
    private UserRepository repository;

    public User addUser(User user){
        return repository.save(user);
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public User updateUser(String username, User user){
        User ogUser = findByUsername(username);
        if(user.getFirstName() != null)
            ogUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            ogUser.setLastName(user.getLastName());
        if(user.getPassword() != null)
            ogUser.setPassword(user.getPassword());
        if(user.getEmailAddress() != null)
            ogUser.setEmailAddress(user.getEmailAddress());

        return repository.save(user);
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public Boolean deleteByUsername(String username){
        Iterable<User> list = findAll();
        for(User user : list)
            if(user.getUsername().equals(username)) {
                repository.delete(user);
                return true;
            }
        return false;
    }

}
