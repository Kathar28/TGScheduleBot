package org.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;


public class ScheduleBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
        SendMessage message = new SendMessage();
        switch (update.getMessage().getText()) {
            case ("Hello"):
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(update.getMessage().getText());
                break;

        }
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public String getBotUsername() {
        return "ScheduleBot";
    }

    @Override
    public String getBotToken() {
        return "5393795445:AAHD-NFrBNjsxrsgOMs8oHhv6s34qYOMkkw";
    }

}
