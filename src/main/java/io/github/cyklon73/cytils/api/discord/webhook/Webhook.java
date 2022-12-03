package io.github.cyklon73.cytils.api.discord.webhook;

import io.github.cyklon73.cytils.api.discord.comp.Image;
import io.github.cyklon73.cytils.api.discord.comp.User;
import io.github.cyklon73.cytils.api.discord.comp.embed.Embed;
import io.github.cyklon73.cytils.api.discord.comp.embed.Field;
import io.github.cyklon73.cytils.api.discord.comp.embed.Footer;
import io.github.cyklon73.cytils.api.discord.comp.embed.Thumbnail;
import io.github.cyklon73.cytils.api.discord.comp.mentions.Mention;
import io.github.cyklon73.cytils.api.discord.comp.mentions.UserMention;
import io.github.cyklon73.cytils.api.discord.exceptions.ConnectException;
import io.github.cyklon73.cytils.json.JSONObject;
import io.github.cyklon73.cytils.utils.Util;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Webhook {

    private final URL webhookUrl;

    private boolean connected;

    public Webhook(URL webhookUrl) throws ConnectException {
        if (Util.removeSpaces(webhookUrl.toString()) == "") throw new ConnectException("cant connect to " + webhookUrl);
        this.webhookUrl = webhookUrl;
        this.connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    /**
     * Null all components you don't want to use.
     *
     * You must add at least one content component to your webhook.
     *
     * These components count as content components:
     * @param message Add a message to your webhook
     * @param embeds Add embeds to your webhook
     *
     * @throws IllegalArgumentException If no content component has been added or if you added too many embeds (too many = more than 10)
     */
    public void send(Message message, User user, Embed[] embeds) {
        if (!connected) return;
        if ((message == null) && ((embeds == null) || (embeds.length <= 0))) throw new IllegalArgumentException("You must use at least 1 content component");

        JSONObject json = new JSONObject();

        if (message != null) {
            if (message.getContent() != null) json.put("content", message.getContent());
            if (message.isTts() != null) json.put("tts", message.isTts());
            if (message.getAllowedMentions() != null) {
                JSONObject allowedMentionsJson = new JSONObject();
                ArrayList<String> parseNames = new ArrayList<String>();
                ArrayList<String> mentionUserIds = new ArrayList<String>();
                for (Mention mention : message.getAllowedMentions()) {
                    if (!parseNames.contains("\"" + mention.getName() + "\"")) {
                        parseNames.add("\"" + mention.getName() + "\"");
                        if (mention instanceof UserMention) {
                            mentionUserIds.addAll(Arrays.asList(((UserMention)mention).getIds()));
                        }
                    }
                }
                allowedMentionsJson.put("parse", parseNames.toArray());
                ArrayList<String> mentionUserIdsFinal = new ArrayList<String>();
                for (String mentionUserId : mentionUserIds) {
                    mentionUserIdsFinal.add(mentionUserId);
                }
                allowedMentionsJson.put("users", mentionUserIdsFinal.toArray());
                json.put("allowed_mentions", allowedMentionsJson);
            }
        }

        if (user != null) {
            if (user.getName() != null) json.put("username", user.getName());
            if (user.getIcon() != null) json.put("avatar_url", user.getIcon());
        }

        if (embeds != null) {
            if (embeds.length >= 1) {
                if (embeds.length >= 10) throw new IllegalArgumentException("Too many embeds, you can send a maximum of 10 embeds at a time");
                List<JSONObject> jsonEmbeds = new ArrayList<JSONObject>();

                for (Embed embed : embeds) {
                    if (embed == null) continue;
                    JSONObject jsonEmbed = new JSONObject();

                    jsonEmbed.put("title", embed.getTitle());
                    jsonEmbed.put("description", embed.getDescription());
                    jsonEmbed.put("url", embed.getUrl());

                    Footer footer = embed.getFooter();
                    Image image = embed.getImage();
                    Thumbnail thumbnail = embed.getThumbnail();
                    User author = embed.getAuthor();
                    List<Field> fields = embed.getFields();

                    if (footer != null) {
                        JSONObject jsonFooter = new JSONObject();

                        jsonFooter.put("text", footer.getText());
                        jsonFooter.put("icon_url", footer.getIcon());
                        jsonEmbed.put("footer", jsonFooter);
                    }

                    if (image != null) {
                        JSONObject jsonImage = new JSONObject();

                        jsonImage.put("url", image.getUrl());
                        jsonEmbed.put("image", jsonImage);
                    }

                    if (thumbnail != null) {
                        JSONObject jsonThumbnail = new JSONObject();

                        jsonThumbnail.put("url", thumbnail.getUrl());
                        jsonEmbed.put("thumbnail", jsonThumbnail);
                    }

                    if (author != null) {
                        JSONObject jsonAuthor = new JSONObject();

                        jsonAuthor.put("name", author.getName());
                        jsonAuthor.put("url", author.getUrl());
                        jsonAuthor.put("icon_url", author.getIcon());
                        jsonEmbed.put("author", jsonAuthor);
                    }

                    List<JSONObject> jsonFields = new ArrayList<>();
                    for (Field field : fields) {
                        JSONObject jsonField = new JSONObject();

                        jsonField.put("name", field.getName());
                        jsonField.put("value", field.getValue());
                        jsonField.put("inline", field.isInline());

                        jsonFields.add(jsonField);
                    }

                    jsonEmbed.put("fields", jsonFields.toArray());
                    jsonEmbeds.add(jsonEmbed);

                }

                json.put("embeds", jsonEmbeds.toArray());
            }
        }

        try {
            sendJson(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendJson(JSONObject json) throws IOException {
        System.out.println(json.toString());
        HttpsURLConnection connection = (HttpsURLConnection) this.webhookUrl.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "Cytils-Discord-Api-Wrapper-By-Cyklon");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStream stream = connection.getOutputStream();
        stream.write(json.toString().getBytes());
        stream.flush();
        stream.close();

        connection.getInputStream().close();
        connection.disconnect();
    }
}
