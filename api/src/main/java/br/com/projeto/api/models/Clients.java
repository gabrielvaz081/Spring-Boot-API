package br.com.projeto.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "clients")
public class Clients {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @NotEmpty(message = "Enter a name") // Não pode haver falta de informação (campos/requisições vazias).
    private String name;

    @Email(message = "Please provide a valid email") // Valida se a informação passada é um e-mail válido.
    private String email;

    // Annotations para validar dados através de JPA

    // @NotNull:	Não pode haver informação nula (null)
    // @NotEmpty:	Não pode haver falta de informação (campos/requisições vazias)
    // @NotBlank:	É obrigatória haver pelo menos um caractere
    // @Min and @Max:	Quantidade mínima e máxima para um número ou quantidade de caracteres
    // @Pattern:	Criação de expressões regulares
    // @Email:	Valida se a informação passada é um e-mail válido
    // @Valid:	Utilizado para validar as requisições em uma rota, essa annotation fica no arquivo de controle

    // Get e Set
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

}
