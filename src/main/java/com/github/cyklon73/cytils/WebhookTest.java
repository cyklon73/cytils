package com.github.cyklon73.cytils;

import com.github.cyklon73.cytils.api.discord.webhook.Webhook;
import com.github.cyklon73.cytils.api.discord.webhook.comp.Embed;

import java.net.MalformedURLException;
import java.net.URL;

public class WebhookTest extends Webhook {

    public WebhookTest() throws MalformedURLException {
        super(new URL("https://discord.com/api/webhooks/996867823861243984/wgXuLG1sYYAdU0KxdT-pUpRXIMyC8araWMcOIsRvAsMEV5_F6tU9LuN4pJtkwTk7JKwY"));
    }

    public void sendTest() {
        send("test");
    }

    public void semd(String msg) {
        send(msg);
    }

    public void semd(Embed embed) {
        send(embed);
    }
}