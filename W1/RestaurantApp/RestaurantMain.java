public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("=== MENU ===");
        menu.tampilMenuMakanan();

        System.out.println("\n=== PESAN 5 PIZZA ===");
        menu.pesanMakanan(0, 5);

        System.out.println("\n=== PESAN 50 SPAGHETTI ===");
        menu.pesanMakanan(1, 50);
        
        System.out.println("\n=== MENU SETELAH PESAN ===");
        menu.tampilMenuMakanan();
    }
}
