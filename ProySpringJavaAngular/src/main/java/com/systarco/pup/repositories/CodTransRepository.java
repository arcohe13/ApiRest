package com.systarco.pup.repositories;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.systarco.pup.entities.TransTarifaComis;

@Repository
@Transactional
public interface CodTransRepository extends JpaRepository<TransTarifaComis, Long> {


}
