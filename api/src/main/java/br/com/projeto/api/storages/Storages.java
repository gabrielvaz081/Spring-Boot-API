package br.com.projeto.api.storages;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.models.Persons;

@Repository
public interface Storages extends CrudRepository<Persons, Integer> {
    
    List<Persons> findAll();

    Persons findByCode(int code); // O findBy seguido do atributo do modelo retorna informações com base em uma característica. Nesse caso, com
                                // base no código. Como não possuem códigos duplicados, não será no formato de lista.
    List<Persons> findByName(String name);

    List<Persons> findByAge(int age);

    List<Persons> findByOrderByCode();

    List<Persons> findByOrderByName(); //Por padrão a ordenação segue o formato Asc, ou seja, em ordem crescente. No caso de ordenar em ordem decresente
                                      // utilizar Desc após o nome do atributo no método.
    List<Persons> findByOrderByAge();

    List<Persons> findByOrderByCodeDesc();

    List<Persons> findByOrderByNameDesc();

    List<Persons> findByOrderByAgeDesc();

    List<Persons> findByCodeOrderByName(int code);

    List<Persons> findByCodeOrderByAge(int code);

    List<Persons> findByNameOrderByCode(String name);

    List<Persons> findByNameOrderByAge(String name);

    List<Persons> findByAgeOrderByCode(int age);

    List<Persons> findByAgeOrderByName(int age);

    List<Persons> findByCodeOrderByNameDesc(int code);

    List<Persons> findByCodeOrderByAgeDesc(int code);

    List<Persons> findByNameOrderByCodeDesc(String name);

    List<Persons> findByNameOrderByAgeDesc(String name);

    List<Persons> findByAgeOrderByCodeDesc(int age);

    List<Persons> findByAgeOrderByNameDesc(int age);

    List<Persons> findByNameContaining(String term);

    List<Persons> findByNameStartsWith(String term);

    List<Persons> findByNameEndsWith(String term);

    @Query(value = "SELECT SUM(age) FROM people", nativeQuery = true) // Utilizado para comandos SQL.
    int sumAge();

    @Query(value = "SELECT AVG(age) FROM people", nativeQuery = true)
    int avgAge();

    @Query(value = "SELECT MAX(age) FROM people", nativeQuery = true)
    int maxAge();

    @Query(value = "SELECT MIN(age) FROM people", nativeQuery = true)
    int minAge();

    @Query(value = "SELECT * FROM people WHERE age >= :age", nativeQuery = true) // Utiliza-se os dois pontos mais o nome do atributo para referenciar o parâmetro.
    List<Persons> isAgeGreaterOrEqual(int age);

    @Query(value = "SELECT * FROM people WHERE age < :age", nativeQuery = true)
    List<Persons> isAgeLessThan(int age);

    int countByCode(int code); // Retorna a quantidade de registros de acordo com o código.

    int countByName(String name);

    int countByAge(int name);

}
