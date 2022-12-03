package io.github.cyklon73.cytils.os.impl;

import io.github.cyklon73.cytils.os.OSBase;

import java.io.File;
import java.io.IOException;

public class Unsupported implements OSBase {
    private void unsupported() {
        throw new RuntimeException("OS \"" + System.getProperty("os.name") + "\" is not supported");
    }

    @Override
    public void shutdown() {
        unsupported();
    }

    @Override
    public void restart() {
        unsupported();
    }

    @Override
    public void executeCommand(String command) {
        unsupported();
    }

    @Override
    public File getAppdata() {
        throw new RuntimeException("OS \"" + System.getProperty("os.name") + "\" is not supported");
    }

    @Override
    public File getProgrammFiles() {
        throw new RuntimeException("OS \"" + System.getProperty("os.name") + "\" is not supported");
    }
}
