package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
@Getter
@Setter
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;

    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")//Para guardar mais caracteres na base de dados
    private String text;

    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}