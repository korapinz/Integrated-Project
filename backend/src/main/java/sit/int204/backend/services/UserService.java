package sit.int204.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.backend.dtos.UserDTO;
import sit.int204.backend.entities.Category;
import sit.int204.backend.entities.User;
import sit.int204.backend.exception.ResourceNotFoundException;
import sit.int204.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    //Get All Users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    //Get 1 User
    public User getUserById(int id){
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User Id" + id + "DOES NOT EXIST !!!"));
    }

    //Create User
public User createUser(UserDTO userDTO){
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setRole(userDTO.getRole());

            Instant now = Instant.now();
        newUser.setCreatedOn(now);
        newUser.setUpdatedOn(now);

        return repository.saveAndFlush(newUser);
    }

    //Update User


    // Delete User
    public User deleteUser(int id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException(id + " DOES NOT EXIST !!!"));
        repository.delete(user);
        return user;
    }

}
