package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;
import use_case.clear_users.ClearInteractor;

import java.lang.ref.Cleaner;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearInputBoundary;
    public ClearController(ClearInputBoundary clearInputBoundary) {
        this.clearInputBoundary = clearInputBoundary;
    }

    public void execute() {
        clearInputBoundary.execute();
    }
}
