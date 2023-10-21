# DESCRIPTION
- Microservicio para registro de usuarios




# SCRIPT

-- CREATE DATABASE

CREATE DATABASE dbo WITH ENCODING='UTF8';



-- Drop table

-- DROP TABLE public.app_users;

CREATE TABLE public.app_users (
	user_id varchar(255) NOT NULL,
	user_active bool NOT NULL,
	user_created_at timestamp NOT NULL,
	user_email varchar(255) NOT NULL,
	user_last_login timestamp NULL,
	user_modified_at timestamp NULL,
	user_name varchar(255) NOT NULL,
	user_password varchar(255) NOT NULL,
	user_token varchar(255) NULL,
	CONSTRAINT pk_userid PRIMARY KEY (user_id)
);



-- public.app_phones definition

-- Drop table

-- DROP TABLE public.app_phones;

CREATE TABLE public.app_phones (
	phone_id int4 NOT NULL,
	phone_citycode varchar(255) NOT NULL,
	phone_contrycode varchar(255) NOT NULL,
	phone_number varchar(255) NOT NULL,
	user_id varchar(255) NOT NULL,
	CONSTRAINT pk_phoneid PRIMARY KEY (phone_id),
	CONSTRAINT fk_userid FOREIGN KEY (user_id) REFERENCES public.app_users(user_id)
);



# REQUEST
{
  "name": "Carlos Mendoza",
  "email": "carlos.ermendoza@gmail.com",
  "password": "string",
  "phones": [
    {
      "number": "77229764",
      "citycode": "503",
      "contrycode": "503"
    }
  ]
}

# SWAGGER
http://localhost:8085/api/v1/swagger-ui/index.html



