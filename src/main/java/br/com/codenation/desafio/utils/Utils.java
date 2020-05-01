package br.com.codenation.desafio.utils;

import java.time.LocalDate;

public class Utils {

    public int idade(LocalDate birthDate){
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();
        if(today.getDayOfYear() < birthDate.getDayOfYear()) age--;
        return age;
    }
}
