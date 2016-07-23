package interfaceTest;

public interface InterfaceWyswietlajace
{
    public abstract String getMessageText();
    
    default String getDefoultString(){
        return "Defoult string from interface defoult method";
    }
}
