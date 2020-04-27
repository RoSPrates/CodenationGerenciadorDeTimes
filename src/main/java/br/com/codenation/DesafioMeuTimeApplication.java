package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.codenation.desafio.app.*;
import br.com.codenation.desafio.jogador.Jogador;
import br.com.codenation.desafio.jogador.ListaJogadores;
import br.com.codenation.desafio.time.ListaDeTimes;
import br.com.codenation.desafio.time.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private ListaDeTimes listaDeTimes = new ListaDeTimes();
    private ListaJogadores listaJogadores = new ListaJogadores();

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        listaDeTimes.verificaIdTimeExistente(id);
        listaDeTimes.adicionarTime(new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario));
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        listaDeTimes.verificarSeTimeNaoExiste(idTime);
        listaJogadores.verificaIdJogadorExistente(id);
        listaJogadores.adicionarJogador(new Jogador(id,idTime,nome,dataNascimento,nivelHabilidade,salario));
    }

    public void definirCapitao(Long idJogador) {
        listaDeTimes.retornaTimePorId(listaJogadores.retornaJogadorPorId(idJogador).getIdTime()).definirCapitao(listaJogadores.retornaJogadorPorId(idJogador));
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        return listaDeTimes.retornaTimePorId(idTime).getCapitao().getId();
    }

    public String buscarNomeJogador(Long idJogador) {
        return listaJogadores.retornaJogadorPorId(idJogador).getNome();
    }

    public String buscarNomeTime(Long idTime) {
        return listaDeTimes.retornaTimePorId(idTime).getNome();
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        listaDeTimes.verificarSeTimeNaoExiste(idTime);
        List<Long> jogadores = new ArrayList<>();
        for(Jogador j : this.listaJogadores.getJogadores()){
            if(j.getIdTime().equals(idTime))
                jogadores.add(j.getId());
        }
        jogadores.sort(null);
        return jogadores;
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        listaDeTimes.verificarSeTimeNaoExiste(idTime);
        return listaJogadores.retornaMelhorJogadorDoTime(listaJogadores.retornaTodosJogadoresDoTime(idTime)).getId();
    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        listaDeTimes.verificarSeTimeNaoExiste(idTime);
        return listaJogadores.retornaJogadorMaisVelhoDoTime(listaJogadores.retornaTodosJogadoresDoTime(idTime)).getId();
    }

    public List<Long> buscarTimes() {
        List<Long> listaTimes = new ArrayList<>();
        if(this.listaDeTimes.getTimes().size() > 0){
            for(Time t : this.listaDeTimes.getTimes()){
                listaTimes.add(t.getId());
            }
        }
        listaTimes.sort(null);
        return listaTimes;
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        listaDeTimes.verificarSeTimeNaoExiste(idTime);
        return listaJogadores.retornaJogadorMaiorSalarioDoTime(listaJogadores.retornaTodosJogadoresDoTime(idTime)).getId();
    }


    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return listaJogadores.retornaJogadorPorId(idJogador).getSalario();
    }

    public List<Long> buscarTopJogadores(Integer top) {
        List<Long> topJogadores = new ArrayList<>();
        List<Jogador> melhoresJogadores = listaJogadores.retornaListaDeMelhoresJogadores(top);
        if(melhoresJogadores == null) return topJogadores;
        for(Jogador j : melhoresJogadores){
            topJogadores.add(j.getId());
        }
        return topJogadores;
    }

    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
       return listaDeTimes.retornaTimePorId(timeDeFora).retornaUniformeJogoForaDeCasa(listaDeTimes.retornaTimePorId(timeDaCasa));
    }

}
