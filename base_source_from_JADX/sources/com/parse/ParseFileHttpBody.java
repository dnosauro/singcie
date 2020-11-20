package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class ParseFileHttpBody extends ParseHttpBody {
    final File file;

    public ParseFileHttpBody(File file2) {
        this(file2, (String) null);
    }

    public ParseFileHttpBody(File file2, String str) {
        super(str, file2.length());
        this.file = file2;
    }

    public InputStream getContent() {
        return new FileInputStream(this.file);
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                ParseIOUtils.copy(fileInputStream, outputStream);
            } finally {
                ParseIOUtils.closeQuietly((InputStream) fileInputStream);
            }
        } else {
            throw new IllegalArgumentException("Output stream can not be null");
        }
    }
}
