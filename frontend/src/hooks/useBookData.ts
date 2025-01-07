import axios, { AxiosPromise } from "axios"
import { Book } from "../interfaces/Book"
import { useQuery } from "@tanstack/react-query"
const URL = "http://localhost:8080/books"
const fetchData = async(): AxiosPromise<Book[]> => {
     const response = await axios.get(URL)
     const bookResponse = response.data
     console.log(bookResponse)
     const bookData = bookResponse.map((book: any) => new Book(book));        
     console.log(bookData)
     return bookData
}

export function useBookData(){
    const query = useQuery({
       queryFn: fetchData,  
       queryKey: ["book-data"],
})  
    return query
}