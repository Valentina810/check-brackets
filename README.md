### Проект развернут в песочнице openshift

При первом обращении может быть большой таймаут  
https://check-brackets-git-valentinakolesnikova-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/swagger-ui/index.html

### Инструкция по локальному развертыванию

- установить Docker Compose
- склонировать проект https://github.com/Valentina810/check-brackets.git
- открыть консоль, перейти в каталог проекта и выполнить команду docker-compose up
- сваггер приложения будет доступен по адресу http://localhost:8080/swagger-ui/index.html
- для остановки приложения нажать Ctrl+C, ввести docker-compose down