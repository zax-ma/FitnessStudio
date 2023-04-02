-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Debian 15.2-1.pgdg110+1)
-- Dumped by pg_dump version 15.1

-- Started on 2023-04-02 14:54:35 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2023-04-02 14:54:35 +03

--
-- PostgreSQL database dump complete
--

--
-- Database "db_products" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Debian 15.2-1.pgdg110+1)
-- Dumped by pg_dump version 15.1

-- Started on 2023-04-02 14:54:35 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3340 (class 1262 OID 16389)
-- Name: db_products; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE db_products WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE db_products OWNER TO postgres;

\connect db_products

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 25123)
-- Name: app; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA app;


ALTER SCHEMA app OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 25138)
-- Name: ingredients; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.ingredients (
    recipe_id uuid NOT NULL,
    product_id uuid NOT NULL,
    weight integer
);


ALTER TABLE app.ingredients OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 25131)
-- Name: products; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.products (
    id uuid NOT NULL,
    title text,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    weight integer,
    calories integer,
    carbohydrates double precision,
    fats double precision,
    proteins double precision
);


ALTER TABLE app.products OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 25124)
-- Name: recipes; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.recipes (
    id uuid NOT NULL,
    title text,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone
);


ALTER TABLE app.recipes OWNER TO postgres;

--
-- TOC entry 3334 (class 0 OID 25138)
-- Dependencies: 217
-- Data for Name: ingredients; Type: TABLE DATA; Schema: app; Owner: postgres
--



--
-- TOC entry 3333 (class 0 OID 25131)
-- Dependencies: 216
-- Data for Name: products; Type: TABLE DATA; Schema: app; Owner: postgres
--



--
-- TOC entry 3332 (class 0 OID 25124)
-- Dependencies: 215
-- Data for Name: recipes; Type: TABLE DATA; Schema: app; Owner: postgres
--



--
-- TOC entry 3187 (class 2606 OID 25137)
-- Name: products product_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.products
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 3185 (class 2606 OID 25130)
-- Name: recipes recipes_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.recipes
    ADD CONSTRAINT recipes_pkey PRIMARY KEY (id);


--
-- TOC entry 3188 (class 2606 OID 25141)
-- Name: ingredients product_id_fkey; Type: FK CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.ingredients
    ADD CONSTRAINT product_id_fkey FOREIGN KEY (product_id) REFERENCES app.products(id);


--
-- TOC entry 3189 (class 2606 OID 25146)
-- Name: ingredients recipe_id_fkey; Type: FK CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.ingredients
    ADD CONSTRAINT recipe_id_fkey FOREIGN KEY (recipe_id) REFERENCES app.recipes(id);


-- Completed on 2023-04-02 14:54:35 +03

--
-- PostgreSQL database dump complete