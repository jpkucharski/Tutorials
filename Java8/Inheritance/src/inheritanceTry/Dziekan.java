package inheritanceTry;

public class Dziekan
    extends Profesor
{
    private String dodatkowaFunkcja = " dziekan wydzialu ";


    public Dziekan( String imiePrzekazywane )
    {
        super( imiePrzekazywane );
    }


    public String getImie()
    {
        String imieItytul = super.getImie();
        return imieItytul + dodatkowaFunkcja;
    }
}
