package seguradora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
* Metodo para cadastras pessoas físicas.
*
* @author  Icaro
* @author Alexandre
* @author Thiago
* @version 1.0
*  
*/
public class Cadastro {
	public static void cadastrofisica() throws IOException {
		FileWriter pw = new FileWriter("dados\\cadastrosf.csv",true);
		String cliente, end, ts, zs, vals,segs;
		Float val,seg;
		int z=0;
		int t=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do Cliente:");
		cliente = input.nextLine();
		System.out.println("Digite o endereço do imovel:");
		end = input.nextLine();
		System.out.println("Digite o valor do imovel:");
		val = input.nextFloat();
		vals = Float.toString(val);
		System.out.println("Digite o zona do imovel\n1-URBANA\n2-SUBURBANA\n3-RURAL\nDigite:");
		z = validarINT(input);
		zs = Integer.toString(z);
		System.out.println("Digite o tipo do imovel\n1-APARTAMENTO\n2-CASA\nDigite:");
		t = validarINT(input);
		ts = Integer.toString(t);
		//Entrada de dados
		seg = val/50;
		if(z == 1) {
			seg = (seg) + (val/100);
		} else if(z == 2) {
			seg = (seg) + (val/200);
		}
		if(t == 2) {
			seg = (seg) + (val/200);
		}
		segs = Float.toString(seg);
		System.out.println("Valor do contrato :" + seg);
		pw.append(cliente);
		pw.append(',');
		pw.append(end);
		pw.append(',');
		pw.append(vals);
		pw.append(',');
		pw.append(zs);
		pw.append(',');
		pw.append(ts);
		pw.append(',');
		pw.append(segs);
		pw.append('\n');
		pw.flush();
		pw.close();
		return;
	}
	
	/**
	* Metodo para cadastras pessoas Juridicas.
	*
	* @author  Icaro
	* @author Alexandre
	* @author Thiago
	* @version 1.0
	*  
	*/	
	public static void cadastrojuridica() throws IOException {
		@SuppressWarnings("resource")
		FileWriter pw = new FileWriter("dados\\cadastrosj.csv",true);
		String cliente, vals,nvds,nfs,rs,segs;
		Float val,seg;
		int r,aux;
		int nf;
		int nvd;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome da Empresa:");
		cliente = input.nextLine();
		System.out.println("Digite o valor do imovel:");
		val = input.nextFloat();
		vals = Float.toString(val);
		System.out.println("Numero de Funcionarios:");
		nf = input.nextInt();
		nfs = Integer.toString(nf);
		System.out.println("Numero de Visita diarias:");
		nvd = validarINT(input);
		nvds =  Integer.toString(nvd);
		System.out.println("Digite o ramo do imovel\n1-COMÉRCIO\n2-INDÚSTRIA\n3-AGROPECUÁRIA\nDigite:");
		r = validarINT(input);
		rs = Integer.toString(r);
		//Entrada de dados
		seg = val*4/100;
		aux = nf/10;
		seg = (seg) + ((val/500)*aux);
		aux = ((nvd/200)/1000)*3;
		seg = (seg) + (val*aux);
		if(r == 2) {
			seg = (seg) + (val/100);
		} else if(r == 1) {
			seg = (seg) + (val/200);
		}
		segs = Float.toString(seg);
		System.out.println("Valor do contrato :" + seg);
		pw.append(cliente);
		pw.append(',');
		pw.append(vals);
		pw.append(',');
		pw.append(nfs);
		pw.append(',');
		pw.append(nvds);
		pw.append(',');
		pw.append(rs);
		pw.append(',');
		pw.append(segs);
		pw.append('\n');
		pw.flush();
		pw.close();
		return;
	}
	/**
	* Enums para variaveis de mesmo tipo.
	*
	* @author  Icaro
	* @author Alexandre
	* @author Thiago
	* @version 1.0
	*  
	*/	
	public enum Zona {
		URBANA, SUBURBANA, RURAL;
	}
	public enum Tipo{
		APARTAMENTO, CASA;
	}
	public enum Ramo{
		COMÉRCIO,INDÚSTRIA,AGROPECUÁRIA;
	}

