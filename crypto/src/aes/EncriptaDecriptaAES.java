package aes;

import java.util.Scanner;

public class EncriptaDecriptaAES {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// Precisamos de uma chave de criptografia e um vetor de inicialização
		String chave = "140b41b22a29beb4061bda66b6747e14"; // neste caso a chave precisa ser de 16 bytes
		String iv = "1234567890123456"; // para este exemplo o vetor de inicialização precisa ser de 16bits.
	
		try {

			System.out.println("Digite o texto que deseja criptografar: ");
			String texto = input.nextLine();

			System.out.println();

			System.out.println("Texto original: ");
			System.out.println(texto);
			System.out.println();

			System.out.println("Texto em hexa: ");

			String textoEmHexa = Conversor.converterByteArrayToHexString(Conversor.converterASCIIParaByteArray(texto, true)); // string e
			// padding
			System.out.println(textoEmHexa);

			MyAES aes = new MyAES(chave, iv); // classe de criptografia

			System.out.println();
			String textoEncriptado = aes.encriptar(textoEmHexa);
			System.out.println("Texto encriptado com AES: ");
			System.out.println(textoEncriptado);

			System.out.println();
			String textoDescriptado = aes.descriptar(textoEncriptado);
			System.out.println("Texto descriptado: ");
			System.out.println(textoDescriptado);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			input.close();
		}

	}

}
