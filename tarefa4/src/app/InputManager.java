package app;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.println(mensagem + " (" + min + " - " + max + "): ");
            String input = null;
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um numero entre " + min + " e " + max + ".");
                    continue;
                }
            
                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("Fora do intervalo. Digite um numero entre " + min + " e " + max + ".");
                    continue;
                }
            
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }
    }

    public static String lerString(String mensagem){
        while (true) {
            System.out.println(mensagem);
            String input = null;
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite algo");
                    continue;
                }

                return input;
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }
    }

    public static boolean lerSimNao(String mensagem){
        while (true) {
            System.out.print(mensagem+" (s/n): ");
            char input;
            try {
                input = scanner.nextLine().charAt(0);

                if(input == 's' || input == 'S') return true;

                if(input == 'n' || input == 'N') return false;

            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }
    }

    public static void esperarEnter(String mensagem){
        System.out.println(mensagem);
        scanner.nextLine();
    }

    public static void fecharScanner(){
        scanner.close();
    }

}