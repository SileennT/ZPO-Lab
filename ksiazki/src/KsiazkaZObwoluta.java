public class KsiazkaZObwoluta implements Publication {

    private Publication publication;

    public KsiazkaZObwoluta(Publication pub){
        if(!(pub instanceof KsiazkaZOkladkaMiekka) && !(pub instanceof KsiazkaZOkladkaTwarda)){
            System.out.println("Książka bez okładki nie może mieć Obwoluta");
        }
        else{
            this.publication = pub;
        }
    }
    @Override
    public String getAuthor() {
        return this.publication.getAuthor();
    }

    @Override
    public String getTitle()
    {
        return this.publication.getTitle();
    }

    @Override
    public int getNumberPages()
    {
        return this.publication.getNumberPages();
    }

    @Override
    public String toString()
    {
        return this.publication.toString() + " Z Obwoluta |";
    }
}

