# Проєктування бази даних

В рамках проекту розробляється: 
- модель бізнес-об'єктів
- ER-модель
- реляційна схема

<hr>

<h2>Mодель бізнес-об'єктів</h2>

@startuml

entity user #09ADA5

entity nickname
entity email 
entity password
nickname --* user
email --* user
password --* user

entity business_role #82FA58
business_role "1"--* user

entity business.name
business.name --* business_role

entity request_status #82FA58

entity status 
status --* request_status

entity dataset #82FA58
dataset "0,*" --* user

entity id
entity dataset.name
entity creation_data
id --* dataset
dataset.name --* dataset
creation_data --* dataset

entity del_dataset #82FA58
del_dataset "0,*" --* request_status
del_dataset "0,*"--* dataset
del_dataset "0,*"--* user

entity del.name
entity del.link
del.name --* del_dataset
del.link --* del_dataset 

entity add_dataset #82FA58
add_dataset "0,*"--* request_status
add_dataset "0,*"--* dataset
add_dataset "0,*"--* user

entity add.file_name
entity add.creation_data
add.file_name --* add_dataset
add.creation_data --* add_dataset

entity save_dataset #82FA58
save_dataset "0,*"--* dataset
save_dataset "0,*"--* request_status
save_dataset "0,*"--* user

entity save.name
entity save.link
save.name --* save_dataset
save.link --* save_dataset

entity give_moderator_status #82FA58
give_moderator_status "0,*"--* request_status
give_moderator_status "0,*"--* user

entity give_status.user_name
entity give_status.date
give_status.user_name --* give_moderator_status
give_status.date --* give_moderator_status

entity take_moderator_status #82FA58
take_moderator_status "0,*"--* request_status
take_moderator_status "0,*"--* user

entity take_status.user_name
entity take_status.date
take_status.user_name --* take_moderator_status
take_status.date --* take_moderator_status

entity search #82FA58
search "0, *" --* request_status
search "0, *" --* dataset
search "0, *" --* user

entity search.name
search.name --* search

@enduml


<h2>ER-модель</h2>


@startuml


entity business_role #82FA58 {
name : text
}


entity user #82FA58 {
nickname : text 
email : text
password : text
}
business_role "1   "--* user


entity request_status #82FA58 {
	status : text
}

entity dataset #82FA58 {
	id : int
	file_name : text
	creation_data : data
}
dataset "0, *" --* user

entity save_dataset #82FA58 {
	name : text
	link : text
}
save_dataset "0,*"--* user
save_dataset "0,*"--* request_status
save_dataset "0,*"--* dataset

entity del_dataset #82FA58 {
	name : text
	link : text
}
del_dataset "0,*"--* user
del_dataset "0,*"--* request_status
del_dataset "0,*"--* dataset

entity add_dataset #82FA58 {
	file_name : text
	creation_data : data
}
add_dataset "   0, *"--* user
add_dataset "0,*"--* request_status
add_dataset "0,*"--* dataset

entity give_moderator_status #82FA58 {
	user_name : text
	date : data
}
give_moderator_status "0,*"--* user
give_moderator_status  "0,*"--* request_status

entity take_moderator_status #82FA58 {
	user_name : text
	date : data
}
take_moderator_status "0,*"--* user
take_moderator_status  "0,*"--* request_status

entity search #82FA58 {
	name : text 
}
search "0, *" --* dataset
search "0, *" --* user
search "0, *" --* request_status

@enduml


<h2>Реляційна схема</h2>


[Посилання на реляційну схему](https://imgur.com/a/1IxEQKt)


Також можна переглянути за посиланням: 
[тут](https://github.com/Hlb03/new_project/blob/gleb/docs/design/media/relationSchema.PNG)