CREATE SCHEMA IF NOT EXISTS app;


CREATE TABLE IF NOT EXISTS app.users
(
    id uuid NOT NULL,
    mail text COLLATE pg_catalog."default" NOT NULL,
    fio text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    role text COLLATE pg_catalog."default" NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (mail)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app.users
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS app.codes
(
    id bigint NOT NULL,
    code text COLLATE pg_catalog."default" NOT NULL,
    mail text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp without time zone NOT NULL,
    expiry_at timestamp without time zone NOT NULL,
    CONSTRAINT codes_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app.codes
    OWNER to postgres;



