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
import java.util.Optional;


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
        List<Imovel> imovelList = new ArrayList<>();
        try{
             imovelList = imovelRepository.findAll();

        }catch (Exception e){
          e.printStackTrace();
        }
        return imovelList;
    }

    public Imovel alteraImovelPorId(Long id, String endereco,
                                            String complemento, String cidade,
                                            String Estado, String cep, int valorCondominio,
                                            int valorImposto, String nomeLocador,
                                            String cpfLocador,String nomeLocatario,
                                            String email,int valorAluguel,String telefone){
        Imovel imovelAlterado = new Imovel();
        Optional<Imovel> imovelParaAlterar = imovelRepository.findById(id);
        Optional<Locador> locadorParaAlterar = locadorRepository.findById(id);
        Optional<Locatario> locatarioParaAlterar = locatarioRepository.findById(id);
        Imovel imovel = new Imovel();
        Locador alteraLocador = new Locador();
        Locatario alteraLocatario = new Locatario();
        Date inicioDeContrato = new Date();
        inicioDeContrato.getTime();
        Recibos recibos = new Recibos();
        try{
            if(imovelParaAlterar.isPresent()){
                alteraLocador = locadorParaAlterar.get();
                /**setando locador*/
                alteraLocador.setNome(nomeLocador);
                alteraLocador.setCpf(cpfLocador);
                locadorRepository.saveAndFlush(alteraLocador);
                /**setando locatário*/
                alteraLocatario = locatarioParaAlterar.get();
                alteraLocatario.setEmail(email);
                alteraLocatario.setName(nomeLocatario);
                alteraLocatario.setInicioContrato(inicioDeContrato);
                alteraLocatario.setFimContrato(inicioDeContrato);
                alteraLocatario.setTelefone(telefone);
                locatarioRepository.saveAndFlush(alteraLocatario);
                /**setandoImovel*/
                imovel = imovelParaAlterar.get();
                imovel.setEndereco(endereco);
                imovel.setComplemento(complemento);
                imovel.setCidade(cidade);
                imovel.setEstado(Estado);
                imovel.setCep(cep);
                imovel.setValorCondominio(valorCondominio);
                imovel.setValorImpostos(valorImposto);
                imovel.setLocador(alteraLocador);
                imovel.setLocatario(alteraLocatario);
                imovel.setValorAluguel(valorAluguel);
                imovelAlterado = imovelRepository.saveAndFlush(imovel);
                /**gerando recibos*/
                recibos.setImovel(imovel);
                reciboRepository.save(recibos);

            }
        }catch (Exception e){
            System.out.println("Error ao adicionar Imovel"+ e);
        }
        return imovelAlterado;
    }

    public String deletaImovelporId(Long id){
        String deleta = null;
        Optional<Imovel> imovelParaDeletar = imovelRepository.findById(id);
        Optional<Locador> locadorParaDeletar = locadorRepository.findById(id);
        Optional<Locatario> locatarioParaDeletar = locatarioRepository.findById(id);
        Optional<Recibos> recibosParaDeletar = reciboRepository.findById(id);
        Imovel imovel;
        Locador locador;
        Locatario locatario;
        Recibos recibos;
        try{
            if (imovelParaDeletar.isPresent()){
                imovel = imovelParaDeletar.get();
                recibos = recibosParaDeletar.get();
                reciboRepository.delete(recibos);
                imovelRepository.delete(imovel);
                deleta = "Imovel foi deletado";
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return deleta;
    }
}
