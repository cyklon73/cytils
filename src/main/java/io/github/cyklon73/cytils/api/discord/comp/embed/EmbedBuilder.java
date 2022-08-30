package io.github.cyklon73.cytils.api.discord.comp.embed;

import io.github.cyklon73.cytils.api.discord.comp.Image;
import io.github.cyklon73.cytils.api.discord.comp.User;

import java.awt.*;
import java.util.ArrayList;

public class EmbedBuilder {

    private String title = null;
    private String description = null;
    private String url = null;
    private String timestamp = null;
    private Color color = null;
    private Footer footer = null;
    private Image image = null;
    private Thumbnail thumbnail = null;
    private User author = null;
    private ArrayList<Field> fields = new ArrayList<>();

    public EmbedBuilder() { }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public void setFooter(Footer footer) {
        this.footer = footer;
    }



    public void setImage(String url) {
        this.image = new Image(url);
    }
    public void setImage(Image image) {
        this.image = image;
    }


    public void setThumbnail(String url) {
        this.thumbnail = new Thumbnail(url);
    }
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }


    public void setAuthor(User author) {
        this.author = author;
    }


    public void addField(Field field) {
        fields.add(field);
    }

    public Embed build() {
        return new Embed(title, description, url, timestamp, color, footer, image, thumbnail, author, fields);
    }
}
