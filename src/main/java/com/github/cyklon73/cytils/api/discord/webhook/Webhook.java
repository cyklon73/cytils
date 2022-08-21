package com.github.cyklon73.cytils.api.discord.webhook;

import com.github.cyklon73.cytils.api.discord.webhook.comp.*;
import net.cyklon.cytils.api.discord.webhook.comp.*;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

public class Webhook {

    private URL webhookUrl;

    public Webhook(URL webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    protected void send(String content, Embed embed) {
        send(content);
        send(embed);
    }

    protected void send(String content, ArrayList<Embed> embeds) {
        send(content);
        send(embeds);
    }

    protected void send(String content) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content", content);
            HttpsURLConnection connection = (HttpsURLConnection) webhookUrl.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream stream = connection.getOutputStream();
            stream.write(jsonObject.toJSONString().getBytes());
            stream.flush();
            stream.close();

            connection.getInputStream().close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void send(Embed embed) {
        try {
            JSONObject embedJson = new JSONObject();
            embedJson.put("title", embed.getTitle());
            embedJson.put("description", embed.getDescription());
            embedJson.put("url", embed.getUrl());

            if (embed.getColor() != null) {
                Color color = embed.getColor();
                int rgb = color.getRed();
                rgb = (rgb << 8) + color.getGreen();
                rgb = (rgb << 8) + color.getBlue();

                embedJson.put("color", rgb);
            }

            if (embed.getFooter() != null) {
                Footer footer = embed.getFooter();
                JSONObject footerJson = new JSONObject();
                footerJson.put("text", footer.getText());
                if (footer.getIcon() != null) footerJson.put("icon_url", footer.getIcon());
                embedJson.put("footer", footerJson);
            }

            if (embed.getImage() != null) {
                JSONObject imageJson = new JSONObject();
                imageJson.put("url", embed.getImage().getUrl());
                embedJson.put("image", imageJson);
            }

            if (embed.getThumbnail() != null) {
                JSONObject thumbnailJson = new JSONObject();
                thumbnailJson.put("url", embed.getThumbnail().getUrl());
                embedJson.put("thumbnail", thumbnailJson);
            }

            if (embed.getAuthor() != null) {
                Author author = embed.getAuthor();
                JSONObject authorJson = new JSONObject();
                authorJson.put("name", author.getName());
                authorJson.put("url", author.getUrl());
                authorJson.put("icon_url", author.getIcon());
                embedJson.put("author", authorJson);
            }

            ArrayList<JSONObject> fieldsJson = new ArrayList<>();
            for (Field field: embed.getFields()) {
                JSONObject fieldJson = new JSONObject();
                fieldJson.put("name", field.getName());
                fieldJson.put("value", field.getValue());
                fieldJson.put("inline", field.isInline());
                fieldsJson.add(fieldJson);
            }
            embedJson.put("fields", fieldsJson.toArray());

            ArrayList<JSONObject> embedsJson = new ArrayList<>();
            embedsJson.add(embedJson);
            System.out.println(embedsJson);
            JSONObject json = new JSONObject();
            json.put("embeds", embedsJson.toArray());

            System.out.println(json);

            HttpsURLConnection connection = (HttpsURLConnection) webhookUrl.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream stream = connection.getOutputStream();
            stream.write(json.toString().getBytes());
            stream.flush();
            stream.close();

            connection.getInputStream().close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void send(ArrayList<Embed> embeds) {
        for (Embed embed : embeds) {
            send(embed);
        }
    }

    protected URL getUrl() {
        return webhookUrl;
    }

}
