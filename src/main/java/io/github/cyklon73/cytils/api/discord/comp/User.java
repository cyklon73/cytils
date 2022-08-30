package io.github.cyklon73.cytils.api.discord.comp;

public class User {

    private String name = null;
    private String icon_url = null;
    private String id = null;
    private String url;

    public User(String name, String icon_url) {
        this.name = name;
        this.icon_url = icon_url;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon_url;
    }

    public String getId() {
        return id;
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

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getMention() {
        if (getId() != null) return "<@" + getId() + ">";
        return "";
    }

}
