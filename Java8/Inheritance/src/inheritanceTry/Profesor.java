package inheritanceTry;

public class Profesor
    extends NadUczen
{
    private String tytul = " prof. ";


    public Profesor( String imiePrzekazywane )
    {
        super( imiePrzekazywane );

    }


    public String getImie()
    {
        String imie = super.getImie();
        return tytul + imie;
    }
}
