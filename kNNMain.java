import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label

    List<DataPoint> fullDataSet = DataSet.readDataSet("data/iris.csv");

    System.out.println(fullDataSet.get(4).getLabel());

    System.out.println(fullDataSet.get(4).getX()[3]);

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset

    List<DataPoint> trainingSet = DataSet.getTrainingSet(fullDataSet, 0.8);

    List<DataPoint> testSet = DataSet.getTestSet(fullDataSet, 0.2);


    // DON'T DO: TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label

    KNNClassifier classifier3 = new KNNClassifier(3);

    DataPoint[] neighborDistances = classifier3.getNearestNeighbors(trainingSet, trainingSet.get(0));

    String targetLabelPrediction = classifier3.predict(trainingSet, trainingSet.get(0));

    System.out.println(targetLabelPrediction);

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.

    for(int k = 1; k<20; k+=2)
    {
      int numAccurate = 0;
      double accuracy = 0;

      System.out.println("k = " + k + ":");

      KNNClassifier newClassifier = new KNNClassifier(k);

      for(int i=0; i<testSet.size(); i++)
      {
        String prediction = newClassifier.predict(trainingSet, testSet.get(i));

        System.out.println(prediction);

        String realAnswer = testSet.get(i).getLabel();

        if(prediction.length() == realAnswer.length())
        {
          numAccurate++;
        }
      }
        accuracy = numAccurate*100/testSet.size();
        System.out.println("Accuracy: " + accuracy);
    }
  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
