# Модель прецедентів

<h2><span style="color: black;"> Діаграма прецедентів </span></h2>

@startuml

actor "Administrator" as Administrator
actor "Moderator" as Moderator
actor "User" as User
actor "Guest" as Guest

usecase "<b>UCA_1.1</b>\nНадати права\n модератора користувачу" as UCA_1.1
usecase "<b>UCA_1.2</b>\nВидалити права модератора\n у користувача/модератора" as UCA_1.2
usecase "<b>UCA_1.3</b>\nВидалити акаунт\n користувача" as UCA_1.3
usecase "<b>UCA_1.4</b>\nДодати dataset" as UCA_1.4
usecase "<b>UCA_1.5</b>\nВидалити dataset" as UCA_1.5

Administrator -r-> UCA_1.5
Administrator -r-> UCA_1.4
Administrator -r-> UCA_1.3
Administrator -r-> UCA_1.2
Administrator -r-> UCA_1.1


usecase "<b>UCE_2.1</b>\nДодати dataset\n користувача" as UCE_2.1
usecase "<b>UCE_2.2</b>\nВидалити dataset" as UCE_2.2
usecase "<b>UCE_2.3</b>\nВидалити користувача" as UCE_2.3

Moderator -r-> UCE_2.3
Moderator -r-> UCE_2.2
Moderator -r-> UCE_2.1

usecase "<b>UCU_3.1</b>\nПошук даних" as UCU_3.1
usecase "<b>UCU_3.2</b>\nВізуалізація даних\n у вигляді таблиці" as UCU_3.2
usecase "<b>UCU_3.3</b>\nЗберегти дані" as UCU_3.3
usecase "<b>UCU_3.4</b>\nДодати dataset" as UCU_3.4

User -r-> UCU_3.4
User -r-> UCU_3.3
User -r-> UCU_3.2
User -r-> UCU_3.1

usecase "<b>UCU_4.1</b>\nРеєстрація у системі" as UCU_4.1
usecase "<b>UCU_4.2</b>\nПошук даних" as UCU_4.2
usecase "<b>UCU_4.3</b>\nВізуалізація даних\n у вигляді таблиці" as UCU_4.3

Guest -r-> UCU_4.3
Guest -r-> UCU_4.2
Guest -r-> UCU_4.1



Administrator -d-|> Moderator
Moderator -d-|> User
User -d-|> Guest
@enduml


<h2><span style="color: black;"> Схема використання для адміністратора </span></h2>

@startuml

actor "Admin" as Admin

usecase "<b>UCA_3</b>\nРедагувати дані" as UCA_3 #0000FF
usecase "<b>UCA_2</b>\nКонтролювати акаунт користувача" as UCA_2 #0000FF
usecase "<b>UCA_1</b>\nНадавати та забирати\n права модератора" as UCA_1 #0000FF

Admin -l-> UCA_1
Admin -u-> UCA_2
Admin -r-> UCA_3

usecase "<b>UCA_1.4</b>\nДодати dataset" as UCA_1.4
usecase "<b>UCA_1.5</b>\nВидалити dataset" as UCA_1.5

UCA_1.4 ..> UCA_3 :extends
UCA_1.5 ..> UCA_3 :extends


usecase "<b>UCA_1.3</b>\nВидалити акаунт\n користувача" as UCA_1.3

UCA_1.3 ..> UCA_2 :extends

usecase "<b>UCA_1.2</b>\nВидалити права модератора\n у користувача/модератора" as UCA_1.2
usecase "<b>UCA_1.1</b>\nНадати права модератора\n користувачу" as UCA_1.1

UCA_1.2 ..> UCA_1 :extends
UCA_1.1 ..> UCA_1 :extends

@enduml


<h2><span style="color: black;"> Схема використання для модератора </span></h2>

@startuml

actor "Moderator" as Moderator

usecase "<b>UCM_1</b>\nРедагувати дані" as UCM_1 #FFFF00
usecase "<b>UCM_2</b>\nКонтролювати користувача" as UCM_2 #FFFF00


Moderator -l-> UCM_1
Moderator -r-> UCM_2


usecase "<b>UCM_2.1</b>\nДодати dataset користувача" as UCM_2.1
usecase "<b>UCM_2.2</b>\nВидалити dataset" as UCM_2.2

UCM_2.1 ..> UCM_1 :extends
UCM_2.2 ..> UCM_1 :extends


usecase "<b>UCM_2.3</b>\nВидалити акаунт\n користувача" as UCM_2.3

UCM_2.3 ..> UCM_2 :extends


@enduml


