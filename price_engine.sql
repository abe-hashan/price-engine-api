--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: configuration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.configuration (
    id bigint NOT NULL,
    key character varying(255),
    value character varying(255)
);


ALTER TABLE public.configuration OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    carton_price double precision NOT NULL,
    carton_size integer NOT NULL,
    created_date timestamp without time zone,
    name character varying(255),
    status boolean NOT NULL,
    unit_price double precision NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Data for Name: configuration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.configuration (id, key, value) FROM stdin;
2	MULTIPLE_CARTON_DISCOUNT_ELIGIBILITY	3
3	SINGLE_ITEM_INCREASE	30
1	MULTIPLE_CARTON_DISCOUNT	10
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, carton_price, carton_size, created_date, name, status, unit_price, updated_date) FROM stdin;
1	175	20	2020-06-13 17:04:31.88453	Penguin-ears	t	0	2020-06-13 17:04:31.88453
2	825	5	2020-06-13 17:05:04.275289	Horseshoe	t	0	2020-06-13 17:05:04.275289
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: configuration configuration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.configuration
    ADD CONSTRAINT configuration_pkey PRIMARY KEY (id);


--
-- Name: configuration keycoluniqueconstraint; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.configuration
    ADD CONSTRAINT keycoluniqueconstraint UNIQUE (key);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: configuration uk_5wejhym1uspe4klluscbwo9r; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.configuration
    ADD CONSTRAINT uk_5wejhym1uspe4klluscbwo9r UNIQUE (key);


--
-- PostgreSQL database dump complete
--

