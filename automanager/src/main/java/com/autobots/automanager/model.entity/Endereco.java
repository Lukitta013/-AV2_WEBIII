package com.autobots.automanager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Endereco {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String estado;
	@Column(nullable = false)
	@NotBlank(message = "Cidade é obrigatória")
	private String cidade;
	@Column(nullable = true)
	private String bairro;
	@Column(nullable = false)
	@NotBlank(message = "Rua é obrigatória")
	private String rua;
	@Column(nullable = false)
	@NotBlank(message = "Número é obrigatório")
	private String numero;
	@Column(nullable = true)
	private String codigoPostal;
	@Column(unique = false, nullable = true)
	private String informacoesAdicionais;

}