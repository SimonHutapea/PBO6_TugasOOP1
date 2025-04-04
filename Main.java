package TugasSistemPembayaran;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistem Pembayaran IKLCMart ===");

        // Input harga
        System.out.print("Masukkan Total Harga (Rp): ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        // Pilihan metode pembayaran
        System.out.println("\nPilih Metode Pembayaran:");
        System.out.println("1. Kartu Kredit");
        System.out.println("2. Transfer Bank");
        System.out.println("3. Voucher Diskon");
        System.out.print("Masukkan pilihan (1-3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        Payment payment = null;
        boolean showDiscount = false;

        switch (pilihan) {
            case 1:
                payment = new Payment(harga, "Kartu Kredit");
                payment.processPayment("Kartu Kredit");
                break;
            case 2:
                payment = new Payment(harga, "Transfer Bank");
                payment.processPayment("Transfer Bank");
                break;
            case 3:
                System.out.print("Masukkan persentase diskon (%): ");
                double diskon = scanner.nextDouble();
                scanner.nextLine();
                payment = new Payment(harga, "Voucher Diskon");
                payment.processPayment("Voucher Diskon", diskon);
                showDiscount = true;
                break;
            default:
                System.out.println("Pilihan tidak valid. Transaksi dibatalkan.");
                scanner.close();
                return;
        }

        System.out.println("\n=== Rincian Pembayaran ===");
        System.out.println("Total Harga Asli : Rp " + (int) harga);
        payment.displayPayment(showDiscount);

        scanner.close();
    }
}
