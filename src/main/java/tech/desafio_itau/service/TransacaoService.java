package tech.desafio_itau.service;

import org.springframework.stereotype.Service;
import tech.desafio_itau.entities.Transacao;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private final List<Transacao> transacoes= new ArrayList<>();

    public void adicionar(Transacao transacao){
        transacoes.add(transacao);
    }
    public void deletar(){
        transacoes.clear();
    }

    public List<Transacao> getTransacoes(){
        return transacoes;
    }

}
