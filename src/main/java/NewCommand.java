public class NewCommand extends Command
{
    private MenuController menuController;
    public NewCommand(Presentation presentation, MenuController menuController)
    {
        super(presentation);
        this.menuController = menuController;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        menuController.setNewSlideRequested(true);
        menuController.showCreateSlideDialog();
    }
}
