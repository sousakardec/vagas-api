package com.mearimsistemas.vagas_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.UUID;


// @Data é uma notação do lombok cria dinamicamente
// os getts e setts da classe
@Data
@Entity(name = "cadidatos")
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
public class CandidatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  uuid;
    private String nome;

    // valida por expressão não permitindo espaço no username
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "O campo [Username] não permite espaço")
    private String username;

    // valida campo email e tamanho
    @Email(message = "O campo deve conter um email valido")
    @Length(min = 10, max = 150)
    private String email;

    @Length(min = 6, max = 150)
    private String password;
    private String descricao;
    private String curriculum;

    @CreatedDate
    @Column(nullable = false, updatable = false) // 'updatable = false' ensures it's set only on creation
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = true, updatable = true) // 'updatable = false' ensures it's set only on creation
    private LocalDateTime updatedAt;


}
