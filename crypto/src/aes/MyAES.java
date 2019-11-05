package aes;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MyAES {

	private final String ALGORITMO = "AES/CTR/NoPadding"; // definindo o algoritmo de encriptação/descriptação
	private Key chaveAES;
	private IvParameterSpec ivps;

	public MyAES(String chave, String iv) {
		byte[] ivArray = Conversor.converterASCIIParaByteArray(iv, false); // não precisamos de padding no iv
		ivps = new IvParameterSpec(ivArray);

		byte[] chaveArray = Conversor.converterHexStringToByteArray(chave);
		chaveAES = new SecretKeySpec(chaveArray, "AES");
	}

	public String encriptar(String texto) throws Exception, InvalidAlgorithmParameterException {

		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.ENCRYPT_MODE, chaveAES, ivps); // inicializar a criptografia informando a chave e o vetor de
														// inicialização

		byte[] textoArray = Conversor.converterHexStringToByteArray(texto);
		byte[] cipherText = c.doFinal(textoArray);
		return Conversor.converterByteArrayToHexString(cipherText);
	}

	public String descriptar(String texto) throws Exception, InvalidAlgorithmParameterException {

		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.DECRYPT_MODE, chaveAES, ivps); 

		byte[] textoArray = Conversor.converterHexStringToByteArray(texto);
		byte[] mensagem = c.doFinal(textoArray);
		return Conversor.converterByteArrayToHexString(mensagem);
	}

}
