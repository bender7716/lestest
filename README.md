# CRM для мебельного производства

## В данной версии реализованы следующие функционалы:
 - CRUD операции для багетов, фрез и участков
 - CRUD операция для заказов с поддержкой каскадного создания и сохранения дочерних сущностей
 - Операции по началу и окончанию работ по технологическому процессу
 - Операции получения сведений по участкам с активными технологическими процессами

## Перез запуском приложения для удобства просмотра рекомендуется запустить скрипт resources/sql/order_number.sql для заполнения базы данных начальными значениями

## Для входа в систему необходимо использовать следующие данные:
- Логин - u
- Пароль - u

## Описание сущностей:
### Заказ (Order) - содержит основную информацию заказа на изготовление мебели.
### Багет (Baguette) - справочник, содержащий перечень багетов, используемых в заказе
### Фреза (Cutter) - справочник, содержащий перечень фрез, используемых в заказе
### Участок (Workplace) - справочник, содержащий перечень этапов (участков) технологического производства заказов
### Технологический процесс (Technological process) - содержит связи заказа с рабочими участками. Дополнительно в нем отражена последовательность прохождения заказа по этапам (участкам) технологического производства заказов

## Рабочий процесс приложения:
 - Создание заказа (POST /rest/order) - эндпоинт создания заказа совместно с дочерними элементами (технологическими процессами), справочные данные (багеты, фрезы, участки) указываются совместно с идентификаторами
 - Получение данных по участкам (GET /rest/workplace) с их активными технологическими процессами. Активный технологичейский процесс - технологический процесс, находящийся в производстве
 - Начало работ (GET /rest/technological-process/{id}/start-job {id} - идентификатор участка) по активному технологическому процессу
 - Завершение работ (GET /rest/technological-process/{id}/end-job {id} - идентификатор участка) по активному технологическому процессу
