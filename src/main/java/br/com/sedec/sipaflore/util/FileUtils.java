package br.com.sedec.sipaflore.util;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

@NoArgsConstructor(access = PRIVATE)
public class FileUtils {

    public static final List<String> DEFAULT_IMAGE_EXTENSIONS = asList("jpg", "jpeg", "png");
    public static final List<String> DEFAULT_DOCUMENT_EXTENSIONS = singletonList("pdf");

    public static String getExtension(final MultipartFile file) {
        final String fileName = requireNonNull(file.getOriginalFilename());
        return fileName.substring(fileName.lastIndexOf(".")).replace(".", "");
    }

    public static void validateFile(final MultipartFile file, final int maxSizeMegabytes,
                                    final List<String> extensions) throws BadRequestException {
        if (isNull(file) || isTrue(file.isEmpty())) {
            throw new BadRequestException("error.file.empty");
        }

        if (file.getSize() > ((long) maxSizeMegabytes * 1024 * 1024)) {
            throw new BadRequestException("error.file.size", maxSizeMegabytes);
        }

        if (isNotEmpty(extensions) && isFalse(extensions.contains(getExtension(file)))) {
            throw new BadRequestException("error.file.extension", getExtension(file));
        }
    }

}
