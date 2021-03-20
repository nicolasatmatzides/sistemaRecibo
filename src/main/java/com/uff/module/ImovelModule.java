package com.uff.module;


import com.uff.entity.Imovel;

import com.uff.repository.ImovelRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImovelModule {
   private final ImovelRepository imovelRepository;


    public  Imovel adicionarImovel(String endereco,
                                        String complemento, String cidade,
                                        String Estado, String cep,
                                        int valorCondominio,
                                        int valorImposto){

        Imovel imovelAdicionado = new Imovel();
        Imovel imovel = new Imovel();

        try{
            imovel.setEndereco(endereco);
            imovel.setComplemento(complemento);
            imovel.setCidade(cidade);
            imovel.setEstado(Estado);
            imovel.setCep(cep);
            imovel.setValorCondominio(valorCondominio);
            imovel.setValorImpostos(valorImposto);
           imovelAdicionado = imovelRepository.save(imovel);
        }catch (Exception e){
            System.out.println("Error ao adicionar Imovel"+ e);
        }
        return imovelAdicionado;
    }
}
