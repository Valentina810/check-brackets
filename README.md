### Инструкция по локальному развертыванию

- установить Docker Compose
- склонировать проект https://github.com/Valentina810/check-brackets.git
- открыть консоль, перейти в каталог проекта и выполнить команду docker-compose up
- сваггер приложения будет доступен по адресу http://localhost:8080/swagger-ui/index.html
- для остановки приложения нажать Ctrl+C, ввести docker-compose down

### Задание 

[Ссылка на задание](https://beautifulcode.sber.ru/task/java)

Нам нужно создать приложение, которое поможет людям понять, правильно ли они расставили скобки в своем тексте. И, казалось бы, задача простая и известная - проверить открывающие и закрывающие пары. Но вот в чем соль: мы хотим, чтобы между этими скобками всегда был какой-то текст. То есть пустые скобки у нас тут не пройдут, они считаются некорректной штукой.

Помимо этого, для нашего приложения уже сделали и сайт, и мобилку. Поэтому нам следует разработать именно веб-сервис.

Итак, пример запроса:

POST /api/checkBrackets

```
{
"text": "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. 
Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). 
В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, 
когда мы подошли ближе к вершине горы, небо стало покрываться облаками, (как будто природа 
готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, особенно 
когда мы достигли высшей точки и увидели прекрасный вид на долину (я почувствовал, 
что все усилия стоили того)."
}
```

Пример ответа для корректного текста:

```
{
"isCorrect" : true
}
```

Пример ответа для некорректного текста:

```
{
"isCorrect" : false
}
```

Поскольку без тестов ничего в прод не заливаем, следует их предусмотреть для корректного и некорректного случая. Также надо задуматься над архитектурой и следовать принципам SOLID - вдруг приложение “выстрелит” и мы захотим его доработать ;). Не забываем про обработку входных данных - не следует обрабатывать пустой текст. И правило хорошего тона - задокументировать наш API!

Также обязательно включить в решение README.md файл с инструкцией по развертыванию.

Удачи!

### Improvements:
- [X] свернуть тесты в параметеризованные
- [X] оптимизация метода checkBracketsInText() 
