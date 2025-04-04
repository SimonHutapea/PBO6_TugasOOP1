public class Payment {
    double totalPrice;
    String paymentMethod, paymentStatus;

    // Constructor
    public Payment (double totalPrice, String paymentMethod) {
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "";
    }

    // Overloaded method: pembayaran tanpa diskon
    public void processPayment (String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pembayaran Berhasil dengan " + paymentMethod;
    }

    // Overloaded method: pembayaran dengan diskon
    public void processPayment (String paymentMethod, double discountPercent) {
        this.paymentMethod = paymentMethod;
        double discountAmount = (discountPercent / 100) * totalPrice;
        totalPrice -= discountAmount;
        this.paymentStatus = "Pembayaran Berhasil";
    }

    // Menampilkan detail pembayaran
    public void displayPayment (boolean showDiscount) {
        System.out.println("Metode Pembayaran   : " + this.paymentMethod);
        System.out.println("Status Pembayaran   : " + this.paymentStatus);
        if (showDiscount) {
            System.out.println("Total Setelah Diskon: Rp " + (int) this.totalPrice);
        }
    }
}
