package com.autobots.automanager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Telefone {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 3)
	@NotBlank(message = "DDD é obrigatório")
	@Size(min = 2, max = 3, message = "DDD deve ter 2 ou 3 dígitos")
	private String ddd;
	@Column
	private String numero;
}