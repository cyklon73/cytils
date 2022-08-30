package io.github.cyklon73.cytils.api.discord.comp;

public class Webhook {
    private final String id; //the id of the webhook
    private final Integer type; //the type of the webhook
    private final String guild_id; //the guild id this webhook is for, if any
    private final String channel_id; //the channel id this webhook is for, if any
    private final User user; //the user this webhook was created by (not returned when getting a webhook with its token)
    private final String name; //the default name of the webhook
    private final String avatar; //	the default user avatar hash of the webhook
    private final String token; //the secure token of the webhook (returned for Incoming Webhooks)
    private final String application_id; //the bot/OAuth2 application that created this webhook
    private final Guild source_guild; //the guild of the channel that this webhook is following (returned for Channel Follower Webhooks)

    //private Channel source_channel; //	the channel that this webhook is following (returned for Channel Follower Webhooks)
    private final String url; //	the url used for executing the webhook (returned by the webhooks OAuth2 flow)

    public Webhook(String id, Integer type, String guild_id, String channel_id, User user, String name, String avatar, String token, String application_id, Guild source_guild, String url) {
        this.id = id;
        this.type = type;
        this.guild_id = guild_id;
        this.channel_id = channel_id;
        this.user = user;
        this.name = name;
        this.avatar = avatar;
        this.token = token;
        this.application_id = application_id;
        this.source_guild = source_guild;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getToken() {
        return token;
    }

    public String getApplication_id() {
        return application_id;
    }

    public Guild getSource_guild() {
        return source_guild;
    }

    public String getUrl() {
        return url;
    }
}
