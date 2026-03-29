package com.autobots.automanager.repository;

import com.autobots.automanager.model.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {
    
}
