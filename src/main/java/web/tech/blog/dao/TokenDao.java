package web.tech.blog.dao;

import org.springframework.data.repository.CrudRepository;

import web.tech.blog.model.TblTokens;

public interface TokenDao extends CrudRepository<TblTokens, Integer>{

//	TokenDto findByTokenName(@Param("tokenName") String tokenName);
	TblTokens findByToken(String tokenName);
}
