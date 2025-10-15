package com.mearimsistemas.vagas_api.services;

import com.mearimsistemas.vagas_api.exceptions.UsernameExisteException;
import com.mearimsistemas.vagas_api.models.CandidatoEntity;
import com.mearimsistemas.vagas_api.repositorys.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public CandidatoEntity salvarCandidato(CandidatoEntity candidatoEntity){

        // chamando a validação de campo unico username e email
        this.candidatoRepository.findByUsernameOrEmail(candidatoEntity.getUsername(), candidatoEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UsernameExisteException();
                });

        return  this.candidatoRepository.save(candidatoEntity);
    }

    public List<CandidatoEntity> listaCandidatos(){
        return this.candidatoRepository.findAll();
    }

    public Optional<CandidatoEntity> buscarPorUuid(UUID uuid){
        return this.candidatoRepository.findById(uuid);
    }

}
