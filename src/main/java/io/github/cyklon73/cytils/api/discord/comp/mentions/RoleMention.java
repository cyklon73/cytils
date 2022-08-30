package io.github.cyklon73.cytils.api.discord.comp.mentions;

import io.github.cyklon73.cytils.api.discord.comp.Role;
import io.github.cyklon73.cytils.api.discord.comp.User;

public class RoleMention implements Mention {

    public RoleMention() {}

    @Override
    public String getName() {
        return "roles";
    }
}
