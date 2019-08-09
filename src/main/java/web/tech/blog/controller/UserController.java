package web.tech.blog.controller;

import web.tech.blog.dto.ApiResponse;
import web.tech.blog.dto.UserDto;
import web.tech.blog.model.TblTokens;
import web.tech.blog.model.TblUser;
import web.tech.blog.service.TokenService;
import web.tech.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import web.tech.blog.config.JwtTokenUtil;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired 
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ApiResponse<TblUser> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping("/getall")
    public ApiResponse<List<TblUser>> listUser(@RequestHeader(value="Authorization") String token){
    	System.out.println("token-> " + token);
    	System.out.println("user from token " + jwtTokenUtil.getUsernameFromToken(token.replaceAll("Bearer", "")));
//    	Boolean tokenValidate = tokenService.findTokenByName(token.replaceAll("Bearer ", ""));
    	TblTokens tokenObject = tokenService.findTokenByName(token.replaceFirst("Bearer ", ""));
    	if(tokenObject == null || tokenObject.getToken() =="") {
    		return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "Not Allowed", new ArrayList<>());
    	}
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/getuser/{id}")
    public ApiResponse<TblUser> getOne(@PathVariable int id, @RequestHeader(value="Authorization") String token){
    	TblTokens tokenObject = tokenService.findTokenByName(token.replaceFirst("Bearer ", ""));
    	if(tokenObject == null || tokenObject.getToken() =="") {
    		return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "Not Allowed", new ArrayList<>());
    	}else if( userService.findById(id) == null ) {
    		return new ApiResponse<>(HttpStatus.OK.value(), "Empty result",userService.findById(id));
    	}
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/updateuser/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto, @RequestHeader(value="Authorization") String token) {
    	TblTokens tokenObject = tokenService.findTokenByName(token.replaceFirst("Bearer ", ""));
    	if(tokenObject == null || tokenObject.getToken() =="") {
    		return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "Not Allowed", new ArrayList<>());
    	}
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable int id, @RequestHeader(value="Authorization") String token) {
    	TblTokens tokenObject = tokenService.findTokenByName(token.replaceFirst("Bearer ", ""));
    	if(tokenObject == null || tokenObject.getToken() =="") {
    		return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "Not Allowed", new ArrayList<>());
    	}
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
