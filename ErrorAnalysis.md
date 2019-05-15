# Report
## Intro to Computer Programming in Engineering and Science - Section 2
## Celeste Groux and Maya Tatarelli

## Distributions of Model Accuracy

Every time the program was run, the array list is shuffled randomly; this means that the test set is different every time the program is run, and thus, the accuracy may change depending on the training set and the specific data points used to test the model in the test set.

After running the process 1000 times with a k value of 1, the mean accuracy of each run was found to be 0.988 and the standard deviation was found to be 5.26E-5.

*Baseline*

To find a baseline, one can consider the simplest model of either categorizing every individual as having a malignant tumor or doing the same for a benign tumor.

   If all individuals are classified as having a malignant tumor, the accuracy is found to be 34.8%.

   If all individuals are classified as having a benign tumor, the accuracy is found to be 65.2%.

The lowest accuracy is produced with the first model where every individual is classified as having a malignant tumor. Thus, this model can be used as a baseline to compare the results of our program.

## Analysis of different error types

### A few definitions

*False Positive vs. False Negative*

1. A false positive is when the program classifies a person as having a malignant tumor while they actually have a benign tumor.
2. A false negative is when the program classifies a person as having a benign tumor while they actually have a malignant tumor.

*Recall vs. Precision*

1. Recall measures the fraction of people with a malignant tumor that the program is able to classify as having a malignant tumor.
2. Precision measures the fraction of people who truly have a malignant tumor over all those the program classifies as having a malignant tumor.

### Analysis With Our Program

After running the program 1000 times, the mean of the recall was found to be 0.979 with a standard deviation of 2.76E-4. The mean of the precision after running the program 1000 times was found to be 0.985 with a standard deviation of 1.86E-4.

To analyze the effect of the hyper parameter k, the odd values of k from 1-9 were studied. It was found that the mean of the precision and the recall decreased as k was increased. As well, the standard deviation of the recall and the precision increased as the k value was increased.

*Baseline*

To find a baseline to compare the results of the recall and of precision for the model, one can consider again two different situations. First, if we consider the case where the program classifies all individuals as positive and having a malignant tumor, then the recall will be 100% and the precision will be equal to the accuracy, or 34.8%. If the opposite is true and all individuals are classified as having a benign tumor, then both the recall and the precision are found to be 0%.

On the other hand, a model that results in a 100% precision would have all of the positives be true positives, so no false positives are found.

Considering this, a baseline for comparison for precision could be 34.8%. Although, according to the previous example, the lowest recall found with these simplest models would be 0%, this is a very low baseline. Thus, a higher value should be considered. A possible baseline could instead be 50% because this falls between the two possible recall values for either of the two situations described above.

*Final Comments*

After the analysis, the best value of k in order to optimize recall, precision, and accuracy was found to be 1.
