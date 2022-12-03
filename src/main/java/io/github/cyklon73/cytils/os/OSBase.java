package io.github.cyklon73.cytils.os;

import java.io.File;
import java.io.IOException;

public interface OSBase {

    public void shutdown() throws IOException;
    public void restart() throws IOException;
    public default void executeCommand(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    };
    public File getAppdata();
    public File getProgrammFiles();

}
