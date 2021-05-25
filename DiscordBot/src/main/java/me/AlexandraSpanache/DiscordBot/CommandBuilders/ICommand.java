package me.AlexandraSpanache.DiscordBot.CommandBuilders;

import java.util.List;

public interface ICommand {
    void handle(CommandEnvironment environment);
    String getName();

    //not all the commands have aliases
    default List<String> getAliases(){
        return List.of();
    }
}
