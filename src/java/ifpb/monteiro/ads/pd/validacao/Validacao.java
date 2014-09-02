package ifpb.monteiro.ads.pd.validacao;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class Validacao {

    public static void validaEntrada(String entrada, String message) throws HumQueCaroException {
        if (entrada == null || entrada.equals("")) {
            throw new HumQueCaroException(message);
        }
    }

    public static void validaSenha(String entrada, String message) throws HumQueCaroException {
        validaEntrada(entrada, message);
        if(entrada.length() < 4){
            throw new HumQueCaroException(message);
        }
    }

    /**
     * Metodo criado para verificar se o email foi digitado corretamente. Sera
     * verificado a quantidade de @ e se contem algum nome valido antes dela.
     *
     * @param email que vai ser verificado
     * @param msg
     *
     */
    public static void verifEmail(String email, String msg)
            throws HumQueCaroException {
        if (email.contains(";") || email.contains(":") || email.contains("ê")) {
            throw new HumQueCaroException(msg);
        }
        if (contRept(email, '@') == 1 && email.length() > 1 && !email.contains(" ")) {
            String[] depoisDoArroba = email.split("@");
            if (depoisDoArroba[0].length() == 0
                    || depoisDoArroba[1].length() == 0) {
                throw new HumQueCaroException(msg);
            }
            if (contRept(depoisDoArroba[1], '.') != 1) {
                throw new HumQueCaroException(msg);
            } else {
                String[] pontosDepoisArroba = depoisDoArroba[1].split("\\.");
                if (pontosDepoisArroba[0].length() == 0
                        || pontosDepoisArroba[1].length() == 0) {
                    throw new HumQueCaroException(msg);
                } else {
                    if (!contemApenasLetras(pontosDepoisArroba[1])) {
                        throw new HumQueCaroException(msg);
                    }
                }
            }
        } else {
            throw new HumQueCaroException(msg);

        }
    }

    /**
     * Este metodo eh usado para contar a repeticao de um elemento em uma
     * String.
     *
     * @param elemento item que sera comparado
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

    /**
     * Classe responsavel por verificar se uma String contem apenas numeros
     *
     * @param msg
     * @return
     */
    public static boolean contemApenasLetras(String msg) {
        return msg.matches("[a-zA-Z\\s]+");
    }
}