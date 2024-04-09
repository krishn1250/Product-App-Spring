package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_id;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(unique = true,nullable = false)
	private String password;
	private String FullName;
	

	
	
}
