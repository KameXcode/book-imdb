export class Book{
        public bookId: number;
        public title: string;
        public author: string;
        public description: string;
        public releaseDate: string;
        public formattedReleaseDate: string;
        public rating: number | null;
        public imgUrl: string ;
    
        constructor(bookData: {
          book_id: number;
          title: string;
          author: string;
          description: string;
          releaseDate: string;
          rating: number | null;
          imgUrl: string ;
        })
         {
          this.bookId = bookData.book_id;
          this.title = bookData.title;
          this.author = bookData.author;
          this.description = bookData.description;
          this.releaseDate = bookData.releaseDate;
          this.formattedReleaseDate = this.formatReleaseDate(bookData.releaseDate);
          this.rating = bookData.rating;
          this.imgUrl = bookData.imgUrl;
        }
      
        private formatReleaseDate(isoDate: string): string {
          const date = new Date(isoDate);
          const day = String(date.getDate()).padStart(2, "0");
          const month = String(date.getMonth() + 1).padStart(2, "0");
          const year = date.getFullYear();
          return `${day}/${month}/${year}`;
        }
      }
      