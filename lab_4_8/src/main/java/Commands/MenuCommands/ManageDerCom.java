package Commands.MenuCommands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Commands.Command;
import Commands.DerivativeCommands.AddInsurObl;
import Commands.DerivativeCommands.DisplayObl;
import Commands.DerivativeCommands.FilterObl;
import Commands.DerivativeCommands.RemInsurObl;
import Commands.DerivativeCommands.SortOblByRisk;
import Commands.DerivativeCommands.TotalValue;
import Der.Derivative;


public class ManageDerCom extends MenuCommand{
    public ManageDerCom(List<Derivative> derivatives){
        super(derivatives);
    }

    @Override
    public void execute(){
        if (this.derivatives.isEmpty()) {
            System.out.println("Немає доступних деривативiв. Будь ласка, створiть спочатку.");
            return;
        }

        System.out.print("Виберiть дериватив для управлiння (1 - " + this.derivatives.size() + "):");
        int index = parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= this.derivatives.size()) {
            System.out.println("Неправильний вибiр.");
            return;
        }

        Derivative selectedDerivative = this.derivatives.get(index);
        Map<Integer, Command> manageCommands = new HashMap<>();
        manageCommands.put(1, new AddInsurObl(selectedDerivative));
        manageCommands.put(2, new RemInsurObl(selectedDerivative));
        manageCommands.put(3, new TotalValue(selectedDerivative));
        manageCommands.put(4, new SortOblByRisk(selectedDerivative));
        manageCommands.put(5, new FilterObl(selectedDerivative));
        manageCommands.put(6, new DisplayObl(selectedDerivative));

        boolean back = false;
        while (!back) {
            System.out.println("\nУправлiння деривативом - Виберiть опцiю:");
            System.out.println("1. Додати страхове зобов'язання");
            System.out.println("2. Видалити страхове зобов'язання");
            System.out.println("3. Розрахувати загальну вартiсть");
            System.out.println("4. Сортувати зобов'язання за рiвнем ризику");
            System.out.println("5. Фiльтрувати зобов'язання за параметрами");
            System.out.println("6. Показати всi зобов'язання");
            System.out.println("7. Повернутися назад");

            System.out.print("Вибiр: ");
            int choice = parseInt(scanner.nextLine());
            logger.info("Вибiр дії: "+ choice);

            if (choice == 7) {
                back = true;
            } else if (manageCommands.containsKey(choice)) {
                manageCommands.get(choice).execute();
            } else {
                System.out.println("Неправильний вибiр, спробуйте ще раз.");
                logger.warn("Користувач ввів неправильний вибір: " + choice);
            }
        }
    }
}
