package org.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Application {
        public static void main(String args[]) {

        try{
            TelegramBotsApi scheduleBot = new TelegramBotsApi(DefaultBotSession.class);
            scheduleBot.registerBot(new ScheduleBot());

        }catch (TelegramApiException e ){
            e.printStackTrace();
        }

        }
    }