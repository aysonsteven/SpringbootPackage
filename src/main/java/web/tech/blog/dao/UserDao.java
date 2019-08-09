package web.tech.blog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.tech.blog.model.TblUser;

@Repository
public interface UserDao extends CrudRepository<TblUser, Integer> {

    TblUser findByUsername(String username);
    
    TblUser findById( int id );
}
