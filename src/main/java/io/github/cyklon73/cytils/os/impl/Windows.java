package io.github.cyklon73.cytils.os.impl;

import io.github.cyklon73.cytils.os.OSBase;

import java.io.File;
import java.io.IOException;

public class Windows implements OSBase {
    @Override
    public void shutdown() throws IOException {
        executeCommand("shutdown.exe -s -t 0");
    }

    @Override
    public void restart() {

    }

    @Override
    public File getAppdata() {
        return new File(System.getenv("APPDATA") + File.separator);
    }

    @Override
    public File getProgrammFiles() {
        return null;
    }
}
