import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class simpleBot extends TelegramLongPollingBot{

    boolean isAdmin = false;

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String chooseLan = "Тілді таңдаңыз:\nВыберите язык:";


                String command = message.getText();

                //language keyboard button
                ReplyKeyboardMarkup lanKeyboardMarkup = new ReplyKeyboardMarkup();
                KeyboardRow row = new KeyboardRow();
                List<KeyboardRow> keyboard = new ArrayList<>();
                row.add("Қазақша");
                row.add("На русском");
                keyboard.add(row);
                lanKeyboardMarkup.setKeyboard(keyboard);
                lanKeyboardMarkup.setResizeKeyboard(true);

                //qazaq keyboard button
                ReplyKeyboardMarkup qazKeyboardMarkup = new ReplyKeyboardMarkup();
                KeyboardRow qazRow = new KeyboardRow();
                List<KeyboardRow> qazKeyboard = new ArrayList<>();
                qazRow.add("Кітапхана");
                qazRow.add("Мәзір");
                qazRow.add("Фото");
                qazKeyboard.add(qazRow);
                qazRow = new KeyboardRow();

                if (!message.getChatId().toString().equals("696669739")){
                    qazRow.add("Админмен чат");
                }
                qazRow.add("Артқа");
                qazKeyboard.add(qazRow);
                qazKeyboardMarkup.setKeyboard(qazKeyboard);
                qazKeyboardMarkup.setResizeKeyboard(true);

                //russian keyboard button
                ReplyKeyboardMarkup rusKeyboardMarkup = new ReplyKeyboardMarkup();
                KeyboardRow rusRow = new KeyboardRow();
                List<KeyboardRow> rusKeyboard = new ArrayList<>();
                rusRow.add("Библиотека");
                rusRow.add("Меню");
                rusRow.add("Фото");
                rusKeyboard.add(rusRow);
                rusRow = new KeyboardRow();

                if (!message.getChatId().toString().equals("696669739")){
                    rusRow.add("Чат с админом");
                }
                rusRow.add("Назад");
                rusKeyboard.add(rusRow);
                rusKeyboardMarkup.setKeyboard(rusKeyboard);
                rusKeyboardMarkup.setResizeKeyboard(true);




                //Admin qaz chat
                ReplyKeyboardMarkup qazAdminKeyboardMarkup = new ReplyKeyboardMarkup();
                KeyboardRow qazAdminRow = new KeyboardRow();
                List<KeyboardRow> qazAdminKeyboard = new ArrayList<>();
                qazAdminRow.add("Аяқтау");
                qazAdminKeyboard.add(qazAdminRow);
                qazAdminKeyboardMarkup.setKeyboard(qazAdminKeyboard);
                qazAdminKeyboardMarkup.setResizeKeyboard(true);

                //Admin rus chat
                ReplyKeyboardMarkup rusAdminKeyboardMarkup = new ReplyKeyboardMarkup();
                KeyboardRow rusAdminRow = new KeyboardRow();
                List<KeyboardRow> rusAdminKeyboard = new ArrayList<>();
                rusAdminRow.add("Завершение");
                rusAdminKeyboard.add(rusAdminRow);
                rusAdminKeyboardMarkup.setKeyboard(rusAdminKeyboard);
                rusAdminKeyboardMarkup.setResizeKeyboard(true);





                if (command.equals("/start") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text(chooseLan)
                            .chatId(message.getChatId().toString())
                            .replyMarkup(lanKeyboardMarkup)
                            .build());


                }
                //qaz
                else if (command.equals("Қазақша") && !isAdmin ) {
                    execute(SendMessage.builder()
                            .text("Біздің кафеге қош келдіңіз!")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(qazKeyboardMarkup)
                            .build());
                } else if (command.equals("Артқа") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text(chooseLan)
                            .chatId(message.getChatId().toString())
                            .replyMarkup(lanKeyboardMarkup)
                            .build());
                } else if (command.equals("Мәзір") && !isAdmin) {

                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu1.jpg")))
                            .caption("Таңғы ас")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu2.jpg")))
                            .caption("Латте")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu3.jpg")))
                            .caption("Сусындар")
                            .build());


                } else if ((command.equals("Кітапхана") || command.equals("Библиотека") ) && !isAdmin) {
                    execute(SendMessage.builder()
                            .text(new String(Files.readAllBytes(Paths.get("src/main/resources/files/books.txt"))))
                            .chatId(message.getChatId().toString())
                            .build());

                }
                else if (command.equals("Фото") && !isAdmin) {

                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/Woo1.png")))
                            .caption("")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/Woo2.png")))
                            .caption("")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/Woo3.png")))
                            .caption("")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/Woo4.png")))
                            .caption("")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/Woo5.png")))
                            .caption("")
                            .build());
                }
                else if (command.equals("Админмен чат") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text("Админнің жеке чатына @nurtorequrmanqoja\nнемесе төменге хабарламаңызды жазыңыз\nАдмин сізге жақын арада жауап беретін болады:")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(qazAdminKeyboardMarkup)
                            .build());
                    isAdmin = true;




                }
                else if (!command.equals("Аяқтау") && !command.equals("Завершение") && isAdmin){
                    if (message.getChatId().toString().equals("696669739")){
                        String[] messageList = command.split(" ");
                        String clientChatId = messageList[0];
                        String messageToClient = "";
                        for (int i = 1; i < messageList.length; i++){
                            messageToClient += messageList[i] + " ";
                        }
                        execute(SendMessage.builder()
                                .text(messageToClient)
                                .chatId(clientChatId)
                                .build());

                    }
                    else if (!message.getChatId().toString().equals("696669739")){
                        String messageToAdmin = "Client name: " + message.getChat().getFirstName() +  " " + message.getChat().getLastName() + "\n"
                                + "Client username: @" + message.getChat().getUserName() +"\n"
                                + "Client chat ID: " + message.getChatId() +"\n"
                                + "Client message: \"" + command + "\"";
                        execute(SendMessage.builder()
                                .text(messageToAdmin)
                                .chatId("696669739")
                                .build());

                    }
                }
                else if (command.equals("Аяқтау") && !message.getChatId().toString().equals("696669739")){
                    isAdmin = false;
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Сәтті аяқталды!")
                            .replyMarkup(qazKeyboardMarkup)
                            .build());
                }






                //rus
                else if (command.equals("На русском") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text("Добро пожаловать в наше кафе!")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(rusKeyboardMarkup)
                            .build());
                } else if (command.equals("Меню") && !isAdmin) {
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu1.jpg")))
                            .caption("Завтраки")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu2.jpg")))
                            .caption("Латте")
                            .build());
                    execute(SendPhoto.builder()
                            .chatId(message.getChatId().toString())
                            .photo(new InputFile(new File("src/main/resources/image/menu3.jpg")))
                            .caption("Напитки")
                            .build());
                } else if (command.equals("Чат с админом") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text("Напишите свое сообщение в личный чат администратора @nurtorequrmanqoja\n или ниже\nАдмин ответит вам в ближайшее время:")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(rusAdminKeyboardMarkup)
                            .build());
                    isAdmin = true;
                }

                else if (command.equals("Завершение") && !message.getChatId().toString().equals("696669739")){
                    isAdmin = false;
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Успешно завершено!")
                            .replyMarkup(rusKeyboardMarkup)
                            .build());
                }
                else if (command.equals("Назад") && !isAdmin) {
                    execute(SendMessage.builder()
                            .text(chooseLan)
                            .chatId(message.getChatId().toString())
                            .replyMarkup(lanKeyboardMarkup)
                            .build());
                }

            }
        }

    }




    @Override
    public String getBotUsername() {
        // TODO
        return "WooCupCoffeeBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5338052218:AAHo_g6mtcmlcGANtgQn6GYwO9BlI41JsnY";
    }




}
