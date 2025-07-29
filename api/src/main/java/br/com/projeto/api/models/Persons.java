package br.com.projeto.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Responsável pela criação da tabela.
@Table(name = "people") // Altera o nome da tabela, para diferenciar da classe, o qual é o padrão.
public class Persons {
    
    //Atributos
    @Id // Responsável pela criação da chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Responsável por gerar valores crescentes a partir do número 1.
    private int code;
    private String name;
    private int age;
    
    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
