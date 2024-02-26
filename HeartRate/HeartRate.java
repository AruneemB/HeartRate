import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class HeartRate
{
    private final int beats;
    private final double seconds;
    public HeartRate(int beats, double seconds)
    {
        this.beats = beats;
        this.seconds = seconds;
    }
    public double getApproximateBeatsPerMinute()
    {
        return 60.0 * this.beats/this.seconds;
    }
    public double getMinimumApproximateBeatsPerMinute()
    {
        return this.getApproximateBeatsPerMinute() - (60.0/this.seconds);
    }
    public double getMaximumApproximateBeatsPerMinute()
    {
        return this.getApproximateBeatsPerMinute() + (60.0/this.seconds);
    }

    public String toString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String toString = "";
        toString += "Minimum Approximate BPM: " + decimalFormat.format(this.getMinimumApproximateBeatsPerMinute()) + " BPM.\n";
        toString += "Calculated Approximate BPM: " + decimalFormat.format(this.getApproximateBeatsPerMinute()) + " BPM.\n";
        toString += "Maximum Approximate BPM: " + decimalFormat.format(this.getMaximumApproximateBeatsPerMinute()) + " BPM.";
        return toString;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many cases would you like?");
        int cases = scanner.nextInt();
        ArrayList<HeartRate> heartRates = new ArrayList<>(cases);

        for(int i = 0; i < cases; i++)
        {
            System.out.println("Enter the number of beats in Case Number " + (i + 1) + ": ");
            int beats = scanner.nextInt();
            System.out.println("Enter the time (in seconds) in Case Number " + (i + 1) + ": ");
            double seconds = scanner.nextDouble();
            HeartRate heartRate = new HeartRate(beats, seconds);
            heartRates.add(heartRate);
            System.out.println();
        }

        System.out.println();
        System.out.println("List of BPM values for each case:");
        System.out.println();
        for(HeartRate heartRate : heartRates)
        {
            System.out.println("BPM values for Case Number " + (heartRates.indexOf(heartRate) +1));
            System.out.println(heartRate.toString());
            System.out.println();
        }
    }
}