<h2><span style="color: black;"> Схема використання для користувача </span></h2>

@startuml

actor "User" as User

usecase "<b>UCU_1</b>\nПошук та візуалізація\n даних" as UCU_1 #FF0000
usecase "<b>UCU_2</b>\nЗбереження та завантаження\n даних" as UCU_2 #FF0000


User -l-> UCU_1
User -r-> UCU_2


usecase "<b>UCU_3.1</b>\nПошук даних" as UCU_3.1
usecase "<b>UCU_3.2</b>\nВізуалізація даних\n у вигляді таблиці" as UCU_3.2

UCU_3.1 ..> UCU_1 :extends
UCU_3.2 ..> UCU_1 :extends


usecase "<b>UCU_3.3</b>\nЗберегти дані" as UCU_3.3
usecase "<b>UCU_3.4</b>\nДодати dataset" as UCU_3.4

UCU_3.3 ..> UCU_2 :extends
UCU_3.4 ..> UCU_2 :extends


@enduml


<h2><span style="color: black;"> Сценарії для адміністратора </span></h2>

***ID:***  Use-Case Administrator (UCA) 1.4

***НАЗВА:*** Додати dataset

***УЧАСНИКИ:*** Адміністратор, система

***ПЕРЕДУМОВИ:*** Адміністратор авторизований

***РЕЗУЛЬТАТ:*** Dataset додано

***ВИКЛЮЧНІ СИТУАЦІЇ:*** 

UCA-Ex-1.4.1 - Dataset порожній

UCA-Ex-1.4.2 - Такий Dataset вже існує

UCA-Ex-1.4.3 - Адміністратор скасував зміни

***ОСНОВНИЙ СЦЕНАРІЙ:*** 
1. Адміністратор натискає кнопку “Додати дані”
2. Адміністратор вибирає файл
3. Система сканує файл
4. Можливе виникнення UCA-Ex-1.4.1 та UCA-Ex-1.4.2 
4. Система запитує підтвердження на додавання нових даних
5. Можливе виникнення ECA-Ex-1.4.3
6. Адміністратор підтверджує зміни

@startuml

<style>
    note {
        BackgroundColor #FF6138
    }
</style>


|#284dc7|Адміністратор|
start
:Натискає кнопку "Додати дані";
:Вибирає файл;
|#f9fc28|Система|
:Сканує файл;
note right: EX_UCA_1.4.1: Dataset порожній
note right: EX_UCA_1.4.1: Dataset вже існує
:Запитує підтвердження;
note right: EX_UCA_1.4.3: Адміністратор\n скасував зміни
|Адміністратор|
:Підтверджує зміни;
stop
@enduml

***ID:***  Use-Case Administrator (UCA) 1.5

***НАЗВА:*** Видалити dataset

***УЧАСНИКИ:*** Адміністратор, система

***ПЕРЕДУМОВИ:*** Адміністратор авторизований

***РЕЗУЛЬТАТ:*** Dataset видалено

***ВИКЛЮЧНІ СИТУАЦІЇ:*** 

 UCA-Ex-1.5.1 - Dataset не існує

UCA-Ex-1.5.2 - Адміністратор скасував зміни

***ОСНОВНИЙ СЦЕНАРІЙ:*** 
1. Адміністратор виконує пошук dataset-у
2. Можливе виникнення  UCA-Ex-1.5.1
3. Система відображає результати пошуку
4. Адміністратор вибирає dataset
5. Адміністратор натискає кнопку “Видалити” 
5. Система запитує підтвердження
6. Можливе виникнення ECA-Ex-1.5.2
7. Адміністратор підтверджує зміни

@startuml

<style>
    note {
        BackgroundColor #FF6138
    }
</style>

|#284dc7|Адміністратор|
start
:Пошук dataset'y;
|#f9fc28|Система|
:Відображає результати пошуку;
note right: UCA-Ex-1.5.1: Dataset не існує
|Адміністратор|
:Вибирає dataset;
:Натискає кнопку "Bидалити";
|Система|
:Запитує підтвердження;
note right: UCA-Ex-1.5.2: Адміністратор\n скасував зміни
|Адміністратор|
:Підтверджує зміни;
stop
@enduml







<hr>
<hr>
<hr>
<hr>
В цьому файлі необхідно перелічити всі документи, розроблені в проекті та дати посилання на них.

*Модель прецедентів повинна містити загальні оглядові діаграми та специфікації прецедентів.*



