package com.systarco.pup.services;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.systarco.pup.entities.TransTarifaComis;
public interface CodTransService {
	List<TransTarifaComis> findAll();
	Optional<TransTarifaComis> findById(long id);
	TransTarifaComis add(TransTarifaComis codtrans);
	TransTarifaComis editar(TransTarifaComis codtrans);
	void delete(long id);
    Page<TransTarifaComis> findAll(Pageable pageable);
	

}
