package use_case.clear_users;


// TODO Complete me
public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface clearUserDataAccessInterface;
    final ClearOutputBoundary clearOutputBoundary;

    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.clearUserDataAccessInterface = clearUserDataAccessInterface;
        this.clearOutputBoundary = clearOutputBoundary;
    }
    @Override
    public void execute() {
        clearUserDataAccessInterface.clear();

    }
}
