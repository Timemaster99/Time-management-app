package pomodoro;

public class PomodoroTimerImplementation implements PomodoroTimer {

	long startTime;
	long endTime;
	int desiredcycles = 0;
	int breaktime = 300000;
	int longbreaktime = 1800000;

	private void startTimer() {
		startTime = System.currentTimeMillis();

	}

	private void endTimer() {
		endTime = System.currentTimeMillis();

	}

	@Override
	public long elapsedTimeMillis() {
		if (startTime != 0) {
			return System.currentTimeMillis() - startTime;
		}
		return 0;
	}

	public void runPomodoro() {

		int pomodoros = 0;
		long nextcycle = 1500000;
		long cycletemptime;
		int pomodorocycles = 0;


		startTimer();

		while (pomodorocycles < desiredcycles) {
			while (pomodoros < 4) { // 4 cycle loop
				if (elapsedTimeMillis() >= nextcycle) { // Check if 25 minutes are up
					pomodoros++;
					System.out.println("Cycle over, take 5 minute break");
					cycletemptime = elapsedTimeMillis();
					while (elapsedTimeMillis() < cycletemptime + breaktime) { // 5 minute break loop
						
					}
					nextcycle = nextcycle+1500000+breaktime;
				}
			}
			
			cycletemptime = elapsedTimeMillis();
			while (elapsedTimeMillis() < cycletemptime + longbreaktime) { // 30 minute break loop

			}

			pomodorocycles++;
		}
		
		endTimer(); // End of method

	}

}
