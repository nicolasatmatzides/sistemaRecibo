package com.uff.module;

import com.uff.entity.Imovel;
import com.uff.repository.ImovelRepository;

import java.util.ArrayList;
import java.util.List;

public class LocatarioModule {
    ImovelRepository imovelRepository;

    public List<Imovel> listarTodosImoveis(){
        List<Imovel> imovelList = new ArrayList<>();

        try{
            imovelList.add((Imovel) imovelRepository.findAll());
        }catch (Exception e){
            System.out.println("Error ao listar imoveis:"+ e);

        }
        return imovelList;
    }
}
