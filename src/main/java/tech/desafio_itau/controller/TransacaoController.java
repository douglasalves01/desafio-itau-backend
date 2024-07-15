package tech.desafio_itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.desafio_itau.entities.Transacao;
import tech.desafio_itau.service.TransacaoService;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    OffsetDateTime dataHoraAtual=OffsetDateTime.now();
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping()
    public ResponseEntity<String> adicionar(@RequestBody Transacao transacao){
        try{
            if(transacao.getValor().compareTo(BigDecimal.ZERO)<0 || transacao.getDataHora().isAfter(dataHoraAtual))
                return ResponseEntity.unprocessableEntity().body("transação não aceita");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        transacaoService.adicionar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping()
    public ResponseEntity<String> deletar(){
        transacaoService.deletar();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Transacao>> retornar(){
        List<Transacao> transacoes= transacaoService.getTransacoes();
        return ResponseEntity.ok().body(transacoes);
    }

}
