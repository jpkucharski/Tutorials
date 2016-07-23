package abstractClassTest;

public class Informatyk
    extends Pracownicy
{
    private String imie = "Kazimierz";
    private String nazwisko = "Kowalski";

    @Override
    public String getInfo()
    {
        return "Opis Informnatyka";
    }

    public String getImie()
    {
        return this.imie + " " + nazwisko;
    }
}
