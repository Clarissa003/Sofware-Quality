public abstract class Command
{
    protected Presentation presentation;

    //Constructor
    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    //Methods
    public abstract void execute();
}
