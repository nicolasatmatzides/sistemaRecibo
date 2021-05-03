package com.uff.module;

import com.uff.entity.Imovel;
import com.uff.entity.Locatario;
import com.uff.repository.ImovelRepository;
import com.uff.repository.LocatarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocatarioModule {
    private  final LocatarioRepository locatarioRepository;

    public List<Locatario> listarLocatarios(){
        List<Locatario> locatarioList = new ArrayList<>();
        try{
            locatarioList = locatarioRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();

        }
        return locatarioList;
    }
}
