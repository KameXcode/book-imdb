export interface BookCard{
    title: string,
    rating: number | null,
    imgUrl: string 
}

export function BookCard({imgUrl, rating, title}: BookCard){
    const redirectToBookPage = () => {}
    return(
    <>
        <div className="bookcard-container" onClick={() => redirectToBookPage}>
            <img src= {imgUrl} alt=""/>
            <div className="card_info">
                <span className="card_name">{title}</span>
                <span className="card_rating">{rating}</span>
            </div>
        </div>
    </>
    )
}