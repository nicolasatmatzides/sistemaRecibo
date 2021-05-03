package com.uff.module;

import com.uff.entity.Imovel;
import com.uff.entity.Recibos;
import com.uff.repository.ReciboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecibosModule {

    private final ReciboRepository reciboRepository;

    public List<Recibos> listarRecibos(){
        try{
            reciboRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
        }
        return reciboRepository.findAll();
    }
}
