package com.github.cyklon73.cytils.api.discord.webhook.comp;

import java.net.URL;

public class Footer {

    private String text = null;
    private URL icon = null;

    public Footer(String text, URL icon) {
        this.text = text;
        this.icon = icon;
    }

    public Footer(String text) {
        this.text = text;
    }

    public Footer(URL icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public URL getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(URL icon) {
        this.icon = icon;
    }
}
