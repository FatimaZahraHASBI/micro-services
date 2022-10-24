import proxy.BanqueSErvice;
import proxy.BanqueWS;
import proxy.Compte;

public class Client {
    public static void main(String[] args) {
        BanqueSErvice stub = new BanqueWS().getBanqueSErvicePort();
        System.out.println(stub.convert( 5600));
        Compte cp=stub.getCompte(3);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
    }
}
