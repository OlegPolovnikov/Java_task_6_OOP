package Java_task_6_OOP;

import Java_task_6_OOP.stores.Laptop;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Laptop Sony = new Laptop("Sony",4, 800, "windows", "black");
        Laptop Acer = new Laptop("Acer",3, 900, "windows", "red");
        Laptop Lenovo = new Laptop("Lenovo",5, 300, "linux", "green");

        Set<Store> laptops = new HashSet<>(Set.of());
        laptops.add(Acer);
        laptops.add(Sony);
        laptops.add(Lenovo);

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "Производитель");
        criteria.put(2, "ОЗУ");
        criteria.put(3, "Объем ЖД");
        criteria.put(4, "Операционная система");
        criteria.put(5, "Цвет");
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) {
            System.out.println("Перечень доступных критериев:");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            int criterion = scanner.nextInt();
            scanner.nextLine();
            switch (criterion) {
                case 1:
                    System.out.print("Введите производителя: ");
                    filters.put("manufacturer", scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                    filters.put("ram", scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
                    filters.put("hdd", scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Введите операционную систему: ");
                    filters.put("os", scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Введите цвет: ");
                    filters.put("color", scanner.nextLine());
                    break;

                default:
                    System.out.println("Некорректный критерий.");
            }
            System.out.print("Хотите добавить еще один критерий? (да/нет): ");
            String response = scanner.nextLine();
            continueFiltering = response.equalsIgnoreCase("да");
        }
        scanner.close();
        filterLaptops(laptops, filters);
    }
    public static void filterLaptops(Set<Store> laptops, Map<String, Object> filters) {
        int counter = 0;
        for (Store laptop : laptops) {
            boolean matches = !filters.containsKey("ram") || laptop.getRam() >= (int) filters.get("ram");
            if (filters.containsKey("hdd") && laptop.getHdd() < (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (filters.containsKey("manufacturer") && !laptop.getManufacturer().equalsIgnoreCase((String) filters.get("manufacturer"))) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
                counter++;
            }
            }
        if (counter == 0) {
            System.out.println("Ноутбуков с заданным критерием не найдено");
        }
        }
    }















