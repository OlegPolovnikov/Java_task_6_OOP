package Java_task_6_OOP;

public abstract class Store {

    private final String manufacturer; // Производитель
    private final int ram; // ОЗУ в ГБ
    private final int hdd; // Объем ЖД в ГБ
    private final String os; // Операционная система
    private final String color; // Цвет

    public Store(String manufacturer, int ram, int hdd, String os, String color) {

        this.manufacturer = manufacturer;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;

    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getRam() {
        return ram;
    }
    public int getHdd() {
        return hdd;
    }
    public String getOs() {
        return os;
    }
    public String getColor() {
        return color;
    }

    public String getGoodType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getGoodType() + " {" + "manufacturer: " + manufacturer + ", " + "ram: " + ram + ", " + "hdd: " + hdd + ", " + "os: " + os + ", " + "color: " + color + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store laptop = (Store) o;
        return ram == laptop.ram && hdd == laptop.hdd && os.equals(laptop.os) && color.equals(laptop.color) && manufacturer.equals(laptop.manufacturer);

    }
}