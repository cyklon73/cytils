package io.github.cyklon73.cytils.os.impl;

import io.github.cyklon73.cytils.os.OSBase;

import java.io.File;
import java.io.IOException;

public class Linux implements OSBase {
    @Override
    public void shutdown() throws IOException {
        executeCommand("shutdown -h now");
    }

    @Override
    public void restart() throws IOException {
        executeCommand("reboot");
    }

    @Override
    public File getAppdata() {
        return new File(System.getProperty("user.home") + File.separator);
    }

    @Override
    public File getProgrammFiles() {
        return null;
    }
}
