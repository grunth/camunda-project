Чтобы запустить понадобится doker и doker-compose:
1. запуск: в папке docker выполнить: docker-compose up
camunda будет по адресу http://localhost:8090/
login/pass: demo/1234
Админка EXCAMAD :http://localhost:8090/index.html#/
API camundы доступно по адресу: http://localhost:8090/engine-rest/
Документация по API: https://docs.camunda.org/manual/7.14/reference/rest/
2. удаление проекта: docker-compose down

Создал пример бизнес процесса "Отпуск".
1. Деплой проекта в camunda: в postman выполняем:
POST: http://localhost:8090/engine-rest/deployment/create
cotent/type: multipart/form-data, body: upload - отпуск.bpmn
Должны получить ответ в виде JSON с id процесса.
image (4).png
В camunda будет следующая ситуация:
image (3).png
2. Запуск процесса с помощью API:
Подставляем key из ответа предыдущего запроса
http://localhost:8090/engine-rest/process-definition/key/Process_Vocation_id/start
content type: application/json
body: пустой JSON {}
image (7).png
В camunda это будет выглядеть так:
image (6).png
И.т.д. документация по API comundы: https://docs.camunda.org/manual/latest/reference/rest/
еще примеры REST запросов:
http://localhost:8090/engine-rest/task - все открытые задачи
http://localhost:8090/engine-rest/task/81d585fc-4044-11eb-aa64-00ff2474f1bb/claim - назначить задачу
http://localhost:8090/engine-rest/task/81d585fc-4044-11eb-aa64-00ff2474f1bb/complete - Завершить задачу