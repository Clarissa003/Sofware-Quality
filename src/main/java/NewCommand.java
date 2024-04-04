public class NewCommand extends Command
{
    public NewCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.clear();
    }
}
