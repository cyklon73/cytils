package io.github.cyklon73.cytils.api.discord.comp.mentions;

import io.github.cyklon73.cytils.api.discord.comp.User;

public class UserMention implements Mention {

    private final String[] ids;

    public UserMention(User[] users) {
        this.ids = new String[users.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = users[i].getId();
        }
    }

    public UserMention(String[] ids) {
        this.ids = ids;
    }

    public UserMention() {
        this.ids = new String[] {};
    }

    public String[] getIds() {
        return ids;
    }

    public String[] getMentions() {
        String[] mentions = new String[ids.length];
        for (int i = 0; i < mentions.length; i++) {
            mentions[i] = "<@" + ids[i] + ">";
        }
        return mentions;
    }

    @Override
    public String getName() {
        return "users";
    }
}
