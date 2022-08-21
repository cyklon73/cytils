package com.github.cyklon73.cytils.api.discord.webhook.comp;

import java.net.URL;

public class Author {

    private String name = null;
    private String icon_url = null;
    private String url;

    public Author(String name, String icon_url) {
        this.name = name;
        this.icon_url = icon_url;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon_url;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon_url) {
        this.icon_url = icon_url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
