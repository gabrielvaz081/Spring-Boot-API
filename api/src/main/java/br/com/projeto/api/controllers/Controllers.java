package br.com.projeto.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Clients;
import br.com.projeto.api.models.Persons;
import br.com.projeto.api.services.Services;
import br.com.projeto.api.storages.Storages;
import jakarta.validation.Valid;


@RestController
public class Controllers {
    
    @Autowired // Responsável pela injeção de dependência.
    private Storages action;

    @Autowired
    private Services services;

    // Controladores para os serviços dos métodos do CRUD.
    
    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody Persons obj) {
        return services.register(obj);
    }

    @GetMapping("/api/select")
    public ResponseEntity<?> select() {
        return services.select();
    }

    @GetMapping("/api/selectByCode/{code}")
    public ResponseEntity<?> selectByCode(@PathVariable int code) {
        return services.selectByCode(code);
    }

    @GetMapping("/api/selectByName/{name}")
    public ResponseEntity<?> selectByName(@PathVariable String name) {
        return services.selectByName(name);
    }

    @GetMapping("/api/selectByAge/{age}")
    public ResponseEntity<?> selectByAge(@PathVariable int age) {
        return services.selectByAge(age);
    }

    // Outra forma para diferenciar as rotas:
    // @GetMapping("/api")
    // public List<Person> search(
    //         @RequestParam(required = false) Integer code,
    //         @RequestParam(required = false) String name,
    //         @RequestParam(required = false) Integer age) {
        
    //     if (code != null) {
    //         return List.of(action.findByCode(code));
    //     } else if (name != null) {
    //         return action.findByName(name);
    //     } else if (age != null) {
    //         return action.findByAge(age);
    //     }
    //     return List.of(); // ou lançar exceção, etc.
    // }

    @PutMapping("/api/edit")
    public ResponseEntity<?> edit(@RequestBody Persons obj) {
        return services.edit(obj);
    }

    // Com o método PutMapping é obrigatório passar todos os dados do objeto, ou seja, completo, para realizar alteração. (Atenção com o code)
    // O método save pode ser usado para cadastar um novo objeto ou para alterar os dados.

    @DeleteMapping("/api/remove/{code}")
    public ResponseEntity<?> remove(@PathVariable int code) {
        return services.remove(code);
    }

    @GetMapping("/api/counter")
    public long counter() {
        return action.count();
    }

    // Métodos de ordenação no formato crescente(Asc) e no formato decrescente(desc).

    @GetMapping("/api/sortCodeAsc")
    public List<Persons> sortCodeAsc() {
        return action.findByOrderByCode();
    }

    @GetMapping("/api/sortNameAsc")
    public List<Persons> sortNameAsc() {
        return action.findByOrderByName();
    }

    @GetMapping("/api/sortAgeAsc")
    public List<Persons> sortAgeAsc() {
        return action.findByOrderByAge();
    }

    @GetMapping("/api/sortCodeDesc")
    public List<Persons> sortCodeDesc() {
        return action.findByOrderByCodeDesc();
    }

    @GetMapping("/api/sortNameDesc")
    public List<Persons> sortNameDesc() {
        return action.findByOrderByNameDesc();
    }

    @GetMapping("/api/sortAgeDesc")
    public List<Persons> sortAgeDesc() {
        return action.findByOrderByAgeDesc();
    }

    @GetMapping("/api/sortCodeByNameAsc/{code}")
    public List<Persons> sortCodeByNameAsc(@PathVariable int code) {
        return action.findByCodeOrderByName(code);
    }

    @GetMapping("/api/sortCodeByAgeAsc/{code}")
    public List<Persons> sortCodeByAgeAsc(@PathVariable int code) {
        return action.findByCodeOrderByAge(code);
    }

    @GetMapping("/api/sortNameByCodeAsc/{name}")
    public List<Persons> sortNameByCodeAsc(@PathVariable String name) {
        return action.findByNameOrderByCode(name);
    }

    @GetMapping("/api/sortNameByAgeAsc/{name}")
    public List<Persons> sortNameByAgeAsc(@PathVariable String name) {
        return action.findByNameOrderByAge(name);
    }

    @GetMapping("/api/sortAgeByCodeAsc/{age}")
    public List<Persons> sortAgeByCodeAsc(@PathVariable int age) {
        return action.findByAgeOrderByCode(age);
    }

    @GetMapping("/api/sortAgeByNameAsc/{age}")
    public List<Persons> sortAgeByNameAsc(@PathVariable int age) {
        return action.findByAgeOrderByName(age);
    }

     @GetMapping("/api/sortCodeByNameDesc/{code}")
    public List<Persons> sortCodeByNameDesc(@PathVariable int code) {
        return action.findByCodeOrderByNameDesc(code);
    }

    @GetMapping("/api/sortCodeByAgeDesc/{code}")
    public List<Persons> sortCodeByAgeDesc(@PathVariable int code) {
        return action.findByCodeOrderByAgeDesc(code);
    }

    @GetMapping("/api/sortNameByCodeDesc/{name}")
    public List<Persons> sortNameByCodeDesc(@PathVariable String name) {
        return action.findByNameOrderByCodeDesc(name);
    }

    @GetMapping("/api/sortNameByAgeDesc/{name}")
    public List<Persons> sortNameByAgeDesc(@PathVariable String name) {
        return action.findByNameOrderByAgeDesc(name);
    }

    @GetMapping("/api/sortAgeByCodeDesc/{age}")
    public List<Persons> sortAgeByCodeDesc(@PathVariable int age) {
        return action.findByAgeOrderByCodeDesc(age);
    }

    @GetMapping("/api/sortAgeByNameDesc/{age}")
    public List<Persons> sortAgeByNameDesc(@PathVariable int age) {
        return action.findByAgeOrderByName(age);
    }

    // Métodos para verificação de contenção

    @GetMapping("/api/nameContains/{term}")
    public List<Persons> nameContains(@PathVariable String term) {
        return action.findByNameContaining(term);
    }

    @GetMapping("/api/startsWith/{term}")
    public List<Persons> startsWith(@PathVariable String term) {
        return action.findByNameStartsWith(term);
    }

    @GetMapping("/api/endsWith/{term}")
    public List<Persons> endsWith(@PathVariable String term) {
        return action.findByNameEndsWith(term);
    }

    // Métodos com funções agregadas em SQL

    @GetMapping("/api/sumAge")
    public int sumAge() {
        return action.sumAge();
    }
    
    @GetMapping("/api/avgAge")
    public int avgAge() {
        return action.avgAge();
    }

    @GetMapping("/api/maxAge")
    public int maxAge() {
        return action.maxAge();
    }

    @GetMapping("/api/minAge")
    public int minAge() {
        return action.minAge();
    }

    // Métodos com operadores de comparação em SQL

    @GetMapping("/api/isAgeGreaterOrEqual/{age}")
    public List<Persons> isAgeGreaterOrEqual(@PathVariable int age) {
        return action.isAgeGreaterOrEqual(age);
    }

    @GetMapping("/api/isAgeLessThan/{age}")
    public List<Persons> isAgeLessThan(@PathVariable int age) {
        return action.isAgeLessThan(age);
    }

    // Método para status da requisição.

    @GetMapping("/status") // Responsável por retornar o status de uma requisição.
    public ResponseEntity<?> status() { // O sinal de interrogação representa um ojeto implícito.
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Métodos com mensagem de boas vindas

    @GetMapping("/api/initialMessage")
    public String message() {
        return "Hello World ! ";
    }

    @GetMapping("/api/welcomeMessage") // É necessário criar uma rota sem passar informação pela URL para não gerar erro.
    public String welcomeMessage() {
        return "Seja bem vindo(a) ! ";
    }

    @GetMapping("/api/welcomeMessage/{nome}") // Utiliza uma informação da URL como variável.
    public String welcomeMessage(@PathVariable String nome) {
        return "Seja bem vindo(a)! " + nome;
    }

    @PostMapping("/person")
    public Persons person(@RequestBody Persons p) {
        return p;
    }

    @PostMapping("/api/client")
    public void client(@Valid @RequestBody Clients obj) { // Utilizado para validar as requisições em uma rota, essa annotation fica no arquivo de controle.

    }

}
