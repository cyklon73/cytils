package io.github.cyklon73.cytils.api.discord.comp;

public interface WebhookTypes {

    //Incoming Webhooks can post messages to channels with a generated token
    public static final Integer INCOMING = 1;

    //	Channel Follower Webhooks are internal webhooks used with Channel Following to post new messages into channels
    public static final Integer CHANNEL_FOLLOWER = 2;

    //Application webhooks are webhooks used with Interactions
    public static final Integer APPLICATION = 3;



}
