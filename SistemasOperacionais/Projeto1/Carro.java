package produtor_consumidor;

class Carro extends Thread {
    private int id;
    private String direcao;
    private Ponte ponte;

    public Carro(int id, String direcao, Ponte ponte) {
        this.id = id;
        this.direcao = direcao;
        this.ponte = ponte;
    }

    @Override
    public void run() {
        ponte.atravessar(id, direcao);
    }
}