package web.tech.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import web.tech.blog.model.TblTokens;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class TblUser {

    public List<TblTokens> getTokens() {
		return tokens;
	}

	public void setTokens(List<TblTokens> tokens) {
		this.tokens = tokens;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="uid")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private long salary;
    @Column
    private int age;


    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "uid", insertable = false, updatable = false)
    private  List<TblTokens> tokens;
    
    @Column(name="active")
    private Integer isActive;
    
    @Column(name="date_created")
    private Date dateCreated;

    public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}


	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
