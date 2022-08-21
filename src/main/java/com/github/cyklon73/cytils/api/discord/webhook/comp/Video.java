package com.github.cyklon73.cytils.api.discord.webhook.comp;

public class Video {

    private String url;
    private String proxy_url;
    private Integer height;
    private Integer width;

    public Video(String url, String proxy_url, Integer height, Integer width) {
        this.url = url;
        this.proxy_url = proxy_url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProxy_url() {
        return proxy_url;
    }

    public void setProxy_url(String proxy_url) {
        this.proxy_url = proxy_url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
