package com.parse;

import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import java.io.File;

class ParseRESTFileCommand extends ParseRESTCommand {
    private final String contentType;
    private final byte[] data;
    private final File file;

    public static class Builder extends ParseRESTCommand.Init<Builder> {
        /* access modifiers changed from: private */
        public String contentType = null;
        /* access modifiers changed from: private */
        public byte[] data = null;
        /* access modifiers changed from: private */
        public File file;

        public Builder() {
            method(ParseHttpRequest.Method.POST);
        }

        public ParseRESTFileCommand build() {
            return new ParseRESTFileCommand(this);
        }

        public Builder contentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder data(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder file(File file2) {
            this.file = file2;
            return this;
        }

        public Builder fileName(String str) {
            return (Builder) httpPath(String.format("files/%s", new Object[]{str}));
        }

        /* access modifiers changed from: package-private */
        public Builder self() {
            return this;
        }
    }

    public ParseRESTFileCommand(Builder builder) {
        super(builder);
        if (builder.file == null || builder.data == null) {
            this.data = builder.data;
            this.contentType = builder.contentType;
            this.file = builder.file;
            return;
        }
        throw new IllegalArgumentException("File and data can not be set at the same time");
    }

    /* access modifiers changed from: protected */
    public ParseHttpBody newBody(ProgressCallback progressCallback) {
        if (progressCallback == null) {
            byte[] bArr = this.data;
            return bArr != null ? new ParseByteArrayHttpBody(bArr, this.contentType) : new ParseFileHttpBody(this.file, this.contentType);
        }
        byte[] bArr2 = this.data;
        return bArr2 != null ? new ParseCountingByteArrayHttpBody(bArr2, this.contentType, progressCallback) : new ParseCountingFileHttpBody(this.file, this.contentType, progressCallback);
    }
}
