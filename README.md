# Сервис NASA Astronomy Picture of the Day

Этот проект является Spring Boot приложением, которое взаимодействует с API NASA Astronomy Picture of the Day (APOD). Оно получает картинку дня и возвращает её URL. Если URL указывает на видео YouTube, то возвращает URL превью изображения.

## Содержание
- [Предварительные требования](#предварительные-требования)
- [Начало работы](#начало-работы)
- [Сборка и запуск](#сборка-и-запуск)
- [Запуск с использованием Docker](#запуск-с-использованием-docker)
- [Конечные точки](#конечные-точки)
- [Контакты](#контакты)

## Предварительные требования

- Java 17
- Gradle
- Docker 

## Начало работы

1. **Клонирование репозитория:**
    ```sh
    git clone https://github.com/ваш-логин/nasa-apod-service.git
    cd nasa-apod-service
    ```

2. **Запросите API ключ от NASA:**
    - Перейдите на [NASA API](https://api.nasa.gov/)
    - Зарегистрируйтесь и запросите API ключ


## Сборка и запуск
- Соберите проект с использованием Gradle:./gradlew build
- Запустите проект : ./gradlew bootRun

## Запуск с использованием Docker
- Соберите Docker-образ:docker build -t nasa-service .
- Запустите Docker-контейнер: docker run -p 8080:8080 nasa-service

## Конечные точки
**GET /api/picture** - - Получает URL изображения дня от NASA.

## Контакты 
- **email** : den.gitelman@gmail.com
- **tg**: t.me/f0rtunaaz

