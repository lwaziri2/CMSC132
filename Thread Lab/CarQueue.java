import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	private Queue<Integer> q;
	private Random random = new Random();

	public CarQueue() {
		q = new LinkedList<>();
		
		q.add(random.nextInt(4));
		q.add(random.nextInt(4));
		q.add(random.nextInt(4));
		q.add(random.nextInt(4));
		q.add(random.nextInt(4));
		q.add(random.nextInt(4));

	}
	
	public void addToQueue() {
		class AddRandom implements Runnable{

			@Override
			public void run() {
				while (true) {
                    q.add(random.nextInt(4));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new Thread(new AddRandom()).start();
    }

    public Integer deleteQueue() {
        return q.remove();
    }
}