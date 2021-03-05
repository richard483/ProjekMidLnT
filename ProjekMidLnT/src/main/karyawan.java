package main;

public class karyawan {
    String kodeKaryawan;
    public karyawan(String kodeKaryawan, String nama, String jenisKelamin, String jabatan, long gaji) {
		super();
		this.kodeKaryawan = kodeKaryawan;
		this.nama = nama;
		this.jenisKelamin = jenisKelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	String nama;
    public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public long getGaji() {
		return gaji;
	}
	public void setGaji(long x) {
		this.gaji = x;
	}
	String jenisKelamin;
    String jabatan;
    long gaji;
    
    
    
    
    
     
}


