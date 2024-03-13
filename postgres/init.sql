CREATE TABLE public.author (
    id bigserial NOT NULL,
    name character varying(30) NOT NULL,
    surname character varying(30) NOT NULL,
    patrymonic character varying(30),
    date_of_birth date NOT NULL
);

CREATE TABLE public.book (
    id bigserial NOT NULL,
    title text NOT NULL,
    year_of_publication date NOT NULL
);

CREATE TABLE public.book_author (
	id bigserial NOT NULL,
    book bigint NOT NULL,
    author bigint NOT NULL
);

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_author_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT author_fk FOREIGN KEY (author) REFERENCES public.author(id) NOT VALID;

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_fk FOREIGN KEY (book) REFERENCES public.book(id) NOT VALID;



INSERT INTO public.author(name, surname, patrymonic, date_of_birth) VALUES ('Стивен', 'Маккооннелл', NULL, '1962-09-03');
INSERT INTO public.author(name, surname, patrymonic, date_of_birth) VALUES ('Томас', 'Кормен', NULL, '1956-01-01');
INSERT INTO public.author(name, surname, patrymonic, date_of_birth) VALUES ('Чарльз', 'Лейзерсон', NULL, '1953-11-10');


INSERT INTO public.book (title, year_of_publication) VALUES ('Алгоритмы: построение и анализ', '1990-01-01');
INSERT INTO public.book (title, year_of_publication) VALUES ('Совершенный код. Мастер-класс', '1993-01-01');
INSERT INTO public.book (title, year_of_publication) VALUES ('Сколько стоит программный проект', '2007-01-01');



INSERT INTO public.book_author(book, author) VALUES (3, 1);
INSERT INTO public.book_author(book, author) VALUES (2, 1);
INSERT INTO public.book_author(book, author) VALUES (1, 2);
INSERT INTO public.book_author(book, author) VALUES (1, 3);