package com.uff.api;

import com.uff.entity.Locador;
import com.uff.module.ImovelModule;
import com.uff.module.LocadorModule;
import com.uff.module.LocatarioModule;
import com.uff.module.RecibosModule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Validated
@RequiredArgsConstructor
public class ReciboApiController {
    private final ImovelModule imovelModule;
    private final RecibosModule recibosModule;
    private final LocatarioModule locatarioModule;
    private final LocadorModule locadorModule;

    @RequestMapping(value = "/")
    public ModelAndView home () {
        return new ModelAndView("cadastro");
    }

    @RequestMapping(value = "/cadastro")
    public ModelAndView cadastro () {
        return new ModelAndView("cadastro");
    }

    @RequestMapping(value = "/lista_locador")
    public ModelAndView listalocador () {
        return new ModelAndView("lista_locador");
    }

    @RequestMapping(value = "/lista_imovel")
    public ModelAndView listaImovel () {
        return new ModelAndView("lista_imovel");
    }

    @RequestMapping(value = "/lista_locatario")
    public ModelAndView listaLocatario () {
        return new ModelAndView("lista_locatario");
    }

    @RequestMapping(value = "/lista_recibo")
    public ModelAndView listaRecibo () {
        return new ModelAndView("lista_recibo");
    }


    /**Metodo que adiciona um Imovel*/
    @ResponseBody
    @RequestMapping(value = "/adicionaImovel", method = RequestMethod.POST, produces = "application/json",params = {"endereco","complemento","cidade",
            "estado","cep","valorCondominio","valorImpostos","nomeLocador","cpfLocador","nomeLocatario","email","valorAluguel","telefone"})
    public ResponseEntity adicionarImovel(@RequestParam("endereco") String endereco, @RequestParam("complemento") String complemento,
                                       @RequestParam("cidade") String cidade, @RequestParam("estado")String estado, @RequestParam("cep")String cep,
                                       @RequestParam("valorCondominio")int valorCondominio, @RequestParam("valorImpostos")int valorImpostos,
                                       @RequestParam("nomeLocador")String nomeLocador,@RequestParam("cpfLocador")String cpfLocador,
                                       @RequestParam("nomeLocatario") String nomeLocatario,@RequestParam("email")String email,@RequestParam("valorAluguel")int valorAluguel,
                                       @RequestParam("telefone")String telefone   ){

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.adicionarImovel(endereco,complemento,cidade,estado,cep,
                valorCondominio,valorImpostos,nomeLocador,cpfLocador,nomeLocatario,email,valorAluguel,telefone));
    }

    /**Metodo que altera um Imovel*/
    @ResponseBody
    @RequestMapping(value = "/alteraImovel", method = RequestMethod.PUT, produces = "application/json",params = {"id","endereco","complemento","cidade",
            "estado","cep","valorCondominio","valorImpostos","nomeLocador","cpfLocador","nomeLocatario","email","valorAluguel","telefone"})
    public ResponseEntity alteraImovel(@RequestParam("id") Long id, @RequestParam("endereco") String endereco, @RequestParam("complemento") String complemento,
                                          @RequestParam("cidade") String cidade, @RequestParam("estado")String estado, @RequestParam("cep")String cep,
                                          @RequestParam("valorCondominio")int valorCondominio, @RequestParam("valorImpostos")int valorImpostos,
                                          @RequestParam("nomeLocador")String nomeLocador,@RequestParam("cpfLocador")String cpfLocador,
                                          @RequestParam("nomeLocatario") String nomeLocatario,@RequestParam("email")String email,@RequestParam("valorAluguel")int valorAluguel,
                                          @RequestParam("telefone")String telefone   ){

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.alteraImovelPorId(id,endereco,complemento,cidade,estado,cep,
                valorCondominio,valorImpostos,nomeLocador,cpfLocador,nomeLocatario,email,valorAluguel,telefone));
    }

    /**Retorna todos os imovéis*/
    @ResponseBody
    @RequestMapping(value = "/listarImovel", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listarImovel(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.ListarImovel());
    }

    /**Metodo delatar imovel por Id*/
    @ResponseBody
    @RequestMapping(value = "/deletaImovel", method = RequestMethod.DELETE, produces = "application/json", params = {"id"})
    public ResponseEntity deletaImovel(@RequestParam("id") Long id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(imovelModule.deletaImovelporId(id));
    }

    /**Retorna todos os locatários*/
    @ResponseBody
    @RequestMapping(value = "/listarLocatario", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listarLocatario(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(locatarioModule.listarLocatarios());
    }

    /**Retorna todos os locadores*/
    @ResponseBody
    @RequestMapping(value = "/listarLocador", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listarLocador(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(locadorModule.listaLocador());
    }

    /**Retorna todos os recibos*/
    @ResponseBody
    @RequestMapping(value = "/listarRecibos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listarRecibos(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(recibosModule.listarRecibos());
    }
}
