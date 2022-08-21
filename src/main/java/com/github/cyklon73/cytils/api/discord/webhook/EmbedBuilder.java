package com.github.cyklon73.cytils.api.discord.webhook;

import com.github.cyklon73.cytils.api.discord.webhook.comp.*;
import com.github.cyklon73.cytils.api.discord.webhook.comp.Image;
import net.cyklon.cytils.api.discord.webhook.comp.*;

import java.awt.*;
import java.util.ArrayList;

public class EmbedBuilder {

    private String title = null;
    private String description = null;
    private String url = null;
    private String timestamp = null;
    private Color color = null;
    private Footer footer = null;
    private com.github.cyklon73.cytils.api.discord.webhook.comp.Image image = null;
    private Thumbnail thumbnail = null;
    private Author author = null;
    private ArrayList<Field> fields = new ArrayList<>();

    public EmbedBuilder() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public com.github.cyklon73.cytils.api.discord.webhook.comp.Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public Embed build() {
        return new Embed(title, description, url, timestamp, color, footer, image, thumbnail, author, fields);
    }
}
