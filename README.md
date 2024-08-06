# translator_lab
ТЗ: Вам необходимо разработать веб-приложение на языке Java/Kotlin для перевода набора слов на другой язык с использованием стороннего сервиса перевода (Яндекс, Google или др.).

Требования к программе:

Приложение должно принимать на вход строку, состоящую из набора слов, исходный язык и целевой язык в качестве параметров для перевода. В ответе программа должна вернуть переведенную строку.
Каждое слово должно быть переведено отдельно в нескольких потоках. При этом число одновременно работающих потоков не должно превышать 10.
Приложение должно сохранять в реляционную базу данных информацию о запросе: IP-адрес пользователя, входную строку для перевода и результат перевода. Структуру хранения нужно придумать самостоятельно.
Код программы должен быть выложен на github и содержать readme — инструкции по запуску приложения и как его использовать.
Дополнительные требования:

Можно использовать фреймворк Spring/SpringBoot
Для базы данных использовать только JDBC
Для вызова внешней системы использовать RestTemplate

Инструкция:

 - запускаем MAMP, чтобы работала база данных.
 - открываем код из репозитория и запускаем, например в IntelliJ IDEA
 - заходим на http://localhost:8080/mytranslator
![image](https://github.com/user-attachments/assets/1f1af138-5b98-4094-8278-9a875dfb4f82)
 - в поле 1 воодим слова для перевода
 - в поле 2 - код языка с которого хотим перевести
 - в поле 3 - код языка на который хотим перевести
 - код языка можно посмотреть на https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%B4%D1%8B_%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%B2
 - после заполнения полей 1, 2, 3 можно нажать на кнопочку 4 и увидеть ответ после слова ansewr (на картинке подчеркнуто бирюзовым)
 - можно повторно вводить новые слова для перевода и получать ответ так же
 - нажав на кнопку 5 можно узнать историю запросов разных пользователей
 - ![image](https://github.com/user-attachments/assets/533d72b0-b656-4e01-8758-9883e64665bc)
 - для нелюбителей стрелочки назад, есть кнопка back сверху :)

 - в случае неуспеха запуска сервиса, можно посмотреть видео с инструкцией по запуску и тестированием сервиса: https://www.youtube.com/watch?v=4my3l5NWnkg




    
