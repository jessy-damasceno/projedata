package application;

import entities.Funcionario;
import enums.funcao;
import java.util.ArrayList;
import java.util.List;

public class Principal {
  public static void main(String[] args) {
    List<Funcionario> funcionarios = new ArrayList<>();

    funcionarios.add(new Funcionario("Maria", 2000, 10, 18, 2009.44, funcao.OPERADOR.toString()));
    funcionarios.add(new Funcionario("João", 1990, 5, 12, 2284.38, funcao.OPERADOR.toString()));
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

    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }
  }
}
