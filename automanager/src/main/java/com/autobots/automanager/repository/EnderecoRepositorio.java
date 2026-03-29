package com.autobots.automanager.repository;

import com.autobots.automanager.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
    
}
