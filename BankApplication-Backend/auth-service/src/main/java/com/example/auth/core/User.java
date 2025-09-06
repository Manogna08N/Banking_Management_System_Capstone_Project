package com.example.auth.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name = "users")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(unique = true, nullable = false)
	  private String email;
	 
	  private String password; // plain text (demo only)
	  private String role;     // "USER" or "ADMIN"

	  public User() {}
	  public User(String email, String password, String role) {
	    this.email=email; this.password=password; this.role=role;
	  }
	  public String getEmail() { return email; }
	  public String getPassword() { return password; }
	  public String getRole() { return role; }
	 

}