	/**
	* Metodo para listar clientes e empresas com contratos.
	*
	* @author  Icaro
	* @author Alexandre
	* @author Thiago
	* @version 1.0
	*  
	*/	
public static void listarclientes() {
	String csvFileF = "dados/cadastrosf.csv";
	String csvFileJ = "dados/cadastrosj.csv";
    String line = "";
    String cvsSplitBy = ",";
    int id = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(csvFileF))) {
    	id = 1;
    	System.out.println("Lista Pessoas Fisicas:");
        while ((line = br.readLine()) != null) {

            
            String[] clientes = line.split(cvsSplitBy);
            
            System.out.println(id + " : " + clientes[0]);
            id = id+1;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    try (BufferedReader br = new BufferedReader(new FileReader(csvFileJ))) {
    	id = 1;
    	System.out.println("Lista Pessoas Juridicas:");
        while ((line = br.readLine()) != null) {

            
            String[] clientes = line.split(cvsSplitBy);
            
            System.out.println(id + " : " + clientes[0]);
            id = id+1;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return;
}
/**
* Metodo para listar contratos de todas empresas e clientes.
*
* @author  Icaro
* @author Alexandre
* @author Thiago
* @version 1.0
*  
*/	
public static void listarcontratos() {
	String csvFileF = "dados/cadastrosf.csv";
	String csvFileJ = "dados/cadastrosj.csv";
    String line = "";
    String cvsSplitBy = ",";
    int id = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(csvFileF))) {
    	id = 1;
    	System.out.println("Lista de Contratos de Pessoas Fisicas:");
        while ((line = br.readLine()) != null) {

            
            String[] clientes = line.split(cvsSplitBy);
            
            System.out.println(id + " : " + clientes[0] + "\nEndereço:" +clientes[1] + "\nValor:" +clientes[2]);
            if(Integer.parseInt(clientes[3]) == 1) {
            	System.out.println("Zona: Urbana");
            }else if(Integer.parseInt(clientes[3]) == 2) {
            	System.out.println("Zona: Suburbana");
            }else {
            	System.out.println("Zona: Rural");
            }
            if(Integer.parseInt(clientes[4]) == 1) {
            	System.out.println("Tipo: Apartamento");
            }else {
            	System.out.println("Tipo: Casa");
            }
            System.out.println("Valor do seguro:"+ clientes[5]);
            id = id+1;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    try (BufferedReader br = new BufferedReader(new FileReader(csvFileJ))) {
    	id = 1;
    	System.out.println("Lista de Contratos de Pessoas Juridicas:");
        while ((line = br.readLine()) != null) {

            
            String[] clientes = line.split(cvsSplitBy);
            
            System.out.println(id + " : " + clientes[0] + "\nValor:" +clientes[1] + "\nNumero de Funcionarios:" + clientes[2] +
            		"\nNumero de visitas diarias:"+ clientes[3]);
            
            if(Integer.parseInt(clientes[4]) == 1) {
            	System.out.println("Ramo: Comércio");
            }else if(Integer.parseInt(clientes[4]) == 2) {
            	System.out.println("Ramo: Industria");
            }else {
            	System.out.println("Ramo: Agropécuaria");
            }
            System.out.println("Valor do seguro:"+ clientes[5]);
            id = id+1;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return;
}
/**
* Metodo para lidar com entradas erradas.
*
* @author  Icaro
* @author Alexandre
* @author Thiago
* @version 1.0
*  
*/	
private static int validarINT (Scanner input) {
    String userEntry = input.next();

    while (!isNumber(userEntry)) {
        System.out.print("Não é um inteiro, digite de novo: ");
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