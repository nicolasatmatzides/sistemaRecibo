package com.uff.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String telefone;

    @ManyToOne
    private Imovel imovel;

    @NonNull
    private Date inicioContrato;

    @NonNull
    private Date fimContrato;

    @NonNull
    private int valorAluguel;


}
