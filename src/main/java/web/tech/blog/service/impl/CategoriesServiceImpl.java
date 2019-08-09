package web.tech.blog.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import web.tech.blog.dao.CategoriesDao;
import web.tech.blog.dao.UserDao;
import web.tech.blog.model.TblCategories;
import web.tech.blog.model.TblUser;
import web.tech.blog.service.CategoriesService;

@Primary
@Service(value="categoriesService")
public class CategoriesServiceImpl implements UserDetailsService, CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private UserDao userDao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TblUser user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	@Override
	public List<TblCategories> findAllCategories() {
		List<TblCategories> categoryList = new ArrayList<TblCategories>();
		categoriesDao.findAll().iterator().forEachRemaining(categoryList::add);
		return categoryList;
	}

	@Override
	public TblCategories findCategoryById( Integer id ) {
		// TODO Auto-generated method stub
		return categoriesDao.fineOne(id);
//		return new TblCategories();
	}




	
}
