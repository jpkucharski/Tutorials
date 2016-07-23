package abstractClassTest;

public class Przktykant
    extends Pracownicy
{

    private String imie;

    public Przktykant( String string )
    {
        this.imie = string;
    }

    @Override
    public String getInfo()
    {
        return "Opis Praktykanta";
    }

    public String getImie()
    {
        return this.imie;
    }
}
