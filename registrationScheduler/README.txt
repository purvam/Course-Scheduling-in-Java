CS542 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due Date: Friday, September 30, 2016
Submission Date: Friday, September 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: - Days
Author: Purva M. Myakal
e-mail:pmyakal1@binghamton.edu


PURPOSE:
The project helps to understand how multithreading work. Also, for new to java 
it helps to understand how to use packages.

PERCENT COMPLETE:
I believe, I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
None.

BUGS:
None.

DATA STRUCTURES USED:
I used ConcurrentHashMap to store results so that many threads can read from it at a time.
And it won't throw ConcurrentModificationException if one thread tries to modify while other is iterating.
I stored Student_data object as a value in map and student_<no> as key.

FILES:
Driver.java
FileProcessor.java
Logger.java
Results.java
FileDisplayInterface.java
StdoutDisplayInterface.java
CreateWorkers.java
WorkerThread.java
Student_data.java
Algorithm.java
ObjectPool.java

Student_data.java Algorithm.java and ObjectPool.java file are the one,
I added to the original structure provided by professor.

SAMPLE OUTPUT:
Student_15   C D E F G  25
Student_59   A B C D E  19
Student_16   A B C D G  19
Student_17   B C D E F  17
Student_18   A B C F G  25
Student_19   A D E F G  17
Student_51   A B C D E  17
Student_52   B C D E F  17
Student_53   A D E F G  15
Student_10   B C D E F  17
Student_54   C D E F G  19
Student_11   A D E F G  15
Student_55   A B E F G  17
Student_12   A B E F G  15
Student_56   A B C D G  15
Student_13   A B C D G  20
Student_57   A B E F G  21
Student_14   A B C D E  20
Student_58   C D E F G  20
Student_60   A B C F G  25
Student_61   A D E F G  17
Student_26   A B E F G  15
Student_27   A B C D G  20
Student_28   A B C D E  20
Student_29   C D E F G  25
Student_62   B C D E F  23
Student_63   A B C D G  15
Student_20   C D E F G  21
Student_64   A B E F G  21
Student_21   A B E F G  19
Student_65   C D E F G  20
Student_22   A B C F G  19
Student_66   A B C D E  19
Student_23   A B C D E  17
Student_67   A B C F G  25
Student_24   B C D E F  17
Student_68   A D E F G  17
Student_25   A D E F G  15
Student_69   B C D E F  23
Student_70   A B C D G  15
Student_71   A B E F G  21
Student_72   C D E F G  20
Student_37   A B C D E  17
Student_38   B C D E F  17
Student_39   A D E F G  15
Student_5   B C D E F  21
Student_73   A B C D E  19
Student_4   A B C D G  23
Student_30   A D E F G  25
Student_74   A B C F G  25
Student_7   A B E F G  19
Student_31   A B C F G  23
Student_75   A D E F G  17
Student_6   C D E F G  21
Student_32   A B C D G  23
Student_76   B C D E F  23
Student_9   A B C D E  17
Student_33   B C D E F  21
Student_77   A B C D G  15
Student_8   A B C F G  19
Student_34   C D E F G  21
Student_78   A B C F G  19
Student_35   A B E F G  19
Student_79   A B C D E  17
Student_36   A B C F G  19
Student_1   A B C D E  15
Student_80   A D E F G  20
Student_3   A D E F G  20
Student_2   A B C F G  21
Student_48   C D E F G  21
Student_49   A B E F G  19
Student_40   A B E F G  15
Student_41   A B C D G  20
Student_42   A B C D E  20
Student_43   C D E F G  25
Student_44   A D E F G  25
Student_45   A B C F G  23
Student_46   A B C D G  23
Student_47   B C D E F  21
Student_50   A B C F G  19
Avarage Preference_score is: 19.0

TO COMPILE:
Extract the tarball named like:
>tar -xvf purva_myakal_assign2.tar.gz

Now, go to the directory where build.xml file is, and type:
>ant

TO RUN:
>ant -buildfile build.xml -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=1 run

arg0 is input_file_name.
arg1 is output_file_name.
arg2 is numer_of_threads.
arg3 is debug_value for logger.

EXTRA CREDIT:
N/A.

BIBLIOGRAPHY:
http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html
http://stackoverflow.com/questions/18093735/double-checked-locking-in-singleton

ACKNOWLEDGEMENT:
None.