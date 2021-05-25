package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class CollectionsCommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        if( environment.getArgs().isEmpty()){
            EmbedBuilder response = new EmbedBuilder();
            response.setTitle("Collections");
            response.setDescription("A collection is an object that groups multiple elements into a single unit.");
            response.addField("Vectors, Lists, Stacks, Sets, Dictionaries, Tables, etc.","", false);
            response.addField("Promotes software reuse","", false);
            response.addField("Reduces programming effort","", false);
            response.addField("Increases program speed and quality","", false);
            response.addField("","For further information, check the command '~collections more'.", false);
            response.setColor(0x997500);
            environment.getEvent().getChannel().sendMessage(response.build()).queue();
            response.clear();
        }
        if( environment.getArgs().contains("more") ){
            RSSFeedReader reader= new RSSFeedReader();
            try {
                reader.setFeed("https://rss.app/feeds/OLsZe1xHnRC3nUlX.xml");
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
        return "collections";
    }
}
