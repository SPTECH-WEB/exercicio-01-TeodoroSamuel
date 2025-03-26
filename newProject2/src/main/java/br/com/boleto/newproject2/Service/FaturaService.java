package br.com.boleto.newproject2.Service;

import br.com.boleto.newproject2.Model.Fatura;
import br.com.boleto.newproject2.Repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FaturaService {
    @Autowired
    private FaturaRepository faturaRepository;

    public Fatura CreateFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> getFaturas() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> getFatura(Long id) {
        return faturaRepository.findById(id);
    }

    public Optional<Fatura> deleteFatura(Long id) {
        faturaRepository.deleteById(id);
        return null;
    }

    public Fatura updateFatura(Long Id,Fatura fatura) {
        Fatura Procuration = faturaRepository.findById(Id).get();

        if (Procuration != null) {
            Procuration.setValor(fatura.getValor());
            Procuration.setDataPagamento(fatura.getDataPagamento());
            Procuration.setEmailContato(fatura.getEmailContato());
            Procuration.setNomeTitular(fatura.getNomeTitular());
            Procuration.setNumeroCartao(fatura.getNumeroCartao());

            return faturaRepository.save(Procuration);
        }

        return null;
    }
}
