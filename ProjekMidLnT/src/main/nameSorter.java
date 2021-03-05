package main;
import java.util.Comparator;
public class nameSorter implements Comparator<karyawan> 
{
    @Override
    public int compare(karyawan o1, karyawan o2) {
        return o1.getNama().compareToIgnoreCase(o2.getNama());
    }
}
