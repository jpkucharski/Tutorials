package interfaceTest;

public class InterfaceMain
{

    public static void main( String[] args )
    {
        InterfaceWyswietlajace errorMessage = new Error();
        InterfaceLoginable login = new Login();
        Login newLogin = new Login();
        EmptyPage emptyPage = new EmptyPage();

        System.out.println( errorMessage.getMessageText() );
        System.out.println( login.itsLogged() );
        System.out.println( newLogin.getMessageText() );
        System.out.println( emptyPage.getDefoultString() );
    }

}
