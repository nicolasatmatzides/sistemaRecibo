package com.uff.module;


import com.uff.entity.Imovel;

import com.uff.entity.Locador;
import com.uff.entity.Locatario;
import com.uff.entity.Recibos;
import com.uff.repository.ImovelRepository;


import com.uff.repository.LocadorRepository;
import com.uff.repository.LocatarioRepository;
import com.uff.repository.ReciboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@RequiredArgsConstructor
public class ImovelModule {
    private final ImovelRepository imovelRepository;
    private final LocadorRepository locadorRepository;
    private final LocatarioRepository locatarioRepository;
    private final ReciboRepository reciboRepository;

    public  Imovel adicionarImovel(String endereco,
                                        String complemento, String cidade,
                                        String Estado, String cep, int valorCondominio,
                                        int valorImposto, String nomeLocador,
                                        String cpfLocador,String nomeLocatario,
                                        String email,int valorAluguel,String telefone){

        Imovel imovelAdicionado = new Imovel();
        Imovel imovel = new Imovel();
        Locador novoLocador = new Locador();
        Locatario novoLocatario = new Locatario();
        Date inicioDeContrato = new Date();
        inicioDeContrato.getTime();
        Recibos recibos = new Recibos();
        try{
            /**setando locador*/
            novoLocador.setNome(nomeLocador);
            novoLocador.setCpf(cpfLocador);
            locadorRepository.save(novoLocador);
            /**setando locatário*/
            novoLocatario.setEmail(email);
            novoLocatario.setName(nomeLocatario);
            novoLocatario.setInicioContrato(inicioDeContrato);
            novoLocatario.setFimContrato(inicioDeContrato);
            novoLocatario.setTelefone(telefone);
            locatarioRepository.save(novoLocatario);
            /**setandoImovel*/
            imovel.setEndereco(endereco);
            imovel.setComplemento(complemento);
            imovel.setCidade(cidade);
            imovel.setEstado(Estado);
            imovel.setCep(cep);
            imovel.setValorCondominio(valorCondominio);
            imovel.setValorImpostos(valorImposto);
            imovel.setLocador(novoLocador);
            imovel.setLocatario(novoLocatario);
            imovel.setValorAluguel(valorAluguel);
           imovelAdicionado = imovelRepository.save(imovel);
           /**gerando recibos*/
            recibos.setImovel(imovel);
            reciboRepository.save(recibos);
        }catch (Exception e){
            System.out.println("Error ao adicionar Imovel"+ e);
        }
        return imovelAdicionado;
    }

    public List<Imovel> ListarImovel(){
        try{
            imovelRepository.findAll();

        }catch (Exception e){
          System.out.println(e);
        }
        return imovelRepository.findAll();
    }

}
