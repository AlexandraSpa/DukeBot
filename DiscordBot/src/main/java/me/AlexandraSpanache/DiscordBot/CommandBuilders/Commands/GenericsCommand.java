package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.CommandEnvironment;
import me.AlexandraSpanache.DiscordBot.CommandBuilders.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class GenericsCommand implements ICommand {
    @Override
    public void handle(CommandEnvironment environment) {
        if( environment.getArgs().isEmpty()){
            EmbedBuilder response = new EmbedBuilder();
            response.setTitle("Generics");
            response.setDescription("""
                    In any nontrivial software project, bugs are simply a fact of life. Careful planning, programming, and testing can help reduce their pervasiveness, but somehow, somewhere, they'll always find a way to creep into your code. This becomes especially apparent as new features are introduced and your code base grows in size and complexity.

                    Fortunately, some bugs are easier to detect than others. Compile-time bugs, for example, can be detected early on; you can use the compiler's error messages to figure out what the problem is and fix it, right then and there. Runtime bugs, however, can be much more problematic; they don't always surface immediately, and when they do, it may be at a point in the program that is far removed from the actual cause of the problem.

                    Generics add stability to your code by making more of your bugs detectable at compile time.\s""");
            response.addField("","For further information, check the command '~generics more'.", false);
            response.setColor(0x997500);
            environment.getEvent().getChannel().sendMessage(response.build()).queue();
            response.clear();
        }
        if( environment.getArgs().contains("more") ){
            RSSFeedReader reader= new RSSFeedReader();
            try {
                reader.setFeed("https://rss.app/feeds/Bq9BKis75YcXkXzJ.xml");
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
        return "generics";
    }
}
