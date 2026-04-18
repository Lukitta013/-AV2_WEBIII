package com.autobots.automanager.model.entity;

import com.autobots.automanager.model.entity.Documento;
import com.autobots.automanager.model.entity.Endereco;
import com.autobots.automanager.model.entity.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@Column
	private String nomeSocial;

	@Column(nullable = false)
	@NotNull(message = "Data de nascimento é obrigatória")
	private Date dataNascimento;

	@Column
	private Date dataCadastro;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Documento> documentos = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<>();
}