public class KsiazkaZAutografem implements Publication{

    private String autograph;
    private Publication publication;
    public KsiazkaZAutografem(Publication pub, String autograph) throws Exception {
        this.publication = pub;
        this.autograph = autograph;
        if(pub instanceof KsiazkaZAutografem ){
            throw new Exception("2 autografy w jednej książce");
        }
    }

    @Override
    public String getAuthor(){
        return this.publication.getAuthor();
    }

    @Override
    public String getTitle(){
        return this.publication.getTitle();
    }

    @Override
    public int getNumberPages(){
        return this.publication.getNumberPages();
    }

    public String getAutograph(){
        return autograph;
    }
    @Override
    public String toString(){
        return this.publication.toString() + " " + autograph + " |";
    }
}
