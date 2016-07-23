package interfaceTest;

public class Login implements InterfaceWyswietlajace, InterfaceLoginable
{
    
    @Override
    public String getMessageText()
    {
    
        return "Login Page";
    }

    @Override
    public boolean itsLogged()
    {
        if(getMessageText()!=null)
        {
            return true;
        }
        
        return false;
    }
}
