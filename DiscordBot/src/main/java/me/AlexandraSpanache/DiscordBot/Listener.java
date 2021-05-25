package me.AlexandraSpanache.DiscordBot;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {
    private final CommandManager manager= new CommandManager();
    private final Bot bot;

    public Listener(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        event.getJDA().getPresence().setActivity(Activity.watching( " over " + event.getGuildTotalCount() + " servers." + "\nMaking my everyday an open source day."));
        System.out.println("Bot loaded successfully!");
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        User user= event.getAuthor();
        if(user.isBot() || event.isWebhookMessage()){
            return;
        }
        String raw = event.getMessage().getContentRaw();
                                      //prefix
        if(raw.equalsIgnoreCase(bot.getPrefix() + "shutdown") && event.getAuthor().getId().equals(bot.getOwnerId())){
            System.out.println("Shutting down..");
            event.getJDA().shutdown();

            return;
        }
        if(raw.startsWith(bot.getPrefix())){
            manager.handle(event, bot.getPrefix());
        }
    }
}
