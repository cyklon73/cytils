package com.github.cyklon73.cytils;

import com.github.cyklon73.cytils.api.discord.webhook.EmbedBuilder;

import java.awt.*;
import java.net.MalformedURLException;

public class test {

    public static void main(String[] args) throws MalformedURLException {
        WebhookTest webhook = new WebhookTest();
        //webhook.sendTest();
        //webhook.semd("test Message");
        EmbedBuilder builder = new EmbedBuilder();
        builder.setDescription("Test Embed");
        builder.setColor(new Color(0x00007C));
        webhook.semd(builder.build());
        //System.out.println(Math.average(new Double[] {1.0}));
    }
}
