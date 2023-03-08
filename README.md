## Инфо о проекте

E2E тесты для сайта fap-house
stack: Java / Gradle / JUnit5 / Selenide / Allure 

## Для запуска тестов

Конфигурация запуска тестов настраивается в gradle.properties, где 
    web.thread - количество параллельных потоков для запуска
    browser.name - браузер на котором требуется запустить тесты

Для запуска тестов можно использовать junit или использовать команду
`gradle clean test`

Для генерации отчетов:
`gradle allureServe`
