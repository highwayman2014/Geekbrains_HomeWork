package homeworkfive;

public class HomeworkFive {

    public static void main(String[] args) {

        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Григорий Дуайтович Быдгощский", "Имитатор программиста", "grishbdysh@mail.ru", "+79351248576", 10000,20);
        workers[1] = new Worker("Честер Кимович Юркин", "Охранник", "evil_djadja@mail.ru", "+79006660066", 1000000,85);
        workers[2] = new Worker("Бенедикт Иванович Толстых", "Кофевар", "ilikecoffee@yandex.ru", "+79847539514", 15000,25);
        workers[3] = new Worker("Модест Хлодвигович Петров", "Уборщик", "icleanyourdirtyhands@gmail.com", "+79001475485", 20000,45);
        workers[4] = new Worker("Роджер Рубенович Фрейд", "Психиатр", "itsallaboutthis@s.ru", "+79451125547", 50000,39);

        for (Worker currentWorker: workers) {
            int age = currentWorker.getAge();
            if (age > 40) {
                currentWorker.printWorkerInformation();
            }
        }

    }
}
