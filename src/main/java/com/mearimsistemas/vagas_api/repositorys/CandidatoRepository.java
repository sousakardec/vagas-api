package com.mearimsistemas.vagas_api.repositorys;

import com.mearimsistemas.vagas_api.models.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {

    // validando para que os campos username e email sejam unicos no bd
     Optional<CandidatoEntity> findByUsernameOrEmail(String username, String email);

    // findByUsernameOrEmail ou findByUsernameAndEmail
    // os campos devem ser igual esta no model
    // o JPA vai montar esse metodo com essas restrições

    //Entidade Optinal<CandidatoEntity> sinaliza que pode ser retornado
    //CandidatoEntity ou outro valor
}
