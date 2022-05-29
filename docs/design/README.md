# Проєктування бази даних

В рамках проекту розробляється: 
- модель бізнес-об'єктів 

<h2>ER-модель</h2>

@startuml


entity bussines_role #82FA58 {
name : text
}


entity user #82FA58 {
nickname : text 
email : text
password : text
}
bussines_role "1"--*"1" user


entity request_status #82FA58 {
	status : text
}

entity dataset #82FA58 {
	file_name : text
	creation_data : data
}
dataset "0, *" --* "1" user

entity save_dataset #82FA58 {
	text : name
	link : text
}
save_dataset "0,*"--*"1" user
save_dataset "0,*"--*"1" request_status
save_dataset "0,*"--*"1" dataset

entity del_dataset #82FA58 {
	name : text
	link : text
}
del_dataset "0,*"--*"1" user
del_dataset "0,*"--*"1" request_status
del_dataset "0,*"--*"1" dataset

entity add_dataset #82FA58 {
	file_name : text
	data_creation : data
}
add_dataset "   0, *"--*"1" user
add_dataset "0,*"--*"1" request_status
add_dataset "0,*"--*"1" dataset

entity give_moderator_status #82FA58 {
	user_name : text
	date : data
}
give_moderator_status "0,*"--*"     1" user
give_moderator_status  "0,*"--*"1" request_status

entity take_moderator_status #82FA58 {
	user_name : text
	date : data
}
take_moderator_status "0,*"--*"    1" user
take_moderator_status  "0,*"--*"1" request_status

@enduml



- реляційна схема

