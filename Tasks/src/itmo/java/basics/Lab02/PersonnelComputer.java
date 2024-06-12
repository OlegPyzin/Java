/* Пояснения касающиеся множителей кило, мега, гига
 * Существуют две системы описывающие содержание указанных обозначений
 * 1. Общепринятая
 *    - кило это         1 000;
 *    - мега это     1 000 000;
 *    - гига это 1 000 000 000.
 * 2. Принятая в индустрии IT. В основу положена система 2 в n-ой степени
 *    - кило это 2 ** 10            -         1 024;
 *    - мега это 1024К, или 2 ** 20 -     1 048 576;
 *    - гига это 1024М, или 2 ** 30 - 1 073 741 824;
 * Единицами измерения оперативной памяти и размера диска до некоторых времен
 * использовалась система описания множителей как IT индустрии, но
 * с появлением flash накопителей изменилась и система множителей используемая
 * для flash накопителей. Производители flash накопителей используют общепринятую
 * систему обозначения множителей.
 * Но в индустрии IT все равно продолжается использоваться их специфицеская система
 * обозначения множителей и, как правило, после инициализации диска в компьютере
 * показывается уменьшенный объем дискового пространства который измеряется в единицах
 * измерения принятый в IT индустрии
 * Пример:
 * пусть SSD диск описан размером в 100Гб в общепринятой системе
 * 100 000 000 000 / 1024 / 1024 / 1024 = 93,13 Гб в системе обозначений IT.
 *
 * На данный момент система множителей применяемых для обозначения оперативной памяти
 * не изменилась и все так же используется 2 в N степени.
 */
package itmo.java.basics.Lab02;

public class PersonnelComputer {
    private String brand;
    private String typeOperatingSystem;
    private String cpu;
    private long ram;
    private long sizeOfDisk;
    private String typeOfDisk;
    private String screen;
    private Long price;

    public PersonnelComputer() {
    }

    public PersonnelComputer( String brand, String typeOperatingSystem, String cpu, String typeOfDisk, long sizeOfDisk, long ram, String screen, Long price) {
        this.brand = brand;
        this.typeOperatingSystem = typeOperatingSystem;
        this.cpu = cpu;
        this.typeOfDisk = typeOfDisk;
        this.sizeOfDisk = sizeOfDisk;
        this.ram = ram;
        this.screen = screen;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "PC {" +
                "brand=\"" + brand + '\"' + " " +
                "Raw of screen=\"" + screen + "\"" + " " +
                "OS=\"" + typeOperatingSystem + '\"' + " " +
                "CPU=\"" + cpu + '\"' + " " +
                "RAM=" + ram + " " +
                typeOfDisk + "=" + sizeOfDisk +
                "}";
    }
}
