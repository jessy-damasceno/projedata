package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
  protected String nome;
  protected LocalDate dataNascimento;

  private static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");

  public Pessoa() {}

  public Pessoa(String nome, LocalDate dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public int getAge() {
    return Period.between(dataNascimento, LocalDate.now()).getYears();
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  @Override
  public String toString() {
    return "Nome: " + nome + ", Data de nascimento: " + dataNascimento.format(formatters);
  }
}
