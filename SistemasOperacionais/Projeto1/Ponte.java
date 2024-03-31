package produtor_consumidor;

import java.util.concurrent.Semaphore;

class Ponte {
    private Semaphore semaforo;

    public Ponte() {
        semaforo = new Semaphore(1); // Apenas um carro pode atravessar a ponte de cada vez
    }

    public void atravessar(int idCarro, String direcao) {
        try {
            semaforo.acquire(); // Adquire o semáforo para atravessar a ponte
            System.out.println("Carro " + idCarro + " atravessando a ponte no sentido " + direcao);
            Thread.sleep(1000); // Simula o tempo que leva para atravessar a ponte
            System.out.println("Carro " + idCarro + " terminou a travessia");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release(); // Libera o semáforo após atravessar a ponte
        }
    }
}

