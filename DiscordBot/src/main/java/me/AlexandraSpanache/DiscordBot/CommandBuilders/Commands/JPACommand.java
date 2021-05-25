package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class JPACommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        if( environment.getArgs().contains("tutorial") ){
            RSSFeedReader reader= new RSSFeedReader();
            try {
                reader.setFeed("https://rss.app/feeds/4fCVyVTcJcn6Q1Hq.xml");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (FeedException e) {
                e.printStackTrace();
            }
            SyndEntry tutorial= reader.getContent();
            environment.getEvent().getChannel().sendMessage("Check out this tutorial from " + tutorial.getAuthor() +"!\n" + tutorial.getLink()).queue();
        }
        if( environment.getArgs().isEmpty()){
            EmbedBuilder response = new EmbedBuilder();
            response.setTitle("JPA");
            response.setDescription("Object/relational mapping specifications for managing relational data in Java applications");
            response.addField("Creator","Alexandra Spanache", false);
            response.setColor(0x997500);
            environment.getEvent().getChannel().sendMessage(response.build()).queue();
            response.clear();
        }
    }

    @Override
    public String getName() {
        return "jpa";
    }
}
