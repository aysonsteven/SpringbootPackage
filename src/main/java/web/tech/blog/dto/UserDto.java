package web.tech.blog.dto;

import java.util.Date;
import java.util.List;

public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private long salary;
    private Integer isActive;
	private Date dateCreated;
	private Integer tokenId;
	private List<TokenDto> tokens;
	
	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public List<TokenDto> getTokens() {
		return tokens;
	}

	public void setTokens(List<TokenDto> tokens) {
		this.tokens = tokens;
	}

	public UserDto() {
		
	}
	
	
    public Integer getToken() {
		return tokenId;
	}

	public void setToken(Integer token) {
		this.tokenId = token;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
