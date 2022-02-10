import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  private static final Scanner input = new Scanner(System.in);
  public static String[] ListMenuAdmin = { "Tambah Produk", "Hapus Produk", "Ubah Produk", "Lihat Produk", "Keluar" };
  public static String[] ListMenuSupervisor = {"Lihat Produk", "Ubah Produk", "Keluar" };
  public static boolean run_code = true;
  public static ArrayList Chart = new ArrayList();
  public static ArrayList TotalProduk = new ArrayList();

  // 1. Tambah Produk
  public static void AddProduct() {
    System.out.printf(" Input Nama Produk   : ");
    try {
      Chart.add(input.nextLine());
      System.out.printf(" Input Jumlah Produk : ");
      try {
        TotalProduk.add(input.nextInt());
        input.nextLine();
        System.out.println(" Add Product, Succes");
      } catch (Exception e) {
        System.out.println(" Add Product Failed, Input jumlah produk dengan benar");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println();
  }

  // 2. Lihat Produk
  public static void ViewProduct() {
    for (int i = 0; i < Chart.size(); i++) {
      System.out.println(" " + (i + 1) + ". " + Chart.get(i) + " = " + TotalProduk.get(i) + " unit");
    }
    System.out.println(" ==================================\n");
  }

  // Search Produk
  public static int SearchProduk(String Keyword) {
    boolean found = false;
    int i;
    for (i = 0; i < Chart.size(); i++) {
      if (Keyword.equals(Chart.get(i))) {
        found = true;
        break;
      }
    }
    if (found == true)
      return i;
    else
      return -1;
  }

  // 3. Update Produk
  public static void UpdateProduct() {
    ViewProduct();
    System.out.print(" Input Nama Produk yang akan diupdate: ");
    try {
      String cari = input.nextLine();
      int ind = SearchProduk(cari);
      if (ind < 0) {
        System.out.println(" Produk yang dicari tidak ada");
      } else {
        System.out.print(" Input jumlah produk yang baru : ");
        try {
          int TotalProdukNew = input.nextInt();
          input.nextLine();
          System.out.print(" Apakah Anda yakin dengan jumlah produk " + Chart.get(ind) + " saat ini? [Ya | Tidak] : ");
          try {
            String pilih_edit = input.nextLine();
            if (pilih_edit.equals("Ya")) {
              TotalProduk.set(ind, TotalProdukNew);
              System.out.println(" Produk berhasil diupdate");
            }
          } catch (Exception e) {
            System.out.println(e + "\n Your input Wrong");
          }
        } catch (Exception e) {
          System.out.println(e + "\n Input jumlah produk dengan benar");
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println();
  }

  // 4. Delete Produk
  public static void DeleteProduct() {
    ViewProduct();
    System.out.print(" Input Nama Produk yang akan dihapus: ");
    try {
      String cari = input.nextLine();
      int ind = SearchProduk(cari);
      if (ind < 0) {
        System.out.println(" Produk yang dicari tidak ada");
      } else {
        System.out.print(
            " Apakah Anda yakin mau menghapus produk " + Chart.get(ind) + " ini dari keranjang Anda? [Ya | Tidak] : ");
        try {
          String pilih_hapus = input.nextLine();
          if (pilih_hapus.equals("Ya")) {
            try {
              Chart.remove(ind);
              TotalProduk.remove(ind);
              System.out.println(" Produk berhasil dihapus");
            } catch (Exception e) {
              System.out.println(e + "\n Your input Wrong");
            }
          }
        } catch (Exception e) {
          System.out.println(e + "\n Your input Wrong");
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(" ========================================\n");
    System.out.println();
  }

  // 5. menu
  public static void MenuAdmin() {
    System.out.println(" =================");
    System.out.println(" == Pilih Menu: ==");
    System.out.println(" =================");
    for (int i = 0; i < ListMenuAdmin.length; i++) {
      System.out.println(" " + (i + 1) + "." + ListMenuAdmin[i]);
    }

    Scanner inputOption = new Scanner(System.in);
    int option;
    System.out.print(" Input nomor Menu: ");
    try {
      option = inputOption.nextInt() - 1;
      try {
        System.out.println(ListMenuAdmin[option]);
        switch (option) {
          case 0:
            AddProduct();
            break;
          case 1:
            DeleteProduct();
            break;
          case 2:
            UpdateProduct();
            break;
          case 3:
            ViewProduct();
            break;
          case 4:
            System.out.println();
            AccesRole();
            // System.exit(0);
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e + "\n Your input wrong");
      }
    } catch (Exception e) {
      System.out.println(e + "\n Your input wrong");
    }
  }

  public static void MenuSupervisor() {
    System.out.println(" =================");
    System.out.println(" == Pilih Menu: ==");
    System.out.println(" =================");
    for (int i = 0; i < ListMenuSupervisor.length; i++) {
      System.out.println(" " + (i + 1) + "." + ListMenuSupervisor[i]);
    }

    Scanner inputOption = new Scanner(System.in);
    int option;
    System.out.print(" Input nomor Menu: ");
    try {
      option = inputOption.nextInt() - 1;
      try {
        System.out.println(ListMenuSupervisor[option]);
        switch (option) {
          case 0:
            ViewProduct();
            break;
          case 1:
            UpdateProduct();
            break;
          case 2:
            System.out.println("Terimakasih telah berkunjung");
            AccesRole();
            // System.exit(0);
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e + "\n Your input wrong");
      }
    } catch (Exception e) {
      System.out.println(e + "\n Your input wrong");
    }
  }

  public static void AccesRole(){
    System.out.print(" Input Login Key : ");
    try {
      String loginKey = input.nextLine();
      if (loginKey.equals("Admin")) {
        System.out.println("  ========================================================================");
        System.out.println(" =Hello Admin, Selamat datang di Sistem Inventory barang Elektronik Team 3=");
        System.out.println("  ========================================================================");
          while (run_code == true) {
            MenuAdmin();
          }
      } else if(loginKey.equals("Supervisor")){
        System.out.println("  =============================================================================");
        System.out.println(" =Hello Supervisor, Selamat datang di Sistem Inventory barang Elektronik Team 3=");
        System.out.println("  =============================================================================");
          while (run_code == true) {
            MenuSupervisor();
          }
      }else{
        System.out.println("    Sorry, Login key salah");
        System.out.println("Input loginKey 'Admin' untuk masuk sebagai ADMIN atau 'Supervisor' untuk masuk sebagai SUPERVISOR");
        System.out.println();
        AccesRole();
      }
    } catch (Exception e) {
      System.out.println(e + "\n Your input Wrong");
    }
  }

  public static void main(String[] args) {
    AccesRole(); 
  }
}
