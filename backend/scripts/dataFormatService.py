import datetime
def formatToDate(string):
    input_string = "Capa dura – 17 agosto 2020"
    parts = input_string.split("–")[1].strip()  
    meses = {
        "janeiro": 1, "fevereiro": 2, "março": 3, "abril": 4,
        "maio": 5, "junho": 6, "julho": 7, "agosto": 8,
        "setembro": 9, "outubro": 10, "novembro": 11, "dezembro": 12
    }
    dia, mes_texto, ano = parts.split()
    mes = meses[mes_texto.lower()]  
    formatted_date = datetime.date(int(ano), mes, int(dia)).strftime("%Y-%m-%d")
    return formatted_date

