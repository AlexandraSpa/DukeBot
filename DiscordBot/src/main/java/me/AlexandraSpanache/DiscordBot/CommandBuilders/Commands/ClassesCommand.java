package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class ClassesCommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        if( environment.getArgs().isEmpty()){
            EmbedBuilder response = new EmbedBuilder();
            response.setTitle("What is a class?");
            response.setDescription("A class is a blueprint or prototype from which objects are created. This section defines a class that models the state and behavior of a real-world object. It intentionally focuses on the basics, showing how even a simple class can cleanly model state and behavior.");
            response.addField("","For further information, check the command '~classes more'.", false);
            response.setColor(0x997500);
            environment.getEvent().getChannel().sendMessage(response.build()).queue();
            response.clear();
        }
        if( environment.getArgs().contains("more") ){
            RSSFeedReader reader= new RSSFeedReader();
            try {
                reader.setFeed("https://rss.app/feeds/IAKkjzEI4sXIYUOi.xml");
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
        return "classes";
    }
}
