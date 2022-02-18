CREATE TABLE book_adder AS (
  SELECT
    books.isbn,
    books.title,
    books.publication_date,
    books.edition,
    books.available_quantity,
    books.price,
    books.images,
    authors.first_name,
    authors.second_name,
    authors.company_name,
    publishers.name AS publisher
  FROM books
    JOIN authors ON books.author = authors.id
    JOIN publishers ON books.publisher = publishers.id
  WHERE 1 = 0
);