package com.mearimsistemas.vagas_api.controllers;

import com.mearimsistemas.vagas_api.exceptions.UsernameExisteException;
import com.mearimsistemas.vagas_api.models.CandidatoEntity;
import com.mearimsistemas.vagas_api.repositorys.CandidatoRepository;
import com.mearimsistemas.vagas_api.services.CandidatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping("/create")
    public CandidatoEntity create(@Valid  @RequestBody CandidatoEntity candidatoEntity){
        return this.candidatoService.salvarCandidato(candidatoEntity);
    }
    @GetMapping("/all")
    public List<CandidatoEntity> all(){
        return this.candidatoService.listaCandidatos();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CandidatoEntity> buscarCandidato(@PathVariable UUID uuid){
        return candidatoService.buscarPorUuid(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
