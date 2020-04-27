package br.com.codenation.desafio.jogador;


import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.utils.Utils;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaJogadores {
    private List<Jogador> jogadores;

    public ListaJogadores() {
        jogadores = new ArrayList<>();
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void verificaIdJogadorExistente(Long id) {
        if (jogadores.size() < 1) return;

        for (Jogador j : jogadores) {
            if (j.getId().equals(id))
                throw new IdentificadorUtilizadoException("Identificador do Jogador já utilizado!");
        }
    }

    public Jogador retornaJogadorPorId(Long id) {
        if (jogadores.size() > 0) {
            for (Jogador j : jogadores) {
                if (j.getId().equals(id)) return j;
            }
        }
        throw new JogadorNaoEncontradoException();
    }

    public Jogador retornaMelhorJogadorDoTime(List<Jogador> time) {
        Jogador melhor = time.get(0);
        for (Jogador j : time) {
            if (melhor.getNivelHabilidade() < j.getNivelHabilidade()) melhor = j;
        }
        return melhor;
    }

    public List<Jogador> retornaTodosJogadoresDoTime(Long idTime) {
        List<Jogador> jogadoresDoTime = new ArrayList<>();
        for (Jogador j : this.jogadores)
            if (j.getIdTime().equals(idTime))
                jogadoresDoTime.add(j);

        return jogadoresDoTime;
    }

    public Jogador retornaJogadorMaiorSalarioDoTime(List<Jogador> time) {
        Jogador maisCaro = time.get(0);
        for (Jogador j : time) {
            if (maisCaro.getSalario().compareTo(j.getSalario()) < 0) {
                maisCaro = j;
            } else if (maisCaro.getSalario().compareTo(j.getSalario()) == 0) {
                if (maisCaro.getId() > j.getId()) maisCaro = j;
            }
        }
        return maisCaro;
    }

    public Jogador retornaJogadorMaisVelhoDoTime(List<Jogador> time) {
        Jogador maisVelho = time.get(0);
        Utils utils = new Utils();
        for (Jogador j : time) {
            if (utils.idade(j.getDataNascimento()) > utils.idade(maisVelho.getDataNascimento())) {
                maisVelho = j;
            } else if (utils.idade(j.getDataNascimento()) == utils.idade(maisVelho.getDataNascimento())) {
                if (j.getId() < maisVelho.getId()) maisVelho = j;
            }
        }
        return maisVelho;
    }

    public List<Jogador> retornaListaDeMelhoresJogadores(int tamanho) {
        List<Jogador> melhoresJogadores = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            if(retornaMelhorJogador(melhoresJogadores) == null) return null;
            melhoresJogadores.add(retornaMelhorJogador(melhoresJogadores));
        }
        return melhoresJogadores;
    }

    public Jogador retornaMelhorJogador(List<Jogador> inclusos) {
        Jogador melhor = new Jogador(7l, 10l, "Allejo", LocalDate.of(1964, 2, 16), 0, new BigDecimal("99999999999999"));
        if (jogadores.isEmpty())
            return null;
        if (inclusos.isEmpty()) {
            for (Jogador j : jogadores) {
                if (j.getNivelHabilidade() > melhor.getNivelHabilidade() || (j.getNivelHabilidade().equals(melhor.getNivelHabilidade()) && j.getId() < melhor.getId()))
                    melhor = j;
            }
        } else {
            for (Jogador j : jogadores){
                if(!inclusos.contains(j)){
                    if(j.getNivelHabilidade() > melhor.getNivelHabilidade() || (j.getNivelHabilidade().equals(melhor.getNivelHabilidade()) && j.getId() < melhor.getId()))
                        melhor = j;
                }
            }
        }
        return melhor;
    }

}
