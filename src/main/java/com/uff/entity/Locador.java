package com.uff.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Locador {

        public Locador(Long id, String nome, String cpf) {
                this.cpf = cpf;
                this.nome = nome;
                this.Id = id;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;

        @NonNull
        private String nome;

        @NonNull
        private String cpf;

}
