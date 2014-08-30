package ifpb.monteiro.ads.pd.validacao;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class Validacao {
	
	public static void validaEntrada(String entrada, String message) throws HumQueCaroException{
		if (entrada == null || entrada.equals("")) {
			throw new HumQueCaroException(message);
		}
	}
	
	/**
	 * Metodo criado para verificar se o email foi digitado corretamente. Sera
	 * verificado a quantidade de @ e se contem algum nome valido antes dela.
	 * 
	 * @param email
	 *            que vai ser verificado
	 * @param msg
	 * 
	 */
	public static void verNomeEmail(String email, String msg)
			throws HumQueCaroException {
		if (email != null && contRept(email, '@') == 1) {
			String[] mail = email.split("@");
			if (mail[0].length() == 0) {
				throw new HumQueCaroException(msg);
			}
		}
	}

	/**
	 * Este metodo eh usado para contar a repeticao de um elemento em uma
	 * String.
	 * 
	 * @param elemento
	 *            item que sera comparado
	 * @return retorna a quantidade de vezes que ele aparece na String
	 */

	public static int contRept(String frs, char elem) {
		int repetiu = 0;
		if (frs != null) {
			for (char elemento : frs.toCharArray()) {
				if (elemento == elem) {
					repetiu++;
				}
			}
		}
		return repetiu;
	}

}
