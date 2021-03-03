import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        StoreManagerDall storeManagerDall = new StoreManagerDall();

        Scanner in = new Scanner(System.in);
        int selection=0;
        System.out.println("*************");
        System.out.println("1.add");
        System.out.println("2.delete");
        System.out.println("3.update");
        System.out.println("4.list");
        System.out.println("5.cart");
        System.out.println("Your Select:");
        selection=in.nextInt();
        System.out.println("*************");

            if(selection==1) storeManagerDall.add(new StoreManager());
            if(selection==2) storeManagerDall.delete(new StoreManager());
            if(selection==3) storeManagerDall.update(new StoreManager());
            if(selection==4) storeManagerDall.list(new StoreManager());
            if(selection==5) storeManagerDall.cart(new StoreManager());



            }
}
