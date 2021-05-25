package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class InterfacesCommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        if( environment.getArgs().isEmpty()){
            EmbedBuilder response = new EmbedBuilder();
            response.setTitle("Interfaces");
            response.setDescription("In the Java programming language, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Method bodies exist only for default methods and static methods. Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces. Extension is discussed later in this lesson.");
            response.addField("","For further information, check the command '~interfaces more'.", false);
            response.setColor(0x997500);
            environment.getEvent().getChannel().sendMessage(response.build()).queue();
            response.clear();
        }
        if( environment.getArgs().contains("more") ){
            RSSFeedReader reader= new RSSFeedReader();
            try {
                reader.setFeed("https://rss.app/feeds/qMhV6imYbFS5lr2Q.xml");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (FeedException e) {
                e.printStackTrace();
            }
            SyndEntry tutorial= reader.getContent();
            environment.getEvent().getChannel().sendMessage("This might help you " + "!\n" + tutorial.getLink()).queue();
        }
    }

    @Override
    public String getName() {
        return "interfaces";
    }
}
