-- Database "db_users" dump
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
-- TOC entry 3336 (class 1262 OID 16388)
-- Name: db_users; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE db_users WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE db_users OWNER TO postgres;

\connect db_users

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
-- TOC entry 6 (class 2615 OID 16392)
-- Name: app; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA app;


ALTER SCHEMA app OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 24996)
-- Name: codes; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.codes (
    id bigint NOT NULL,
    code text NOT NULL,
    mail text NOT NULL,
    created_at timestamp without time zone NOT NULL,
    expiry_at timestamp without time zone NOT NULL
);


ALTER TABLE app.codes OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24995)
-- Name: codes_id_seq; Type: SEQUENCE; Schema: app; Owner: postgres
--

CREATE SEQUENCE app.codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app.codes_id_seq OWNER TO postgres;

--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 216
-- Name: codes_id_seq; Type: SEQUENCE OWNED BY; Schema: app; Owner: postgres
--

ALTER SEQUENCE app.codes_id_seq OWNED BY app.codes.id;


--
-- TOC entry 215 (class 1259 OID 24979)
-- Name: users; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.users (
    id uuid NOT NULL,
    mail text NOT NULL,
    fio text NOT NULL,
    password text NOT NULL,
    role text NOT NULL,
    status text NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL
);


ALTER TABLE app.users OWNER TO postgres;

--
-- TOC entry 3181 (class 2604 OID 24999)
-- Name: codes id; Type: DEFAULT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.codes ALTER COLUMN id SET DEFAULT nextval('app.codes_id_seq'::regclass);


--
-- TOC entry 3328 (class 0 OID 24979)
-- Dependencies: 215
-- Data for Name: users; Type: TABLE DATA; Schema: app; Owner: postgres
--

INSERT INTO app.users VALUES ('c6b558e8-5c1b-4339-bf47-1cb6f40297e2', 'matrikary@gmail.com', 'admin', '$2a$10$.dmmNSaPXeZQ9CYhFJiZmOtW2wKwvZj7CN/ZdjjHXSbFsNt2gspSG', 'ADMIN', 'ACTIVATED', '2023-03-21 22:06:15.382309', '2023-03-21 22:06:15.382338');

--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 216
-- Name: codes_id_seq; Type: SEQUENCE SET; Schema: app; Owner: postgres
--

SELECT pg_catalog.setval('app.codes_id_seq', 19, true);


--
-- TOC entry 3185 (class 2606 OID 25003)
-- Name: codes codes_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.codes
    ADD CONSTRAINT codes_pkey PRIMARY KEY (id);


--
-- TOC entry 3183 (class 2606 OID 24985)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (mail);


-- Completed on 2023-04-02 14:54:35 +03

--
-- PostgreSQL database dump complete
