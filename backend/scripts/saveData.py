import psycopg2
from psycopg2 import sql

def insertBook(title, author, description, release_date, img_link):
    try:
        connection = psycopg2.connect(
            host="localhost",
            port="5433",
            database="book-imdb",
            user="postgres",
            password=""
        )
        cursor = connection.cursor()
        insert_query = """
            INSERT INTO books(title, author, description, release_date, img_link) 
            VALUES (%s, %s, %s, %s)
            """
        values = (title, author, description, release_date, img_link)
        cursor.execute(insert_query, values)
        connection.commit()
        print(values)
    except psycopg2.Error as e:

        print(f"Erro ao conectar ao banco de dados: {e}")

    finally:
        # Fecha a conexão
        if connection:
            cursor.close()
            connection.close()
            print("Conexão ao banco de dados encerrada.")