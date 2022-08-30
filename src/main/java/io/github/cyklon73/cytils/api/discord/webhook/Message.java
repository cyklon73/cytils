package io.github.cyklon73.cytils.api.discord.webhook;

import io.github.cyklon73.cytils.api.discord.comp.mentions.Mention;

public class Message {

    private final String content;
    private final Boolean tts;

    private final Mention[] allowed_mentions;

    public Message(String content, Boolean tts, Mention[] allowed_mentions) {
        this.content = content;
        this.tts = tts;
        this.allowed_mentions = allowed_mentions;
    }

    public String getContent() {
        return content;
    }

    public Boolean isTts() {
        return tts;
    }

    public Mention[] getAllowedMentions() {
        return allowed_mentions;
    }
}
