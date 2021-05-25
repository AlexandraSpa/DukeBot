package me.AlexandraSpanache.DiscordBot.CommandBuilders;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class CommandEnvironment {
    private final GuildMessageReceivedEvent event;
    private final List<String> args;

    public CommandEnvironment(GuildMessageReceivedEvent event, List<String> args) {
        this.event = event;
        this.args = args;
    }

    public GuildMessageReceivedEvent getEvent() {
        return event;
    }

    public List<String> getArgs() {
        return args;
    }

    public Guild getGuild(){
        return this.getEvent().getGuild();
    }
}
