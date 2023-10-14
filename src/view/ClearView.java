package view;

import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ClearView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "clear";
    private final ClearViewModel clearViewModel;
    private final ClearController clearController;
    private final JButton clear;
    private final JButton cancel;

    public ClearView(ClearController controller, ClearViewModel clearViewModel) {
        this.clearController = controller;
        this.clearViewModel = clearViewModel;
        clearViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ClearViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        clear = new JButton(ClearViewModel.CLEAR_BUTTON_LABEL);
        cancel = new JButton(ClearViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(clear);
        buttons.add(cancel);

        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(clear)) {
                            clearController.execute();
                        }
                    }
                }
        );

        this.add(title);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
