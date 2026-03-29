package com.autobots.automanager.repository;

import com.autobots.automanager.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepositorio extends JpaRepository<Telefone, Long> {
    
}
