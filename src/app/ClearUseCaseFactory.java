package app;

import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;
import view.ClearView;

import javax.swing.*;
import java.io.IOException;

public class ClearUseCaseFactory {
    private ClearUseCaseFactory() {
    }

    public static ClearView create(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel, ClearUserDataAccessInterface userDataAccessObject) {
        try {
            ClearController clearController = createUserClearUseCase(viewManagerModel, clearViewModel, userDataAccessObject);
            return new ClearView(clearController, clearViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static ClearController createUserClearUseCase(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel, ClearUserDataAccessInterface userDataAccessObject) throws IOException {
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, clearViewModel);
        ClearInputBoundary userClearInteractor = new ClearInteractor(userDataAccessObject, clearOutputBoundary);
        return new ClearController(userClearInteractor);
    }
}
