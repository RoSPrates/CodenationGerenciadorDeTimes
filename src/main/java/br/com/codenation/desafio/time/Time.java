package br.com.codenation.desafio.time;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.jogador.Jogador;

import java.time.LocalDate;
import java.util.Objects;

public class Time {

    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Jogador capitao;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.setId(id);
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getId() {
        return id;
    }

    public Jogador getCapitao() {
        if (capitao == null) throw new CapitaoNaoInformadoException();
            return capitao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    private String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void definirCapitao(Jogador jogador) {
        capitao = jogador;
    }

    public void setId(Long id) {
        id.toString();
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id) &&
                Objects.equals(nome, time.nome) &&
                Objects.equals(dataCriacao, time.dataCriacao) &&
                Objects.equals(corUniformePrincipal, time.corUniformePrincipal) &&
                Objects.equals(corUniformeSecundario, time.corUniformeSecundario) &&
                Objects.equals(capitao, time.capitao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario, capitao);
    }

    public String retornaUniformeJogoForaDeCasa(Time timeDeCasa){
        if(timeDeCasa.getCorUniformePrincipal().equalsIgnoreCase(this.corUniformePrincipal))
            return this.corUniformeSecundario;
        return this.corUniformePrincipal;
    }
}
