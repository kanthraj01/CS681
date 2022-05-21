package edu.umb.cs681.hw10;

public class RunnableAircraft implements Runnable {
	public void run() {

        Aircraft aircraft = new Aircraft(new Position(98.4,88.1,20000));
        System.out.println("The Aircraft's start position: "+ aircraft.getPosition());

        aircraft.setPosition(aircraft.getPosition().changeLat(99.1));
        System.out.println("The Aircraft's new latitude: "+ aircraft.getPosition().getLatitude());

        aircraft.setPosition(aircraft.getPosition().changeLong(82.8));
        System.out.println("The Aircraft's new longitude: "+ aircraft.getPosition().getLongitude());

        aircraft.setPosition(aircraft.getPosition().changeAlt(25000));
        System.out.println("Aircraft's new altitude: "+ aircraft.getPosition().getAltitude());

        System.out.println("Aircraft's new position: "+ aircraft.getPosition());

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				RunnableAircraft r1 = new RunnableAircraft();
				RunnableAircraft r2 = new RunnableAircraft();
				Thread t1 = new Thread(r1);
				Thread t2 = new Thread(r2);
				
				t1.start();
				t2.start();
				try {
					t1.join();
					t2.join();
				} catch (InterruptedException e) {}

	}
}

