package Main;

import Main.Class.Event;
import Main.Class.User;
import Main.Data.staticData;
import Main.Utils.DataUtil;
import Main.Utils.InitUtil;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;


/**
 * 程序入口
 */
@SpringBootApplication
public class Main {

    public static staticData staticData = new staticData();


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        staticData.bot.login();
        afterLogin(staticData.bot);
        InitUtil.init();
//        SpringApplication.run(Main.class, args);


    }

    public static void afterLogin(Bot bot) {


        //好友信息
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {

        });
        bot.getEventChannel().subscribeAlways(GroupMessageEvent.class, (event) -> {

            for (Event e : staticData.perMissionData.events.values()
            ) {
                e.passEvent(event.getMessage().contentToString(), event.getGroup(), event.getSender());
            }

        });


    }
}
