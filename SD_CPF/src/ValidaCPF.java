import java.util.InputMismatchException;

public class ValidaCPF {
	
	public static boolean validarCPF (String CPF) {
		if (CPF.length() != 11) {
			return (false);
			
		}
		char digito10, digito11;
		int soma, i, resultado, num, peso;
		try {
// Calculo do primeiro digito verificador.
			soma = 0;
			peso = 10;
// transforma o i-esimo caractere do CPF em um número.
			for (i = 0; i < 9 ; i ++) {
				num = (int)(CPF.charAt(i) - 48);
				soma = soma + (num * peso);
				peso -= 1;
			}
			
			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11)) {
				digito10 = '0';
			}else digito10 = (char)(resultado + 48);
// Calculo do segundo digito verificador.
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i ++) {
				num = (int)(CPF.charAt(i) - 48);
				soma = soma + (num * peso);
				peso -= 1;
			}
			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11)) {
				digito11 = '0';
			}else digito11 = (char)(resultado + 48);
			
			if ((digito10 == CPF.charAt(9)) && (digito11 == CPF.charAt(10))) {
				return (true);
			} else return false;
		} catch (InputMismatchException e) {
			return (false);
			// TODO: handle exception
		}
	}
}
