public class KsiazkaZOkladkaTwarda implements Publication {

    private Publication publication;

    public KsiazkaZOkladkaTwarda(Publication pub) {
        if ((pub instanceof KsiazkaZOkladkaTwarda) || pub instanceof KsiazkaZOkladkaMiekka) {
            System.out.println("Książka nie może mieć dwóch okładek");
        } else {
            this.publication = pub;
        }
    }

    @Override
    public String getAuthor() {
        return this.publication.getAuthor();
    }

    @Override
    public String getTitle() {
        return this.publication.getTitle();
    }

    @Override
    public int getNumberPages() {
        return this.publication.getNumberPages();
    }

    @Override
    public String toString() {
        return this.publication.toString() + "Okladka Twarda|";
    }
}