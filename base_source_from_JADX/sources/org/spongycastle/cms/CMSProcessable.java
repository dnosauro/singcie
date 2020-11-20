package org.spongycastle.cms;

import java.io.OutputStream;

public interface CMSProcessable {
    Object getContent();

    void write(OutputStream outputStream);
}
