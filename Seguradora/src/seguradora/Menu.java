package seguradora;

import java.io.IOException;
import java.util.Scanner;
/**
* Menu para acesso as funções do programa.
*
* @author  Icaro
* @author Alexandre
* @author Thiago
* @version 1.0
*  
*/
public class Menu extends Cadastro {
	public static void main(String[] args) throws IOException {
		int esc = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("1-Cadastro de clientes\r\n" +  
				"2-Lista de clientes\r\n" + 
				"3-Lista de contratos\r\n" + 
				"0-Sair");
		int esc2 =0;
		int l = 0;
		while(l == 0) {
			System.out.println("Digite a opção:");
			esc = validarINT(input);
		switch(esc) {
		case 1:
			//Cadastro de clientes
			System.out.println("Pessoa Fisica?\nDigite 1 para sim e qualque outro numero para não.");
			esc2 = validarINT(input);
			if(esc2 == 1) {
				Cadastro.cadastrofisica();
			}
			else {
				Cadastro.cadastrojuridica();
			}
			break;
		case 2:
			//Lista de clientes
			Cadastro.listarclientes();
			break;
		case 3:
			//Lista de contratos
			Cadastro.listarcontratos();
			break;
		case 0:
			System.out.println("Saindo");
			l = 1;
			break;
		default: System.out.println("Invalido");
		
		}
		}
		input.close();
	}
private static int validarINT (Scanner input) {
    String userEntry = input.next();

    while (!isNumber(userEntry)) {
        System.out.print("Não é um numero, digite de novo: ");
        userEntry = input.next();
    }
    return Integer.parseInt(userEntry);
}
private static boolean isNumber(String input) {
    try {
       Integer.parseInt(input);
        return true;
    } catch (NumberFormatException nfe) {
        return false;
    }
}
}
