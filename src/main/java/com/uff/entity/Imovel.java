package com.uff.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Imovel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private String endereco;

    @NonNull private String complemento;

    @NonNull private String cidade;

    @NonNull private String estado;

    @NonNull private String cep;

    @ManyToOne
    private Locador locador;

    @ManyToOne
    private Locatario locatario;

    @NonNull
    private int valorCondominio;

    @NonNull
    private int valorImpostos;


}
