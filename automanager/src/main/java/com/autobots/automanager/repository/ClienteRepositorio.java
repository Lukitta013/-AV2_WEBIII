package com.autobots.automanager.repository;

import com.autobots.automanager.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.model.entity.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}