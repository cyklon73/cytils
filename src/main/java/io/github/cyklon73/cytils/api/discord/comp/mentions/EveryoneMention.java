package io.github.cyklon73.cytils.api.discord.comp.mentions;

import io.github.cyklon73.cytils.api.discord.comp.Role;

public class EveryoneMention implements Mention {

    public EveryoneMention() {}

    public String getMention() {
        return "@everyone";
    }

    @Override
    public String getName() {
        return "everyone";
    }
}
