public class Book implements Publication {
    private String author;
    private String title;
    private Integer numberPages;

        @Override
        public String getAuthor(){
            return author;
        }

        @Override
        public String getTitle(){
            return title;
        }

        @Override
        public int getNumberPages(){
            return numberPages;
    }

    @Override
    public String toString(){
        return "| "+ author + " | " + title + " | " + numberPages + " |" ;
    }

    public Book(String author, String title, Integer numberPages){
        this.author = author;
        this.title = title;
        this.numberPages = numberPages;
    }

    public Book(Book old){
        this(old.author, old.title, old.numberPages);
    }
}
