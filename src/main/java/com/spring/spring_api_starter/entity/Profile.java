package com.spring.spring_api_starter.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name="profiles")
public class Profile {
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="boi")
	private String boi;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="loyalty_points")
	private Integer loyaltyPoints;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	@MapsId
	private User user;
	
}
