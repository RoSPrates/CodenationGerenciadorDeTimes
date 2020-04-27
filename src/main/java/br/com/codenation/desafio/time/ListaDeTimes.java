package br.com.codenation.desafio.time;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTimes {
    private List<Time> times;

    public List<Time> getTimes() {
        return times;
    }

    public ListaDeTimes() {
        times = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void verificaIdTimeExistente(Long id) {
        if (times.size() < 1) return;

        for (Time t : times) {
            if (t.getId().equals(id)) throw new IdentificadorUtilizadoException("Identificador do time já utilizado!");
        }
    }

    public void verificarSeTimeNaoExiste(Long id){
        if(times.size() > 0){
            for(Time t : times){
                if (t.getId().equals(id)) return;
            }
        }
        throw new TimeNaoEncontradoException();
    }

    public Time retornaTimePorId(Long id){
        if(times.size() > 0){
            for(Time t : times){
                if (t.getId().equals(id)) return t;
            }
        }
        throw new TimeNaoEncontradoException();
    }

}
