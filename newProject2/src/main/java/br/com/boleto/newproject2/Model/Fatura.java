package br.com.boleto.newproject2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O numero do Cartão não pode estar em Branco")
    @Pattern(regexp = "\\d{16}")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em Branco")
    @Size(min = 3, max = 100, message = "O nome do titular deve estar entre 3 a 5 caracteres")
    private String nomeTitular;

    @NotNull(message = "O Valor não pode ser Nulo")
    @DecimalMin(value = "10.00", message = "O Valor minimo da fatura deve ser de R$10.00")
    @DecimalMax(value = "5000.00", message = "O Valor maximo da fatura é até 5000,00")
    private Double valor;

    @NotNull(message = "A data de Pagamento não pode ser Nula")
    @FutureOrPresent(message = "Insira uma data de pagamento Válida")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Insira um Email Valido")
    private String emailContato;

    public Long getId() {
        return id;
    }

    public  String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
