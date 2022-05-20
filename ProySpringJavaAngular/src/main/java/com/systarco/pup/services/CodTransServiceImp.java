package com.systarco.pup.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.systarco.pup.entities.TransTarifaComis;
import com.systarco.pup.repositories.CodTransRepository;

@Service
public class CodTransServiceImp implements CodTransService {
	
	@Autowired
	CodTransRepository codtransrepository;
	
	@Override
	public List<TransTarifaComis> findAll() {
	return this.codtransrepository.findAll();
   }
	
	
	@Override
	public TransTarifaComis add(TransTarifaComis codtrans) {
		return codtransrepository.save(codtrans);
	}

	
	@Override
	public void delete(long id) {
		this.codtransrepository.deleteById(id);
		
	}
	
	

	@Override
	public TransTarifaComis editar(TransTarifaComis codtrans) {
		Optional<TransTarifaComis> transaccion = codtransrepository.findById(codtrans.getIdtrans());
		if (transaccion.isPresent()) {
			TransTarifaComis  transaccionEncontrada = transaccion.get();
			transaccionEncontrada.setIdtrans(codtrans.getIdtrans());
			transaccionEncontrada.setCodtrans(codtrans.getCodtrans());
			transaccionEncontrada.setDescritrans(codtrans.getDescritrans());
			transaccionEncontrada.setFchcrea(codtrans.getFchcrea());
			transaccionEncontrada.setCodcarnetrespb(codtrans.getCodcarnetrespb());
			return this.codtransrepository.save(transaccionEncontrada);
		}
		 return null;
	}

	public Optional<TransTarifaComis> findById(long id) {
		return this.codtransrepository.findById(id);
	}


	
	@Override
	public Page<TransTarifaComis> findAll(Pageable pageable) {
		return codtransrepository.findAll(pageable);
		
	}


}
