DROP TABLE BOOKS_DISCOUNTS;
DROP TABLE BOOKS_GENRES;
DROP TABLE COMMENTS;
DROP TABLE GENRES;
DROP TABLE ORDERS_DETAILS;
DROP TABLE RATINGS;
DROP TABLE USERS_DISCOUNTS;
DROP TABLE BOOKS;
DROP TABLE AUTHORS;
DROP TABLE PUBLISHERS;
DROP TABLE ORDERS;
DROP TABLE DISCOUNTS;
DROP TABLE SHIPPERS;
DROP TABLE USERS;
DROP TABLE ROLE;

SELECT * FROM BOOKS
                INNER JOIN BOOKS_GENRES BG on BOOKS.ISBN = BG.BOOK_ISBN
                INNER JOIN GENRES G2 on BG.GENRE_ID = G2.ID
WHERE BOOKS.ISBN NOT LIKE ''