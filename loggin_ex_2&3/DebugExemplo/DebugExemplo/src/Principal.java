import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Principal {

    public static void main(String[] args) throws Exception {

        Logger meuLogger = Logger.getLogger("MeuLogger");
        FileHandler fileHandler = new FileHandler("ArquivosLogger/Logtext.txt", true);
        fileHandler.setFormatter(new SimpleFormatter());
        meuLogger.addHandler(fileHandler);
        meuLogger.setLevel(Level.ALL);

        try {
        	meuLogger.log(Level.INFO, "\n O programa iniciou a chamada da Calculadora!!");

        } catch (Exception e) {
            meuLogger.log(Level.SEVERE, "Erro ao iniciar a calculadora!:", e);
            e.printStackTrace();

        }

        

        try (Scanner leitura = new Scanner(System.in)) {
            Calculadora c = new Calculadora();
            float a = 0, b = 0, resultado = 0;
            String operador;
            System.out.println("Calculadora");
            do {
                System.out.println("Insira o operador +, -, *, /");
                operador = leitura.nextLine();
            } while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
                    || operador.contains("/")));

            System.out.println("Insira o 1o valor");
            a = leitura.nextFloat();
            System.out.println("Insira o 2o valor");
            b = leitura.nextFloat();

            resultado = c.calcular(a, b, operador.charAt(0));

            if (a < b && operador.contains("-")) {
                meuLogger.log(Level.INFO, "\n A ordem dos números foi alterada! O usuário inseriu o primeiro número menor que o segundo. ");

                resultado = c.calcular(a, b, operador.charAt(0));
                System.out.println(
                        "Ops, parece que houve um engano! O segundo número que você informou é menor que o primeiro.");
                System.out.println("Vamos trocar a ordem e realizar o cálculo para você!");
                System.out.printf("O resultado de " + b + " " + operador + " " + a + ": %.2f", resultado);
                System.out.printf("\n");
            } else {
                System.out.printf("O resultado de " + a + " " + operador + " " + b + ": %.2f", resultado);
                System.out.printf("\n");
            }

            if (a <= 0 || b <= 0 && operador.contains("/") || operador.contains("/")) {
                meuLogger.warning("Tentativa de divisão utilizando o número 0!");
                System.out.println("Ops, algo deu errado!");
                System.out.println(
                        "Por favor, tente novamente informando números maiores que zero para realizar a divisão");
                do {
                    System.out.println("Insira o 1o valor novamente");
                    a = leitura.nextFloat();
                    System.out.println("Insira o 2o valor novamente");
                    b = leitura.nextFloat();

                    if (a > 0 && b > 0) {
                        resultado = c.calcular(a, b, operador.charAt(0));

                        System.out.printf("O resultado de " + a + " " + operador + " " + b + ": %.2f", resultado);
                        System.out.printf("\n");

                    } else {
                        System.out.println("Por favor, informe números maiores que zero.");
                    }

                } while
 (b <= 0);
			}

		}
        meuLogger.log(Level.INFO, "\n O cálculo foi realizado com sucesso!.");
	}

}
