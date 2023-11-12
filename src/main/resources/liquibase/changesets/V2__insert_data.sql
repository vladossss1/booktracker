insert into users(username, password)
values ('admin', '$2a$10$6Lg1LaPjb94qWtNKrR3XWuxJX3a9Ix5WShTkCTAgDMZ4A/JgMsC3a');

insert into users_roles(user_id, role)
values('1', 'ROLE_ADMIN');

insert into books(status, total_pages, current_page)
values ('PLANNED', 450, 0);

insert into book_templates(title)
values ('Martin Eden');

insert into authors(id, author)
values (1, 'Jack London'),
       (2, 'Plato');

insert into users_books(user_id, book_id)
values (1, 1);

insert into books_book_templates(book_id, book_template_id)
values (1, 1);

insert into book_templates_authors(book_template_id, author_id)
values (1, 1),
       (1, 2);

insert into book_templates_genres(book_template_id, genre)
values (1, 'FICTION'),
       (1, 'PHILOSOPHY');