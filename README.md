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
 ![image](https://github.com/user-attachments/assets/d3fa1685-8fe9-4170-988e-3ece068f3157)


    
