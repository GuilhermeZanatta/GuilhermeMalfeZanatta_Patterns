package AbstractFacory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tema Claro ===");
        new Application(new LightThemeFactory()).renderInterface();

        System.out.println();

        System.out.println("=== Tema Escuro ===");
        new Application(new DarkThemeFactory()).renderInterface();
    }

    private interface UIComponentFactory {
        Button createButton();
        TextField createTextField();
        Checkbox createCheckbox();
    }

    private static class LightThemeFactory implements UIComponentFactory {
        public Button createButton() {
            return new LightButton();
        }

        public TextField createTextField() {
            return new LightTextField();
        }

        public Checkbox createCheckbox() {
            return new LightCheckbox();
        }
    }

    private static class DarkThemeFactory implements UIComponentFactory {
        public Button createButton() {
            return new DarkButton();
        }

        public TextField createTextField() {
            return new DarkTextField();
        }

        public Checkbox createCheckbox() {
            return new DarkCheckbox();
        }
    }

    private static class LightButton implements Button {
        public void render() {
            System.out.println("Renderizando Botão com fundo branco");
        }
    }

    private static class LightTextField implements TextField {
        public void render() {
            System.out.println("Renderizando Caixa de Texto com borda cinza clara");
        }
    }

    private static class LightCheckbox implements Checkbox {
        public void render() {
            System.out.println("Renderizando Checkbox com tema claro");
        }
    }

    private static class DarkButton implements Button {
        public void render() {
            System.out.println("Renderizando Botão com fundo cinza escuro");
        }
    }

    private static class DarkTextField implements TextField {
        public void render() {
            System.out.println("Renderizando Caixa de Texto com borda cinza escura");
        }
    }

    private static class DarkCheckbox implements Checkbox {
        public void render() {
            System.out.println("Renderizando Checkbox com tema escuro");
        }
    }

    private static class Application {
        private final UIComponentFactory factory;

        Application(UIComponentFactory factory) {
            this.factory = factory;
        }

        void renderInterface() {
            factory.createButton().render();
            factory.createTextField().render();
            factory.createCheckbox().render();
        }
    }
}
