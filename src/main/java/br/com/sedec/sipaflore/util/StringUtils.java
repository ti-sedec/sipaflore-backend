package br.com.sedec.sipaflore.util;

import lombok.NoArgsConstructor;

import static java.text.Normalizer.Form.NFD;
import static java.text.Normalizer.normalize;
import static lombok.AccessLevel.PRIVATE;
import static net.bytebuddy.utility.RandomString.make;

@NoArgsConstructor(access = PRIVATE)
public class StringUtils {

    public static String generateRandomString(final Integer length) {
        return make(length);
    }

    public static String normalizeString(final String texto) {
        final String textoNormalize = normalize(texto, NFD);
        return textoNormalize
            .replaceAll("[^\\p{ASCII}]", "")
            .replaceAll("[^a-zA-Z0-9\\s]", "");
    }

}
