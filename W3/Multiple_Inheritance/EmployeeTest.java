public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data dari setiap staf
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Membandingkan gaji antar staf
        for (int i = 0; i < staff.length; i++) {
            for (int j = i + 1; j < staff.length; j++) {
                int result = staff[i].compare(staff[j]);
                
                System.out.println("\nMembandingkan staff[" + i + "] dan staff[" + j + "]");
                
                if (result < 0) {
                    System.out.println("Gaji staff[" + i + "] lebih kecil");
                } else if (result > 0) {
                    System.out.println("Gaji staff[" + i + "] lebih besar");
                } else {
                    System.out.println("Gaji sama");
                }
            }
        }
    }
}
