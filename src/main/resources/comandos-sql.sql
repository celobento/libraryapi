create table tb_author (
	id uuid not null primary key,
	name varchar(100) not null,
	birth_date date not null,
	nationality varchar(50) not null
);

SELECT * FROM TB_AUTHOR;

create table tb_book (
	id uuid not null primary key,
	isbn varchar(20) not null,
	title varchar(150) not null,
	publication_date date not null,
	gender varchar(30) not null,
	price numeric (18,2),
	id_author uuid not null references tb_author(id)
	constraint chk_gender check(gender in ('FICTION', 'FANTASY', 'MYSTERY', 'ROMANCE', 'SCIENCE'))
)

SELECT * FROM TB_BOOK;