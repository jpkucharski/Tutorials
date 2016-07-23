package inheritanceTry;

public class TestTablica
{
    public static void main( String[] args )
    {
        NadUczen[] tablica1 = new NadUczen[4];
        tablica1[0] = new Uczen( "asia" );
        tablica1[1] = new Uczen( "marysia" );
        tablica1[2] = new Profesor( "ola" );
        tablica1[3] = new Dziekan( "aga" );

        for( NadUczen m : tablica1 )
        {
            System.out.println( "Name: " + m.getImie() );
        }
    }
}

