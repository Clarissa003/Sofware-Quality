public class NextCommand extends Command
{
    public NextCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.nextSlide();
    }
}
