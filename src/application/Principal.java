package application;

import entities.Funcionario;
import enums.funcao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
  public static void main(String[] args) {
    final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1212.00);
    // 3.1 Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
    List<Funcionario> funcionarios = new ArrayList<>();

    Funcionario maria = new Funcionario("Maria", 2000, 10, 18, 2009.44, funcao.OPERADOR.toString());
    Funcionario joao = new Funcionario("João", 1990, 5, 12, 2284.38, funcao.OPERADOR.toString());

    funcionarios.add(maria);
    funcionarios.add(joao);
    funcionarios.add(new Funcionario("Caio", 1961, 5, 2, 9836.14, funcao.COORDENADOR.toString()));
    funcionarios.add(new Funcionario("Miguel", 1988, 10, 14, 19119.88, funcao.DIRETOR.toString()));
    funcionarios
        .add(new Funcionario("Alice", 1995, 1, 5, 2234.68, funcao.RECEPCIONISTA.toString()));
    funcionarios.add(new Funcionario("Heitor", 1999, 11, 19, 1582.72, funcao.OPERADOR.toString()));
    funcionarios.add(new Funcionario("Arthur", 1993, 3, 31, 4071.84, funcao.CONTADOR.toString()));
    funcionarios.add(new Funcionario("Laura", 1994, 7, 8, 3017.45, funcao.GERENTE.toString()));
    funcionarios
        .add(new Funcionario("Heloísa", 2003, 5, 24, 1606.85, funcao.ELETRICISTA.toString()));
    funcionarios.add(new Funcionario("Helena", 1996, 9, 2, 2799.93, funcao.GERENTE.toString()));

    System.out.println(
        "3.1 Inserir todos os funcionários, na mesma ordem e informações da tabela acima.");
    System.out.println(funcionarios + "\n");
    /*
     * 3.2 Remover o funcionário “João” da lista. Poderia remover o funcionário através da instância
     * dele também (Overload método removeFuncionario)
     */
    removeFuncionario(funcionarios, "João");

    System.out.println();

    // 3.3 Imprimir todos os funcionários com todas suas informações
    imprimirTodosFuncionarios(funcionarios);
    System.out.println();

    // 3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários
    // com novo valor.
    System.out.println(
        "3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
    for (Funcionario funcionario : funcionarios) {
      funcionario.aumentarSalario();
      System.out.println(funcionario);
    }

    System.out.println();

    // 3.5 Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista
    // de funcionários”.


    Map<String, List<Funcionario>> funcionariosPorFuncao =
        funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

    System.out.println();

    // 3.6 – Imprimir os funcionários, agrupados por função.
    System.out.println("3.6 – Imprimir os funcionários, agrupados por função.");
    System.out.println(funcionariosPorFuncao.entrySet());

    System.out.println();

    // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
    System.out
        .println(
            funcionarios.stream()
                .filter(s -> s.getDataNascimento().getMonth().getValue() == 10
                    || s.getDataNascimento().getMonth().getValue() == 12)
                .collect(Collectors.toList()));

    System.out.println();

    // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
    System.out.println(
        "3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");

    Comparator<Funcionario> comparatorAsc =
        (func1, func2) -> func1.getDataNascimento().compareTo(func2.getDataNascimento());

    Collections.sort(funcionarios, comparatorAsc);

    Funcionario maisVelho = funcionarios.get(0);
    System.out
        .println("Nome: " + maisVelho.getNome() + ", Idade: " + maisVelho.getAge() + " anos.");

    System.out.println();

    // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
    List<Funcionario> listaOrdenadaFuncionarios =
        funcionarios.stream().sorted((arg0, arg1) -> arg0.getNome().compareTo(arg1.getNome()))
            .collect(Collectors.toList());

    System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética.");
    imprimirTodosFuncionarios(listaOrdenadaFuncionarios);

    System.out.println();

    // 3.11 – Imprimir o total dos salários dos funcionários.
    BigDecimal somaDosSalarios =
        funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println("3.11 – Imprimir o total dos salários dos funcionários.");
    System.out.println(Funcionario.formatSalario(somaDosSalarios) + "\n");

    // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário
    // mínimo é R$1212.00.
    System.out.println(
        "3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");

    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario.getNome() + " recebe "
          + funcionario.salariosMinimos(SALARIO_MINIMO) + " salário(s) mínimo(s).");
    }
  }


  // Remove o funcionário e retorna a nova lista atualizada (não quis alterar a lista atual)
  public static List<Funcionario> removeFuncionario(List<Funcionario> funcionarios,
      Funcionario funcionario) {
    List<Funcionario> novaLista = new ArrayList<>(funcionarios);
    novaLista.remove(funcionario);

    System.out.println("3.2 Remover o funcionário “João” da lista.");
    System.out.println(novaLista);

    return novaLista;
  }

  // Remove o funcionário pelo nome e retorna a nova lista atualizada (não quis alterar a lista
  // atual)
  public static List<Funcionario> removeFuncionario(List<Funcionario> funcionarios, String nome) {
    List<Funcionario> novaLista = new ArrayList<>(funcionarios);
    novaLista.removeIf(s -> s.getNome().equals(nome));

    System.out.println("3.2 Remover o funcionário “João” da lista.");
    System.out.println(novaLista);

    return novaLista;
  }

  public static void imprimirTodosFuncionarios(List<Funcionario> funcionarios) {
    System.out.println("3.3 Imprimir todos os funcionários com todas suas informações");
    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }
  }
}
