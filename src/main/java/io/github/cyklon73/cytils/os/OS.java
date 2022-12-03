package io.github.cyklon73.cytils.os;

import io.github.cyklon73.cytils.os.impl.Linux;
import io.github.cyklon73.cytils.os.impl.MacOS;
import io.github.cyklon73.cytils.os.impl.Unsupported;
import io.github.cyklon73.cytils.os.impl.Windows;

public enum OS {

    WINDOWS("windows", new Windows()),
    MAC("mac", new MacOS()),
    LINUX("linux", new Linux()),
    UNSUPPORTED("unsupported", new Unsupported());


    private final String name;
    private final OSBase clazz;

    OS(String name, OSBase clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }


    public OSBase getClazz() {
        return clazz;
    }

    public static OS getOS() {
        final String currentOS = System.getProperty("os.name").toLowerCase();

        if (currentOS.startsWith("windows")) return WINDOWS;
        else if (currentOS.startsWith("mac")) return MAC;
        else if (currentOS.startsWith("Linux")) return LINUX;
        else return UNSUPPORTED;
    }
}
