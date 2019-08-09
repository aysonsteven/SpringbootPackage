package web.tech.blog.service;

import web.tech.blog.dto.UserDto;
import web.tech.blog.model.TblUser;

import java.util.List;

public interface UserService {

    TblUser save(UserDto user);
    List<TblUser> findAll();
    void delete(int id);

    TblUser findOne(String username);

    TblUser findById(int id);

    UserDto update(UserDto userDto);
}
