package me.AlexandraSpanache.DiscordBot;

import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands.*;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {

        addCommand(new JPACommand());
        addCommand(new CollectionsCommand());
        addCommand(new InterfacesCommand());
        addCommand(new GenericsCommand());
        addCommand(new ObjectCommand());
        addCommand(new ClassesCommand());
    }

    private void addCommand(ICommand newCommand){
        for (ICommand command: commands) {
            if(command.getName().equals(newCommand.getName())){
                throw new IllegalArgumentException("The name of the command is already in use!");
            }
        }
        commands.add(newCommand);
    }
    private ICommand getCommand(String name){
        String nameLower = name.toLowerCase();
        for (ICommand command: commands) {
            if(command.getName().equals(nameLower) || command.getAliases().contains(nameLower)){
                return command;
            }
        }
        return null;
    }
    public void handle(GuildMessageReceivedEvent event, String botPrefix){
        String [] rawSplit = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(botPrefix),"")
                .split("\\s+");
        String rawSplitLower= rawSplit[0].toLowerCase();
        ICommand command= this.getCommand(rawSplitLower);
        if(command!= null){
            event.getChannel().sendTyping().queue();
            List<String> args= Arrays.asList(rawSplit).subList(1, rawSplit.length);

            CommandEnvironment environment= new CommandEnvironment(event, args);

            command.handle(environment);
        }

        }
}
