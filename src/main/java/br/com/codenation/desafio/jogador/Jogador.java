package br.com.codenation.desafio.jogador;

import br.com.codenation.desafio.time.ListaDeTimes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Jogador {

    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        setNivelHabilidade(nivelHabilidade);
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if(nivelHabilidade > 100 || nivelHabilidade < 0) throw new IllegalArgumentException();
        this.nivelHabilidade = nivelHabilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id) &&
                Objects.equals(idTime, jogador.idTime) &&
                Objects.equals(nome, jogador.nome) &&
                Objects.equals(dataNascimento, jogador.dataNascimento) &&
                Objects.equals(nivelHabilidade, jogador.nivelHabilidade) &&
                Objects.equals(salario, jogador.salario);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
    }
}
