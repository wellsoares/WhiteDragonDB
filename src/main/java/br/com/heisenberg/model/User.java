package br.com.heisenberg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author well
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "id", sequenceName = "seq_users", allocationSize = 1)
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String cpf;
    private String password;
    private String email;
    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "User{" + "id= " + id + ", name= " + name + '}';
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
