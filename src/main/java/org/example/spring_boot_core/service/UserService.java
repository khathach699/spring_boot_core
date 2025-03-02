package org.example.spring_boot_core.service;

import org.example.spring_boot_core.dto.request.UserRequest;
import org.example.spring_boot_core.dto.request.UserUpdateRequest;
import org.example.spring_boot_core.entity.User;
import org.example.spring_boot_core.exception.AppException;
import org.example.spring_boot_core.exception.ErrorCode;
import org.example.spring_boot_core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createRequest(UserRequest request){
        if(userRepository.existsByName(request.getName())){
           throw  new AppException(ErrorCode.USER_EXISTED);
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User findUser(String id){
        return  userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    public User updateUser(String id,UserUpdateRequest request){
        User user = findUser(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
