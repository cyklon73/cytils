package io.github.cyklon73.cytils.api.discord.comp.embed;

import java.net.URL;

public class Footer {

    private String text = null;
    private String icon = null;

    public Footer(String text, String icon) {
        this.text = text;
        this.icon = icon;
    }

    public Footer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
