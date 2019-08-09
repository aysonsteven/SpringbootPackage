package web.tech.blog.service;

import web.tech.blog.dto.TokenDto;

import web.tech.blog.model.TblTokens;

public interface TokenService {
	String inserTokens(TokenDto token, int uid);

	TblTokens findTokenByName(String token);
	
	String deleteTokenByTokenName(String token);
	
	
}
