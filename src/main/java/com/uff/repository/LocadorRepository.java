package com.uff.repository;

import com.uff.entity.Locador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LocadorRepository extends JpaRepository<Locador, Long> {
}
