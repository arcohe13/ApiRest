package com.systarco.pup.controllers;

import java.util.List;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.systarco.pup.entities.TransTarifaComis;
import com.systarco.pup.services.CodTransService;


@CrossOrigin(origins="http://10.0.9.11:4200")
@RestController
@RequestMapping("/transaccion")
public class TransTarifaComisController {
	@Autowired
	CodTransService codtransservice;
	
	@GetMapping()
	public List<TransTarifaComis> findAll(){
		return codtransservice.findAll();
	}
	
	
	@RequestMapping(value="/pag", method=RequestMethod.GET)	
	public ResponseEntity<Page<TransTarifaComis>> paginas
	(
			
			@RequestParam (defaultValue = "${page}") int page,
			@RequestParam (defaultValue = "${size}") int size,
			@RequestParam (defaultValue = "${order}") String order,
			@RequestParam (defaultValue = "${asc}") boolean asc
			
	){
		
		Page<TransTarifaComis> tarifas =  codtransservice.findAll(
				PageRequest.of(page, size, Sort.by(order)));
		System.out.println("page:"+ page + "size:"+ size+"order:"+"order:"+order+"asc:"+asc );
		if (!asc)
			tarifas = codtransservice.findAll (
					PageRequest.of(page, size, Sort.by(order).descending()));
					
		return new ResponseEntity<Page<TransTarifaComis>>(tarifas, HttpStatus.OK);
	
	}
				
			
	@PostMapping()
	public TransTarifaComis add(@RequestBody TransTarifaComis codtrans) {
		return this.codtransservice.add(codtrans);
	}
	
	@PutMapping()
	public TransTarifaComis editar(@RequestBody TransTarifaComis codtrans) {
		 return this.codtransservice.editar(codtrans);
		
	}
	// ejemplo1
	// ejemplo2
	// ejemplo3
	// ejemplo4
	// ejemplo5
	// ejemplo7
	// ejemplo8
	// ejemplo9
	// ejemplo10
	// ejemplo11
	// ejemplo12
	// ejemplo13
	// ejemplo14
	// ejemplo16
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.codtransservice.delete(id);
		
	}
	
	@GetMapping(path={"/{id}"})
	public Optional<TransTarifaComis> findId(@PathVariable("id")  Long id ) {
		return this.codtransservice.findById(id);
		
	}
	

	
}
