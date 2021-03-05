package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
	ArrayList<karyawan>arrlist=new ArrayList<>();
	ArrayList<String> manajer = new ArrayList<String>();
	ArrayList<String> sv = new ArrayList<String>();
	ArrayList<String> mimin = new ArrayList<String>();
	
	
	static String rendom(){
		String generated[] = {"\0","\0"};
		int leftLimit[] = {'A','0'}, rightLimit[] = {'Z','9'}, targetStringLength[]= {2,4};
		for(int j=0;  j<2; j++)
		{
		    Random random = new Random();

		    generated[j] = random.ints(leftLimit[j], rightLimit[j] + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength[j])
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		}
	    
		String kodeKaryawanPen = generated[0].concat("-").concat(generated[1]);
		
		return kodeKaryawanPen;
	}
	
	static void printKepala() {
		String a="No.", b="Kode Karyawan",c="Nama Karyawan", d="Jenis kelamin", e="Jabatan", f="Gaji Karyawan";
        System.out.printf("|-----|--------------------|------------------------------|---------------|---------------|---------------|\n");
        //5, 10, 30, 5, 15, 15
        System.out.printf("|%-5s|%-20s|%-30s|%-15s|%-15s|%-15s|\n",a,b,c,d,e,f);
        System.out.printf("|-----|--------------------|------------------------------|---------------|---------------|---------------|\n");
	}
	
	public main() {
		 int select;
	        do{
	            Scanner scan = new Scanner(System.in);

	            System.out.println("==========SELAMAT DATANG==========");
	            System.out.println("Menu:");
	            System.out.println("1. Insert data karyawan");
	            System.out.println("2. View data karyawan");
	            System.out.println("3. Update data karyawan");
	            System.out.println("4. Delete data karyawan");
	            System.out.println("5. Log-out");
	            System.out.println("Silahkan pilih:");
	            select = scan.nextInt(); scan.nextLine();

	            switch(select){
	                case 1:
	                
	        			String kodeKaryawanPen = rendom();
		                String namaPen;
		                String jenisKelaminPen;
		                String jabatanPen;
		                int gajiPen = 100000;
		                
		                do {
		                	System.out.print("Input nama karyawan [>=3]: ");
			                namaPen = scan.nextLine();
		                }while(namaPen.length()<3);
		                
		                do {
		                	System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			                jenisKelaminPen = scan.nextLine();
		                }while(!jenisKelaminPen.contentEquals("Laki-laki")&&!jenisKelaminPen.contentEquals("Perempuan"));
		                
		                do {
		                	System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			                jabatanPen = scan.nextLine();
		                }while(!jabatanPen.contentEquals("Manager")&&!jabatanPen.contentEquals("Supervisor")&&!jabatanPen.contentEquals("Admin"));
		                
		                
		                System.out.printf("Berhasil menambahkan karyawan dengan id %s\n",kodeKaryawanPen);
		                
		                if(jabatanPen.contentEquals("Manager")) {
		                	
		                	if(manajer.size()%3==0) {
		                		if(manajer.size()!=0) {
		                			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<manajer.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(manajer.get(j))) {
			                					System.out.printf("%s", manajer.get(j));
			                					if((a+1) < manajer.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x*110)/100;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
		                		}
		                	}
		                	manajer.add(kodeKaryawanPen);
	                		gajiPen = 8000000;
		                }else if(jabatanPen.contentEquals("Supervisor")) {
		                	if(sv.size()%3==0) {
		                		if(sv.size()!=0) {
		                			System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<sv.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(sv.get(j))) {
			                					System.out.printf("%s", sv.get(j));
			                					if((a+1) < sv.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x*1075)/1000;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
		                		}
		                	}
		                	sv.add(kodeKaryawanPen);
	                		gajiPen = 6000000;
		                }else if(jabatanPen.contentEquals("Admin")) {
		                	if(mimin.size()%3==0) {
		                		if(mimin.size()!=0) {
		                			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<mimin.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(mimin.get(j))) {
			                					System.out.printf("%s", mimin.get(j));
			                					if((a+1) < mimin.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x*105)/100;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
		                		}
		                	}
		                	mimin.add(kodeKaryawanPen);
	                		gajiPen = 4000000;
		                }
		                
		                arrlist.add(new karyawan(kodeKaryawanPen, namaPen, jenisKelaminPen, jabatanPen, gajiPen));
		                arrlist.sort(new nameSorter());
		                System.out.printf("\n\n");
		                break;


	                case 2:
		                printKepala();
		                for(int i=0; i < arrlist.size(); i++)
						{
		                    System.out.printf("|%5d|%20s|%30s|%15s|%15s|%15d|\n",i+1,arrlist.get(i).getKodeKaryawan(),arrlist.get(i).getNama(),arrlist.get(i).getJenisKelamin(), arrlist.get(i).getJabatan(), arrlist.get(i).getGaji());
		                    System.out.printf("|-----|--------------------|------------------------------|---------------|---------------|---------------|\n");
		                }
		                System.out.printf("\n\n");
					
		                break;
	                
	                
	                case 3:
	                	int update;
	                	long gaj = 0;
	                	String nam, kel, jabat,kod, A, B;
	                	//prinnt tabel
		                printKepala();
		                for(int i=0; i < arrlist.size(); i++)
						{
		                    System.out.printf("|%5d|%20s|%30s|%15s|%15s|%15d|\n",i+1,arrlist.get(i).getKodeKaryawan(),arrlist.get(i).getNama(),arrlist.get(i).getJenisKelamin(), arrlist.get(i).getJabatan(), arrlist.get(i).getGaji());
		                    System.out.printf("|-----|--------------------|------------------------------|---------------|---------------|---------------|\n");
		                }
		                //minta
		                System.out.println("List data ke berapa yang ingin diupdate?");
		                update = scan.nextInt();scan.nextLine();update = update - 1;
		                A = arrlist.get(update).jabatan;
		                if(A.contentEquals("Manager")) {
		                	manajer.remove(arrlist.get(update).kodeKaryawan);
		                	
		                }else if(A.contentEquals("Supervisor")) {
		                	sv.remove(arrlist.get(update).kodeKaryawan);
		                	
		                }else if(A.contentEquals("Admin")) {
		                	mimin.remove(arrlist.get(update).kodeKaryawan);
		                	
		                }
		                
		                
		                
		                do {
		                	System.out.print("Input nama karyawan [>=3]: ");
			                nam = scan.nextLine();
		                }while(nam.length()<3);
		                
		                do {
		                	System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			                kel = scan.nextLine();
		                }while(!kel.contentEquals("Laki-laki")&&!kel.contentEquals("Perempuan"));
		                
		                do {
		                	System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			                jabat = scan.nextLine();
		                }while(!jabat.contentEquals("Manager")&&!jabat.contentEquals("Supervisor")&&!jabat.contentEquals("Admin"));
		                B = jabat;
		                //random aj de
	        			kod = rendom();
	        			//pembatallan bonus
	        			if(!A.contentEquals(B)){
	        				if(A.contentEquals("Manager")) {
	        					if(manajer.size()%3 == 0) {
	        						System.out.print("Bonus sebesar 10% telah dibatalkan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<manajer.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(manajer.get(j)) && arrlist.get(i).gaji>8000000) {
			                					System.out.printf("%s", manajer.get(j));
			                					if((a+1) < manajer.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x/110)*100;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
	        						
	        						
	        					}
	        				}
	        				
	        				
	        				else if(A.contentEquals("Supervisor")) {
	        					if(sv.size()%3 == 0) {
	        						System.out.print("Bonus sebesar 7,5% telah dibataklan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<sv.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(sv.get(j)) && arrlist.get(i).gaji>6000000) {
			                					System.out.printf("%s", sv.get(j));
			                					if((a+1) < sv.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x/1075)*1000;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
	        						
	        					}
	        				}
	        				
	        				else if(A.contentEquals("Admin")) {
	        					if(mimin.size()%3 == 0) {
	        						System.out.print("Bonus sebesar 5% telah dibatalkan kepada karyawan dengan id ");
		                			int a=0;
			                		for(int i=0; i<arrlist.size(); i++)
			                		{
			                			for(int j=0; j<mimin.size(); j++)
			                			{
			                				if(arrlist.get(i).getKodeKaryawan().contentEquals(mimin.get(j))  && arrlist.get(i).gaji>4000000) {
			                					System.out.printf("%s", mimin.get(j));
			                					if((a+1) < mimin.size())
			                						System.out.print(", ");
			                					long x = arrlist.get(i).getGaji();
			                					x = (x/105)*100;
			                					arrlist.get(i).setGaji(x);a++;
			                				}
			                			}
			                		}
	        					}
	        					
	        					
	        				}
	        				
	        				
	        			}
	        			//pemberian bonus
	        			if(B.contentEquals("Manager") && !B.contentEquals(A)) {
	        				gaj = 8000000;
        					if(manajer.size()%3 == 0 && manajer.size()!=0) {
        						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
	                			int a=0;
		                		for(int i=0; i<arrlist.size(); i++)
		                		{
		                			for(int j=0; j<manajer.size(); j++)
		                			{
		                				if(arrlist.get(i).getKodeKaryawan().contentEquals(manajer.get(j))) {
		                					System.out.printf("%s", manajer.get(j));
		                					if((a+1) < manajer.size())
		                						System.out.print(", ");
		                					long x = arrlist.get(i).getGaji();
		                					x = (x*110)/100;
		                					arrlist.get(i).setGaji(x);a++;
		                				}
		                			}
		                		}
		                		
        						
        						
        					}
        				}
        				
        				
        				else if(B.contentEquals("Supervisor")) {
        					gaj = 6000000;
        					if(sv.size()%3 == 0 && sv.size()!=0) {
        						System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan id ");
	                			int a=0;
		                		for(int i=0; i<arrlist.size(); i++)
		                		{
		                			for(int j=0; j<sv.size(); j++)
		                			{
		                				if(arrlist.get(i).getKodeKaryawan().contentEquals(sv.get(j))) {
		                					System.out.printf("%s", sv.get(j));
		                					if((a+1) < sv.size())
		                						System.out.print(", ");
		                					long x = arrlist.get(i).getGaji();
		                					x = (x*1075)/1000;
		                					arrlist.get(i).setGaji(x);a++;
		                				}
		                			}
		                		}
		                		
        						
        					}
        				}
        				
        				else if(B.contentEquals("Admin")) {
        					gaj = 4000000;
        					if(mimin.size()%3 == 0 && mimin.size() != 0) {
        						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
	                			int a=0;
		                		for(int i=0; i<arrlist.size(); i++)
		                		{
		                			for(int j=0; j<mimin.size(); j++)
		                			{
		                				if(arrlist.get(i).getKodeKaryawan().contentEquals(mimin.get(j))) {
		                					System.out.printf("%s", mimin.get(j));
		                					if((a+1) < mimin.size())
		                						System.out.print(", ");
		                					long x = arrlist.get(i).getGaji();
		                					x = (x*105)/100;
		                					arrlist.get(i).setGaji(x);a++;
		                				}
		                			}
		                		}
		                		
        					}
        					
        					
        				}
	        			
	        			
	        			if(B.contentEquals("Manager")) {
		                	manajer.add(kod);
		                }else if(B.contentEquals("Supervisor")) {
		                	sv.add(kod);
		                }else if(B.contentEquals("Admin")) {
		                	mimin.add(kod);
		                }
		                
		                arrlist.get(update).setGaji(gaj);arrlist.get(update).setJabatan(jabat);arrlist.get(update).setJenisKelamin(kel);arrlist.get(update).setNama(nam);arrlist.get(update).setKodeKaryawan(kod);
		                System.out.printf("\nBerhasil mengupdate karyawan dengan id %s\n",kod);
		                arrlist.sort(new nameSorter());
		                System.out.printf("\n\n");
	                	
		                break;
	                
	                
	                
	                case 4:
	                	int del;
	                	//print tabel
	                	printKepala();
		                for(int i=0; i < arrlist.size(); i++)
						{
		                    System.out.printf("|%5d|%20s|%30s|%15s|%15s|%15d|\n",i+1,arrlist.get(i).getKodeKaryawan(),arrlist.get(i).getNama(),arrlist.get(i).getJenisKelamin(), arrlist.get(i).getJabatan(), arrlist.get(i).getGaji());
		                    System.out.printf("|-----|--------------------|------------------------------|---------------|---------------|---------------|\n");
		                }
		                //minta
		                System.out.println("List data ke berapa yang ingin dihapus?");
		                del = scan.nextInt();scan.nextLine();
	                	arrlist.remove(del-1);
	                	arrlist.sort(new nameSorter());
	                	System.out.printf("\n\n");
	                	break;
	                	
	                default:
	                	System.out.println("Perintah yang anda masukkan belum tersedia");
	            }
	            
	           
	        }while(select!=5);
	        System.out.println("==========GoodBye==========!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
		
	}

}
