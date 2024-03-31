package produtor_consumidor;

//import java.util.concurrent.Semaphore;
//import java.lang.Object;
//import java.awt.Component;
//import java.awt.Container;
//import javax.swing.JComponent;




public class Main {
    public static void main(String[] args) {
        Ponte ponte = new Ponte();

        // Criação de carros e threads
        Carro carro1 = new Carro(1, "leste", ponte);
        Carro carro2 = new Carro(2, "oeste", ponte);
        Carro carro3 = new Carro(3, "leste", ponte);
        Carro carro4 = new Carro(4, "oeste", ponte);

        // Inicia as threads dos carros
        carro1.start();
        carro2.start();
        carro3.start();
        carro4.start();

        // Espera todas as threads terminarem
        try {
            carro1.join();
            carro2.join();
            carro3.join();
            carro4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

