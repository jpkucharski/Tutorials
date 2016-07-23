package inheritanceTry;

public class Uczen
    extends NadUczen
{
    private String tytul = " uczen ";


    public Uczen( String imiePrzekazywane )
    {
        super( imiePrzekazywane );
    }


    public String getImie()
    {
        String imie = super.getImie();
        return tytul + imie;
    }
}
