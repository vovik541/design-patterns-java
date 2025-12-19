package creational.abstractFactory.factories;

import creational.abstractFactory.buttons.Button;
import creational.abstractFactory.buttons.MacOSButton;
import creational.abstractFactory.checkboxes.Checkbox;
import creational.abstractFactory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}