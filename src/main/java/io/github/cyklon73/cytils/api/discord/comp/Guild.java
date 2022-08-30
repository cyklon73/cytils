package io.github.cyklon73.cytils.api.discord.comp;

public class Guild {

    private String id; //guild id
    private String name; //guild name (2-100 characters, excluding trailing and leading whitespace)
    private String icon; //	icon hash
    private String icon_hash; // 	icon hash, returned when in the template object
    private String splash; //splash hash
    private String discovery_splash; //discovery splash hash; only present for guilds with the "DISCOVERABLE" feature
    private String owner_id; //	id of owner
    private String region; //voice region id for the guild (deprecated)
    private String afk_channel_id; //	id of afk channel
    private Integer afk_timeout; //afk timeout in seconds
    private Boolean widget_enabled; //	true if the server widget is enabled
    private String widget_channel_id; //the channel id that the widget will generate an invite to, or null if set to no invite
    private Integer verification_level; //	verification level required for the guild
    private Integer default_message_notifications; //default message notifications level
    private Integer explicit_content_filter; //explicit content filter level
    private Role[] roles; //roles in the guild
    private Emoji[] emojis; //custom guild emojis
    private GuildFeature[] features; //	enabled guild features
    private Integer mfa_level; //required MFA level for the guild
    private String application_id; //application id of the guild creator if it is bot-created
    private String system_channel_id; //the id of the channel where guild notices such as welcome messages and boost events are posted
    private Integer system_channel_flags; //system channel flags
    private String rules_channel_id; //	the id of the channel where Community guilds can display rules and/or guidelines
    private Integer max_presences; //	the maximum number of presences for the guild (null is always returned, apart from the largest of guilds)
    private Integer max_members; //	the maximum number of members for the guild
    private String vanity_url_code; //	the vanity url code for the guild
    private String description; //the description of a guild
    private String banner; //banner hash
    private Integer premium_tier; //premium tier (Server Boost level)
    private Integer premium_subscription_count; //the number of boosts this guild currently has
    private String preferred_locale; //the preferred locale of a Community guild; used in server discovery and notices from Discord, and sent in interactions; defaults to "en-US"
    private String public_updates_channel_id; //	the id of the channel where admins and moderators of Community guilds receive notices from Discord
    private Integer max_video_channel_users; //	the id of the channel where admins and moderators of Community guilds receive notices from Discord
    private Integer approximate_member_count; //	approximate number of members in this guild, returned from the GET /guilds/<id> endpoint when with_counts is true
    private Integer approximate_presence_count; //approximate number of non-offline members in this guild, returned from the GET /guilds/<id> endpoint when with_counts is true
    private WelcomeScreen Welcome_screen; //	the welcome screen of a Community guild, shown to new members, returned in an Invite's guild object
    private Integer nsfw_level; //	guild NSFW level
    private Sticker[] stickers; //	custom guild stickers
    private Boolean premium_progress_bar_enabled; //	whether the guild has the boost progress bar enabled

}
