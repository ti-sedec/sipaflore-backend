package br.com.sedec.sipaflore.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

@Getter
@AllArgsConstructor
public class CustomMultipartFile implements MultipartFile {

    private byte[] input;
    private String name;
    private String originalFilename;
    private String contentType;

    @Override
    public boolean isEmpty() {
        return input == null || input.length == 0;
    }

    @Override
    public long getSize() {
        return input.length;
    }

    @Override
    public byte @NotNull [] getBytes() {
        return input;
    }

    @Override
    public @NotNull InputStream getInputStream() {
        return new ByteArrayInputStream(input);
    }

    @Override
    public void transferTo(@NonNull final File destination) throws IOException, IllegalStateException {
        writeByteArrayToFile(destination, input);
    }

}
