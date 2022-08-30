package io.github.cyklon73.cytils.api.discord.comp;

public enum GuildFeature {
    ANIMATED_BANNER, //guild has access to set an animated guild banner image
    ANIMATED_ICON, //guild has access to set an animated guild icon
    AUTO_MODERATION, //guild has set up auto moderation rules
    BANNER, //guild has access to set a guild banner image
    COMMUNITY, //guild can enable welcome screen, Membership Screening, stage channels and discovery, and receives community updates
    DISCOVERABLE, //guild is able to be discovered in the directory
    FEATURABLE, //guild is able to be featured in the directory
    INVITE_SPLASH, //guild has access to set an invite splash background
    MEMBER_VERIFICATION_GATE_ENABLED, //guild has enabled Membership Screening
    MONETIZATION_ENABLED, //guild has enabled monetization
    MORE_STICKERS, //guild has increased custom sticker slots
    NEWS, //guild has access to create news channels
    PARTNERED, //guild is partnered
    PREVIEW_ENABLED, //guild can be previewed before joining via Membership Screening or the directory
    PRIVATE_THREADS, //guild has access to create private threads
    ROLE_ICONS, //guild is able to set role icons
    TICKETED_EVENTS_ENABLED, //guild has enabled ticketed events
    VANITY_URL, //guild has access to set a vanity URL
    VERIFIED, //guild is verified
    VIP_REGIONS, //guild has access to set 384kbps bitrate in voice (previously VIP voice servers)
    WELCOME_SCREEN_ENABLED; //guild has enabled the welcome screen
}
