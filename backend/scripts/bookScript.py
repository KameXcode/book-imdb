from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from dataFormatService import formatToDate
import saveData
service = Service()
options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=service, options=options)
from datetime import date
from time import sleep

for i in range(1, 4):
    url = f"https://www.amazon.com.br/s?k=livros&i=stripbooks&rh=n%3A6740748011&dc&page={i}&__mk_pt_BR=ÅMÅŽÕÑ&crid=3MWA6YK5SZSVU&qid=1735912329&rnid=18726358011&sprefix=livr%2Caps%2C275&xpid=mp4Ukc6JJuyH8&ref=sr_pg_2"
    driver.get(url)
    sleep(4)
    link_elements = WebDriverWait(driver, 10).until(
    EC.presence_of_all_elements_located((By.CSS_SELECTOR, "a.a-link-normal.s-line-clamp-2.s-link-style.a-text-normal"))
    )
    href_list = [element.get_attribute('href') for element in link_elements]
    for link in href_list:
        driver.get(link)
        title = driver.find_element(By.ID,"productTitle").text
        try:
            author = driver.find_element(By.ID, "centerCol").find_element(By.ID, "bylineInfo_feature_div").find_element(By.ID, "bylineInfo").find_element(By.CSS_SELECTOR, "span.author.notFaded").find_element(By.TAG_NAME, "a").text
        except Exception as e:
            author = driver.find_element(By.ID, "centerCol").find_element(By.ID, "bylineInfo_feature_div").find_element(By.CSS_SELECTOR, "span.author.notFaded").find_element(By.TAG_NAME, "a").text
        try:
            description = driver.find_element(By.ID, "bookDescription_feature_div").find_element(By.TAG_NAME, "div").find_element(By.CSS_SELECTOR, "div.a-expander-content.a-expander-partial-collapse-content").find_element(By.TAG_NAME, "p").find_element(By.TAG_NAME, "span").text
        except Exception as e:
            description = driver.find_element(By.ID, "bookDescription_feature_div").find_element(By.TAG_NAME, "div").find_element(By.CSS_SELECTOR, "div.a-expander-content.a-expander-partial-collapse-content").find_element(By.TAG_NAME, "span").text
        release_date = formatToDate(driver.find_element(By.ID, "centerCol").find_element(By.CSS_SELECTOR, "div.a-section.a-spacing-none").find_element(By.TAG_NAME,"h1").find_element(By.ID,"productSubtitle").text)
        img_link = driver.find_element(By.CSS_SELECTOR, "ul.a-unordered-list.a-nostyle.a-horizontal.list.maintain-height").find_element(By.CSS_SELECTOR, "li.image.item.itemNo0.maintain-height.selected").find_element(By.TAG_NAME,"span").find_element(By.TAG_NAME,"span").find_element(By.TAG_NAME,"div").find_element(By.TAG_NAME,"img").get_attribute("src")
        #Insert book into database
        saveData.insertBook(title,author,description,release_date, img_link)

