package com.educando.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	/*One-to-one	Qualquer um dos lados pode ser o dono, mas apenas um deles deve realmente ser o dono. Se isso não for especificado teremos uma dependência circular.
	One-to-many	O lado "many" da associação deve ser tornado como o dono da associação.
	Many-to-one	Este é como o de cima, porém visualizado sob uma perspectiva oposta, mas a mesma regra se aplica - o lado “many” é o dono da associação.
	Many-to-many	Qualquer um dos lados pode ser o dono da associação.*/
	
	@JsonIgnore
	@OneToMany(mappedBy = "client") // mappedBy para dizer que este lado não é o dominante...  O LADO MANY SE TORNA SEMPRE O DOMINANTE 
	private List<Order> Orders = new ArrayList<>();  //associação da relação de cliente com pedido 1 cliente pode ter muitos pedidos 
	
	public User(Long id, String name, String email, String phone, String password) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return Orders;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ "]";
	}

	
	
	

}
