
public class Calculadora {
	public float calcular(float a, float b, char operacao) {
		float resultado = 0;
		float maior=0,menor=0;
		
		if(a>b) {
			maior=a;
		}else {
			maior=b;
			menor=a;
		}
		
		switch (operacao) {
		case '+': {
			resultado = a + b;
			break;
		}
		case '-': {
			resultado = maior - menor;
			break;
		}
		case '/': {
			resultado = a / b;
			break;
		}
		case '*': {
			resultado = a * b;
			break;

		}

		}
		return resultado;

	}
}
