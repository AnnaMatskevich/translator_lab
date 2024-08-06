<!DOCTYPE html>
<!--<html xmlns:th="http://www.thymeleaf.org">-->
<html>
<body>

<div class = "container mt-5 mb-5">
    <h1>Translate</h1>
    <form action="/mytranslator" method = "post">
        <input type="text" name = "text" placeholder = "I want to translate" class = "form-control"><br>
        <input type="text" name = "sourceLanguageCode" placeholder = "source language code" class = "form-control"><br>
        <input type="text" name = "targetLanguageCode" placeholder = "target language code" class = "form-control"><br>
            <button type="submit" class = "btn btn-success">translate</button>
    </form>
</div>


<div>answer: ${answer}</div>

<div class = "container mt-5 mb-5">
    <form action="/mytranslator/requests_history" method = "get">
        <button type="submit" class="btn btn-success">get requests history</button>
    </form>
</div>

</body>
</html>

