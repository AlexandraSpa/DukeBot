package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;

public class PingCommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        environment.getEvent().getChannel().sendMessage("Pong!").queue();
    }

    @Override
    public String getName() {
        return "ping";
    }
}
