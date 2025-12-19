package creational.abstractFactory.app;

import creational.abstractFactory.buttons.Button;
import creational.abstractFactory.checkboxes.Checkbox;
import creational.abstractFactory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
