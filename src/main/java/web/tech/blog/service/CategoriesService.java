package web.tech.blog.service;

import java.util.List;

import web.tech.blog.model.TblCategories;

public interface CategoriesService {
	List<TblCategories> findAllCategories();
	
	TblCategories findCategoryById( Integer id );
}
