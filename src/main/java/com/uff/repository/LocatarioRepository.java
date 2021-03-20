package com.uff.repository;

import com.uff.entity.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

    List<Locatario> findLocatarioById (Long id);
}
