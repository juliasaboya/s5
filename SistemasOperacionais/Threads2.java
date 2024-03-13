package semaph_atv;
import java.util.concurrent.Semaphore;


public class Threads2 {
	
	static Semaphore semA = new Semaphore(4);
    static Semaphore semB = new Semaphore(0);
	
	
	static class ThreadA extends Thread {
		public void run() {
			while(true) {
				try {
                    semA.acquire(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
				
				double soma = 0;
				for (int i =0; i<1000; i++)
					for (int j =0; j<2000; j++) {
						soma = soma + Math.sin(i) + Math.sin(j);			
						}
				System.out.print("A");
				if (semA.availablePermits() == 0) {
					semB.release();

				}
			}
		}
		
	}
	
	static class ThreadB extends Thread {
		public void run() {
			while(true) {
				try {
                    semB.acquire(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                } // o método acquire requer utilização do try-catch
				double soma = 0;
				for (int i =0; i<10000; i++)
					for (int j =0; j<2000; j++) {
						soma = soma + Math.sin(i) + Math.sin(j);			}
				System.out.print("B");
				semA.release(4);

				
			}
		}
		
	}

	public static void main(String[] args) {
		ThreadA tA1 = new ThreadA();
		tA1.start();
		ThreadA tA2 = new ThreadA();
		tA2.start();
		ThreadB tB = new ThreadB();
		tB.start();



	}

}
