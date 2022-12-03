package io.github.cyklon73.cytils;

import io.github.cyklon73.cytils.api.discord.comp.mentions.Mention;
import io.github.cyklon73.cytils.api.discord.comp.mentions.UserMention;
import io.github.cyklon73.cytils.api.discord.exceptions.ConnectException;
import io.github.cyklon73.cytils.api.discord.webhook.Message;
import io.github.cyklon73.cytils.api.discord.webhook.Webhook;

import java.net.MalformedURLException;
import java.net.URL;

public class WebhookTest {

    public static void main(String[] args) {

        Webhook webhook = null;
        try {
            webhook = new Webhook(new URL("https://discord.com/api/webhooks/1014212116745560145/7slmAj-I-oG35v7N6BNXNbulpgaW6Dvxe9IBAqC8S4KDSCUhKtpDxP2CkvTpNnA8vY13"));
        } catch (ConnectException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

        webhook.send(new Message("<@706884094856003655>", null, new Mention[]{new UserMention()}), null, null);

        webhook.disconnect();

    }

}