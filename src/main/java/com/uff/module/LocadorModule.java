package com.uff.module;

import com.uff.entity.Locador;
import com.uff.repository.LocadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocadorModule {
    private final LocadorRepository locadorRepository;

    public List<Locador> listaLocador(){
        try{
            locadorRepository.findAll();

        }catch (Exception e){
            System.out.println(e);
        }
        return locadorRepository.findAll();
    }

}
