/*
3- Você deverá criar um programa Java que receberá um número inteiro e desenhará um triângulo
    retângulo começando pela base utilizando asteriscos. Por exemplo:

  Se o usuário informar o número 9, o seguinte triângulo deverá ser desenhado pela aplicação:
      *
     ***
    *****
   *******
  *********
 */

import java.util.Scanner;

public class Questao3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite um número inteiro: ");
    int quantidade = scanner.nextInt();

    if(quantidade <= 0)
      return;

    // sempre aumentando a quantidade total em 1 para que o triângulo tenha uma base
    if(quantidade % 2 == 0)
      quantidade++;

    int asteriscos = 1;
    while (asteriscos <= quantidade) {

      int espacos = quantidade - asteriscos;

      for (int i = 1; i <= espacos/2; i++) {
        System.out.print(" ");
      }

      for (int i = 1; i <= asteriscos; i++) {
        System.out.print("*");
      }

      for (int i = 1; i <= espacos/2; i++) {
        System.out.print(" ");
      }

      System.out.println();
      asteriscos += 2;
    }

    // ajustando asteriscos para o topo do triângulo
    asteriscos -= 2;

    while (asteriscos >= 1) {

      int espacos = quantidade - asteriscos;

      for (int i = 1; i <= espacos/2; i++) {
        System.out.print(" ");
      }

      for (int i = 1; i <= asteriscos; i++) {
        System.out.print("*");
      }

      for (int i = 1; i <= espacos/2; i++) {
        System.out.print(" ");
      }

      System.out.println();
      asteriscos -= 2;
    }

    scanner.close();
  }

}