Вбудовування зображень діаграм здійснюється з використанням сервісу [plantuml.com](https://plantuml.com/). 

В markdown-файлі використовується опис діаграми

```md

<center style="
    border-radius:4px;
    border: 1px solid #cfd7e6;
    box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
    padding: 1em;"
>

@startuml

    right header
        <font size=24 color=black>Package: <b>UCD_3.0
    end header

    title
        <font size=18 color=black>UC_8. Редагувати конфігурацію порталу
        <font size=16 color=black>Діаграма прецедентів
    end title


    actor "Користувач" as User #eeeeaa
    
    package UCD_1{
        usecase "<b>UC_1</b>\nПереглянути список \nзвітів" as UC_1 #aaeeaa
    }
    
    usecase "<b>UC_1.1</b>\nЗастосувати фільтр" as UC_1.1
    usecase "<b>UC_1.2</b>\nПереглянути метадані \nзвіту" as UC_1.2  
    usecase "<b>UC_1.2.1</b>\nДати оцінку звіту" as UC_1.2.1  
    usecase "<b>UC_1.2.2</b>\nПереглянути інформацію \nпро авторів звіту" as UC_1.2.2
    
    package UCD_1 {
        usecase "<b>UC_4</b>\nВикликати звіт" as UC_4 #aaeeaa
    }
    
    usecase "<b>UC_1.1.1</b>\n Використати \nпошукові теги" as UC_1.1.1  
    usecase "<b>UC_1.1.2</b>\n Використати \nрядок пошуку" as UC_1.1.2
    usecase "<b>UC_1.1.3</b>\n Використати \nавторів" as UC_1.1.3  
    
    
    
    User -> UC_1
    UC_1.1 .u.> UC_1 :extends
    UC_1.2 .u.> UC_1 :extends
    UC_4 .d.> UC_1.2 :extends
    UC_1.2 .> UC_1.2 :extends
    UC_1.2.1 .u.> UC_1.2 :extends
    UC_1.2.2 .u.> UC_1.2 :extends
    UC_1 ..> UC_1.2.2 :extends
    
    
    UC_1.1.1 -u-|> UC_1.1
    UC_1.1.2 -u-|> UC_1.1
    UC_1.1.3 -u-|> UC_1.1
    
    right footer
        Аналітичний портал. Модель прецедентів.
        НТУУ КПІ ім.І.Сікорського
        Киів-2020
    end footer

@enduml

**Діаграма прецедентів**

</center>
```

яка буде відображена наступним чином

<center style="
    border-radius:4px;
    border: 1px solid #cfd7e6;
    box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
    padding: 1em;"
>

@startuml

    right header
        <font size=24 color=black>Package: <b>UCD_3.0
    end header

    title
        <font size=18 color=black>UC_8. Редагувати конфігурацію порталу
        <font size=16 color=black>Діаграма прецедентів
    end title


    actor "Користувач" as User #eeeeaa
    
    package UCD_1{
        usecase "<b>UC_1</b>\nПереглянути список \nзвітів" as UC_1 #aaeeaa
    }
    
    usecase "<b>UC_1.1</b>\nЗастосувати фільтр" as UC_1.1
    usecase "<b>UC_1.2</b>\nПереглянути метадані \nзвіту" as UC_1.2  
    usecase "<b>UC_1.2.1</b>\nДати оцінку звіту" as UC_1.2.1  
    usecase "<b>UC_1.2.2</b>\nПереглянути інформацію \nпро авторів звіту" as UC_1.2.2
    
    package UCD_1 {
        usecase "<b>UC_4</b>\nВикликати звіт" as UC_4 #aaeeaa
    }
    
    usecase "<b>UC_1.1.1</b>\n Використати \nпошукові теги" as UC_1.1.1  
    usecase "<b>UC_1.1.2</b>\n Використати \nрядок пошуку" as UC_1.1.2
    usecase "<b>UC_1.1.3</b>\n Використати \nавторів" as UC_1.1.3  
    
    
    
    User -> UC_1
    UC_1.1 .u.> UC_1 :extends
    UC_1.2 .u.> UC_1 :extends
    UC_4 .d.> UC_1.2 :extends
    UC_1.2 .> UC_1.2 :extends
    UC_1.2.1 .u.> UC_1.2 :extends
    UC_1.2.2 .u.> UC_1.2 :extends
    UC_1 ..> UC_1.2.2 :extends
    
    
    UC_1.1.1 -u-|> UC_1.1
    UC_1.1.2 -u-|> UC_1.1
    UC_1.1.3 -u-|> UC_1.1
    
    right footer
        Аналітичний портал. Модель прецедентів.
        НТУУ КПІ ім.І.Сікорського
        Киів-2020
    end footer

@enduml

**Діаграма прецедентів**

</center>

