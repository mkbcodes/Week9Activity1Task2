public class BackgroundTask implements Runnable {

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++){
            // CounterGUI2.lblCount.setText(Integer.toString(i));
            System.out.println("i: " + i);
            pause(1);  // waits 1 millisecond before continuing to help simulate a large task
        }
    }
    /**
     * Use this method instead of Thread.sleep(). It handles the possible
     * exception by catching it, because re-throwing it is not an option in this
     * case.
     *
     * @param duration Pause time in milliseconds.
     */
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

    /// Back at 3:55pm

}
