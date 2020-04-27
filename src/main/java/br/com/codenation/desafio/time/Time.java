package br.com.codenation.desafio.time;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.jogador.Jogador;

import java.time.LocalDate;

public class Time {

    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Jogador capitao;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
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


    public String retornaUniformeJogoForaDeCasa(Time timeDeCasa){
        if(timeDeCasa.getCorUniformePrincipal().equalsIgnoreCase(this.corUniformePrincipal))
            return this.corUniformeSecundario;
        return this.corUniformePrincipal;
    }
}
