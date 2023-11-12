create table if not exists users
(
    id       bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists books
(
    id           bigserial primary key,
    status       varchar(255)  not null,
    rating       smallint      null,
    total_pages  integer       not null,
    current_page integer       not null,
    start_time   timestamp     null,
    finish_time  timestamp     null,
    comment      varchar(1024) null
);

create table if not exists book_templates
(
    id    bigserial primary key,
    title varchar(255) not null
);

create table if not exists authors
(
    id     bigserial primary key,
    author varchar(255) not null
);

create table if not exists users_books
(
    user_id bigint not null,
    book_id bigint not null,
    primary key (user_id, book_id),
    constraint fk_users_books_users foreign key (user_id) references users (id) on delete cascade on update no action,
    constraint fk_users_books_books foreign key (book_id) references books (id) on delete cascade on update no action
);

create table if not exists books_book_templates
(
    book_id          bigint not null,
    book_template_id bigint not null,
    primary key (book_id, book_template_id),
    constraint fk_books_book_templates_books foreign key (book_id) references books (id) on delete cascade on update no action,
    constraint fk_books_book_templates_book_templates foreign key (book_template_id) references book_templates (id) on delete cascade on update no action
);

create table if not exists book_templates_authors
(
    book_template_id bigint not null,
    author_id        bigint not null,
    primary key (author_id, book_template_id),
    constraint fk_book_templates_authors_book_templates foreign key (book_template_id) references book_templates (id) on delete cascade on update no action,
    constraint fk_book_templates_authors_authors foreign key (author_id) references authors (id) on delete cascade on update no action
);

create table if not exists book_templates_genres
(
    book_template_id bigint       not null,
    genre            varchar(255) not null,
    primary key (genre, book_template_id),
    constraint fk_book_templates_genres_book_templates foreign key (book_template_id) references book_templates (id) on delete cascade on update no action
);

create table if not exists users_roles
(
    user_id bigint       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);