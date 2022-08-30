package io.github.cyklon73.cytils.api.discord.comp;

public class Emoji {

    private String id; //emoji id
    private String name; //emoji name
    private Role[] roles; //roles allowed to use this emoji
    private User user; //user that created this emoji
    private Boolean require_colons; //whether this emoji must be wrapped in colons
    private Boolean managed; //whether this emoji is managed
    private Boolean animated; //whether this emoji is animated
    private Boolean available; //whether this emoji can be used, may be false due to loss of Server Boosts
}
