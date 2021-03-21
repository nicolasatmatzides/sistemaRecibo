package com.uff.module;

import com.uff.entity.Locador;
import com.uff.repository.LocadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocadorModule {
    private final LocadorRepository locadorRepository;

    public Locador adicionaLocador(String nome, String cpf){
        Locador locador =  new Locador();
        Locador newLocador = new Locador();
        try{
            locador.setNome(nome);
            locador.setCpf(cpf);
            newLocador = locadorRepository.save(locador);
        }catch (Exception e){
        System.out.println("Não foi possivel adicionar o locador devido a:"+""+ e);
        }
        return newLocador;
    }
}
