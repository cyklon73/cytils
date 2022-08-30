package io.github.cyklon73.cytils.api.discord.comp;

public class Sticker {

    private String id; //id of the sticker
    private String pack_id; //for standard stickers, id of the pack the sticker is from
    private String name; //name of the sticker
    private String description; //description of the sticker
    private String tags; //autocomplete/suggestion tags for the sticker (max 200 characters)
    private String asset; //Deprecated previously the sticker asset hash, now an empty string
    private Integer type; //type of sticker
    private Integer format_type; //type of sticker format
    private Boolean available; //whether this guild sticker can be used, may be false due to loss of Server Boosts
    private String guild_id; //id of the guild that owns this sticker
    private User user; //the user that uploaded the guild sticker
    private Integer sprt_value; //the standard sticker's sort order within its pack
}
