package aes;

/*
 * Rotinas de conversão para hexadecimal
 *
 * */

public class Conversor {

	/*
	 * 
	 * Criar uma rotina que converte uma string com caracteres ASCII para um array
	 * de bytes
	 * 
	 */

	public static byte[] converterASCIIParaByteArray(String s, boolean padding) {
		/*
		 * Lembrar que o AES exige que a string seja multipla de 16 bytes, por isso
		 * temos que acrescentar um padding.
		 */
		int tamanhoPadding;

		if (padding) {
			tamanhoPadding = s.length() % 16;

			if (tamanhoPadding == 0) {
				tamanhoPadding = 16;
			}
		} else {
			tamanhoPadding = 0;
		}

		byte[] arrayResult = new byte[s.length() + tamanhoPadding];
		for (int i = 0; i < s.length(); i++) {
			arrayResult[i] = (byte) s.charAt(i); // cast para byte
		}

		byte pad = (byte) tamanhoPadding;
		for (int i = s.length(); i < s.length() + tamanhoPadding; i++) {
			arrayResult[i] = pad;
		}

		return arrayResult;
	}

	public static String converterByteArrayToHexString(byte[] a) {

		char hexDig[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		StringBuffer buf = new StringBuffer(); // para acumular as conversoes
		// retorna string com bytes em hexa
		for (int i = 0; i < a.length; i++) {
			buf.append(hexDig[(a[i] >> 4) & 0X0f]); // shift right de 4 bits. 4 bits superiores
			buf.append(hexDig[a[i] & 0x0f]); // 4 bits inferiores.
		}
		return buf.toString();
	}

	public static byte[] converterHexStringToByteArray(String s) {
		// recebe uma string com caracteres em hexadecimal e converte em byte[]

		int tamanho = s.length() / 2; // cada dois caracteres dão um byte
		byte[] arrayResult = new byte[tamanho];

		for (int i = 0; i < tamanho; i++) {
			String hex = s.substring(i * 2, i * 2 + 2);
			Integer valor = Integer.parseInt(hex, 16); // converte usando base 16.
			arrayResult[i] = valor.byteValue();
		}
		return arrayResult;
	}
}
