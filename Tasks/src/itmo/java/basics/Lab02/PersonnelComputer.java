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
 * ===================================================================================
 * Методы:
 * String getBrand()
 * void setBrand( String )
 * String getTypeOperatingSystem()
 * void setTypeOperatingSystem( String )
 * String getCpu()
 * void setCpu( String )
 * long getRam()        - long -> размер оперативной памяти в гигабайтах
 * void setRam( long )  - long -> размер оперативной памяти в гигабайтах
 * String getTypeOfDisk()
 * void setTypeOfDisk( String )
 * void setSizeOfDisk( long )
 * void setSizeOfDiskIt( long )
 * double getSizeOfDisk()    - возвращает размер диска в Гб в общепринятой системе измерений
 * double getSizeOfDiskIt()  - возвращает размер диска в Гб принятой в IT индустрии
 * String getScreen()
 * void setScreen( String )
 * Long getPrice()
 * void setPrice( Long )
 */

package itmo.java.basics.Lab02;

public class PersonnelComputer {
    private String brand;
    private String typeOperatingSystem;
    private String cpu;
    private long ram; // size of RAM in bytes
    private long sizeOfDisk; // size of disk in bytes
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
        this.ram = ram * 1024 * 1024 * 1024;
        this.screen = screen;
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public String getTypeOperatingSystem() {
        return this.typeOperatingSystem;
    }

    public void setTypeOperatingSystem( String os ) {
        this.typeOperatingSystem = os;
    }

    public String getCpu() {
        return this.cpu;
    }

    public void setCpu( String cpu ) {
        this.cpu = cpu;
    }

    public long getRam() {
        long result;

        if( this.ram > 0 )
            result = this.ram / 1073741824L;
        else
            result = this.ram;

        return result;
    }

    public void setRam( long ram ) {
        this.ram = ram * 1073741824L;
    }

    public String getTypeOfDisk() {
        return this.typeOfDisk;
    }

    public void setTypeOfDisk( String disk ) {
        this.typeOfDisk = disk;
    }

    public double getSizeOfDisk() {
        double result;

        if( this.sizeOfDisk > 0)
            result = (double) this.sizeOfDisk / 1000000000L;
        else
            result = (double) this.sizeOfDisk;

        return result;
    }

    public double getSizeOfDiskIt() {
        double result;

        if( this.sizeOfDisk > 0)
            result = (double) this.sizeOfDisk / 1073741824L;
        else
            result = (double) this.sizeOfDisk;

        return result;
    }

    public void setSizeOfDisk( long size ) {
        this.sizeOfDisk = size * 1000000000L;
    }

    public void setSizeOfDiskIt( long size ) {
        this.sizeOfDisk = size * 1073741824L;
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen( String resolutions ) {
        this.screen = resolutions;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice( Long price ) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "PC {" +
                "Price=" + price + " " +
                "brand=\"" + brand + '\"' + " " +
                "Raw of screen=\"" + screen + "\"" + " " +
                "OS=\"" + typeOperatingSystem + '\"' + " " +
                "CPU=\"" + cpu + '\"' + " " +
                "RAM=" + ram + " " +
                typeOfDisk + "=" + sizeOfDisk +
                "}";
    }
}
