package com.amm.task.repositories;

import com.amm.task.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    List<Modulo> findByDescSistema(String descSistema);

}
