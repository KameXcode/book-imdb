import { BookCard } from "../components/BookCard";
import { useBookData } from "../hooks/useBookData";

export function Home(){
    const {data, isLoading} = useBookData()

    return (
    <>
        {data?.data.map((bookData) => (
            <BookCard title={bookData.title} imgUrl={bookData.imgUrl} rating={bookData.rating} />
        ))}
    </>
    )
}