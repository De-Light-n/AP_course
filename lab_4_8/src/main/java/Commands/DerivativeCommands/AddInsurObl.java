package Commands.DerivativeCommands;

import Der.Derivative;
import Obligations.HealthInsurance;
import Obligations.InsuranceObligation;
import Obligations.LifeInsurance;
import Obligations.PropertyInsurance;

public class AddInsurObl extends DerCommand{
    public AddInsurObl(Derivative der){
        super(der);
    }

    @Override
    public void execute() {
        System.out.println("Виберiть тип страхового зобов'язання для додавання:");
        System.out.println("1. Страхування життя");
        System.out.println("2. Медичне страхування");
        System.out.println("3. Страхування майна");
    
        int type = parseInt(scanner.nextLine());
        logger.info("Додано Страхування: " + type);
        if(type<=0 || type>=4){
            System.out.println("Неправильно вибраний тип.");
            return;
        }

        System.out.print("Введiть рiвень ризику: ");
        double riskLevel = parseDouble(scanner.nextLine());
        logger.info("Додано ризик: " + riskLevel);
        
        System.out.print("Введiть суму: ");
        double amount = parseDouble(scanner.nextLine());
        logger.info("Додано суму: " + amount);
        
        System.out.print("Введiть тривалiсть: ");
        int duration = parseInt(scanner.nextLine());
        logger.info("Додано тривалiсть: " + duration);
    
        InsuranceObligation obligation = null;
        switch (type) {
            case 1:
                System.out.print("Введiть iм'я бенефiцiара: ");
                String beneficiary = scanner.nextLine();
                logger.info("Додано бенефiцiара: " + beneficiary);
                obligation = new LifeInsurance(riskLevel, amount, duration, beneficiary);
                break;
            case 2:
                System.out.print("Введiть вiк: ");
                int age = parseInt(scanner.nextLine());
                logger.info("Додано вiк: " + age);
                System.out.print("Введiть наявнiсть захворювань (true(так) / false(нi)): ");
                boolean preConditions = parseBoolean(scanner.nextLine());
                logger.info("Додано захворювання: " + preConditions);
                obligation = new HealthInsurance(riskLevel, amount, duration, age, preConditions);
                break;
            case 3:
                System.out.print("Введiть мiсцезнаходження майна: ");
                String location = scanner.nextLine();
                System.out.print("Введiть цiну майна: ");
                double propertyValue = parseDouble(scanner.nextLine());
                System.out.print("Введiть чи власнiсть знаходиться в небезпечному мiсцi (true(так) / false(нi)): ");
                boolean isHighRisk = parseBoolean(scanner.nextLine());
                obligation = new PropertyInsurance(riskLevel, amount, duration, location, propertyValue, isHighRisk);
                break;
            default:
                System.out.println("Неправильно вибраний тип.");
                return;
        }
    
        derivative.addObligation(obligation);
        logger.info("Додано нове зобов’язання: " + obligation);
    }
    
}
