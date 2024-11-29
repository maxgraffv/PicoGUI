import java.util.List;
import java.util.ArrayList;

// public class KalmanFilter {



//     private List<Double> data_unfiltered;

//     KalmanFilter( List<Double> data_unfiltered )
//     {

//         this.data_unfiltered = data_unfiltered;



//     }
    
//     void matrix_mult_3x3_3x1(double a[][], double b[], double result[]) {
//         for (int i = 0; i < 3; i++) {
//             result[i] = 0;
//             for (int j = 0; j < 3; j++) {
//                 result[i] += a[i][j] * b[j];
//             }
//         }
//     }


//     double dt = 0.01422;

//     double X[] = {0, 0, 1};

//     double F[][] = {
//         {1, dt, 0.5*dt*dt},
//         {0, 1, dt},
//         {0, 0, 1}
//     };

//     double P[][] = {
//         {400, 0, 0},
//         {0, 400, 0},
//         {0, 0, 400}
//     };

//     double Q[][] = {
//         {0.5, 0, 0},
//         {0, 0.5, 0},
//         {0, 0, 0.5}
//     };

//     double R = 8*8;






//     private double calculate_data_point(double z)
//     {

//         double x_pred[] = {};
//         double P_pred[][] = {};
        
//         matrix_mult_3x3_3x1(F, X, x_pred);
    
    
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 P_pred[i][j] = Q[i][j];
//                 for (int k = 0; k < 3; k++) {
//                     P_pred[i][j] += F[i][k] * P[k][j];
//                 }
//             }
//         }
    
//         double y = z - x_pred[2];
    
//         double S = P_pred[2][2] + R;
    
//         double K[] = {0, 0, 0};
    
//         for(int i = 0; i < 3; i++)
//         {
//             K[i] = P_pred[i][2] / S;
//         }
    
//         for(int i = 0; i < 3; i++)
//         {
//             X[i] = x_pred[i] + K[i] * y;
//         }
    
//         double P_new[][] = {};
//         for(int i = 0; i < 3; i++)
//             for(int j = 0; j < 3; j++)
//                 P_new[i][j] = P_pred[i][j] - K[i] * P_pred[2][j];
    
//         for(int i = 0; i < 3; i++)
//             for(int j = 0; j < 3; j++)
//                 P[i][j] = P_new[i][j];
    

//         return X[2];
//     }

//     public List<Double> filter()
//     {
//         List<Double> data_filtered = new ArrayList<>();

//         double H[][] = {
//             {0, 0, 1}
//         };
        
//         for(int i = 0; i < data_unfiltered.size(); i++)
//         {
//             data_filtered.add(calculate_data_point(i));
//         }
        
//         return data_filtered;
//     }




    
// }


public class KalmanFilter {
    private double processNoise; // Process noise (Q)
    private double measurementNoise; // Measurement noise (R)
    private double estimatedError; // Error in the estimated state (P)
    private double currentEstimate; // Current estimated acceleration
    private double lastEstimate; // Last estimated acceleration
    private boolean initialized; // Flag to indicate if initialized

    // Constructor to initialize the filter with process and measurement noise
    public KalmanFilter(double processNoise, double measurementNoise, double initialEstimate) {
        this.processNoise = processNoise;
        this.measurementNoise = measurementNoise;
        this.estimatedError = 1; // Initial error can be arbitrary
        this.currentEstimate = initialEstimate;
        this.initialized = true;
    }

    // Method to apply the Kalman filter to new acceleration data
    public double update(double measurement) {
        if (!initialized) {
            // If not initialized, set the initial estimate to the first measurement
            currentEstimate = measurement;
            initialized = true;
        } else {
            // Kalman gain (K)
            double kalmanGain = estimatedError / (estimatedError + measurementNoise);

            // Update the current estimate
            currentEstimate = lastEstimate + kalmanGain * (measurement - lastEstimate);

            // Update the estimation error
            estimatedError = (1 - kalmanGain) * estimatedError + Math.abs(lastEstimate - currentEstimate) * processNoise;
        }

        // Store the current estimate as the last estimate for the next update
        lastEstimate = currentEstimate;

        return currentEstimate;
    }

    public List<Double> filter( List<Double> unfiltered )
    {
        List<Double> filtered = new ArrayList<>();
        for(int i = 0; i < unfiltered.size(); i++)
        {
            filtered.add( update( unfiltered.get(i) ) );
        }

        return filtered;
    }
}

