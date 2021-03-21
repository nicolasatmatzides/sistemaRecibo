package com.uff.api;

import com.uff.entity.Imovel;
import com.uff.module.ImovelModule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Validated
@RequiredArgsConstructor
public class ReciboApiController {
    private final ImovelModule imovelModule;

    /**Metodo que adiciona um Imovel*/
    @ResponseBody
    @RequestMapping(value = "/adicionaImovel", method = RequestMethod.POST, produces = "application/json",params = {"endereco","complemento","cidade",
            "estado","cep","valorCondominio","valorImpostos","nomeLocador","cpfLocador","nomeLocatario","email","valorAluguel"})
    public ResponseEntity adicionarImovel(@RequestParam("endereco") String endereco, @RequestParam("complemento") String complemento,
                                       @RequestParam("cidade") String cidade, @RequestParam("estado")String estado, @RequestParam("cep")String cep,
                                       @RequestParam("valorCondominio")int valorCondominio, @RequestParam("valorImpostos")int valorImpostos,
                                       @RequestParam("nomeLocador")String nomeLocador,@RequestParam("cpfLocador")String cpfLocador,
                                       @RequestParam("nomeLocatario") String nomeLocatario,@RequestParam("email")String email,@RequestParam("valorAluguel")int valorAluguel,
                                       @RequestParam("telefone")String telefone   ){

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.adicionarImovel(endereco,complemento,cidade,estado,cep,
                valorCondominio,valorImpostos,nomeLocador,cpfLocador,nomeLocatario,email,valorAluguel,telefone));
    }

    /**Retorna todos os imovéis*/
    @ResponseBody
    @RequestMapping(value = "/listarImovel", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listarImovel(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.ListarImovel());
    }

}
