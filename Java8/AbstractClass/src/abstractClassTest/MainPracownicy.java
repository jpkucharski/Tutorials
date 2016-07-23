package abstractClassTest;

public class MainPracownicy
{
    public static void main( String[] args )
    {
        Pracownicy[] tabelaPracownikow1 = new Pracownicy[2];

        tabelaPracownikow1[0] = new Przktykant( "Stasiek" );
        tabelaPracownikow1[1] = new Informatyk();

        for( Pracownicy m : tabelaPracownikow1 )
            System.out.println( m.getImie() + " " + m.getInfo() );
    }
}
