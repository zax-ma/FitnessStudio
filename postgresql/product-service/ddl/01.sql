CREATE SCHEMA IF NOT EXISTS app;

CREATE TABLE IF NOT EXISTS app.recipes
(
    id uuid NOT NULL,
    title text COLLATE pg_catalog."default",
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    CONSTRAINT recipes_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app.recipes
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS app.products
(
    id uuid NOT NULL,
    title text COLLATE pg_catalog."default",
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    weight integer,
    calories integer,
    carbohydrates double precision,
    fats double precision,
    proteins double precision,
    CONSTRAINT product_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app.products
    OWNER to postgres;



CREATE TABLE IF NOT EXISTS app.ingredients
(
    recipe_id uuid NOT NULL,
    product_id uuid NOT NULL,
    weight integer,
    CONSTRAINT product_id_fkey FOREIGN KEY (product_id)
        REFERENCES app.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES app.recipes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app.ingredients
    OWNER to postgres;