/*
2- Criar um programa para fazer conversões de temperaturas, o programa deve:

- pedir que o usuário digite uma temperatura para ser transformada.
- pedir que o usuário informe a unidade de origem da temperatura, podendo ser C para grau Celsius,
  K para Kelvin ou F para grau Fahrenheit. Caso a entrada não for uma das especificadas imprimir uma
  resposta para o usuário informando que a entrada especificada não é válida.
- pedir que o usuário informe a unidade de destino das temperaturas, podendo ser C para grau Celsius,
  K para Kelvin ou F para grau Fahrenheit. Caso a entrada não for uma das especificadas imprimir uma
  resposta para o usuário informando que a entrada especificada não é válida.
 */

import java.util.Scanner;

public class Questao2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Pergunta a temperatura
    System.out.println("Informe a temperatura: ");
    double temperatura = scanner.nextDouble();

    // Pergunta a unidade de origem
    System.out.println("Qual a unidade de origem dessa temperatura? [C, K, F]");
    scanner.nextLine();
    String unidadeOrigem = scanner.nextLine();

    // Pergunta a unidade de destino
    System.out.println("Qual a unidade de destino dessa temperatura? [C, K, F]");
    String unidadeDestino = scanner.nextLine();

    // Converte a temperatura
    double temperaturaConvertida = Questao2.converteTemperatura(temperatura, unidadeOrigem, unidadeDestino);

    // Imprime o resultado
    if (temperaturaConvertida == -1) {
      System.out.println("Unidade de origem ou destino inválida.");
    } else {
      System.out.printf("%.2f %s = %.2f %s", temperatura, unidadeOrigem, temperaturaConvertida, unidadeDestino);
    }

    scanner.close();
  }

  public static double converteTemperatura(double temperatura, String unidadeOrigem, String unidadeDestino) {
    switch (unidadeOrigem) {
      case "C" -> {
        if (unidadeDestino.equals("K")) {
          return Questao2.celciusParaKelvin(temperatura);
        } else if (unidadeDestino.equals("F")) {
          return Questao2.celciusParaFahrenheit(temperatura);
        } else {
          return -1;
        }
      }
      case "K" -> {
        if (unidadeDestino.equals("C")) {
          return Questao2.kelvinParaCelcius(temperatura);
        } else if (unidadeDestino.equals("F")) {
          return Questao2.kelvinParaFahrenheit(temperatura);
        } else {
          return -1;
        }
      }
      case "F" -> {
        if (unidadeDestino.equals("C")) {
          return Questao2.fahrenheitParaCelcius(temperatura);
        } else if (unidadeDestino.equals("K")) {
          return Questao2.fahrenheitParaKelvin(temperatura);
        } else {
          return -1;
        }
      }
      default -> {
        return -1;
      }
    }
  }

  public static double celciusParaFahrenheit(double temperatura) {
    return ((temperatura * 9 / 5) + 32);
  }

  public static double celciusParaKelvin(double temperatura) {
    return (temperatura + 273.15);
  }

  public static double fahrenheitParaCelcius(double temperatura) {
    return ((temperatura - 32) * 5 / 9);
  }

  public static double fahrenheitParaKelvin(double temperatura) {
    return ((temperatura - 32) * 5 / 9) + 273.15;
  }

  public static double kelvinParaCelcius(double temperatura) {
    return (temperatura - 273.15);
  }

  public static double kelvinParaFahrenheit(double temperatura) {
    return ((temperatura - 273.15) * 9 / 5) + 32;
  }



}
