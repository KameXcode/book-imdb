CREATE TABLE books(
    book_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    release_date DATE NOT NULL,
    rating NUMERIC(3,2)
);
INSERT INTO books(title,author,description,release_date)
VALUES(
 'Hábitos Atômicos: Um Método Fácil e Comprovado de Criar Bons Hábitos e Se Livrar dos Maus',
 'James Clear',
 'Não importa quais sejam seus objetivos, Hábitos Atômicos oferece um método eficaz para você se aprimorar ― todos os dias. James Clear, um dos mais expoentes especialistas na criação de hábitos, revela as estratégicas práticas que o ensinarão, exatamente, como criar bons hábitos, abandonar os maus e fazer pequenas mudanças de comportamento que levam a resultados impressionantes.',
 '2019-08-8'
);