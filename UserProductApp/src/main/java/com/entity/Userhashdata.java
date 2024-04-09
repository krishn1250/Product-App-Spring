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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Builder
public class Userhashdata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int HashCodeId;
	@Column(unique = true,nullable = false)
	private int  userhashcode;
	@Column(unique = true,nullable=false)
	private String HashCodeUsername;


}
